package com.bilge.catchminato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            database = this.openOrCreateDatabase("Coin",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS coin (id INTEGER PRIMARY KEY, miktar INT)");
            database.execSQL("INSERT INTO coin(miktar) VALUES (1000)");
            database.execSQL("INSERT INTO coin(miktar) VALUES (0)");
            database.execSQL("INSERT INTO coin(miktar) VALUES (0)");
            database.execSQL("INSERT INTO coin(miktar) VALUES (0)");
            database.execSQL("INSERT INTO coin(miktar) VALUES (1)");

            database.execSQL("DELETE FROM coin WHERE id > 5");

            // ca-app-pub-1056663813267203~9862545014     appid
            //ca-app-pub-1056663813267203/3013053871 reklamid
            // ca-app-pub-3940256099942544/6300978111 testid






        } catch (Exception e){
            e.printStackTrace();
        }
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



    }
    public void shop (View view){
        Intent intent = new Intent(MainActivity.this,Shop.class);
        startActivity(intent);
    }
    public void start (View view){
        Intent intent = new Intent(MainActivity.this,game.class);
        startActivity(intent);
    }
    public void levels (View view){
        Intent intent = new Intent(MainActivity.this,levels.class);
        startActivity(intent);
    }
    public void train (View view){
        Intent intent = new Intent(MainActivity.this,Training.class);
        startActivity(intent);
    }
}