package com.example.jpablos.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PassData2Fragment extends Fragment {
    private Button btnPasarDatos;
    private TextView textViewCadena;
    private TextView textViewNumero;
    private DatosSerializable datosSerializable;

    public PassData2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pass_data2, container, false);

        textViewCadena = view.findViewById(R.id.textView_cadena);
        textViewNumero = view.findViewById(R.id.textView_numero);
        btnPasarDatos = view.findViewById(R.id.button_pass_data_to_activity);

        Bundle args = getArguments();

        if(args != null) {
            String cadena = args.getString("cadena");
            int numero = args.getInt("numero");


            Toast.makeText(getActivity(), "En el Fragmento 2 Recibiendo datos de Activity con Bundle", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "cadena = " + cadena, Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), "numero = " + numero, Toast.LENGTH_LONG).show();

            textViewCadena.setText(cadena);
            textViewNumero.setText(String.valueOf(numero));
        }

        //para obtener el objeto

        Intent intent = getActivity().getIntent();

        if (intent != null) {
            if (intent.hasExtra("datosSerializable")) {
                datosSerializable = (DatosSerializable) intent.getSerializableExtra("datosSerializable");

                Toast.makeText(getActivity(), "Recibiendo Objetos desde Activity con Intent", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Cadena = " + datosSerializable.getCadena(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Numero = " + datosSerializable.getNumero(), Toast.LENGTH_SHORT).show();

                textViewCadena.setText(datosSerializable.getCadena());
                textViewNumero.setText(String.valueOf(datosSerializable.getNumero()));
            }
        }


        btnPasarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), FragmentPassDataActivity.class);
                //Bundle bundle = new Bundle();

                intent.putExtra("cadena", "Desde Fragmento 2");
                intent.putExtra("numero", 99);

                getActivity().startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
