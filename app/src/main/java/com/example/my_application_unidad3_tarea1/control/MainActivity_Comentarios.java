package com.example.my_application_unidad3_tarea1.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.my_application_unidad3_tarea1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity_Comentarios extends AppCompatActivity {

    private EditText editText_misComentarios;
    private Button button_guardar;
    private Button button_recuperarDatos;
    private BottomNavigationView bottomNavigationView_MainActivity_Comentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_comentarios);

        editText_misComentarios = findViewById(R.id.editText_misComentarios);
        button_guardar = findViewById(R.id.button_guardar);
        button_recuperarDatos = findViewById(R.id.button_recuperarDatos);
        bottomNavigationView_MainActivity_Comentarios = findViewById(R.id.bottomNavigationView_MainActivity_Comentarios);

        Intent recogerDatos = getIntent();
        String rutaMatemática = recogerDatos.getStringExtra("Ruta matemática");
        String rutaTecnológica = recogerDatos.getStringExtra("Ruta tecnológica");
        String rutaArtística = recogerDatos.getStringExtra("Ruta artística");
        String rutaLiteraria = recogerDatos.getStringExtra("Ruta literaria");

        bottomNavigationView_MainActivity_Comentarios.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.item_Salir) {
                    finishAffinity();
                    return true;
                } else if (item.getItemId() == R.id.item_Rutas) {
                    Intent intentLlevarA_MainActivity_Rutas_Desde_MainActivityHome = new Intent(MainActivity_Comentarios.this, MainActivity_Rutas.class);
                    startActivity(intentLlevarA_MainActivity_Rutas_Desde_MainActivityHome);
                    return true;
                } else if (item.getItemId() == R.id.item_Home) {
                    Intent intent_AbrirMainActivity_Home_DesdeMainActivity_Rutas = new Intent(MainActivity_Comentarios.this, MainActivity_Home.class);
                    startActivity(intent_AbrirMainActivity_Home_DesdeMainActivity_Rutas);
                }
                return false;
            }
        });

        button_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rutaMatemática != null) {
                    try {
                        OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("comentarios_rutaMatematica.txt", 0));
                        outputWriter.write(editText_misComentarios.getText().toString());
                        outputWriter.flush();
                        outputWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaTecnológica != null) {
                    try {
                        OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("comentarios_rutaTecnologica.txt", 0));
                        outputWriter.write(editText_misComentarios.getText().toString());
                        outputWriter.flush();
                        outputWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaArtística != null) {
                    try {
                        OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("comentarios_rutaArtistica.txt", 0));
                        outputWriter.write(editText_misComentarios.getText().toString());
                        outputWriter.flush();
                        outputWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaLiteraria != null) {
                    try {
                        OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("comentarios_rutaLiteraria.txt", 0));
                        outputWriter.write(editText_misComentarios.getText().toString());
                        outputWriter.flush();
                        outputWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        button_recuperarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rutaMatemática != null) {
                    try {
                        InputStream inputWriter = openFileInput("comentarios_rutaMatematica.txt");
                        if (inputWriter != null) {
                            InputStreamReader inputReader = new InputStreamReader(inputWriter);
                            BufferedReader bufferedReader = new BufferedReader(inputReader);
                            String str;
                            StringBuffer stringBuffer = new StringBuffer();
                            while ((str = bufferedReader.readLine()) != null) {
                                stringBuffer.append(str + "\n");
                            }
                            inputWriter.close();
                            editText_misComentarios.setText(stringBuffer.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaTecnológica != null) {
                    try {
                        InputStream inputWriter = openFileInput("comentarios_rutaTecnologica.txt");
                        if (inputWriter != null) {
                            InputStreamReader inputReader = new InputStreamReader(inputWriter);
                            BufferedReader bufferedReader = new BufferedReader(inputReader);
                            String str;
                            StringBuffer stringBuffer = new StringBuffer();
                            while ((str = bufferedReader.readLine()) != null) {
                                stringBuffer.append(str + "\n");
                            }
                            inputWriter.close();
                            editText_misComentarios.setText(stringBuffer.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaArtística != null) {
                    try {
                        InputStream inputWriter = openFileInput("comentarios_rutaArtistica.txt");
                        if (inputWriter != null) {
                            InputStreamReader inputReader = new InputStreamReader(inputWriter);
                            BufferedReader bufferedReader = new BufferedReader(inputReader);
                            String str;
                            StringBuffer stringBuffer = new StringBuffer();
                            while ((str = bufferedReader.readLine()) != null) {
                                stringBuffer.append(str + "\n");
                            }
                            inputWriter.close();
                            editText_misComentarios.setText(stringBuffer.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (rutaLiteraria != null) {
                    try {
                        InputStream inputWriter = openFileInput("comentarios_rutaLiteraria.txt");
                        if (inputWriter != null) {
                            InputStreamReader inputReader = new InputStreamReader(inputWriter);
                            BufferedReader bufferedReader = new BufferedReader(inputReader);
                            String str;
                            StringBuffer stringBuffer = new StringBuffer();
                            while ((str = bufferedReader.readLine()) != null) {
                                stringBuffer.append(str + "\n");
                            }
                            inputWriter.close();
                            editText_misComentarios.setText(stringBuffer.toString());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }
}