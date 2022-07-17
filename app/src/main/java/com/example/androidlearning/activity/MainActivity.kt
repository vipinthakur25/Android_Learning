package com.example.androidlearning.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlearning.R

const val TAG: String = "LIFE_CYCLE_METHOD"

class MainActivity : AppCompatActivity() {
    private lateinit var btnOpenActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "Activity 1 On Create")
        btnOpenActivity = findViewById(R.id.btnOpenActivity)
        initView()
    }

    private fun initView() {
        btnOpenActivity.setOnClickListener {
            openActivity()
        }
    }

    private fun openActivity() {
        startActivity(Intent(this, SecondActivity::class.java))
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Activity 1 On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Activity 1 On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Activity 1 On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "Activity 1 On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Activity 1 On Destroy")
    }
}