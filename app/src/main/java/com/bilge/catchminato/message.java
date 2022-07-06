package com.bilge.catchminato;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class message extends AppCompatActivity {
    private AdView mAdView;
    TextView message;
    SQLiteDatabase database;
    Cursor lvl;
    ImageView hokage;
    ImageView tobi;
    ImageView tobim;

    int lvlAdet;

    Button tr;
    Button eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        database = this.openOrCreateDatabase("Coin", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS coin (id INTEGER PRIMARY KEY, miktar INT)");
        lvl = database.rawQuery("SELECT * FROM coin WHERE id = 5", null);
        tr = findViewById(R.id.dilTr);
        eng = findViewById(R.id.dilEng);
        hokage = findViewById(R.id.minatoPhoto);
        tobi = findViewById(R.id.tobiBlack);
        tobim = findViewById(R.id.tobim);

        while (lvl.moveToNext()) {
            String adet = lvl.getString(1);
            lvlAdet = Integer.parseInt(adet);
        }

        message = findViewById(R.id.minatoMessage);
        if (lvlAdet == 2) {
            message.setText("Congratulations, you passed the first level ,but do not think that the next levels are going to be easy like this. I am going to contact with you occasionaly ,but someone other than me can try to communicate with you..");
        }
        if (lvlAdet == 8) {
            message.setText("You are developing very well.  But you have a long way to go.  Keep improving.");
        }
        if (lvlAdet == 12) {
            message.setText("Someone you don't know yet can contact you. Be careful.");
        }
        if (lvlAdet == 15) {
            message.setText("Do you think are you fast? You can't stop me at your current speed.");
            tobi.setVisibility(View.VISIBLE);
            hokage.setVisibility(View.INVISIBLE);
        }
        if (lvlAdet == 17) {
            message.setText("It looks like that masked man will start implementing his plans.  There is no need to worry.  But it could become dangerous in the future.");
        }
        if (lvlAdet == 22) {
            message.setText("I have a bad feeling about this. We can meet the masked man again at any moment");
        }
        if (lvlAdet == 25) {
            message.setText("It's time to put my plans into action. There is no one that has power to prevent me HAHAHAHAHA!!!");
            tobim.setVisibility(View.VISIBLE);
            hokage.setVisibility(View.INVISIBLE);
        }
        if (lvlAdet == 28) {
            message.setText("Danger is getting close day by day. You need to improve yourself as soon as possible!");
        }
        if (lvlAdet == 35) {
            message.setText("Our speed may not be enough to stop the masked man. You have to keep your Jutsu for your fight with him.");
        }
        if (lvlAdet == 51) {
            message.setText("Are you curious about my name and plans? For now, it will be enough to know my name. My name is Kain.");
            tobim.setVisibility(View.VISIBLE);
            hokage.setVisibility(View.INVISIBLE);
        }
        if (lvlAdet == 52) {
            message.setText("We have learned the name of our enemy, this shows that things are getting serious, you have to prepare yourself as soon as possible and reach enough speed.");
        }
        if (lvlAdet == 65) {
            message.setText("Always be with goodness. Even if you end up losing.");
        }
        if (lvlAdet == 76) {
            message.setText("Although my clan is superior to all of you, it has been marginalized, so when I get to where you live, there will be no survivors except my clan.");
            tobim.setVisibility(View.VISIBLE);
            hokage.setVisibility(View.INVISIBLE);
        }
        if (lvlAdet == 80) {
            message.setText("We have learned Kain's purpose. The peace of our village and the fate of the people living here are in your hands.");
        }
        if (lvlAdet == 86) {
            message.setText("Your fight with Kain is approaching. Our next training sessions will be more challenging.  Try to keep your Jutsu for your fight with Kain.");
        }
        if (lvlAdet == 96) {
            message.setText("I feel a huge chakra, gather all of your concentration and speed. This fight will be very difficult, everything is in your hands, don't forget what I've taught to you.");
        }
        if (lvlAdet == 100) {
            message.setText("It's been a long time since we met, I want to make an offer to you before we start our last fight. In you... my clan's blood flows in you, so I want you to join me and win the last battle together with me.");
            tobim.setVisibility(View.VISIBLE);
            hokage.setVisibility(View.INVISIBLE);
        }
        if (lvlAdet == 101) {
            message.setText("The last battle was the battle you fought yourself and you lost that battle then listened to evil inside. You are no longer my student. Study things i taught you again.");
        }
        if (lvlAdet == 102) {
            message.setText("The last battle was the fight you will with yourself and you won this fight. You are the fastest ninja in the village now, I am proud of you. We can train again if you want, 100000 Coins are gift to you from me.");
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
    public void nextMessageLevel(View view){
        lvl = database.rawQuery("SELECT * FROM coin WHERE id = 5", null);
        while (lvl.moveToNext()) {
            String adet = lvl.getString(1);
            lvlAdet = Integer.parseInt(adet);
        }
        if(lvlAdet==100){
            AlertDialog.Builder lose = new AlertDialog.Builder(message.this);
            lose.setTitle("Kain");
            lose.setMessage("Do you agree with me?\n(TR) Bana katılıyor musun?");
            lose.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        database.execSQL("UPDATE coin SET miktar = miktar + 1 WHERE id = 5");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            lose.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        database.execSQL("UPDATE coin SET miktar = miktar + 2 WHERE id = 5");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            });
            lose.show();
        }
        else if(lvlAdet==101){
            try {
                database.execSQL("UPDATE coin SET miktar = 1 WHERE id = 5");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent again = new Intent(message.this,MainActivity.class);
            startActivity(again);
        }
        else if(lvlAdet==102){
            try {
                database.execSQL("UPDATE coin SET miktar = 1 WHERE id = 5");
                database.execSQL("UPDATE coin SET miktar = miktar + 100000 WHERE id = 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Intent again = new Intent(message.this,MainActivity.class);
            startActivity(again);

        }
        else {
            Intent intent = new Intent(message.this, game.class);
            finish();
            startActivity(intent);
        }
    }
    public void changeTr(View view){
        lvl = database.rawQuery("SELECT * FROM coin WHERE id = 5", null);
        while (lvl.moveToNext()) {
            String adet = lvl.getString(1);
            lvlAdet = Integer.parseInt(adet);
        }
        if(lvlAdet==2) {
            message.setText("Tebrikler, ilk seviyeyi geçtin ama önümüzdeki seviyelerin de bu kadar kolay olacağını düşünme. Seninle aralarda iletişime geçeceğim fakat benden başkaları da seninle iletişim kurmaya çalışabilir.");
        }
        if (lvlAdet == 8) {
            message.setText("Gayet iyi gelişme gösteriyorsun ama daha çok yolun var, gelişmeye devam et.");
        }
        if (lvlAdet == 12) {
            message.setText("Henüz kim olduğunu bilmediğim biri yakında seninle iletişime geçebilir, dikkatli ol.");
        }
        if (lvlAdet == 15) {
            message.setText("Kendini hızlı mı sanıyorsun? Şuan ki hızınla planlarıma engel olamazsın.");
        }
        if (lvlAdet == 17) {
            message.setText("Maskeli adam planlarını uygulamaya başlayacak gibi görünüyor, henüz endişelenecek bir durum yok fakat ileride çok daha tehlikeli bir hal alabilir.");
        }
        if (lvlAdet == 22) {
            message.setText("İçimde kötü bir his var, her an maskeli adam ile tekrar karşılaşabiliriz.");
        }
        if (lvlAdet == 25) {
            message.setText("Planlarımı yürürlüğe sokmanın vakti geldi. Bana engel olabilecek güçte kimse yok HAHAHAHAH!!!");
        }
        if (lvlAdet == 28) {
            message.setText("Tehlike gün geçtikçe yaklaşıyor bir an önce gelişmen lazım.");
        }
        if (lvlAdet == 35) {
            message.setText("Maskeli adamı durdurmak için hızımız yeterli olmayabilir. Jutsularını onunla olan savaşın için saklaman lazım.");
        }
        if (lvlAdet == 51) {
            message.setText("Adımı ve planlarımı merak ediyorsunuz değil mi? Şimdilik size sadece adım yeterli. Benim adım Kain.");
        }
        if (lvlAdet == 52) {
            message.setText("Düşmanımızın adını öğrenmiş olduk, bu işlerin ciddileştiğini gösterir, kendini bir an önce hazırlaman ve yeterli hıza ulaşman lazım.");
        }
        if (lvlAdet == 65) {
            message.setText("Her zaman iyiliğin yanında ol, sonunda kaybetmek olsa bile.");
        }
        if (lvlAdet == 76) {
            message.setText("Benim klanım hepinizinkinden üstün olmasına rağmen ötekileştirildi, bu yüzden yaşadığınız yere geldiğimde klanım hariç hayatta kalan olmayacak.");
        }
        if (lvlAdet == 80) {
            message.setText("Kain'nin amacını öğrenmiş olduk. Köyümüzün huzuru ve burada yaşayan insanların kaderi senin ellerinde.");
        }
        if (lvlAdet == 86) {
            message.setText("Kain ile olan savaşın yaklaşıyor. Bundan sonraki antrenmanlarımız daha zorlu olacak. Jutsularını Kain ile olan savaşın için saklamaya çalış.");
        }
        if (lvlAdet == 96) {
            message.setText("Çok büyük bir çakra hissediyorum, bütün konsantreni ve hızını topla. Bu savaş çok büyük olacak her şey senin ellerinde, öğrettiğim şeyleri aklından çıkarma.");
        }
        if (lvlAdet == 100) {
            message.setText("Görüşmeyeli uzun zaman oldu, son savaşımıza başlamadan önce sana bi teklifte bulunmak istiyorum. Sende... benim klanımın kanı akıyor, bu yüzden bana katılıp son savaşı beraber kazanmamızı istiyorum.");
        }
        if (lvlAdet == 101) {
            message.setText("Son savaş kendinle vereceğin savaştı ve sen bu savaşı kaybedip içindeki kötülüğü dinledin, artık benim öğrencim değilsin. Sana öğrettiğim şeylere tekrar çalış.");
        }
        if (lvlAdet == 102) {
            message.setText("Son savaş kendinle vereceğin savaştı ve sen bu savaşı kazandın. Köyün en hızlı ninjası artık sensin, seninle gurur duyuyorum. İstersen tekrar antrenman yapabiliriz, benden sana 100000 Coin hediye");
        }



        tr.setVisibility(View.INVISIBLE);
        eng.setVisibility(View.VISIBLE);
    }
    public void changeEng(View view){
        lvl = database.rawQuery("SELECT * FROM coin WHERE id = 5", null);
        while (lvl.moveToNext()) {
            String adet = lvl.getString(1);
            lvlAdet = Integer.parseInt(adet);
        }
        if(lvlAdet==2) {
            message.setText("Congratulations, you passed the first level ,but do not think that the next levels are going to be easy like this. I am going to contact with you occasionaly ,but someone other than me can try to communicate with you.");
        }
        if(lvlAdet==8) {
            message.setText("You are developing very well.  But you have a long way to go.  Keep improving.");
        }
        if(lvlAdet==12) {
            message.setText("Someone you don't know yet can contact you. Be careful.");
        }
        if(lvlAdet==15) {
            message.setText("Do you think are you fast? You can't stop me at your current speed.");
        }
        if (lvlAdet == 17) {
            message.setText("It looks like that masked man will start implementing his plans.  There is no need to worry.  But it could become dangerous in the future.");
        }
        if (lvlAdet == 22) {
            message.setText("I have a bad feeling about this. We can meet the masked man again at any moment");
        }
        if (lvlAdet == 25) {
            message.setText("It's time to put my plans into action. There is no one that has power to prevent me HAHAHAHAHA!!!");
        }
        if (lvlAdet == 28) {
            message.setText("Danger is getting close day by day. You need to improve yourself as soon as possible!");
        }
        if (lvlAdet == 35) {
            message.setText("Our speed may not be enough to stop the masked man. You have to keep your Jutsu for your fight with him.");
        }
        if (lvlAdet == 51) {
            message.setText("Are you curious about my name and plans? For now, it will be enough to know my name. My name is Kain.");
        }
        if (lvlAdet == 52) {
            message.setText("We have learned the name of our enemy, this shows that things are getting serious, you have to prepare yourself as soon as possible and reach enough speed.");
        }
        if (lvlAdet == 65) {
            message.setText("Always be with goodness. Even if you end up losing.");
        }
        if (lvlAdet == 76) {
            message.setText("Although my clan is superior to all of you, it has been marginalized, so when I get to where you live, there will be no survivors except my clan.");
        }
        if (lvlAdet == 80) {
            message.setText("We have learned Kain's purpose. The peace of our village and the fate of the people living here are in your hands.");
        }
        if (lvlAdet == 86) {
            message.setText("Your fight with Kain is approaching. Our next training sessions will be more challenging.  Try to keep your Jutsu for your fight with Kain.");
        }
        if (lvlAdet == 96) {
            message.setText("I feel a huge chakra, gather all of your concentration and speed. This fight will be very difficult, everything is in your hands, don't forget what I've taught to you.");
        }
        if (lvlAdet == 100) {
            message.setText("It's been a long time since we met, I want to make an offer to you before we start our last fight. In you... my clan's blood flows in you, so I want you to join me and win the last battle together with me.");
        }
        if (lvlAdet == 101) {
            message.setText("The last battle was the battle you fought yourself and you lost that battle then listened to evil inside. You are no longer my student. Study things i taught you again.");
        }
        if (lvlAdet == 102) {
            message.setText("The last battle was the fight you will with yourself and you won this fight. You are the fastest ninja in the village now, I am proud of you. We can train again if you want, 100000 Coins are gift to you from me.");
        }
        tr.setVisibility(View.VISIBLE);
        eng.setVisibility(View.INVISIBLE);
    }
}