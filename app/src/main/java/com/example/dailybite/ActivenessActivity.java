package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivenessActivity extends AppCompatActivity {

    private TextView sedentaryText, lowActiveText, activeText, veryActiveText;
    private ImageButton nextButton;
    private TextView backText;
    private String selectedActivityLevel = null;  // Variable to store selected activity level

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activeness);  // Set your layout

        // Initialize the UI components
        sedentaryText = findViewById(R.id.sedentary_text);
        lowActiveText = findViewById(R.id.low_active_text);
        activeText = findViewById(R.id.active_text);
        veryActiveText = findViewById(R.id.very_active_text);
        nextButton = findViewById(R.id.next_button);
        backText = findViewById(R.id.back_text);

        // Set onClickListeners for the activity level options
        sedentaryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectActivityLevel(sedentaryText);
                selectedActivityLevel = "Sedentary";
                Toast.makeText(ActivenessActivity.this, "Selected: Sedentary", Toast.LENGTH_SHORT).show();
            }
        });

        lowActiveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectActivityLevel(lowActiveText);
                selectedActivityLevel = "Low Active";
                Toast.makeText(ActivenessActivity.this, "Selected: Low Active", Toast.LENGTH_SHORT).show();
            }
        });

        activeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectActivityLevel(activeText);
                selectedActivityLevel = "Active";
                Toast.makeText(ActivenessActivity.this, "Selected: Active", Toast.LENGTH_SHORT).show();
            }
        });

        veryActiveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectActivityLevel(veryActiveText);
                selectedActivityLevel = "Very Active";
                Toast.makeText(ActivenessActivity.this, "Selected: Very Active", Toast.LENGTH_SHORT).show();
            }
        });

        // Set onClickListener for the back button
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Finish this activity and go back to the previous screen
            }
        });

        // Set onClickListener for the proceed button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedActivityLevel != null) {
                    // If an activity level is selected, proceed to the next activity
                    Intent intent = new Intent(ActivenessActivity.this, HeightActivity.class);  // Replace with your next activity
                    intent.putExtra("selectedActivityLevel", selectedActivityLevel);  // Pass the selected activity level
                    startActivity(intent);
                } else {
                    // Show a message if no activity level is selected
                    Toast.makeText(ActivenessActivity.this, "Please select an activity level", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void selectActivityLevel(TextView selectedButton) {
        // Reset the backgrounds for all options
        sedentaryText.setBackgroundResource(android.R.color.transparent);
        lowActiveText.setBackgroundResource(android.R.color.transparent);
        activeText.setBackgroundResource(android.R.color.transparent);
        veryActiveText.setBackgroundResource(android.R.color.transparent);

        // Apply the outline to the selected button
        selectedButton.setBackgroundResource(R.drawable.outline);  // Use your drawable for the border
    }
}
