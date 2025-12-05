package com.app.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    // Button click method for Login
    public void onLoginClicked(View view) {
        String email = safeText(etEmail);
        String password = safeText(etPassword);

        if (email.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_email), Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_password), Toast.LENGTH_SHORT).show();
            return;
        }

        // Temporary: just show success
        Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();
    }

    // Click method for Register text
    public void onRegisterClicked(View view) {
        // Create an Intent to start RegisterActivity
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);

        // Optional: nice slide animation
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private String safeText(TextInputEditText editText) {
        if (editText == null) return "";
        Editable e = editText.getText();
        return (e == null) ? "" : e.toString().trim();
    }
}
