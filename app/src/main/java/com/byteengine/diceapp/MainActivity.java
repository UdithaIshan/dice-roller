package com.byteengine.diceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img1 = findViewById(R.id.img1);
        final ImageView img2 = findViewById(R.id.img2);
        Button btn = findViewById(R.id.btnRoller);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);
        final Random number = new Random();

        final int[] imgArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int randomNum1 = number.nextInt(6);
                final int randomNum2 = number.nextInt(6);
                img1.setImageResource(imgArray[randomNum1]);
                img2.setImageResource(imgArray[randomNum2]);

                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(img1);
                YoYo.with(Techniques.Tada)
                        .duration(500)
                        .repeat(0)
                        .playOn(img2);

                mp.start();
            }
        });


    }
}