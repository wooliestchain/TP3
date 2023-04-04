package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des vues
        editTextLogin = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextNumberPassword);
        button = findViewById(R.id.button);

        // Ajout du listener de clic sur le bouton
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString();
                String password = editTextPassword.getText().toString();

                // Vérification des champs
                if (login.equals("levy") && password.equals("1234")) {
                    // Redirection vers la page suivante
                    Intent intent = new Intent(MainActivity.this, NextActivity.class);
                    // Ajout de la valeur de login à transmettre
                    intent.putExtra("LOGIN_VALUE", login);
                    startActivity(intent);
                } else {
                    // Affichage d'un message d'erreur
                    Toast.makeText(MainActivity.this, "Identifiants incorrects", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}