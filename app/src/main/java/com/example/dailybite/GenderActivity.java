package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;  // Import Toast to show messages

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.EdgeToEdgeUtils;

public class GenderActivity extends AppCompatActivity {

    private Button maleButton, femaleButton;
    private ImageButton nextButton;
    private TextView backText;
    private String selectedGender = null;  // Variable to store selected gender

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);  // Set your layout

        // Initialize the UI components
        maleButton = findViewById(R.id.male_button);
        femaleButton = findViewById(R.id.female_button);
        nextButton = findViewById(R.id.next_button);
        backText = findViewById(R.id.back_text);

        // Click listener for Male button
        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedGender = "Male";
               // maleButton.setBackgroundResource(R.drawable.gender_button_border); // Highlight male button
                femaleButton.setBackgroundColor(android.graphics.Color.TRANSPARENT); // Reset female button
            }
        });

        // Click listener for Female button
        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedGender = "Female";
                //femaleButton.setBackgroundResource(R.drawable.gender_button_border); // Highlight female button
                maleButton.setBackgroundColor(android.graphics.Color.TRANSPARENT); // Reset male button
            }
        });

        // Click listener for Back text
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the previous activity (if any)
                onBackPressed();  // Simply go back to the previous activity
            }
        });

        // Click listener for Next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedGender != null) {
                    // If a gender is selected, proceed to the next activity
                    Intent intent = new Intent(GenderActivity.this, WeightActivity.class);
                    intent.putExtra("selectedGender", selectedGender);  // Pass the selected gender to the next activity
                    startActivity(intent);
                } else {
                    // Optionally, show a message if no gender is selected
                    showMessage("Please select a gender before proceeding.");
                }
            }
        });
    }

    // Method to show a message (e.g., toast) when no gender is selected
    private void showMessage(String message) {
        Toast.makeText(GenderActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
