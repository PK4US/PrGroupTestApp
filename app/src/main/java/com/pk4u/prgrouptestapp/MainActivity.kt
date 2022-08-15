package com.pk4u.prgrouptestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pk4u.prgrouptestapp.fragments.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.placeHolder,StartFragment.newInstance()).commit()
    }
}