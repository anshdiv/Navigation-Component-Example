package com.example.navigationpoc.java.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.navigationpoc.kotlin.MainViewModel;
import com.example.navigationpoc.R;
import com.example.navigationpoc.kotlin.ui.gallery.GalleryFragmentDirections;

class GalleryFragment extends Fragment {

    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        TextView textView=root.findViewById(R.id.text_gallery);
        Button detailButton = root.findViewById(R.id.detail_button);
        mainViewModel.getSchoolName().observe(this, s -> textView.setText("Gallery" +s));

        detailButton.setOnClickListener(view -> {
            NavDirections action = GalleryFragmentDirections.Companion.galleryToDetail("From Gallery -> " + mainViewModel.getSchoolName().getValue());
            Navigation.findNavController(view.findViewById(R.id.gallery_container)).navigate(action);
        });
        return root;
    }
}