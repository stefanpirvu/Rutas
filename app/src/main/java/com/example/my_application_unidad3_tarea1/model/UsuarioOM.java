package com.example.my_application_unidad3_tarea1.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsuarioOM {

    private final Context context;

    public UsuarioOM(Context context) {
        this.context = context;
    }

    public ArrayList<Usuario> cargarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            FileInputStream fis = context.openFileInput("usuarios.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    usuarios.add(new Usuario(partes[0], partes[1], partes[2], partes[3], partes[4]));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public void guardarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            FileOutputStream fos = context.openFileOutput("usuarios.txt", Context.MODE_PRIVATE);
            for (Usuario usuario : usuarios) {
                String linea = usuario.getNombre() + "," + usuario.getApellido() + "," +
                        usuario.getDNI() + "," + usuario.getNombreUsuario() + "," +
                        usuario.getContraseniaUsuario() + "\n";
                fos.write(linea.getBytes());
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = cargarUsuarios();
        if (usuarios.isEmpty()) {
            usuarios = crearUsuarios();
            guardarUsuarios(usuarios);
        }
        return usuarios;
    }

    private ArrayList<Usuario> crearUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Stefan", "Pirvu", "123456789", "ssp", "1234"));
        usuarios.add(new Usuario("Juan", "Pérez", "12345678A", "juanp", "password123"));
        usuarios.add(new Usuario("María", "Gómez", "87654321B", "mariag", "pass456"));
        usuarios.add(new Usuario("Carlos", "López", "11223344C", "carlosl", "mypassword"));
        usuarios.add(new Usuario("Ana", "Martínez", "22334455D", "anam", "abc123"));
        usuarios.add(new Usuario("Luis", "Hernández", "33445566E", "luish", "123456"));
        usuarios.add(new Usuario("Nieves", "Tejeda", "101010101D", "nieves", "1234"));
        return usuarios;
    }
}
