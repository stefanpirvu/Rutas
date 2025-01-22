package com.example.my_application_unidad3_tarea1.control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_application_unidad3_tarea1.R;
import com.example.my_application_unidad3_tarea1.model.Usuario;
import com.example.my_application_unidad3_tarea1.model.UsuarioOM;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences datosUsuariosGuardados;
    private EditText editText_NombreUsuario;
    private EditText editText_Contrasenia;
    private TextView textView_CrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datosUsuariosGuardados = getSharedPreferences("preferencias",
                Context.MODE_PRIVATE);
        String nombreUsuarioGuardado = datosUsuariosGuardados.getString("nombreUsuario", null);
        String contraseniaUsuarioGuardada = datosUsuariosGuardados.getString("contraseñaUsuario", null);
        if (nombreUsuarioGuardado != null && contraseniaUsuarioGuardada != null) {
            Intent intentAbrirDirectamenteMainActivity_Home = new Intent(MainActivity.this, MainActivity_Home.class);
            startActivity(intentAbrirDirectamenteMainActivity_Home);
            finish();
            return;
        }
        ImageView imageView_logo = findViewById(R.id.imageView_logo);
        editText_NombreUsuario = findViewById(R.id.editText_NombreUsuario);
        editText_Contrasenia = findViewById(R.id.editText_Contrasenia);
        Button button_Acceder_ComprobarCredenciales = findViewById(R.id.button_Acceder_ComprobarCredenciales);
        TextView textView_CrearCuenta = findViewById(R.id.textView_CrearCuenta);

        UsuarioOM usuarioOM = new UsuarioOM(this);
        ArrayList<Usuario> usuarios = usuarioOM.getUsuarios();

        registerForContextMenu(imageView_logo);

        // Permite al usuario acceder a su cuenta si ya tiene una

        button_Acceder_ComprobarCredenciales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_NombreUsuario.getText().toString().isEmpty() && editText_Contrasenia.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Campos vacíos!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (editText_Contrasenia.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Rellena el campo de la contraseña!", Toast.LENGTH_SHORT).show();
                    return;
                } else if (editText_NombreUsuario.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Rellena el campo del usuario!", Toast.LENGTH_SHORT).show();
                    return;
                }

                for (int i = 0; i < usuarios.size(); i++) {
                    if (usuarios.get(i).getNombreUsuario().equals(editText_NombreUsuario.getText().toString())
                            && usuarios.get(i).getContraseniaUsuario().equals(editText_Contrasenia.getText().toString())) {

                        // Si los datos son correctos, se guardan para iniciar el MainActivity_Home directamente

                        datosUsuariosGuardados.getString("nombreUsuario", editText_NombreUsuario.getText().toString());
                        datosUsuariosGuardados.getString("contraseñaUsuario", editText_Contrasenia.getText().toString());
                        SharedPreferences.Editor editor = datosUsuariosGuardados.edit();
                        editor.putString("nombreUsuario", editText_NombreUsuario.getText().toString());
                        editor.putString("contraseñaUsuario", editText_Contrasenia.getText().toString());
                        editor.apply();
                        Intent intent_AbrirMainActivity_Home_DesdeMainActivity = new Intent(view.getContext(), MainActivity_Home.class);
                        startActivity(intent_AbrirMainActivity_Home_DesdeMainActivity);
                        return;
                    }
                }

                Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        textView_CrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAbrirMainActivity_CrearCuentaDesdeMainActivity = new Intent(MainActivity.this, MainActivity_CrearCuenta.class);
                startActivity(intentAbrirMainActivity_CrearCuentaDesdeMainActivity);
                finish();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_mainactivity, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Item_llamarCentroDesdePrincipal) {
            Intent intentLlamarAlCentro = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:924281040"));
            startActivity(intentLlamarAlCentro);
            return true;
        }
        return true;
    }
}
