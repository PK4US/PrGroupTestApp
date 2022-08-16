package com.pk4u.prgrouptestapp.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pk4u.prgrouptestapp.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var prefs: SharedPreferences
    private var defBool = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartBinding.inflate(inflater,container,false)
        prefs = requireContext().getSharedPreferences("settings", Context.MODE_PRIVATE)

        binding.bAgree.setOnClickListener {
            defBool = true
            onOpenWebView() }
        binding.bDisagree.setOnClickListener { onExitPressed() }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val editor = prefs.edit()
        editor.putBoolean("bool", defBool).apply()
    }

    override fun onResume() {
        super.onResume()
        if(prefs.contains("bool")){
            defBool = prefs.getBoolean("bool", true)
           if (defBool){
               navigator().showWebView()
           }
        }
    }

    private fun onOpenWebView() { navigator().showWebView() }
    private fun onExitPressed() { navigator().goBack() }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
}