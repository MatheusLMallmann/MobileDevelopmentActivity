package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button botaoVoltarSplash = (Button) findViewById(R.id.botaoVoltarSplash);
        Button botaoVoltarLogin = (Button) findViewById(R.id.botaoVoltarLogin);

        botaoVoltarSplash.setOnClickListener(this::botaoVoltarSplash);
        botaoVoltarLogin.setOnClickListener(this::botaoVoltarLogin);
    }

    private void botaoVoltarSplash(View view) {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    private void botaoVoltarLogin(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}