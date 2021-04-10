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
        Button botaoScrollView = (Button) findViewById(R.id.botaoScrollView);
        Button botaoRecyclerView = (Button) findViewById(R.id.botaoRecyclerView);

        botaoVoltarSplash.setOnClickListener(this::botaoVoltarSplash);
        botaoVoltarLogin.setOnClickListener(this::botaoVoltarLogin);
        botaoScrollView.setOnClickListener(this::botaoScrollView);
        botaoRecyclerView.setOnClickListener(this::botaoRecyclerView);
    }

    private void botaoVoltarSplash(View view) {
        Intent intent = new Intent(this, SplashScreen.class);
        startActivity(intent);
    }

    private void botaoVoltarLogin(View view) {
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }

    private void botaoScrollView(View view){
        Intent intent = new Intent(this, OptionsJson.class);
        startActivity(intent);
    }

    private void botaoRecyclerView(View view){
        Intent intent = new Intent(this, OptionsRecyclerView.class);
        startActivity(intent);
    }
}