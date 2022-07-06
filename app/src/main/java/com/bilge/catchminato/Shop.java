package com.bilge.catchminato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {
    SQLiteDatabase database;
    Cursor cursor;
    Cursor mani;
    Cursor sha;
    Cursor sage;
    Cursor kage;
    int asıl;
    TextView coinView;
    String shopCoins;
    Button sham;
    Button sagem;
    Button kagem;
    String sasuke;
    String naruto;
    String shika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        sham = findViewById(R.id.sharinganBuyButton);
        sagem = findViewById(R.id.sageBuyButton);
        kagem = findViewById(R.id.kageBuyButton);
        coinView = findViewById(R.id.coinis);
try {
    database = this.openOrCreateDatabase("Coin",MODE_PRIVATE,null);
    database.execSQL("CREATE TABLE IF NOT EXISTS coin (id INTEGER PRIMARY KEY, miktar INT)");
    cursor = database.rawQuery("SELECT * FROM coin WHERE id < 5",null);
    mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
    sha = database.rawQuery("SELECT * FROM coin WHERE id = 2",null);
    sage = database.rawQuery("SELECT * FROM coin WHERE id = 3",null);
    kage = database.rawQuery("SELECT * FROM coin WHERE id = 4",null);



    while (mani.moveToNext()){
        shopCoins = mani.getString(1);
    }
    coinView.setText("Coins: " + shopCoins);

    kage = database.rawQuery("SELECT * FROM coin WHERE id = 4",null);
    while (kage.moveToNext()) {
        shika = kage.getString(1);
    }
    kagem.setText("Buy - " + shika);
    sha = database.rawQuery("SELECT * FROM coin WHERE id = 2",null);
    while (sha.moveToNext()) {
        sasuke = sha.getString(1);
    }
    sham.setText("Buy - " + sasuke);
    sage = database.rawQuery("SELECT * FROM coin WHERE id = 3",null);
    while (sage.moveToNext()) {
        naruto = sage.getString(1);
    }
    sagem.setText("Buy - " + naruto);
}catch (Exception e){
    e.printStackTrace();
}


    }
    public void stayB (View view){


        Intent intent = new Intent(Shop.this,MainActivity.class);
        startActivity(intent);
    }
    public void sharinganBuy (View view){

        try {
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()) {
                String deger = mani.getString(1);

                asıl = Integer.parseInt(deger);
            }
            if(asıl<300){
                Toast.makeText(getApplicationContext(),"You gotta have 300 coins!",Toast.LENGTH_SHORT).show();

            }else {
                database.execSQL("UPDATE coin SET miktar = miktar - 300 WHERE id = 1");
                database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 2");
            }
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()){
                shopCoins = mani.getString(1);
            }
            coinView.setText("Coins: " + shopCoins);

            sha = database.rawQuery("SELECT * FROM coin WHERE id = 2",null);
            while (sha.moveToNext()) {
                sasuke = sha.getString(1);
            }
            sham.setText("Buy - " + sasuke);

        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void sageBuy (View view){
        try {
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()) {
                String deger = mani.getString(1);

                asıl = Integer.parseInt(deger);
            }
            if(asıl<300){
                Toast.makeText(getApplicationContext(),"You gotta have 300 coins!",Toast.LENGTH_SHORT).show();

            }else {
                database.execSQL("UPDATE coin SET miktar = miktar - 300 WHERE id = 1");
                database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 3");
            }
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()){
                shopCoins = mani.getString(1);
            }
            coinView.setText("Coins: " + shopCoins);

            sage = database.rawQuery("SELECT * FROM coin WHERE id = 3",null);
            while (sage.moveToNext()) {
                naruto = sage.getString(1);
            }
            sagem.setText("Buy - " + naruto);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void kageBuy (View view){
        try {
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()) {
                String deger = mani.getString(1);

                asıl = Integer.parseInt(deger);
            }
            if(asıl<500){
                Toast.makeText(getApplicationContext(),"You gotta have 500 coins!",Toast.LENGTH_SHORT).show();

            }else {
                database.execSQL("UPDATE coin SET miktar = miktar - 500 WHERE id = 1");
                database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 4");
            }
            mani = database.rawQuery("SELECT * FROM coin WHERE id = 1",null);
            while (mani.moveToNext()){
                shopCoins = mani.getString(1);
            }
            coinView.setText("Coins: " + shopCoins);

            kage = database.rawQuery("SELECT * FROM coin WHERE id = 4",null);
            while (kage.moveToNext()) {
                shika = kage.getString(1);
            }
            kagem.setText("Buy - " + shika);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}