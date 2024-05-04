package com.example.nike_practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, R.string.nike, Toast.LENGTH_SHORT).show();
    }
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText idUsuario = findViewById(R.id.idusuario);
                EditText idPassword = findViewById(R.id.idcontraseña);
                String usuario = idUsuario.getText().toString();
                String password = idPassword.getText().toString();


                if (usuario.equals("alumno") && password.equals("1234")) {

                    Intent intent = new Intent(getApplicationContext(), principal_main.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}