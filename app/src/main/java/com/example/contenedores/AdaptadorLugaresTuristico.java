package com.example.contenedores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdaptadorLugaresTuristico extends ArrayAdapter<LugarTuristico> {
    public AdaptadorLugaresTuristico(Context context, ArrayList<LugarTuristico> datos) {
        super(context, R.layout.lyitem, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem, null);

        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        lblNombre.setText(getItem(position).getNombre());
        TextView lblDireccion = (TextView)item.findViewById(R.id.lblDireccion);
        lblDireccion.setText(getItem(position).getDireccion());
        TextView lblTelefono = (TextView)item.findViewById(R.id.lbltelefono);
        lblTelefono.setText(getItem(position).getTelefono());
        ImageView imageView = (ImageView)item.findViewById(R.id.imglogo);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlLogo())
                .into(imageView);

        return(item);
    }

}
