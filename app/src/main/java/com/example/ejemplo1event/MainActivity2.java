package com.example.ejemplo1event;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.b2);
        btn2.setOnClickListener(this);
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btn1){
            createAlarm("Alarma 1", 13, 30);
        } else if (view == btn2) {
            showMap(Uri.parse("geo:25.496938,-103.412225"));
        } else if (view == btn3) {
            llamada("8715074853");
        } else if (view==btn4) {
            searchWeb("Real Madrid");
        } else if (view == btn5) {
            playMedia(Uri.parse("https://www.youtube.com/watch?v=80lwLvr1l_0&ab_channel=RichVagos"));
        } else if (view == btn6) {
            abrirgoogle("https://uttorreon.mx/");
        }
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void llamada(String numero){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + numero));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void playMedia(Uri file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(file);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void abrirgoogle(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setPackage("com.android.chrome");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}