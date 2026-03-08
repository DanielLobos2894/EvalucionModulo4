package com.example.evaluacionmodulo4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button btnLinkedIn = findViewById(R.id.btn_linkedin);
        Button btnWhatsApp = findViewById(R.id.btn_whatsapp);
        Button btnEmail = findViewById(R.id.btn_email);

        btnLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir LinkedIn en el navegador
                String url = "https://www.linkedin.com/in/lobosarriaza";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Conectar mediante WhatsApp
                String number = "56942094646";
                String url = "https://api.whatsapp.com/send?phone=" + number;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Enviar correo electrónico
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // Solo apps de email manejarán esto
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"daniel.lobos.arriaza@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto desde App About Me");
                
                try {
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ContactActivity.this, "No tienes una app de correo instalada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
