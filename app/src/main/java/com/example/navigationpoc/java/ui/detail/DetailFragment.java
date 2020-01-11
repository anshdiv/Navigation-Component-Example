package com.example.navigationpoc.java.ui.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationpoc.R;

class DetailFragment extends Fragment {

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = root.findViewById(R.id.text_detail);
        getBundleData();
        return root;

    }


    private void getBundleData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String mSelectedTaskOption = bundle.getString("selected_option");
            textView.setText(mSelectedTaskOption);
        }
    }
}