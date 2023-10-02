package com.example.ejemplo1event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        TextView txt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            txt = (TextView) findViewById(R.id.txt2);
            Intent i=new Intent(this, MainActivity2.class);

            new CountDownTimer(10000, 1000) {

                public void onTick(long millisUntilFinished) {
                    txt.setText("Espere: " + millisUntilFinished / 1000);
                }

                public void onFinish() {
                    txt.setText("Listo!");
                    startActivity(i);
                }
            }.start();


        };





}