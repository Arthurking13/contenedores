package com.example.contenedores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LugarTuristico {
    private String Nombre, Direccion, Telefono, UrlLogo;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }
    public LugarTuristico(JSONObject a) throws JSONException {
        Nombre =       a.getString("nombre_lugar").toString() ;
        Direccion =    a.getString("direccion").toString() ;
       Telefono =      a.getString("telefono").toString() ;
        UrlLogo =    "https://uealecpeterson.net/turismo/assets/imgs/logos_gifs/"+
                        a.getString("logo").toString() ;
    }
    public static ArrayList<LugarTuristico> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<LugarTuristico> lstLugares = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            lstLugares.add(new LugarTuristico(datos.getJSONObject(i)));
        }
        return lstLugares;
    }




}
