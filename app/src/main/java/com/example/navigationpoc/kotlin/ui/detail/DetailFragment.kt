package com.example.navigationpoc.kotlin.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.navigationpoc.kotlin.MainViewModel
import com.example.navigationpoc.R

class DetailFragment : Fragment() {

    private var mSelectedTaskOption: String? = null
    private lateinit var mainViewModel: MainViewModel
    private var textView: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        textView = root.findViewById(R.id.text_detail)
        getBundleData()
        return root
    }

    private fun getBundleData() {
        val bundle = arguments
        if (bundle != null) {
            mSelectedTaskOption = bundle.getString("selected_option")
            textView?.text = mSelectedTaskOption;
        }
    }
}