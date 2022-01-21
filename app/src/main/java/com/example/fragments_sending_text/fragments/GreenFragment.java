package com.example.fragments_sending_text.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments_sending_text.R;

public class GreenFragment extends Fragment {
    private onGreenFragmentListener mCallback;
    EditText editText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_green_layout,container,false);
        editText = v.findViewById(R.id.edt_message);
        Button button = v.findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                mCallback.messageFromGreenFragment(message);
            }
        });
        return v;
    }
    // This is the interface that the Activity will implement
    // so that this Fragment can communicate with the Activity.
public interface onGreenFragmentListener{
        void messageFromGreenFragment(String text);
}


    // This method insures that the Activity has actually implemented our
    // listener and that it isn't null.


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onGreenFragmentListener){
            mCallback = (onGreenFragmentListener) context;
        }else{
            throw new RuntimeException(context.toString()+ " must implement onGreenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    mCallback = null;
    }
}
