package com.example.androidlearning.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.androidlearning.R
import com.example.androidlearning.activity.ReceiverActivity

class ReciveFragment : Fragment() {
    private lateinit var tvName: AppCompatTextView
    private lateinit var tvNumber: AppCompatTextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recive, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {
        if (view != null) {
            tvName = view.findViewById(R.id.tvName)
            tvNumber = view.findViewById(R.id.tvNumber)
        }

        val bundle = arguments
        if (bundle != null) {
            tvName.text = bundle.getString("NAME")
            tvNumber.text = bundle.getString("NUMBER")
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }
}