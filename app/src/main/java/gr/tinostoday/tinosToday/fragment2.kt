package gr.tinostoday.tinosToday
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment

class fragment2 : Fragment() {
    private var webView: WebView? = null
    private val constantUrl = "https://tinostoday.gr/efimereuonta-farmakeia-stin-tino/"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_fragment1, container, false)

        // Initialize the WebView
        webView = view.findViewById(R.id.webview)
        webView?.settings?.javaScriptEnabled = true // Enable JavaScript (if needed)
        // Set a custom WebViewClient to handle URL loading
        webView?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val uri = request?.url
                val url = uri.toString()

                // Check if the URL starts with "tel:"
                if (url.startsWith("tel:")) {
                    // If it's a telephone number, open the phone dialer
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = uri
                    startActivity(intent)
                    return true
                } else {
                    // If it's a regular URL, load it in the WebView
                    view?.loadUrl(url)
                    return true
                }
            }
        }

        // Load the constant URL when the fragment is created
        webView?.loadUrl(constantUrl)

        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            // Always load the constant URL when the back button is clicked
            webView?.loadUrl(constantUrl)
        }

        return view
    }
}
