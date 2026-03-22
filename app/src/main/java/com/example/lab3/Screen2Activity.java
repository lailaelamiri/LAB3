package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2Activity extends AppCompatActivity {

    private TextView tvRecap;
    private Button btnRetour, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        tvRecap   = findViewById(R.id.tv_recap);
        btnRetour = findViewById(R.id.btn_retour);
        btnShare  = findViewById(R.id.btn_share);

        Intent intent = getIntent();

        String nom     = intent.getStringExtra("nom");
        String email   = intent.getStringExtra("email");
        String phone   = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville   = intent.getStringExtra("ville");

        String resume = "Full Name : " + safe(nom)     +
                "\nEmail : "   + safe(email)   +
                "\nPhone : "   + safe(phone)   +
                "\nAddress : " + safe(adresse) +
                "\nCity : "    + safe(ville);

        tvRecap.setText(resume);

        // Back button
        btnRetour.setOnClickListener(v -> finish());

        // Bonus 3 : share the summary via email/SMS/etc
        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact Summary");
            shareIntent.putExtra(Intent.EXTRA_TEXT, resume);
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}