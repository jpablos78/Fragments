package com.example.jpablos.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class FragmentoConBottomNavigationLibraryActivity extends AppCompatActivity {
    private BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_con_bottom_navigation_library);

        loadFragment(new HomeFragment());

        bottomBar = findViewById(R.id.bottom_bar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                Fragment fragment = null;

                switch (tabId) {
                    case R.id.tab_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.tab_dashboard:
                        Toast.makeText(FragmentoConBottomNavigationLibraryActivity.this, "toy en dashboard", Toast.LENGTH_SHORT).show();
                        fragment = new DashboardFragment();
                        break;
                    case R.id.tab_profile:
                        fragment = new ProfileFragment();
                        break;
                }

                loadFragment(fragment);
            }
        });

        //bottomBar.setDefaultTabPosition(1); //para cambiar el tab por default, seleccion por posicion
        bottomBar.setDefaultTab(R.id.tab_dashboard);  //para cambiar el tab por default, seleccion por id element
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container_2, fragment)
                    .commit();

            //return true;
        }

        //return false;
    }
}
