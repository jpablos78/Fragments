package com.example.jpablos.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentPassDataActivity extends AppCompatActivity {
    private Button btnIntent;
    private Button btnBundle;
    private Button btnSerializable;
    private Button btnParcelable;
    private EditText txtCadena;
    private EditText txtNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pass_data);

        btnIntent = findViewById(R.id.btn_intent);
        btnBundle = findViewById(R.id.btn_bundle);
        btnSerializable = findViewById(R.id.btn_serializable);
        btnParcelable = findViewById(R.id.btn_parcelable);
        txtCadena = findViewById(R.id.editText_cadena);
        txtNumero = findViewById(R.id.editText_numero);


        btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PassData1Fragment();

                Intent intent = getIntent();

                intent.putExtra("cadena", txtCadena.getText().toString());
                intent.putExtra("numero", Integer.parseInt(txtNumero.getText().toString()));

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment_1, fragment)
                        .commit();

            }
        });

        btnBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PassData2Fragment();
                Bundle bundle = new Bundle();

                bundle.putString("cadena", txtCadena.getText().toString());
                bundle.putInt("numero", Integer.parseInt(txtNumero.getText().toString()));

                fragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment_2, fragment)
                        .commit();
            }
        });

        btnParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PassData1Fragment();

                Bundle bundle = new Bundle();

                DatosParcelable datosParcelable = new DatosParcelable(txtCadena.getText().toString(), Integer.parseInt(txtNumero.getText().toString()));

                bundle.putParcelable("datosParcelable", datosParcelable);
                fragment.setArguments(bundle);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment_1, fragment)
                        .commit();
            }
        });

        btnSerializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PassData2Fragment();

                Intent intent = getIntent();
                DatosSerializable datosSerializable = new DatosSerializable(txtCadena.getText().toString(), Integer.parseInt(txtNumero.getText().toString()));

                intent.putExtra("datosSerializable", datosSerializable);

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame_layout_fragment_2, fragment)
                        .commit();
            }
        });

//recibiendo los datos desde fragment2 con intent

        if (getIntent() != null) {
            if (getIntent().hasExtra("cadena")) {
                Toast.makeText(this, "Cadena desde Fragment2: " + getIntent().getStringExtra("cadena"), Toast.LENGTH_SHORT).show();
                txtCadena.setText(getIntent().getStringExtra("cadena"));
            }
            if (getIntent().hasExtra("numero")) {
                Toast.makeText(this, "Cadena desde Fragment2: " + String.valueOf(getIntent().getIntExtra("numero", 0)), Toast.LENGTH_SHORT).show();
                txtNumero.setText(String.valueOf(getIntent().getIntExtra("numero", 0)));
            }
        }


//        if (getIntent() != null) {

//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
    }
}
