package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        // OnClickBotao
        Button botaoLogin = findViewById(R.id.botao_login);
        botaoLogin.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        // Pegar conteúdo login
        EditText loginUser = (EditText) findViewById(R.id.user);
        String user = loginUser.getText().toString();

        EditText loginPassword = (EditText) findViewById(R.id.password);
        String password = loginPassword.getText().toString();

        //TODO (Change the Toast to DialogFragment)
        String mensagemErro = "Login e senha devem ser iguais";

        // Comparando Login e Senha
        if(user.equals(password)){
            startActivity(intent);
        }else{
            Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT).show();
        }
    }
}