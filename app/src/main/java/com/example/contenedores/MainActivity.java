package com.example.contenedores;

import static java.lang.invoke.VarHandle.AccessMode.GET;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity
    //al implementar  (implements AdapterView.OnItemSelectedListener)
    //se nos abren dos opciones en la parte inferior
        implements AdapterView.OnItemSelectedListener, Asynchtask {



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

        Map<String, String> datos2 = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://uealecpeterson.net/turismo/lugar_turistico/json_getlistadoGrid",
                datos2, MainActivity.this, MainActivity.this);
        ws.execute("GET");



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

    @Override
    public void processFinish(String result) throws JSONException {
        //paso 1 Data
        ArrayList<LugarTuristico> ListaLugaresTuristico = new
                ArrayList<LugarTuristico> ();

        JSONObject lista= new JSONObject(result);
        JSONArray JSONlista = lista.getJSONArray("data");

       ListaLugaresTuristico = LugarTuristico.JsonObjectsBuild(JSONlista);
        AdaptadorLugaresTuristico adapatorLugares =
                new AdaptadorLugaresTuristico(this, ListaLugaresTuristico);
        ListView lstOpciones = (ListView)findViewById(R.id.listlugares);
        lstOpciones.setAdapter(adapatorLugares);


       /* JSONObject lista= new JSONObject(result);
        JSONArray JSONlista = lista.getJSONArray("data");
        for(int i=0; i< JSONlista.length();i++) {
            JSONObject lugar =
                    JSONlista.getJSONObject(i);
            lstLugares.add(lugar.getString("nombre_lugar").toString());
        }
        //paso 2 Adaptador
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, lstLugares);*/
        //paso 3
        // SE USA PARTE DE CODIGO DE SPINNER Y DE LA PAGINA LISTVIEW


    }


}