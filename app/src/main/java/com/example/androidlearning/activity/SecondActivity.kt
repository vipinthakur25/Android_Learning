package com.example.androidlearning.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.example.androidlearning.R


class SecondActivity : AppCompatActivity() {
    private lateinit var btnOpenFragment: Button
    private lateinit var etName: AppCompatEditText
    private lateinit var etNumber: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.e(TAG, "Activity 2 On Create")
        initView()
    }

    private fun initView() {
        btnOpenFragment = findViewById(R.id.btnOpenFragment)
        etName = findViewById(R.id.etName)
        etNumber = findViewById(R.id.etNumber)

        btnOpenFragment.setOnClickListener {
            goToFragment()
        }
    }

    private fun goToFragment() {
        if (etName.text.toString().isNotEmpty() && etNumber.text.toString().isNotEmpty()) {
            openFragment(etName.text.toString(), etNumber.text.toString())
        } else {
            Toast.makeText(this, "Please enter complete details", Toast.LENGTH_SHORT).show()
        }

    }

    private fun openFragment(name: String, number: String) {
        startActivity(Intent(this, ReceiverActivity::class.java).apply {
            putExtra("NAME", name)
            putExtra("NUMBER", number)
        })
        println("NAME $name  NUMBER $number")
    }

    /*supportFragmentManager.beginTransaction().replace(
    R.id.fragment_container,
    fragment
    ).commit()*/
    override fun onStart() {
        super.onStart()
        Log.e(TAG, "Activity 2 On Start")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "Activity 2 On Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "Activity 2 On Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "Activity 2 On Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "Activity 2 On Destroy")
    }
}