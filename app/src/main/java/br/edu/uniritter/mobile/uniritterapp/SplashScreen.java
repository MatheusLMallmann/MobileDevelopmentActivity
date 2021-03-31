package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Usando handler para criar o delay entre as telas
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                abreTelaLogin();
            }
        }, 3000);
    }

    private void abreTelaLogin() {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
        finish();
    }
}