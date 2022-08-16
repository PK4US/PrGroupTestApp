package com.pk4u.prgrouptestapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pk4u.prgrouptestapp.NetworkConnection
import com.pk4u.prgrouptestapp.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWebViewBinding.inflate(inflater,container,false)
        opeWebView()
        internet()
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun opeWebView() = with(binding){
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://megasport.ua/")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        webView.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN) {
                    val webView = v as WebView
                    when (keyCode) {
                        KeyEvent.KEYCODE_BACK -> if (webView.canGoBack()) {
                            webView.goBack()
                            return true
                        }
                    }
                }
                return false
            }
        })
    }

    private fun internet(){
        val networkConnection = context?.let { NetworkConnection(it) }
        networkConnection?.observe(viewLifecycleOwner, Observer { isConnected ->
            if (!isConnected){
                navigator().showNotInternet()
            }
        })
    }
}