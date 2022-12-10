package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class el_cubo extends AppCompatActivity  {
    public ViewFlipper g_cubo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_el_cubo);



        int images[] = {R.drawable.cubo1, R.drawable.cubo2, R.drawable.cubo3, R.drawable.cubo4, R.drawable.cubo5, R.drawable.cubo6};
        g_cubo = findViewById(R.id.galeria_estancia);
        for (int image : images) {
            flipperImages(image);

        }
    }
    public void flipperImages ( int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        g_cubo.addView(imageView);
        g_cubo.setFlipInterval(3000);
        g_cubo.setAutoStart(true);

        g_cubo.setInAnimation(this, android.R.anim.slide_out_right);
        g_cubo.setOutAnimation(this, android.R.anim.slide_out_right);


    }

}