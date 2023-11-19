package com.example.proyecto11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        // "datos" es el nombre del fichero donde se guardan los datos y Context.MODE_PRIVATE indica que solo la aplicación puede acceder a los datos
        SharedPreferences pref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(pref.getString("mail", "")); // "" es el valor por defecto si no encuentra nada en la clave "mail" del fichero "datos"

    }
    //
    @Override
    // Este método se ejecuta cuando se pulsa el botón de menú
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void ejecutar(View view){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("mail", et1.getText().toString());
        editor.commit();
        finish();
    }
}