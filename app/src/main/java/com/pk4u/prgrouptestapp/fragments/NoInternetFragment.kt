package com.pk4u.prgrouptestapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pk4u.prgrouptestapp.databinding.FragmentNoInternetBinding

class NoInternetFragment : Fragment() {

    private lateinit var binding: FragmentNoInternetBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNoInternetBinding.inflate(inflater,container,false)
        binding.bReload.setOnClickListener { navigator().showWebView() }
        return binding.root
    }
}