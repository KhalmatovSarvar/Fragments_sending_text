package com.example.fragments_sending_text.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments_sending_text.R;

public class BlueFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmment_blue_layout,container,false);
        textView = v.findViewById(R.id.textView);
        return v;
    }
    // This is a public method that the Activity can use to communicate
    // directly with this Fragment

    public  void getMessage(String text){
        textView.setText(text);
    }
}
