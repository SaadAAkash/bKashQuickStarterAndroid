package ninja.saad.bkashdemo.features.bkash

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.SslErrorHandler
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dialog_bkash_payment.*
import ninja.saad.bkashdemo.R
import ninja.saad.bkashdemo.data.BkashPaymentRequest

class BkashPaymentActivity : AppCompatActivity() {

    private lateinit var mWebView: WebView
    private lateinit var progressBar: ProgressBar
    private var paymentRequest = ""

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.dialog_bkash_payment)

        val request = BkashPaymentRequest(intent.getStringExtra("amount"), intent.getStringExtra("intent"))
        paymentRequest = "{paymentRequest:${Gson().toJson(request)}}"

        bkashWebView.settings.apply {
            javaScriptEnabled = true
            javaScriptEnabled = true
            domStorageEnabled = true
            setAppCacheEnabled(false)
            cacheMode = WebSettings.LOAD_NO_CACHE
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
        }

        bkashWebView.clearCache(true)
        bkashWebView.isFocusableInTouchMode = true

        

        bkashWebView.webViewClient = object : WebViewClient(){

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler, error: SslError?) {
                handler.proceed()
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d("External URL: ", url)
                //loadingProgressBar.visibility = VISIBLE
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
                loadingProgressBar.visibility = GONE
                topBar.visibility = VISIBLE
                closeIv.visibility = VISIBLE
                mWebView.let {
                    it.loadUrl("javascript:callReconfigure($paymentRequest )")
                    it.loadUrl("javascript:clickPayButton()")
                }
                progressBar.visibility = GONE
            }
        }
    }
}