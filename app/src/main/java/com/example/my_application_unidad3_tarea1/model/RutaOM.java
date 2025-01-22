package com.example.my_application_unidad3_tarea1.model;

import com.example.my_application_unidad3_tarea1.R;

import java.util.ArrayList;

public class RutaOM {

    public ArrayList<Ruta> crearRutas() {
        ArrayList<Ruta> rutas = new ArrayList<>();
        rutas.add(new Ruta("Ruta matemática", R.mipmap.ic_ruta_matematicas_foreground));
        rutas.add(new Ruta("Ruta tecnológica", R.mipmap.ic_ruta_tecnologia_foreground));
        rutas.add(new Ruta("Ruta artística", R.mipmap.ic_ruta_artistica_foreground));
        rutas.add(new Ruta("Ruta literaria", R.mipmap.ic_ruta_literatura_foreground));
        return rutas;
    }

    public ArrayList<Ruta> getRutas() {
        return crearRutas();
    }
}
