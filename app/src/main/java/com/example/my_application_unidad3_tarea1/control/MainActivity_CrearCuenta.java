package com.example.my_application_unidad3_tarea1.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_application_unidad3_tarea1.R;
import com.example.my_application_unidad3_tarea1.model.Usuario;
import com.example.my_application_unidad3_tarea1.model.UsuarioOM;

import java.util.ArrayList;

public class MainActivity_CrearCuenta extends AppCompatActivity {

    private EditText editText_recogerNombre;
    private EditText editText_recogerApellido;
    private EditText editText_recogerDNI;
    private EditText editText_recogerNombreDeUsuario;
    private EditText editText_recogerContrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_crear_cuenta);

        editText_recogerNombre = findViewById(R.id.editText_recogerNombre);
        editText_recogerApellido = findViewById(R.id.editText_recogerApellido);
        editText_recogerDNI = findViewById(R.id.editText_recogerDNI);
        editText_recogerNombreDeUsuario = findViewById(R.id.editText_recogerNombreDeUsuario);
        editText_recogerContrasenia = findViewById(R.id.editText_recogerContrasenia);
        Button button_crearCuenta = findViewById(R.id.button_crearCuenta);

        UsuarioOM usuarioOM = new UsuarioOM(this);
        ArrayList<Usuario> usuarios = usuarioOM.getUsuarios();

        button_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_recogerNombre.getText().toString().isEmpty() ||
                        editText_recogerApellido.getText().toString().isEmpty() ||
                        editText_recogerDNI.getText().toString().isEmpty() ||
                        editText_recogerNombreDeUsuario.getText().toString().isEmpty() ||
                        editText_recogerContrasenia.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity_CrearCuenta.this, "Rellena todos los campos!", Toast.LENGTH_SHORT).show();
                } else {
                    boolean usuarioExistente = false;
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNombreUsuario().equals(editText_recogerNombreDeUsuario.getText().toString()) ||
                                usuario.getDNI().equals(editText_recogerDNI.getText().toString())) {
                            usuarioExistente = true;
                            break;
                        }
                    }
                    if (!usuarioExistente) {
                        Usuario nuevoUsuario = new Usuario(
                                editText_recogerNombre.getText().toString(),
                                editText_recogerApellido.getText().toString(),
                                editText_recogerDNI.getText().toString(),
                                editText_recogerNombreDeUsuario.getText().toString(),
                                editText_recogerContrasenia.getText().toString()
                        );
                        usuarios.add(nuevoUsuario);
                        usuarioOM.guardarUsuarios(usuarios);
                        Toast.makeText(MainActivity_CrearCuenta.this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                        Intent intentVolverA_MainActivity = new Intent(MainActivity_CrearCuenta.this, MainActivity.class);
                        startActivity(intentVolverA_MainActivity);
                    } else {
                        Toast.makeText(MainActivity_CrearCuenta.this, "Nombre de usuario o DNI ya existentes", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}