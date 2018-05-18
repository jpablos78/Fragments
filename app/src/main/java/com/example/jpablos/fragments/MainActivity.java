package com.example.jpablos.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnFragmetosEmbebidos;
    private Button btnFragmentosProgramacion;
    private Button btnFragmentosConBottonNavigation;
    private Button btnFragmentosConBottonNavigationLibrary;
    private Button btnFragmentosPassData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragmetosEmbebidos = findViewById(R.id.button_fragment_1);

        btnFragmetosEmbebidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentoEmbebidoActivity.class);
                startActivity(intent);
            }
        });

        btnFragmentosProgramacion = findViewById(R.id.button_fragment_2);

        btnFragmentosProgramacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentoProgramacionActivity.class);
                startActivity(intent);
            }
        });

        btnFragmentosConBottonNavigation = findViewById(R.id.button_fragment_3);

        btnFragmentosConBottonNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentoConBottomNavigationActivity.class);
                startActivity(intent);
            }
        });

        btnFragmentosConBottonNavigationLibrary = findViewById(R.id.button_fragment_4);

        btnFragmentosConBottonNavigationLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentoConBottomNavigationLibraryActivity.class);
                startActivity(intent);
            }
        });

        btnFragmentosPassData = findViewById(R.id.button_fragment_5);

        btnFragmentosPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FragmentPassDataActivity.class);
                startActivity(intent);
            }
        });
    }
}
