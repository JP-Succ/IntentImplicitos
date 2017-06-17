package com.example.juanpablo.intentimplicitos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelefonoActivity extends AppCompatActivity {

    private Button btnMarcar;
    private EditText edtTelefono;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);

        btnMarcar = (Button) findViewById(R.id.btnMarcar);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);

        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarApp();
            }
        });
    }

    public void cerrarApp() {
        finish();
    }


    public void marcarLlamada(View v) {
        String nro = edtTelefono.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + nro));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
}

