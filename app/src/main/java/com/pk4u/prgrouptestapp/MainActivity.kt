package com.pk4u.prgrouptestapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.onesignal.OneSignal
import com.pk4u.prgrouptestapp.databinding.ActivityMainBinding
import com.pk4u.prgrouptestapp.fragments.Navigator
import com.pk4u.prgrouptestapp.fragments.NoInternetFragment
import com.pk4u.prgrouptestapp.fragments.StartFragment
import com.pk4u.prgrouptestapp.fragments.WebViewFragment

class MainActivity : AppCompatActivity() , Navigator {

    private lateinit var binding: ActivityMainBinding
    private val ONESIGNAL_APP_ID = "9a89e4e3-e7e8-43d3-96d5-1b62c56c7c3e"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
        OneSignal.promptForPushNotifications()

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,StartFragment.newInstance()).commit()
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun showWebView() { launchFragment(WebViewFragment()) }
    override fun goBack() { onBackPressed() }
    override fun showNotInternet() { launchFragment(NoInternetFragment()) }
}