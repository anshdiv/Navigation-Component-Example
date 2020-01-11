package com.example.navigationpoc.kotlin.ui.slideshow

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
import com.example.navigationpoc.kotlin.MainViewModel
import com.example.navigationpoc.R
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        val detailButton: Button = root.findViewById(R.id.detail_button)
        mainViewModel.schoolName.observe(this, Observer {
            textView.text = "SlideShow $it"
        })

        detailButton.setOnClickListener {
            val action: NavDirections =
                SlideshowFragmentDirections.slideshowToDetail(selectedOption = "From SlideShow -> " + mainViewModel.schoolName.value)
            Navigation.findNavController(slideshow_container).navigate(action)
        }
        return root
    }
}