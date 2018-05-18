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
public class PassData1Fragment extends Fragment {
    private Button btnPasarDatos;
    private TextView textViewCadena;
    private TextView textViewNumero;
    private DatosParcelable datosParcelable;

    public PassData1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pass_data1, container, false);

        textViewCadena = view.findViewById(R.id.textView_cadena_f1);
        textViewNumero = view.findViewById(R.id.textView_numero_f1);
        btnPasarDatos = view.findViewById(R.id.button_pass_data_to_activity_f1);

        Intent intent = getActivity().getIntent();

        if (intent != null) {
            String cadena = intent.getStringExtra("cadena");
            int numero = intent.getIntExtra("numero", 0);

            Toast.makeText(getActivity(), "En el Fragmento 1 Recibiendo datos de Activity con Intent", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "cadena = " + cadena, Toast.LENGTH_LONG).show();
            Toast.makeText(getActivity(), "numero = " + numero, Toast.LENGTH_LONG).show();

            textViewCadena.setText(cadena);
            textViewNumero.setText(String.valueOf(numero));
        }

        //Para obtener el objeto con bundle

        Bundle args = getArguments();

        if(args != null) {
            datosParcelable = (DatosParcelable)  args.getParcelable("datosParcelable");

            Toast.makeText(getActivity(), "Recibiendo Objetos desde Activity con Bundle", Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Cadena = " + datosParcelable.getCadena(), Toast.LENGTH_SHORT).show();
            Toast.makeText(getActivity(), "Numero = " + datosParcelable.getNumero(), Toast.LENGTH_SHORT).show();

            textViewCadena.setText(datosParcelable.getCadena());
            textViewNumero.setText(String.valueOf(datosParcelable.getNumero()));
        }

        btnPasarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), FragmentPassDataActivity.class);

                intent.putExtra("cadena", "Desde Fragmento number 1");
                intent.putExtra("numero", 777);

                getActivity().startActivity(intent);
                //startActivityForResult(intent, 111);
            }
        });

        return view;
    }

}
