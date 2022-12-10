package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class kopana extends AppCompatActivity {
    public ViewFlipper kopana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopana);

        int images[] = {R.drawable.kopana1, R.drawable.kopana2, R.drawable.kopana3, R.drawable.kopana4,R.drawable.kopana5};
        kopana = findViewById(R.id.galeria_kopana);
        for (int image : images) {
            flipperImages(image);

        }
    }
    public void flipperImages ( int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        kopana.addView(imageView);
        kopana.setFlipInterval(3000);
        kopana.setAutoStart(true);

        kopana.setInAnimation(this, android.R.anim.slide_out_right);
        kopana.setOutAnimation(this, android.R.anim.slide_out_right);


    }
}