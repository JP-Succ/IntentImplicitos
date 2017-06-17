package com.example.juanpablo.intentimplicitos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private EditText edtEmail, edtAsunto, edtMensaje;
    private Button btnEnviar, btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        //asigno controles de usuario
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtAsunto = (EditText) findViewById(R.id.edtAsunto);
        edtMensaje = (EditText) findViewById(R.id.edtMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarApp();
            }
        });

        //asigno manejador evento clic al button enviar
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //variables para llamar metodo de envio de mail
                String[] email  = {edtEmail.getText().toString()}  ;
                String asunto = edtAsunto.getText().toString();
                String mensaje = edtMensaje.getText().toString();

                //llamar metodo para enviar email
                enviarEmail(email, asunto, mensaje);
            }
        });
    }

    private void enviarEmail(String[] email, String asunto, String mensaje){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);

        //verificamos que android pueda gestionar el ACTION sin dar error
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }
    public void cerrarApp(){
        finish();
    }

}
