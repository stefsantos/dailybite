package com.example.dailybite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private ImageView backButton;
    private EditText emailInput;
    private EditText passwordInput;
    private Button loginButton;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin); // Make sure activity_login.xml exists and is referenced correctly

        // Initialize views by finding them by ID
        backButton = findViewById(R.id.back_button);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        loginButton = findViewById(R.id.login_button);
        forgotPassword = findViewById(R.id.forgot_password);

        // Set OnClickListener for the back button to return to the previous activity
        backButton.setOnClickListener(v -> onBackPressed()); // This will handle navigating to the previous page/activity

        // Set OnClickListener for the login button
        loginButton.setOnClickListener(v -> {
            // Perform login logic or validation here
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            // Simple validation
            if (email.isEmpty()) {
                emailInput.setError("Email is required");
                emailInput.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                passwordInput.setError("Password is required");
                passwordInput.requestFocus();
                return;
            }

            // Proceed with login logic
            Toast.makeText(SignInActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
            // You can add more code here to handle actual login (e.g., authentication)
        });

        // Set OnClickListener for the forgot password text
        forgotPassword.setOnClickListener(v -> Toast.makeText(SignInActivity.this, "Forgot password clicked", Toast.LENGTH_SHORT).show());
    }
}
