package com.pk4u.prgrouptestapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pk4u.prgrouptestapp.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStartBinding.inflate(inflater,container,false)

        binding.bAgree.setOnClickListener { onOpenWebView() }
        binding.bDisagree.setOnClickListener { onExitPressed() }
        return binding.root
    }

    private fun onOpenWebView() { navigator().showWebView() }
    private fun onExitPressed() { navigator().goBack() }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
}