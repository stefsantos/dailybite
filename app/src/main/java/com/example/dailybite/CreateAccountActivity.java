package com.example.dailybite;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passwordEditText;
    private ImageButton backButton;
    private Button registerButton;
    private ImageView passwordVisibilityToggle;
    private boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        // Initialize UI components
        nameEditText = findViewById(R.id.name_edittext);
        emailEditText = findViewById(R.id.email_edittext);
        passwordEditText = findViewById(R.id.password_edittext);
        backButton = findViewById(R.id.back_button);
        registerButton = findViewById(R.id.register_button);
        passwordVisibilityToggle = findViewById(R.id.password_visibility_toggle);

        // Handle back button click
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to the previous screen (finish this activity)
                finish();
            }
        });

        // Handle register button click
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    // Show error message if fields are empty
                    Toast.makeText(CreateAccountActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Proceed with registration process (you can add your registration logic here)
                    Toast.makeText(CreateAccountActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Handle password visibility toggle
        passwordVisibilityToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                    // If password is visible, make it hidden
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordVisibilityToggle.setImageResource(R.drawable.ic_email); // Use appropriate icon
                    isPasswordVisible = false;
                } else {
                    // If password is hidden, make it visible
                    passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordVisibilityToggle.setImageResource(R.drawable.ic_email); // Use appropriate icon
                    isPasswordVisible = true;
                }
                // Move cursor to the end of the text
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });
    }
}
