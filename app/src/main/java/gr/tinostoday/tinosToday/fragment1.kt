package gr.tinostoday.tinosToday

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment

class fragment1 : Fragment() {
    private var webView: WebView? = null
    private val constantUrl = "https://tinostoday.gr"

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
        webView?.setWebViewClient(WebViewClient()) // Handle navigation inside the WebView

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
