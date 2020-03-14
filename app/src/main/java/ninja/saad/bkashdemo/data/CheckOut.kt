package ninja.saad.bkashdemo.data

import java.io.Serializable

data class Checkout(var amount: String? = "", var intent : String? = "", var version : String? = "") : Serializable