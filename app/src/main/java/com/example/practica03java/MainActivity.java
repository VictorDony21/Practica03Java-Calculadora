package com.example.practica03java;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtUser;
    private EditText txtPass;
    private Button btnIng;
    private Button btnSalir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnIng = findViewById(R.id.btnIng);
        btnSalir = findViewById(R.id.btnSalir);



        btnIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuario = txtUser.getText().toString();
                String password = txtPass.getText().toString();

                if (usuario.equals(getString(R.string.user)) && password.equals(getString(R.string.password))) {
                    // Credenciales válidas, redireccionar a otra actividad

                    Intent intent = new Intent(MainActivity.this, CalculadorActivity.class);
                    intent.putExtra("user", usuario); // Agregar el nombre de usuario al intent
                    startActivity(intent);


                } else {
                    // Credenciales inválidas, mostrar mensaje de error
                    txtUser.setError("Credenciales inválidas");
                    txtPass.setError("Credenciales inválidas");
                }
            }
        });

        //Boton para cerrar la app
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Cerrar aplicación");
                builder.setMessage("¿Estás seguro de que quieres cerrar la aplicación?");

                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // Cerrar la actividad actual y salir de la aplicación
                    }
                });

                builder.setNegativeButton("No", null); // No hacer nada si se selecciona "No"

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
}
