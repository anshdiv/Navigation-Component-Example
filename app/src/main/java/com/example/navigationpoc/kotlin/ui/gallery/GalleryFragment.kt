package com.example.navigationpoc.kotlin.ui.gallery

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
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        val detailButton: Button = root.findViewById(R.id.detail_button)
        mainViewModel.schoolName.observe(this, Observer {
            textView.text = "Gallery $it"
        })

        detailButton.setOnClickListener {
            val action: NavDirections =
                GalleryFragmentDirections.galleryToDetail(selectedOption = "From Gallery -> " + mainViewModel.schoolName.value)
            Navigation.findNavController(gallery_container).navigate(action)
        }

        return root
    }

}