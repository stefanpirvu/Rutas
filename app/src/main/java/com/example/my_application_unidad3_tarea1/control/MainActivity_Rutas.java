package com.example.my_application_unidad3_tarea1.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_application_unidad3_tarea1.R;
import com.example.my_application_unidad3_tarea1.model.Ruta;
import com.example.my_application_unidad3_tarea1.model.RutaOM;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity_Rutas extends AppCompatActivity implements ItemClickListener {

    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rutas);

        WebView webView_MostrarRuta = findViewById(R.id.webView_MostrarRuta);
        BottomNavigationView bottomNavigationView_MainActivityHome = findViewById(R.id.bottomNavigationView_MainActivity_Comentarios);
        bottomNavigationView_MainActivityHome.setSelectedItemId(R.id.item_Home);

        webView_MostrarRuta.loadUrl("https://es.wikiloc.com/rutas-senderismo/zahinos-zamoreja-159745434?utm_medium=app&utm_campaign=share&utm_source=13925438");

        RutaOM rutaOM = new RutaOM();
        ArrayList<Ruta> rutas = rutaOM.getRutas();

        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new MyRecyclerViewAdapter(this, rutas);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        registerForContextMenu(recyclerView);
        adapter.attachToRecyclerView(recyclerView);

        bottomNavigationView_MainActivityHome.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.item_Salir) {
                finishAffinity();
                return true;
            } else if (item.getItemId() == R.id.item_Home) {
                Intent intent_AbrirMainActivity_Home_DesdeMainActivity_Rutas = new Intent(MainActivity_Rutas.this, MainActivity_Home.class);
                startActivity(intent_AbrirMainActivity_Home_DesdeMainActivity_Rutas);
            }
            return false;
        });
    }

    @Override
    public void onItemClick(View activista, int position) {
        Ruta rutaElegida = adapter.getItem(position);
        Intent intentAbrirMainActivity_RutaConcreta = new Intent(MainActivity_Rutas.this, MainActivity_RutaConcreta.class);
        intentAbrirMainActivity_RutaConcreta.putExtra("Tipo de ruta", rutaElegida.getNombre());
        startActivity(intentAbrirMainActivity_RutaConcreta);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Abre los comentarios de esta ruta:");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_mainactivity_rutas, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = adapter.getSelectedPosition();
        if (position == RecyclerView.NO_POSITION) return false;
        Ruta ruta = adapter.getItem(position);
        if (ruta != null) {
            if (item.getItemId() == R.id.item_misComentarios) {
                if ("Ruta matemática".equals(ruta.getNombre())) {
                    String rutaMatematica = ruta.getNombre();
                    Intent intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas = new Intent(MainActivity_Rutas.this, MainActivity_Comentarios.class);
                    intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas.putExtra("Ruta matemática", rutaMatematica);
                    startActivity(intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas);

                }
                if ("Ruta tecnológica".equals(ruta.getNombre())) {
                    String rutaTecnologica = ruta.getNombre();
                    Intent intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas = new Intent(MainActivity_Rutas.this, MainActivity_Comentarios.class);
                    intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas.putExtra("Ruta tecnológica", rutaTecnologica);
                    startActivity(intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas);

                }
                if ("Ruta artística".equals(ruta.getNombre())) {
                    String rutaArtistica = ruta.getNombre();
                    Intent intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas = new Intent(MainActivity_Rutas.this, MainActivity_Comentarios.class);
                    intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas.putExtra("Ruta artística", rutaArtistica);
                    startActivity(intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas);

                }
                if ("Ruta literaria".equals(ruta.getNombre())) {
                    String rutaLiteraria = ruta.getNombre();
                    Intent intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas = new Intent(MainActivity_Rutas.this, MainActivity_Comentarios.class);
                    intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas.putExtra("Ruta literaria", rutaLiteraria);
                    startActivity(intentoAbrirMainActivity_Comentarios_DesdeMainActivity_Rutas);
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}
