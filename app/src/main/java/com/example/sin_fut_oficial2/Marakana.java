package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Marakana extends AppCompatActivity {
    public ViewFlipper maracana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marakana);

        int images[] = {R.drawable.maracana1, R.drawable.maracana2, R.drawable.maracana3, R.drawable.maracana4, R.drawable.maracana5};
        maracana = findViewById(R.id.galeria_estancia);
        for (int image : images) {
            flipperImages(image);

        }
    }

    public void flipperImages ( int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        maracana.addView(imageView);
        maracana.setFlipInterval(3000);
        maracana.setAutoStart(true);

        maracana.setInAnimation(this, android.R.anim.slide_out_right);
        maracana.setOutAnimation(this, android.R.anim.slide_out_right);


    }
    public void Ver_metodopagooooo(View view) {

        Intent ver = new Intent(this, metodopago.class);
        startActivity(ver);

    }

}