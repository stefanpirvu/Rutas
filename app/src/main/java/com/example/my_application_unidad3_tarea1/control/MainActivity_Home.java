package com.example.my_application_unidad3_tarea1.control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.my_application_unidad3_tarea1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity_Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        Toolbar toolbar_Home = findViewById(R.id.toolbar_Home);
        setSupportActionBar(toolbar_Home);

        WebView webView_mostrarWebCentro = findViewById(R.id.webView_mostrarWebCentro);
        webView_mostrarWebCentro.loadUrl("https://iesocuatroabril.educarex.es/");

        BottomNavigationView bottomNavigationView_MainActivityHome = findViewById(R.id.bottomNavigationView_MainActivity_Comentarios);
        bottomNavigationView_MainActivityHome.setSelectedItemId(R.id.item_Home);
        bottomNavigationView_MainActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_Salir) {
                    finishAffinity();
                    return true;
                } else if (item.getItemId() == R.id.item_Rutas) {
                    Intent intentLlevarA_MainActivity_Rutas_Desde_MainActivityHome = new Intent(MainActivity_Home.this, MainActivity_Rutas.class);
                    startActivity(intentLlevarA_MainActivity_Rutas_Desde_MainActivityHome);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mainactivityhome_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.llamarAlCentro) {
            Intent intentLlamarAlCentro = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:924281040"));
            startActivity(intentLlamarAlCentro);
            return true;

        } else if (itemId == R.id.visitarNuestraWeb) {
            Intent intentAbrirWebCentro = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iesocuatroabril.educarex.es/"));
            startActivity(intentAbrirWebCentro);
            return true;

        } else if (itemId == R.id.visitarNuestraRadio) {
            Intent intentAbrirWebRadioCentro = new Intent(Intent.ACTION_VIEW, Uri.parse("https://radioedu.educarex.es/radio4deabril/"));
            startActivity(intentAbrirWebRadioCentro);
            return true;
        } else if (itemId == R.id.cerrarSesion) {
            SharedPreferences datosUsuariosGuardados = getSharedPreferences("preferencias",
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = datosUsuariosGuardados.edit();
            editor.putString("nombreUsuario", null);
            editor.putString("contraseñaUsuario", null);
            editor.apply();
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
