package com.example.androidlearning.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidlearning.R
import com.example.androidlearning.fragments.DemoFragment

class ReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        initFragment()
    }



    private fun initFragment() {
        val bundle = Bundle()
        if (intent != null) {
            println("NAME FRAGMENT_ACTIVITY ${intent.getStringExtra("NAME")}")
            bundle.apply {
                putString("NAME", intent.getStringExtra("NAME"))
                putString("NUMBER", intent.getStringExtra("NUMBER"))
                val fragment: Fragment = DemoFragment()
                val mFragmentManager = supportFragmentManager
                fragment.arguments = bundle
                val fragmentTransaction = mFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_container, fragment)
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

    }


}