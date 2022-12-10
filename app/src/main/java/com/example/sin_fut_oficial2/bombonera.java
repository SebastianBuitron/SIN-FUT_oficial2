package com.example.sin_fut_oficial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class bombonera extends AppCompatActivity {
    public ViewFlipper g_bombo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bombonera);

        int images[] = {R.drawable.bombo1, R.drawable.bombo2, R.drawable.bombo3, R.drawable.bombo4, R.drawable.bombo5};
        g_bombo = findViewById(R.id.galeria_bombonera);
        for (int image : images) {
            flipperImages(image);

        }

    }
    public void flipperImages ( int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        g_bombo.addView(imageView);
        g_bombo.setFlipInterval(3000);
        g_bombo.setAutoStart(true);

        g_bombo.setInAnimation(this, android.R.anim.slide_out_right);
        g_bombo.setOutAnimation(this, android.R.anim.slide_out_right);


    }
}