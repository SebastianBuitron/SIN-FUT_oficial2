package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void VER_cubo(View view) {

        Intent ver = new Intent(this, el_cubo.class);
        startActivity(ver);

    }

    public void Ver_bombo (View view) {

        Intent ver = new Intent(this, bombonera.class);
        startActivity(ver);

    }
    public void Ver_kopana (View view) {

        Intent ver = new Intent(this, kopana.class);
        startActivity(ver);

    }

    public void Ver_maracana (View view) {

        Intent ver = new Intent(this, Marakana.class);
        startActivity(ver);

    }

    public void Ver_estancia (View view) {

        Intent ver = new Intent(this, Estancia.class);
        startActivity(ver);

    }

    public void registrarse (View view) {

        Intent ver = new Intent(this, logginNewAccount.class);
        startActivity(ver);

    }

    public void loggin (View view) {

        Intent ver = new Intent(this, loggin.class);
        startActivity(ver);

    }


}