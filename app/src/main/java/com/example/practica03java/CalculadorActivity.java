package com.example.practica03java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

public class CalculadorActivity extends AppCompatActivity {

    private EditText txtNum1;
    private EditText txtNum2;
    private Button btnSuma;
    private Button btnResta;
    private Button btnMulti;
    private Button btnDivi;
    private Button btnLimpiar;
    private Button btnCerrar;
    private TextView lblRes;
    private TextView txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivi = findViewById(R.id.btnDivi);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);
        lblRes = findViewById(R.id.lblRes);
        txtUsuario = findViewById(R.id.txtUsuario);


        // Obtener el nombre de usuario del intent
        String user = getIntent().getStringExtra("user");

        // Mostrar el mensaje de bienvenida
        String mensajeBienvenida = "¡Bienvenido, " + user + "!";
        txtUsuario.setText(mensajeBienvenida);




        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number1 = txtNum1.getText().toString();
                String number2 = txtNum2.getText().toString();

                if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
                    Toast.makeText(CalculadorActivity.this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
                } else {
                    // Ambos campos tienen información, realizar la acción
                    double num1 = Double.parseDouble(number1);
                    double num2 = Double.parseDouble(number2);
                    double res = Calculadora.sumar(num1, num2);

                    // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
                    lblRes.setText("Resultado: " + res);
                }
            }
        });


        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number1 = txtNum1.getText().toString();
                String number2 = txtNum2.getText().toString();

                if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
                    Toast.makeText(CalculadorActivity.this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
                } else {
                    // Ambos campos tienen información, realizar la acción
                    double num1 = Double.parseDouble(number1);
                    double num2 = Double.parseDouble(number2);
                    double res = Calculadora.restar(num1, num2);

                    // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
                    lblRes.setText("Resultado: " + res);
                }
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number1 = txtNum1.getText().toString();
                String number2 = txtNum2.getText().toString();

                if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
                    Toast.makeText(CalculadorActivity.this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
                } else {
                    // Ambos campos tienen información, realizar la acción
                    double num1 = Double.parseDouble(number1);
                    double num2 = Double.parseDouble(number2);
                    double res = Calculadora.multiplicar(num1, num2);

                    // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
                    lblRes.setText("Resultado: " + res);
                }
            }
        });

        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number1 = txtNum1.getText().toString();
                String number2 = txtNum2.getText().toString();

                if (TextUtils.isEmpty(number1) || TextUtils.isEmpty(number2)) {
                    Toast.makeText(CalculadorActivity.this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
                } else {
                    // Ambos campos tienen información, realizar la acción
                    double num1 = Double.parseDouble(number1);
                    double num2 = Double.parseDouble(number2);

                    // Mostrar el resultado en un TextView o en otro lugar de la interfaz de usuario
                    try {
                        double res = Calculadora.dividir(num1, num2);
                        lblRes.setText("Resultado: " + res);
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(CalculadorActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //Boton de limpiar
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum1.setText("");
                txtNum2.setText("");
                lblRes.setText("");
            }
        });

        //Boton para salir al login
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

