package ninja.saad.bkashdemo.features.bkash

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_bkash_payment.*
import ninja.saad.bkashdemo.R
import ninja.saad.bkashdemo.data.BkashPaymentRequest
import ninja.saad.bkashdemo.util.JSInterface

class BkashPaymentActivity : AppCompatActivity() {

    private var paymentRequest = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bkash_payment)

        val request = BkashPaymentRequest(intent.getStringExtra("amount"), intent.getStringExtra("intent"))
        paymentRequest = "{paymentRequest:${Gson().toJson(request)}}"

        initBkashWebView()
        initBkashWebViewClient(paymentRequest)
    }

    private fun initBkashWebView() {
        bkashWebView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setAppCacheEnabled(false)
            cacheMode = WebSettings.LOAD_NO_CACHE
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        bkashWebView.apply {
            clearCache(true)
            isFocusableInTouchMode = true
            bkashWebView.addJavascriptInterface(JSInterface(this@BkashPaymentActivity), "AndroidNative")
            loadUrl("file:///android_asset/www/checkout_120.html")
        }
    }

    private fun initBkashWebViewClient(paymentRequest: String) {
        bkashWebView.webViewClient = object : WebViewClient(){

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
                handler.proceed()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                loadingProgressBar.visibility = VISIBLE
                if (url == "https://www.bkash.com/terms-and-conditions") {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    return true
                }
                return super.shouldOverrideUrlLoading(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                loadingProgressBar.visibility = VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                bkashWebView.let {
                    it.loadUrl("javascript:callReconfigure($paymentRequest )")
                    it.loadUrl("javascript:clickPayButton()")
                }
                loadingProgressBar.visibility = GONE
            }
        }
    }

}