package com.example.juanpablo.intentimplicitos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEmail, btnSms, btnTelefono, btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmail = (Button) findViewById(R.id.btnEmail);
        btnSms = (Button) findViewById(R.id.btnMsj);
        btnTelefono = (Button) findViewById(R.id.btnLlamado);
        btnSalir = (Button) findViewById(R.id.btnCerrar);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarSms();
            }
        });

        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marcarLlamado();
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarApp();
            }
        });
    }

    public void marcarLlamado(){
        Intent intent = new Intent (this, TelefonoActivity.class);
        startActivity(intent);
    }

    public void enviarSms(){
        Intent intent = new Intent (this, SmsActivity.class);
        startActivity(intent);
    }

    public void enviarEmail(){
        Intent intent = new Intent (this, EmailActivity.class);
        startActivity(intent);
    }

    public void cerrarApp(){
        finish();
    }

}
