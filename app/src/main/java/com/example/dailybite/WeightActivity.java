package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {

    private EditText weightInput;
    private TextView unitToggleButton;
    private ImageButton nextButton;
    private TextView backText;
    private boolean isKg = true;  // Default unit is kg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);  // Set your layout

        // Initialize the UI components
        weightInput = findViewById(R.id.weight_input);
        unitToggleButton = findViewById(R.id.unit_toggle_button);
        nextButton = findViewById(R.id.next_button);
        backText = findViewById(R.id.back_text);

        // Set the initial unit text (kg)
        unitToggleButton.setText("kg");

        // Toggle between kg and lbs when unit button is clicked
        unitToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isKg) {
                    unitToggleButton.setText("lbs");
                    isKg = false;
                } else {
                    unitToggleButton.setText("kg");
                    isKg = true;
                }
            }
        });

        // Set onClickListener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightInput.getText().toString();
                if (weight.isEmpty()) {
                    Toast.makeText(WeightActivity.this, "Please enter your weight", Toast.LENGTH_SHORT).show();
                } else {
                    // Pass the selected weight and unit to the next activity
                    String selectedUnit = isKg ? "kg" : "lbs";
                    Intent intent = new Intent(WeightActivity.this, AgeActivity.class);
                    intent.putExtra("weight", weight);
                    intent.putExtra("unit", selectedUnit);
                    startActivity(intent);
                }
            }
        });

        // Set onClickListener for the back button
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Go back to the previous screen
            }
        });
    }
}
