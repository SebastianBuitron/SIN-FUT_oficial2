package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class metodopago extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentincial, fragment_banco, fragment_paypal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodopago);

        //fragmentincial= new metodopago();
        fragment_banco=new banco();
        fragment_paypal=new paypal();


        getSupportFragmentManager().beginTransaction().add(R.id.fragmentinicio,fragment_banco).commit ();

    }
    public void onClick (View view){
        transaction=getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.banco: transaction.replace(R.id.fragmentinicio, fragment_banco);
                transaction.addToBackStack(null);
                break;
            case R.id.paypal:transaction.replace(R.id.fragmentinicio, fragment_paypal);
                transaction.addToBackStack(null);
                break;

        }
        transaction.commit();
    }
    public void Ver_chat(View view) {

        Intent ver = new Intent(this, chat.class);

    }
    public void prueba (View view) {

        Intent ver = new Intent(this, chat.class);
        startActivity(ver);

    }

}
