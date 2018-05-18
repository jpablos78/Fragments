package com.example.jpablos.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class FragmentoConBottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_con_bottom_navigation);

        loadFragment(new HomeFragment());

        BottomNavigationView btnNavigation = findViewById(R.id.navigation);
        btnNavigation.setOnNavigationItemSelectedListener(this);
        btnNavigation.setSelectedItemId(R.id.navigation_notifications);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();

            return true;
        }

        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                fragment = new DashboardFragment();
                break;
            case R.id.navigation_notifications:
                fragment= new NotificationsFragment();
                break;
            case R.id.navigation_profile:
                fragment =new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
