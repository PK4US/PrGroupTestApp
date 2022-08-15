package com.pk4u.prgrouptestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pk4u.prgrouptestapp.databinding.ActivityMainBinding
import com.pk4u.prgrouptestapp.fragments.Navigator
import com.pk4u.prgrouptestapp.fragments.NoInternetFragment
import com.pk4u.prgrouptestapp.fragments.StartFragment
import com.pk4u.prgrouptestapp.fragments.WebViewFragment

class MainActivity : AppCompatActivity() , Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,StartFragment.newInstance()).commit()
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun showWebView() { launchFragment(WebViewFragment()) }
    override fun goBack() { onBackPressed() }
    override fun showNotInternet() { launchFragment(NoInternetFragment()) }
}