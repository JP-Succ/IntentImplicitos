package com.example.juanpablo.intentimplicitos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {

    private EditText edtTelefono;
    private EditText edtMensaje;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
        edtMensaje = (EditText) findViewById(R.id.edtMensaje);

        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarApp();
            }
        });
    }
    public void cerrarApp(){
        finish();
    }

    public void componerSms(View v){

        String telefono = edtTelefono.getText().toString();
        String mensaje = edtMensaje.getText().toString();

        Intent intent = new Intent (Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+telefono));

        intent.putExtra("sms_body",mensaje);

        startActivity(intent);
    }
}
