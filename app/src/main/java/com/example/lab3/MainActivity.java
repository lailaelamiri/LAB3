package com.example.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText fieldNom, fieldEmail, fieldPhone, fieldAdresse, fieldVille;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldNom     = findViewById(R.id.field_nom);
        fieldEmail   = findViewById(R.id.field_email);
        fieldPhone   = findViewById(R.id.field_phone);
        fieldAdresse = findViewById(R.id.field_adresse);
        fieldVille   = findViewById(R.id.field_ville);
        btnSend      = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(v -> {
            String vNom     = fieldNom.getText().toString().trim();
            String vEmail   = fieldEmail.getText().toString().trim();
            String vPhone   = fieldPhone.getText().toString().trim();
            String vAdresse = fieldAdresse.getText().toString().trim();
            String vVille   = fieldVille.getText().toString().trim();

            // Validation : required fields
            if (vNom.isEmpty() || vEmail.isEmpty()) {
                Toast.makeText(this, "Full name and Email are required.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Bonus 1 : email format validation
            if (!Patterns.EMAIL_ADDRESS.matcher(vEmail).matches()) {
                Toast.makeText(this, "Invalid email address.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, Screen2Activity.class);
            intent.putExtra("nom",     vNom);
            intent.putExtra("email",   vEmail);
            intent.putExtra("phone",   vPhone);
            intent.putExtra("adresse", vAdresse);
            intent.putExtra("ville",   vVille);
            startActivity(intent);
        });
    }

    // Bonus 2 : clear all fields when returning to this screen
    @Override
    protected void onResume() {
        super.onResume();
        fieldNom.setText("");
        fieldEmail.setText("");
        fieldPhone.setText("");
        fieldAdresse.setText("");
        fieldVille.setText("");
    }
}