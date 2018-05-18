package com.example.jpablos.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FragmentoProgramacionActivity extends AppCompatActivity {
    private Button btnActivity;
    private Button btnAddFragment;
    private Button btnFirstFragment;
    private Button btnSecondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmento_programacion);

        btnActivity = findViewById(R.id.button_ativity);
        btnAddFragment = findViewById(R.id.button_add_fragment);
        btnFirstFragment = findViewById(R.id.button_first_fragment);
        btnSecondFragment = findViewById(R.id.button_second_fragment);

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FragmentoProgramacionActivity.this, "Click Boton Activity", Toast.LENGTH_SHORT).show();
            }
        });

        btnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFragment addFragment = new AddFragment();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.frame_layout_add, addFragment);
                ft.commit();
            }
        });

        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new FirstFragment());
            }
        });

        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SecondFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_replace, fragment);
        fragmentTransaction.commit();
    }
}
