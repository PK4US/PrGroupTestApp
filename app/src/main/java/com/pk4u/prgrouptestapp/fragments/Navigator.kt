package com.pk4u.prgrouptestapp.fragments

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showWebView()

    fun goBack()
}