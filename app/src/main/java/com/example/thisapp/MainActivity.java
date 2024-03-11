package com.example.thisapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.thisapp.databinding.ActivityMainBinding;

//import com.example.thisapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
//    public CardView java, javascript, nextjs;
    private Button button;

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);

        // Bottom Nav
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        repFragment(new HomeFragment());

        binding.bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                repFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.profile) {
                repFragment(new ProfileFragment());
            } else if (item.getItemId() == R.id.settings) {
                repFragment(new SettingsFragment());
            }

            return true;
        });

//        button = (Button) findViewById(R.id.nextButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity2();
//            }
//        });
//
//        java = (CardView) findViewById(R.id.java);
//        java.setOnClickListener(this::onClick);
//
//        javascript = (CardView) findViewById(R.id.javascript);
//        javascript.setOnClickListener(this::onClick);
//
//        nextjs = (CardView) findViewById(R.id.nextjs);
//        nextjs.setOnClickListener(this::onClick);

    }

    private void repFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out, fragment);
        fragmentTransaction.commit();
    }

//    public void openActivity2() {
//        Intent intent = new Intent(this, Activity2.class);
//        startActivity(intent);
//    }
//
//    public void onClick(View view) {
//        Intent i;
//
//        if (view.getId() == R.id.java) {
//            i = new Intent(this, Java.class);
//            startActivity(i);
//        } else if (view.getId() == R.id.javascript) {
//            i = new Intent(this, Javascript.class);
//            startActivity(i);
//        } else if (view.getId() == R.id.nextjs) {
//            i = new Intent(this, NextJS.class);
//            startActivity(i);
//        }
//    }
}