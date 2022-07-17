package com.example.androidlearning.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.androidlearning.R

class DemoFragment : Fragment() {
    private lateinit var tvName: AppCompatTextView
    private lateinit var tvNumber: AppCompatTextView
    private lateinit var btnSendData: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_demo, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View) {
        tvName = view.findViewById(R.id.tvName)
        tvNumber = view.findViewById(R.id.tvNumber)
        btnSendData = view.findViewById(R.id.btnSendData)
        val fragment: Fragment = ReciveFragment()
        val bundle = arguments
        if (bundle != null) {
            tvName.text = bundle.getString("NAME")
            tvNumber.text = bundle.getString("NUMBER")
        }
        fragment.arguments = bundle
        btnSendData.setOnClickListener {
            val mFragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = mFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_NONE)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

}