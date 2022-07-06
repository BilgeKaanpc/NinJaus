package com.bilge.catchminato;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class levels extends AppCompatActivity {
    private AdView mAdView;
    TextView score;
    TextView coinsAdd;
    TextView totalCoins;
    TextView lvl;
    SQLiteDatabase database;
    Cursor mani;
    Cursor sevi;
    String shopCoins;
    String seviyem;
    int seviyesu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        score = findViewById(R.id.scoreLvl);
        coinsAdd = findViewById(R.id.coinsAdd);
        totalCoins = findViewById(R.id.totalCoins);
        lvl = findViewById(R.id.nextLvl);
        database = this.openOrCreateDatabase("Coin",MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS coin (id INTEGER PRIMARY KEY, miktar INT)");
        mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
        sevi = database.rawQuery("SELECT * FROM coin WHERE id = 5",null);

        while (mani.moveToNext()){
            shopCoins = mani.getString(1);
        }
        totalCoins.setText(""+shopCoins);
        while (sevi.moveToNext()){
            seviyem = sevi.getString(1);
        }
        lvl.setText(""+seviyem);

        Intent getir = getIntent();
        String ahaScore =getir.getStringExtra("scoreAl");
        score.setText(""+ahaScore);
        coinsAdd.setText(""+ahaScore);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }
    public void nextLevel (View view){
        sevi = database.rawQuery("SELECT * FROM coin WHERE id = 5",null);
        while (sevi.moveToNext()){
            seviyem = sevi.getString(1);
            seviyesu = Integer.parseInt(seviyem);
        }
        if(seviyesu==2 || seviyesu==8 || seviyesu==12 || seviyesu==17 || seviyesu==22 || seviyesu==28 || seviyesu==35 || seviyesu==52 || seviyesu==65 || seviyesu==80 || seviyesu==86 || seviyesu==96){
            AlertDialog.Builder lose = new AlertDialog.Builder(levels.this);
            lose.setTitle("There is a message from Nin Jaus.");
            lose.setPositiveButton("See the message.",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(levels.this, message.class);
                    finish();
                    startActivity(intent);
                }
            });
            lose.show();
            }
        else if(seviyesu==15){
            AlertDialog.Builder lose = new AlertDialog.Builder(levels.this);
            lose.setTitle("Message from an unknown person.");
            lose.setPositiveButton("See the message.",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(levels.this, message.class);
                    finish();
                    startActivity(intent);
                }
            });
            lose.show();
        }
        else if(seviyesu==25 || seviyesu == 51){
            AlertDialog.Builder lose = new AlertDialog.Builder(levels.this);
            lose.setTitle("Message from a masked man.");
            lose.setPositiveButton("See the message.",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(levels.this, message.class);
                    finish();
                    startActivity(intent);
                }
            });
            lose.show();
        }
        else if(seviyesu==76 || seviyesu==100){
            AlertDialog.Builder lose = new AlertDialog.Builder(levels.this);
            lose.setTitle("There is a message from Kain.");
            lose.setPositiveButton("See the message.",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(levels.this, message.class);
                    finish();
                    startActivity(intent);
                }
            });
            lose.show();
        }

        else {
            Intent intent = new Intent(levels.this, game.class);
            finish();
            startActivity(intent);
        }
    }
}