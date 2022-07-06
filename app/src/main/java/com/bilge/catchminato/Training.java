package com.bilge.catchminato;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Training extends AppCompatActivity {
    TextView score;
    TextView time;
    TextView best;
    int scor;
    ImageView m0;
    ImageView m1;
    ImageView m2;
    ImageView m3;
    ImageView m4;
    ImageView m5;
    ImageView m6;
    ImageView m7;
    ImageView m8;
    ImageView m9;
    ImageView m10;
    ImageView m11;
    ImageView m12;
    ImageView m13;
    ImageView m14;
    ImageView m15;
    ImageView[] minatos;
    int topus;
    Handler hand;
    Runnable run;
    SharedPreferences topum;
    int bist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        score = findViewById(R.id.point);
        time = findViewById(R.id.time);
        best = findViewById(R.id.top);
        scor = 0;

        topum = this.getSharedPreferences("com.bilge.catchminato", Context.MODE_PRIVATE);

        topus = 0;
        bist = topum.getInt("kayitli",0);
        best.setText(""+bist);

        m0 = findViewById(R.id.m0);
        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        m4 = findViewById(R.id.m4);
        m5 = findViewById(R.id.m5);
        m6 = findViewById(R.id.m6);
        m7 = findViewById(R.id.m7);
        m8 = findViewById(R.id.m8);
        m9 = findViewById(R.id.m9);
        m10 = findViewById(R.id.m10);
        m11 = findViewById(R.id.m11);
        m12 = findViewById(R.id.m12);
        m13 = findViewById(R.id.m13);
        m14 = findViewById(R.id.m14);
        m15 = findViewById(R.id.m15);


        minatos = new ImageView[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15};
        sakla();
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                time.setText("Time's Up!");
                hand.removeCallbacks(run);
                for (ImageView image : minatos) {
                    image.setVisibility(View.INVISIBLE);
                }
                int a = Integer.parseInt(score.getText().toString());
                if (a>bist) {
                    topum.edit().putInt("kayitli", a).apply();
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(Training.this);
                alert.setTitle("Do you want to play again?");
                alert.setMessage("Nin Jaus: will you give up?");
                alert.setPositiveButton("Play Again!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Return to the menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Training.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();
            }
        }.start();
    }

    public void tik(View view) {
        scor++;
        score.setText("" + scor);
    }

    public void sakla() {

        hand = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : minatos) {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(16);
                minatos[i].setVisibility(View.VISIBLE);
                hand.postDelayed(this, 500);
            }
        };
        hand.post(run);
    }

}