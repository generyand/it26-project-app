package com.example.thisapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.thisapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public CardView java, javascript, nextjs;
    private Button button;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavController navController;

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

        /***************** DILI MOGANA AAAAAAAAAAAA *****************/
//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.navigation_view);
//
//        // Set navigation drawer menu
//        navigationView.inflateMenu(R.menu.navigation_side);
//
//        // Handle navigation item clicks
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int itemId = menuItem.getItemId();
//
//            if (itemId == R.id.nav_home) {
//                repFragment(new SideHomeFragment());
//            } else if (itemId == R.id.nav_profile) {
//                repFragment(new SideProfileFragment());
//            } else if (itemId == R.id.nav_msg) {
//                repFragment(new SideSettingsFragment());
//            } else if (itemId == R.id.nav_settings) {
//                repFragment(new SideSettingsFragment());
//            }
//
//                // Close the drawer after selection
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });
//
//        // Optional: Set a listener for the hamburger menu icon
//        Toolbar toolbar = findViewById(R.id.layoutToolbar); // Assuming you have a toolbar
//        setSupportActionBar(toolbar);
//        toolbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawerLayout.openDrawer(GravityCompat.START);
//            }
//        });


        /***************** OPTION 2 DILI SAD MOGANA AAAAAAAAAAAA *****************/
//        drawerLayout = findViewById(R.id.drawer_layout);
//
//        // Initialize NavigationView and set navigation graph
//        navigationView = findViewById(R.id.navigation_view);
//        navController = Navigation.findNavController(this, R.id.sideNavHostFragment);
//        NavigationUI.setupWithNavController(navigationView, navController);
//
//        // Handle menu item clicks for side navigation
//        navigationView.setNavigationItemSelectedListener(item -> {
//            int itemId = item.getItemId();
//            if (itemId == R.id.nav_home) {
//                navController.navigate(R.id.nav_home);
//            } else if (itemId == R.id.nav_profile) {
//                navController.navigate(R.id.nav_profile);
//            } else if (itemId == R.id.nav_msg) {
//                navController.navigate(R.id.nav_msg);
//            } else if (itemId == R.id.nav_settings) {
//                navController.navigate(R.id.nav_settings);
//            }
//            drawerLayout.closeDrawer(GravityCompat.START);
//            return true;
//        });
//
//        // Optional: Set a listener for the hamburger menu icon
//        Toolbar toolbar = findViewById(R.id.layoutToolbar); // Assuming you have a toolbar
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
//        }











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


    }

    private void repFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_out, fragment);
        fragmentTransaction.commit();
    }

}