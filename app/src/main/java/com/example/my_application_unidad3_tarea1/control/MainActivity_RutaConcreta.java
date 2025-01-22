package com.example.my_application_unidad3_tarea1.control;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_application_unidad3_tarea1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_RutaConcreta extends AppCompatActivity {

    private EditText editText_Contrasenia_1;
    private EditText editText_Contrasenia_2;
    private EditText editText_Contrasenia_3;
    private EditText editText_Contrasenia_4;

    private ImageView imageView_bloqueado_1;
    private ImageView imageView_bloqueado_2;
    private ImageView imageView_bloqueado_3;
    private ImageView imageView_bloqueado_4;

    private ImageView imageView_desbloqueado_1;
    private ImageView imageView_desbloqueado_2;
    private ImageView imageView_desbloqueado_3;
    private ImageView imageView_desbloqueado_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ruta_concreta);

        editText_Contrasenia_1 = findViewById(R.id.editText_Contrasenia_1);
        editText_Contrasenia_2 = findViewById(R.id.editText_Contrasenia_2);
        editText_Contrasenia_3 = findViewById(R.id.editText_Contrasenia_3);
        editText_Contrasenia_4 = findViewById(R.id.editText_Contrasenia_4);

        imageView_bloqueado_1 = findViewById(R.id.imageView_bloqueado_1);
        imageView_bloqueado_2 = findViewById(R.id.imageView_bloqueado_2);
        imageView_bloqueado_3 = findViewById(R.id.imageView_bloqueado_3);
        imageView_bloqueado_4 = findViewById(R.id.imageView_bloqueado_4);

        imageView_desbloqueado_1 = findViewById(R.id.imageView_desbloqueado_1);
        imageView_desbloqueado_1.setVisibility(View.INVISIBLE);
        imageView_desbloqueado_2 = findViewById(R.id.imageView_desbloqueado_2);
        imageView_desbloqueado_2.setVisibility(View.INVISIBLE);
        imageView_desbloqueado_3 = findViewById(R.id.imageView_desbloqueado_3);
        imageView_desbloqueado_3.setVisibility(View.INVISIBLE);
        imageView_desbloqueado_4 = findViewById(R.id.imageView_desbloqueado_4);
        imageView_desbloqueado_4.setVisibility(View.INVISIBLE);

        Button button_Verificar_1 = findViewById(R.id.button_Verificar_1);
        Button button_Verificar_2 = findViewById(R.id.button_Verificar_2);
        Button button_Verificar_3 = findViewById(R.id.button_Verificar_3);
        Button button_Verificar_4 = findViewById(R.id.button_Verificar_4);

        ImageView imageView_fondoMatematicas = findViewById(R.id.imageView_fondoMatematicas);
        imageView_fondoMatematicas.setVisibility(View.INVISIBLE);
        ImageView imageView_fondoTecnologias = findViewById(R.id.imageView_fondoTecnologias);
        imageView_fondoTecnologias.setVisibility(View.INVISIBLE);
        ImageView imageView_fondoArtistico = findViewById(R.id.imageView_fondoArtistico);
        imageView_fondoArtistico.setVisibility(View.INVISIBLE);
        ImageView imageView_fondoLiterario = findViewById(R.id.imageView_fondoLiterario);
        imageView_fondoLiterario.setVisibility(View.INVISIBLE);

        BottomNavigationView bottomNavigationView_MainActivityHome = findViewById(R.id.bottomNavigationView_MainActivity_Comentarios);

        Intent recogerDatos = getIntent();
        String tipoDeRuta = recogerDatos.getStringExtra("Tipo de ruta");

        if (tipoDeRuta.equals("Ruta matemática")) {
            imageView_fondoMatematicas.setVisibility(View.VISIBLE);
        } else if (tipoDeRuta.equals("Ruta tecnológica")) {
            imageView_fondoTecnologias.setVisibility(View.VISIBLE);
        } else if (tipoDeRuta.equals("Ruta artística")) {
            imageView_fondoArtistico.setVisibility(View.VISIBLE);
        } else if (tipoDeRuta.equals("Ruta literaria")) {
            imageView_fondoLiterario.setVisibility(View.VISIBLE);
        }

        button_Verificar_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_Contrasenia_1.getText().toString().equals("Contraseña_1") && tipoDeRuta.equals("Ruta matemática")) {
                    Intent intentAbrirWebEnigma1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    imageView_bloqueado_1.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_1.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma1);
                } else if (editText_Contrasenia_1.getText().toString().equals("Contraseña_1") && tipoDeRuta.equals("Ruta tecnológica")) {
                    Intent intentAbrirWebEnigma1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"));
                    imageView_bloqueado_1.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_1.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma1);
                } else if (editText_Contrasenia_1.getText().toString().equals("Contraseña_1") && tipoDeRuta.equals("Ruta artística")) {
                    Intent intentAbrirWebEnigma1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.as.com"));
                    imageView_bloqueado_1.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_1.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma1);
                } else if (editText_Contrasenia_1.getText().toString().equals("Contraseña_1") && tipoDeRuta.equals("Ruta literaria")) {
                    Intent intentAbrirWebEnigma1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    imageView_bloqueado_1.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_1.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma1);
                } else if (editText_Contrasenia_1.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Introduce la contraseña!", Toast.LENGTH_SHORT).show();
                } else if (!editText_Contrasenia_1.getText().toString().equals("Contraseña_1")) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Verificar_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_Contrasenia_2.getText().toString().equals("Contraseña_2") && tipoDeRuta.equals("Ruta matemática")) {
                    Intent intentAbrirWebEnigma2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    imageView_bloqueado_2.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_2.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma2);
                } else if (editText_Contrasenia_2.getText().toString().equals("Contraseña_2") && tipoDeRuta.equals("Ruta tecnológica")) {
                    Intent intentAbrirWebEnigma2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"));
                    imageView_bloqueado_2.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_2.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma2);
                } else if (editText_Contrasenia_2.getText().toString().equals("Contraseña_2") && tipoDeRuta.equals("Ruta artística")) {
                    Intent intentAbrirWebEnigma2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.as.com"));
                    imageView_bloqueado_2.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_2.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma2);
                } else if (editText_Contrasenia_2.getText().toString().equals("Contraseña_2") && tipoDeRuta.equals("Ruta literaria")) {
                    Intent intentAbrirWebEnigma2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    imageView_bloqueado_2.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_2.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma2);
                } else if (editText_Contrasenia_2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Introduce la contraseña!", Toast.LENGTH_SHORT).show();
                } else if (!editText_Contrasenia_2.getText().toString().equals("Contraseña_2")) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Verificar_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_Contrasenia_3.getText().toString().equals("Contraseña_3") && tipoDeRuta.equals("Ruta matemática")) {
                    Intent intentAbrirWebEnigma3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    imageView_bloqueado_3.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_3.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma3);
                } else if (editText_Contrasenia_3.getText().toString().equals("Contraseña_3") && tipoDeRuta.equals("Ruta tecnológica")) {
                    Intent intentAbrirWebEnigma3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"));
                    imageView_bloqueado_3.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_3.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma3);
                } else if (editText_Contrasenia_3.getText().toString().equals("Contraseña_3") && tipoDeRuta.equals("Ruta artística")) {
                    Intent intentAbrirWebEnigma3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.as.com"));
                    imageView_bloqueado_3.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_3.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma3);
                } else if (editText_Contrasenia_3.getText().toString().equals("Contraseña_3") && tipoDeRuta.equals("Ruta literaria")) {
                    Intent intentAbrirWebEnigma3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    imageView_bloqueado_3.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_3.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma3);
                } else if (editText_Contrasenia_3.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Introduce la contraseña!", Toast.LENGTH_SHORT).show();
                } else if (!editText_Contrasenia_3.getText().toString().equals("Contraseña_3")) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button_Verificar_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_Contrasenia_4.getText().toString().equals("Contraseña_4") && tipoDeRuta.equals("Ruta matemática")) {
                    Intent intentAbrirWebEnigma4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    imageView_bloqueado_4.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_4.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma4);
                } else if (editText_Contrasenia_4.getText().toString().equals("Contraseña_4") && tipoDeRuta.equals("Ruta tecnológica")) {
                    Intent intentAbrirWebEnigma4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"));
                    imageView_bloqueado_4.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_4.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma4);
                } else if (editText_Contrasenia_4.getText().toString().equals("Contraseña_4") && tipoDeRuta.equals("Ruta artística")) {
                    Intent intentAbrirWebEnigma4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.as.com"));
                    imageView_bloqueado_4.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_4.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma4);
                } else if (editText_Contrasenia_4.getText().toString().equals("Contraseña_4") && tipoDeRuta.equals("Ruta literaria")) {
                    Intent intentAbrirWebEnigma4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                    imageView_bloqueado_4.setVisibility(View.INVISIBLE);
                    imageView_desbloqueado_4.setVisibility(View.VISIBLE);
                    startActivity(intentAbrirWebEnigma4);
                } else if (editText_Contrasenia_4.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Introduce la contraseña!", Toast.LENGTH_SHORT).show();
                } else if (!editText_Contrasenia_4.getText().toString().equals("Contraseña_4")) {
                    Toast.makeText(MainActivity_RutaConcreta.this, "Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomNavigationView_MainActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_Salir) {
                    finishAffinity();
                    return true;
                } else if (item.getItemId() == R.id.item_Home) {
                    Intent intent_AbrirMainActivity_Home_DesdeMainActivity_RutaConcreta = new Intent(MainActivity_RutaConcreta.this, MainActivity_Home.class);
                    startActivity(intent_AbrirMainActivity_Home_DesdeMainActivity_RutaConcreta);
                } else if (item.getItemId() == R.id.item_Rutas) {
                    Intent intent_AbrirMainActivity_Rutas_DesdeMainActivity_RutaConcreta = new Intent(MainActivity_RutaConcreta.this, MainActivity_Rutas.class);
                    startActivity(intent_AbrirMainActivity_Rutas_DesdeMainActivity_RutaConcreta);
                }
                return false;
            }
        });
    }
}
