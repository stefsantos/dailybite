package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AgeActivity extends AppCompatActivity {

    private EditText ageInput;
    private ImageButton nextButton;
    private TextView backText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);  // Set your layout

        // Initialize the UI components
        ageInput = findViewById(R.id.age_input);
        nextButton = findViewById(R.id.next_button);
        backText = findViewById(R.id.back_text);

        // Set onClickListener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = ageInput.getText().toString();
                if (age.isEmpty()) {
                    Toast.makeText(AgeActivity.this, "Please enter your age", Toast.LENGTH_SHORT).show();
                } else {
                    // Pass the age to the next activity
                    Intent intent = new Intent(AgeActivity.this, PFCActivity.class);
                    intent.putExtra("age", age);
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
