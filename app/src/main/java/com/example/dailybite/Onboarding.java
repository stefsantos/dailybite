package com.example.dailybite;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Onboarding extends AppCompatActivity {

    private Button maleButton, femaleButton, submitButton;
    private Button sedentaryButton, lowActiveButton, activeButton, veryActiveButton;
    private NumberPicker heightMeters, heightCm;
    private EditText weightInput, ageInput;
    private String selectedGender = "";
    private String activityLevel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        maleButton = findViewById(R.id.male_button);
        femaleButton = findViewById(R.id.female_button);
        sedentaryButton = findViewById(R.id.active_btn_sedentary);
        lowActiveButton = findViewById(R.id.active_btn_lowactive);
        activeButton = findViewById(R.id.active_btn_active);
        veryActiveButton = findViewById(R.id.button2);
        heightMeters = findViewById(R.id.height_meters);
        heightCm = findViewById(R.id.height_cm);
        weightInput = findViewById(R.id.weight_input);
        ageInput = findViewById(R.id.age_input);
        submitButton = findViewById(R.id.submit_button);

        heightMeters.setMinValue(0);
        heightMeters.setMaxValue(2);
        heightCm.setMinValue(0);
        heightCm.setMaxValue(99);


        maleButton.setOnClickListener(v -> {
            selectedGender = "Male";
            highlightButton(maleButton, femaleButton);
        });

        femaleButton.setOnClickListener(v -> {
            selectedGender = "Female";
            highlightButton(femaleButton, maleButton);
        });


        sedentaryButton.setOnClickListener(v -> {
            activityLevel = "Sedentary";
            highlightButton(sedentaryButton, lowActiveButton, activeButton, veryActiveButton);
        });

        lowActiveButton.setOnClickListener(v -> {
            activityLevel = "Low Active";
            highlightButton(lowActiveButton, sedentaryButton, activeButton, veryActiveButton);
        });

        activeButton.setOnClickListener(v -> {
            activityLevel = "Active";
            highlightButton(activeButton, sedentaryButton, lowActiveButton, veryActiveButton);
        });

        veryActiveButton.setOnClickListener(v -> {
            activityLevel = "Very Active";
            highlightButton(veryActiveButton, sedentaryButton, lowActiveButton, activeButton);
        });

        // Submit button
        submitButton.setOnClickListener(v -> handleSubmit());
    }

    private void handleSubmit() {
        int meters = heightMeters.getValue();
        int centimeters = heightCm.getValue();
        float heightInMeters = meters + (centimeters / 100f);

        String weightText = weightInput.getText().toString();
        String ageText = ageInput.getText().toString();

        if (selectedGender.isEmpty() || activityLevel.isEmpty() || weightText.isEmpty() || ageText.isEmpty()) {
            Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show();
        } else {
            float weight = Float.parseFloat(weightText);
            int age = Integer.parseInt(ageText);

            String message = "Gender: " + selectedGender + "\nActivity Level: " + activityLevel +
                    "\nHeight: " + heightInMeters + "m\nWeight: " + weight + "kg\nAge: " + age;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    // Utility function to highlight selected button
    private void highlightButton(Button selected, Button... others) {
        selected.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        for (Button button : others) {
            button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        }
    }
}