package com.bilge.catchminato;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
    SQLiteDatabase database;
    TextView score;
    TextView time;
    TextView goal;
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
    ImageView saske;
    ImageView nardo;
    ImageView maru;
    TextView lvlNumber;



    Handler hand;
    Runnable run;
    SharedPreferences topum;

    Cursor sha;
    Cursor sage;
    Cursor kage;
    Cursor lvl;

    int shaAdet;
    int sageAdet;
    int kageAdet;
    int lvlAdet;

    String scoreGo;

    // Alınan bilgiler kısmı
    int hız;
    int sure;
    int hedef;

    int sharingan;
    int sagemode;
    int kagemane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        score = findViewById(R.id.point);
        time = findViewById(R.id.time);
        goal = findViewById(R.id.top);
        lvlNumber = findViewById(R.id.lvlNumber);
        scor = 0;


        topum = this.getSharedPreferences("com.bilge.catchminato", Context.MODE_PRIVATE);

        saske = findViewById(R.id.saske);
        nardo = findViewById(R.id.nardo);
        maru = findViewById(R.id.maru);

        hız = 500;
        sure = 20000;
        hedef = 18;

        database = this.openOrCreateDatabase("Coin",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS coin (id INTEGER PRIMARY KEY, miktar INT)");
        sha = database.rawQuery("SELECT * FROM coin WHERE id = 2",null);
        sage = database.rawQuery("SELECT * FROM coin WHERE id = 3",null);
        kage = database.rawQuery("SELECT * FROM coin WHERE id = 4",null);
        lvl = database.rawQuery("SELECT * FROM coin WHERE id = 5",null);

        while (lvl.moveToNext()){
            String adet = lvl.getString(1);
            lvlAdet = Integer.parseInt(adet);
        }
        lvlNumber.setText(""+lvlAdet);
        if(lvlAdet==1){
            hız = 1000;
            sure = 15000;
            hedef = 15;
        }
        else if(lvlAdet==2){
            hız = 1000;
            sure = 15000;
            hedef = 17;
        }
        else if(lvlAdet==3){
            hız = 1000;
            sure = 15000;
            hedef = 22;
        }
        else if(lvlAdet==4){
            hız = 1000;
            sure = 15000;
            hedef = 25;
        }
        else if(lvlAdet==5){
            hız = 1000;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==6){
            hız = 1000;
            sure = 15000;
            hedef = 33;
        }
        else if(lvlAdet==7){
            hız = 1000;
            sure = 15000;
            hedef = 35;
        }
        else if(lvlAdet==8){
            hız = 1000;
            sure = 15000;
            hedef = 37;
        }
        else if(lvlAdet==9){
            hız = 1000;
            sure = 15000;
            hedef = 38;
        }
        else if(lvlAdet==10){
            hız = 1000;
            sure = 16000;
            hedef = 40;
        }
        else if(lvlAdet==11){
            hız = 900;
            sure = 12000;
            hedef = 14;
        }
        else if(lvlAdet==12){
            hız = 900;
            sure = 15000;
            hedef = 18;
        }
        else if(lvlAdet==13){
            hız = 900;
            sure = 15000;
            hedef = 22;
        }
        else if(lvlAdet==14){
            hız = 900;
            sure = 15000;
            hedef = 27;
        }
        else if(lvlAdet==15){
            hız = 900;
            sure = 15000;
            hedef = 35;
        }
        else if(lvlAdet==16){
            hız = 900;
            sure = 15000;
            hedef = 37;
        }
        else if(lvlAdet==17){
            hız = 900;
            sure = 15000;
            hedef = 43;
        }
        else if(lvlAdet==18){
            hız = 900;
            sure = 17000;
            hedef = 50;
        }
        else if(lvlAdet==19){
            hız = 900;
            sure = 17000;
            hedef = 60;
        }
        else if(lvlAdet==20){
            hız = 900;
            sure = 17000;
            hedef = 70;
        }
        else if(lvlAdet==21){
            hız = 800;
            sure = 15000;
            hedef = 20;
        }
        else if(lvlAdet==22){
            hız = 800;
            sure = 20000;
            hedef = 30;
        }
        else if(lvlAdet==23){
            hız = 800;
            sure = 15000;
            hedef = 22;
        }
        else if(lvlAdet==24){
            hız = 800;
            sure = 20000;
            hedef = 35;
        }
        else if(lvlAdet==25){
            hız = 800;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==26){
            hız = 800;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==27){
            hız = 800;
            sure = 25000;
            hedef = 45;
        }
        else if(lvlAdet==28){
            hız = 800;
            sure = 25000;
            hedef = 50;
        }
        else if(lvlAdet==29){
            hız = 750;
            sure = 10000;
            hedef = 10;
        }
        else if(lvlAdet==30){
            hız = 750;
            sure = 10000;
            hedef = 15;
        }
        else if(lvlAdet==31){
            hız = 750;
            sure = 15000;
            hedef = 20;
        }
        else if(lvlAdet==32){
            hız = 750;
            sure = 20000;
            hedef = 25;
        }
        else if(lvlAdet==33){
            hız = 750;
            sure = 20000;
            hedef = 30;
        }
        else if(lvlAdet==34){
            hız = 750;
            sure = 20000;
            hedef = 32;
        }
        else if(lvlAdet==35){
            hız = 750;
            sure = 20000;
            hedef = 35;
        }else if(lvlAdet==36){
            hız = 750;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==37){
            hız = 700;
            sure = 10000;
            hedef = 15;
        }
        else if(lvlAdet==38){
            hız = 700;
            sure = 10000;
            hedef = 20;
        }
        else if(lvlAdet==39){
            hız = 700;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==40){
            hız = 700;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==41){
            hız = 700;
            sure = 20000;
            hedef = 45;
        }
        else if(lvlAdet==42){
            hız = 600;
            sure = 10000;
            hedef = 20;
        }
        else if(lvlAdet==43){
            hız = 600;
            sure = 15000;
            hedef = 35;
        }
        else if(lvlAdet==44){
            hız = 600;
            sure = 20000;
            hedef = 50;
        }
        else if(lvlAdet==45){
            hız = 550;
            sure = 10000;
            hedef = 10;
        }
        else if(lvlAdet==46){
            hız = 550;
            sure = 10000;
            hedef = 15;
        }
        else if(lvlAdet==47){
            hız = 500;
            sure = 15000;
            hedef = 20;
        }
        else if(lvlAdet==48){
            hız = 500;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==49){
            hız = 500;
            sure = 17000;
            hedef = 40;
        }
        else if(lvlAdet==50){
            hız = 500;
            sure = 20000;
            hedef = 50;
        }
        else if(lvlAdet==51){
            hız = 500;
            sure = 15000;
            hedef = 25;
        }
        else if(lvlAdet==52){
            hız = 500;
            sure = 15000;
            hedef = 32;
        }
        else if(lvlAdet==53){
            hız = 500;
            sure = 15000;
            hedef = 40;
        }
        else if(lvlAdet==54){
            hız = 500;
            sure = 20000;
            hedef = 30;
        }
        else if(lvlAdet==55){
            hız = 500;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==56){
            hız = 500;
            sure = 20000;
            hedef = 55;
        }
        else if(lvlAdet==57){
            hız = 500;
            sure = 25000;
            hedef = 30;
        }
        else if(lvlAdet==58){
            hız = 500;
            sure = 25000;
            hedef = 45;
        }
        else if(lvlAdet==59){
            hız = 500;
            sure = 25000;
            hedef = 60;
        }
        else if(lvlAdet==60){
            hız = 500;
            sure = 30000;
            hedef = 35;
        }
        else if(lvlAdet==61){
            hız = 500;
            sure = 30000;
            hedef = 45;
        }
        else if(lvlAdet==62){
            hız = 500;
            sure = 30000;
            hedef = 65;
        }
        else if(lvlAdet==63){
            hız = 450;
            sure = 15000;
            hedef = 15;
        }
        else if(lvlAdet==64){
            hız = 450;
            sure = 15000;
            hedef = 20;
        }
        else if(lvlAdet==65){
            hız = 450;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==66){
            hız = 450;
            sure = 20000;
            hedef = 25;
        }
        else if(lvlAdet==67){
            hız = 450;
            sure = 20000;
            hedef = 35;
        }
        else if(lvlAdet==68){
            hız = 450;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==69){
            hız = 450;
            sure = 25000;
            hedef = 25;
        }
        else if(lvlAdet==70){
            hız = 450;
            sure = 25000;
            hedef = 35;
        }
        else if(lvlAdet==71){
            hız = 450;
            sure = 25000;
            hedef = 50;
        }
        else if(lvlAdet==72){
            hız = 450;
            sure = 30000;
            hedef = 35;
        }
        else if(lvlAdet==73){
            hız = 450;
            sure = 30000;
            hedef = 45;
        }
        else if(lvlAdet==74){
            hız = 450;
            sure = 30000;
            hedef = 55;
        }
        else if(lvlAdet==75){
            hız = 450;
            sure = 35000;
            hedef = 40;
        }
        else if(lvlAdet==76){
            hız = 450;
            sure = 35000;
            hedef = 55;
        }
        else if(lvlAdet==77){
            hız = 450;
            sure = 35000;
            hedef = 65;
        }
        else if(lvlAdet==78){
            hız = 400;
            sure = 15000;
            hedef = 15;
        }
        else if(lvlAdet==79){
            hız = 400;
            sure = 15000;
            hedef = 20;
        }
        else if(lvlAdet==80){
            hız = 400;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==81){
            hız = 400;
            sure = 20000;
            hedef = 17;
        }
        else if(lvlAdet==82){
            hız = 400;
            sure = 20000;
            hedef = 30;
        }
        else if(lvlAdet==83){
            hız = 400;
            sure = 20000;
            hedef = 40;
        }
        else if(lvlAdet==84){
            hız = 400;
            sure = 25000;
            hedef = 20;
        }
        else if(lvlAdet==85){
            hız = 400;
            sure = 25000;
            hedef = 40;
        }
        else if(lvlAdet==86){
            hız = 400;
            sure = 25000;
            hedef = 50;
        }
        else if(lvlAdet==87){
            hız = 400;
            sure = 30000;
            hedef = 22;
        }
        else if(lvlAdet==88){
            hız = 400;
            sure = 30000;
            hedef = 38;
        }
        else if(lvlAdet==89){
            hız = 400;
            sure = 30000;
            hedef = 60;
        }
        else if(lvlAdet==90){
            hız = 400;
            sure = 35000;
            hedef = 25;
        }
        else if(lvlAdet==91){
            hız = 400;
            sure = 35000;
            hedef = 50;
        }
        else if(lvlAdet==92){
            hız = 400;
            sure = 35000;
            hedef = 75;
        }
        else if(lvlAdet==93){
            hız = 350;
            sure = 15000;
            hedef = 15;
        }
        else if(lvlAdet==94){
            hız = 350;
            sure = 15000;
            hedef = 30;
        }
        else if(lvlAdet==95){
            hız = 350;
            sure = 15000;
            hedef = 45;
        }
        else if(lvlAdet==96){
            hız = 350;
            sure = 25000;
            hedef = 20;
        }
        else if(lvlAdet==97){
            hız = 350;
            sure = 25000;
            hedef = 35;
        }
        else if(lvlAdet==98){
            hız = 350;
            sure = 25000;
            hedef = 50;
        }
        else if(lvlAdet==99){
            hız = 300;
            sure = 60000;
            hedef = 100;
        }
        else if(lvlAdet==100){
            Intent intent = new Intent(game.this,message.class);
            startActivity(intent);
        }
        else if(lvlAdet==101){
            Intent intent = new Intent(game.this,message.class);
            startActivity(intent);
        }
        else if(lvlAdet==102){
            Intent intent = new Intent(game.this,message.class);
            startActivity(intent);
        }
        else{
            hız = 1000;
            sure = 3000;
            hedef = 1;
        }

        goal.setText(""+hedef);

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
        new CountDownTimer(sure, 1000) {

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
                Toast.makeText(getApplicationContext(),a + " Coins added.",Toast.LENGTH_SHORT).show();
                if (a>=hedef) {
                    try {
                        database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 5");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    scoreGo = score.getText().toString();
                    Intent gec = new Intent(game.this,levels.class);
                    gec.putExtra("scoreAl",scoreGo);
                    finish();
                    startActivity(gec);
                }else{
                    AlertDialog.Builder lose = new AlertDialog.Builder(game.this);
                    lose.setTitle("You didn't succeed");
                    lose.setMessage("Nin Jaus: Did you think you could catch me.");
                    lose.setPositiveButton("Try Again",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });
                    lose.setNegativeButton("Return to the menu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(game.this,MainActivity.class);
                            finish();
                            startActivity(intent);
                        }
                    });
                    lose.show();
                }


            }
        }.start();
    }
    public void sharinganUse (View view){
        try{
            sha = database.rawQuery("SELECT * FROM coin WHERE id = 2",null);
            while (sha.moveToNext()){
                String adet = sha.getString(1);
                shaAdet = Integer.parseInt(adet);
            }
            if(shaAdet<1){
                Toast.makeText(getApplicationContext(),"You don't have Sharp Vision",Toast.LENGTH_SHORT).show();
            }else{
                new CountDownTimer(5000,1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {
                        sharingan = 1;
                        nardo.setVisibility(View.INVISIBLE);
                        maru.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFinish() {
                        sharingan = 0;
                        nardo.setVisibility(View.VISIBLE);
                        maru.setVisibility(View.VISIBLE);
                    }
                }.start();
                try {
                    database.execSQL("UPDATE coin SET miktar = miktar - 1 WHERE id = 2");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void sageUse (View view){
        try{
            sage = database.rawQuery("SELECT * FROM coin WHERE id = 3",null);
            while (sage.moveToNext()){
                String adet = sage.getString(1);
                sageAdet = Integer.parseInt(adet);
            }
            if(sageAdet<1){
                Toast.makeText(getApplicationContext(),"You don't have Full Strength Mode",Toast.LENGTH_SHORT).show();
            }else{
                new CountDownTimer(10000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {
                        sagemode = 1;
                        saske.setVisibility(View.INVISIBLE);
                        maru.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFinish() {
                        sagemode = 0;
                        saske.setVisibility(View.VISIBLE);
                        maru.setVisibility(View.VISIBLE);
                    }
                }.start();
                try {
                    database.execSQL("UPDATE coin SET miktar = miktar - 1 WHERE id = 3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void kageUse (View view){
        try{
            kage = database.rawQuery("SELECT * FROM coin WHERE id = 4",null);
            while (kage.moveToNext()){
                String adet = kage.getString(1);
                kageAdet = Integer.parseInt(adet);
            }
            if(kageAdet<1){
                Toast.makeText(getApplicationContext(),"You don't have Freeze Jutsu",Toast.LENGTH_SHORT).show();
            }else{
                new CountDownTimer(2000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {
                        kagemane = 1;
                        saske.setVisibility(View.INVISIBLE);
                        nardo.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFinish() {
                        kagemane = 0;
                        saske.setVisibility(View.VISIBLE);
                        nardo.setVisibility(View.VISIBLE);
                    }
                }.start();
                try {
                    database.execSQL("UPDATE coin SET miktar = miktar - 1 WHERE id = 4");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void tik(View view) {
        if(sagemode == 1){
            scor = scor + 2;
            score.setText("" + scor);
            try {
                database.execSQL("UPDATE coin SET miktar = miktar + 2 WHERE id = 1");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            scor++;
            score.setText("" + scor);
            try {
                database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void sakla() {

        hand = new Handler();
        run = new Runnable() {
            @Override
            public void run() {
                if(sharingan == 1){
                    for (ImageView image : minatos) {
                        image.setVisibility(View.INVISIBLE);
                    }
                    Random random = new Random();
                    int i = random.nextInt(16);
                    minatos[i].setVisibility(View.VISIBLE);
                    hand.postDelayed(this, hız*2);
                }else if(kagemane == 1){
                    for (ImageView image : minatos) {
                        image.setVisibility(View.INVISIBLE);
                    }
                    Random random = new Random();
                    int i = random.nextInt(16);
                    minatos[i].setVisibility(View.VISIBLE);
                    hand.postDelayed(this, 2000);
                }else{
                    for (ImageView image : minatos) {
                        image.setVisibility(View.INVISIBLE);
                    }
                    Random random = new Random();
                    int i = random.nextInt(16);
                    minatos[i].setVisibility(View.VISIBLE);
                    hand.postDelayed(this, hız);
                }

            }
        };
        hand.post(run);
    }

}