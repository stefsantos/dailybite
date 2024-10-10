package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PFCActivity extends AppCompatActivity {

    private Button proteinsButton, fatsButton, carbsButton, caloriesButton;
    private Button continueWithGoogleButton, continueWithEmailButton;
    private TextView backText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfc);  // Ensure this matches the name of your layout XML

        // Initialize the UI components
        proteinsButton = findViewById(R.id.proteins_button);
        fatsButton = findViewById(R.id.fats_button);
        carbsButton = findViewById(R.id.carbs_button);
        caloriesButton = findViewById(R.id.calories_button);
        continueWithGoogleButton = findViewById(R.id.continue_with_google);
        continueWithEmailButton = findViewById(R.id.continue_with_email);
        backText = findViewById(R.id.back_text);

        // Optionally set click listeners for the PFC buttons (if needed)
        proteinsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle protein button click, if needed
            }
        });

        fatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle fats button click, if needed
            }
        });

        carbsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle carbs button click, if needed
            }
        });

        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle calories button click, if needed
            }
        });

        // Handle Continue with Google button click
        continueWithGoogleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to move to another activity for Google login (optional)
                Intent intent = new Intent(PFCActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        // Handle Continue with Email button click
        continueWithEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to move to another activity for Email login (optional)
                Intent intent = new Intent(PFCActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Handle the back button
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Go back to the previous activity
            }
        });
    }
}
