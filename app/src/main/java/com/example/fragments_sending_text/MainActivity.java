package com.example.fragments_sending_text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.fragments_sending_text.fragments.BlueFragment;
import com.example.fragments_sending_text.fragments.GreenFragment;

public class MainActivity extends AppCompatActivity implements GreenFragment.onGreenFragmentListener {

    private static final String BLUE_TAG = "blue";
    private static final String GREEN_TAG = "green";

        BlueFragment blueFragment;
        GreenFragment greenFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

    FragmentManager  fragmentManager = getSupportFragmentManager();
    blueFragment = (BlueFragment) fragmentManager.findFragmentByTag("blue");
    if(blueFragment == null){
        blueFragment = new BlueFragment();
        fragmentManager.beginTransaction().add(R.id.blue_layout_container,blueFragment,BLUE_TAG).commit();
    }
    greenFragment = (GreenFragment) fragmentManager.findFragmentByTag("green");
    if(greenFragment == null){
        greenFragment = new GreenFragment();
        fragmentManager.beginTransaction().add(R.id.green_layout_container,greenFragment,GREEN_TAG).commit();
    }
    }
    @Override
    public void messageFromGreenFragment(String text) {
        blueFragment.getMessage(text);
    }
}