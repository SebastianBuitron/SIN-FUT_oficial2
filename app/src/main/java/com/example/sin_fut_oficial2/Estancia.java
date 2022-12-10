package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Estancia extends AppCompatActivity {
    public ViewFlipper estancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estancia);


        int images[] = {R.drawable.estancia1, R.drawable.estancia2, R.drawable.estancia3, R.drawable.estancia4, R.drawable.estancia5};
        estancia = findViewById(R.id.galeria_estancia);
        for (int image : images) {
            flipperImages(image);

        }



    }
    public void flipperImages ( int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        estancia.addView(imageView);
        estancia.setFlipInterval(3000);
        estancia.setAutoStart(true);

        estancia.setInAnimation(this, android.R.anim.slide_out_right);
        estancia.setOutAnimation(this, android.R.anim.slide_out_right);


    }


}