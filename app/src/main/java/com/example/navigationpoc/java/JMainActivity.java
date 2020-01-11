package com.example.navigationpoc.java;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigationpoc.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;


public class JMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    private MainViewModel mainViewModel;
    private NavController navController;
    NavHostFragment navHostFragment;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        navigationView.setNavigationItemSelectedListener(this);
        configNavigation();
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
    }

    private void configNavigation() {

        NavigationUI.setupWithNavController(
                bottomNavigationView,
                navController
        );

        NavigationUI.setupActionBarWithNavController(
                this,
                navController,
                drawerLayout
        );

        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.nav_home);
        topLevelDestinations.add(R.id.nav_gallery);
        topLevelDestinations.add(R.id.nav_slideshow);
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations).setDrawerLayout(drawerLayout).build();

        NavigationUI.setupWithNavController(
                findViewById(R.id.toolbar),
                navController,
                appBarConfiguration
        );

    }


    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_school_1:
                mainViewModel.setSchoolName("School 1");
                break;
            case R.id.nav_school_2:
                mainViewModel.setSchoolName("School 2");
                break;
            case R.id.nav_school_3:
                mainViewModel.setSchoolName("School 3");
                break;
            case R.id.nav_school_4:
                mainViewModel.setSchoolName("School 4");
                break;
        }
        return true;
    }
}
