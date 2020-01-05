package com.appzgarden.navigationpoc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.appzgarden.navigationpoc.MainViewModel
import com.appzgarden.navigationpoc.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val detailButton: Button = root.findViewById(R.id.detail_button)
        mainViewModel.schoolName.observe(this, Observer {
            textView.text = "Home $it"
        })

        detailButton.setOnClickListener {
            val action: NavDirections =
                HomeFragmentDirections.homeToDetail(selectedOption = "From Home -> " + mainViewModel.schoolName.value)
            Navigation.findNavController(home_container).navigate(action)
        }
        return root
    }
}