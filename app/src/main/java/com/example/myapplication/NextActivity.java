package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class NextActivity extends AppCompatActivity {


   private EditText editTextNumber;

   private TextView textView4;
   private ImageView image;

   private TextView textView2;
   private EditText editTextNumber2;
   private TextView textView11;
   private Button button2;
   private TextView textView12;
   private Button button3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        editTextNumber = findViewById(R.id.editTextNumber);
        textView4 = findViewById(R.id.textView4);
        image = findViewById(R.id.imageView);
        image.setImageResource(R.drawable.my_image);
        textView2 = findViewById(R.id.textView2);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textView11 = findViewById(R.id.textView11);
        button2 = findViewById(R.id.button2);
        textView12 = findViewById(R.id.textView12);
        button3 = findViewById(R.id.button3);

        // Obtention de la valeur de login transmise
        String loginValue = getIntent().getStringExtra("LOGIN_VALUE");
        textView4.setText(loginValue);
        textView4.setTextColor(getResources().getColor(R.color.teal_200));


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = editTextNumber.getText().toString();
                String operateur = "";

                int maxLength = 14;
                //editTextNumber2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

                String num_recharge = editTextNumber2.getText().toString();
                //if(numero.length() < maxLength || numero.length() > maxLength){
                  //  Toast.makeText(this, "La longueur du numéro doit être de " + maxLength + " caractères", Toast.LENGTH_SHORT).show();
                //}
                String recharge = "";

                if (numero.length() >= 2) {
                    String deuxPremiersChiffres = numero.substring(0, 2);
                    if (deuxPremiersChiffres.equals("23") ||deuxPremiersChiffres.equals("24") ) {
                        operateur = "Votre ligne est Ooredoo";
                        textView2.setTextColor(getResources().getColor(R.color.red));
                        textView11.setTextColor(getResources().getColor(R.color.red));
                        recharge = "*101*"+ num_recharge+"#";
                        /*
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+ numero));
                        if (ActivityCompat.checkSelfPermission(NextActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // Demander la permission d'appeler si elle n'a pas encore été accordée
                            ActivityCompat.requestPermissions(NextActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                        } else {
                            // Lancer l'appel
                            startActivity(intent);
                        }*/
                    } else if (deuxPremiersChiffres.equals("31")) {
                        operateur = "Votre ligne est Orange";
                        textView2.setTextColor(getResources().getColor(R.color.orange));
                        recharge = "*100*"+ num_recharge+"#";
                        textView11.setTextColor(getResources().getColor(R.color.orange));
                    } else if (deuxPremiersChiffres.equals("97")) {
                        operateur = "Votre ligne est Tunisie Telecom";
                        textView2.setTextColor(getResources().getColor(R.color.blue));
                        textView11.setTextColor(getResources().getColor(R.color.blue));
                        recharge = "*123*"+ num_recharge+"#";
                    }
                }

                textView2.setText(operateur);
                textView11.setText(recharge);




            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = editTextNumber.getText().toString();
                String operateur = "";
                String consult = "";


                if (numero.length() >= 2) {
                    String deuxPremiersChiffres = numero.substring(0, 2);
                    if (deuxPremiersChiffres.equals("23") ||deuxPremiersChiffres.equals("24")) {
                        consult = "*100#";
                        textView12.setTextColor(getResources().getColor(R.color.red));

                    } else if (deuxPremiersChiffres.equals("31")) {
                        consult = "*111#";
                        textView12.setTextColor(getResources().getColor(R.color.orange));
                    } else if (deuxPremiersChiffres.equals("97")) {
                        consult = "*122#";
                        textView12.setTextColor(getResources().getColor(R.color.blue));

                    }
                }

                textView12.setText(consult);
            }
        });


/*
        String phoneNumber = editTextNumber.getText().toString();

        // Extraction des deux premiers chiffres
        String firstTwoDigits = phoneNumber.substring(0, 2);

        // Attribution de l'opérateur en fonction des deux premiers chiffres
        String operatorName;
        if (firstTwoDigits.equals("31")) {
            operatorName = "Orange";
        } else if (firstTwoDigits.equals("23")) {
            operatorName = "Ooredoo";
        } else if (firstTwoDigits.equals("97")) {
            operatorName = "Tunisie Telecom";
        } else {
            operatorName = "Opérateur inconnu";
        }

        // Affichage du nom de l'opérateur dans un TextView
       // textView2.setText(operatorName);*/
    }


}
