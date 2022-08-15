package com.pk4u.prgrouptestapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pk4u.prgrouptestapp.databinding.FragmentWebViewBinding

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWebViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    companion object {
        fun newInstance() = WebViewFragment()

    }
}