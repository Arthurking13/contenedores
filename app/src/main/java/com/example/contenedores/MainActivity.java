package com.example.contenedores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    //al implementar  (implements AdapterView.OnItemSelectedListener)
    //se nos abren dos opciones en la parte inferior
        implements AdapterView.OnItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //llenar comboBox o lista
        //paso 1
        final String[] datos =
                new
                        String[]{"Alojamiento","Alimentacion y bebidas","Atractivos culturales","Esparcimiento","Compras"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        //paso 3 vista del spinner
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cbCategorias);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );
        cmbOpciones.setAdapter(adaptador);
        //esto es para que aparezca la seleccionanda
        cmbOpciones.setOnItemSelectedListener(this);
        //Listview
        //paso 1 Data
        final String[] datos2 =
                new
                        String[]{"EXPLOMUNDO",
                        "MULTICARIBE",
                        "XPLORA",
                        "CAFE Y TINTO",
                        "FANCY MINT COFFEE",
                        "SWEET LAND",
                        "TORO CAFE"
        };
        //paso 2 Adaptador
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos2);
        //paso 3
        // SE USA PARTE DE CODIGO DE SPINNER Y DE LA PAGINA LISTVIEW
        ListView lstOpciones =
                (ListView)findViewById(R.id.listlugares);
         lstOpciones.setAdapter(adaptador2);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView txtItem =
                (TextView)findViewById(R.id.txtcategoria);

        txtItem.setText("Seleccionado: " +
                parent.getItemAtPosition(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}