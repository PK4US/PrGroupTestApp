package com.pk4u.prgrouptestapp.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pk4u.prgrouptestapp.NetworkConnection
import com.pk4u.prgrouptestapp.databinding.FragmentWebViewBinding

open class WebViewFragment : Fragment() {
    private lateinit var binding: FragmentWebViewBinding
    private lateinit var prefs: SharedPreferences
    private val APP_PREFERENCES_WEB_URL = "app_pref_web_url"
    private var webUrl = "https://megasport.ua/"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWebViewBinding.inflate(inflater,container,false)
        prefs = requireContext().getSharedPreferences("settings", Context.MODE_PRIVATE)
        opeWebView()
        internet()
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun opeWebView() = with(binding){
        webView.webViewClient = WebViewClient()
        webView.loadUrl(webUrl)
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

    override fun onPause() {
        super.onPause()
        webUrl = binding.webView.url.toString()
        // Запоминаем данные
        val editor = prefs.edit()
        editor.putString(APP_PREFERENCES_WEB_URL, webUrl).apply()
    }

    override fun onResume() {
        super.onResume()

        if(prefs.contains(APP_PREFERENCES_WEB_URL)){
            // Получаем число из настроек
            webUrl = prefs.getString(APP_PREFERENCES_WEB_URL, "g").toString()


            binding.webView.webViewClient = WebViewClient()
            binding.webView.loadUrl(webUrl)
        }
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