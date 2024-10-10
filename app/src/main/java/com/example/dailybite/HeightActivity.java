package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HeightActivity extends AppCompatActivity {

    private NumberPicker meterPicker, cmPicker;
    private ImageButton nextButton;
    private TextView backText;
    private Switch unitSwitch;
    private int meters = 0, centimeters = 0;
    private boolean isMetric = true;  // By default, we are in metric mode

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);  // Set your layout

        // Initialize the UI components
        meterPicker = findViewById(R.id.meter_picker);
        cmPicker = findViewById(R.id.cm_picker);
        nextButton = findViewById(R.id.next_button);
        backText = findViewById(R.id.back_text);
        unitSwitch = findViewById(R.id.unit_switch);

        // Initial setup for metric system
        setupMetricPickers();

        // Set listener for the unit switch
        unitSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                isMetric = false;
                unitSwitch.setText("Switch to Metric");
                setupImperialPickers();
            } else {
                isMetric = true;
                unitSwitch.setText("Switch to Imperial");
                setupMetricPickers();
            }
        });

        // Set up listeners to store the selected values
        meterPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                meters = newVal;
            }
        });

        cmPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                centimeters = newVal;
            }
        });

        // Set onClickListener for the back button
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Go back to the previous screen
            }
        });

        // Set onClickListener for the next button
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the selected height (meters/centimeters or feet/inches) to the next activity
                Intent intent = new Intent(HeightActivity.this, WeightActivity.class);
                intent.putExtra("heightMeters", meters);
                intent.putExtra("heightCentimeters", centimeters);
                intent.putExtra("isMetric", isMetric);
                startActivity(intent);
            }
        });
    }

    private void setupMetricPickers() {
        // Set up the picker for meters and centimeters
        meterPicker.setMinValue(0);
        meterPicker.setMaxValue(3);  // 0 to 3 meters
        cmPicker.setMinValue(0);
        cmPicker.setMaxValue(99);  // 0 to 99 centimeters

        TextView meterLabel = findViewById(R.id.meter_label);
        TextView cmLabel = findViewById(R.id.cm_label);
        meterLabel.setText("m");
        cmLabel.setText("cm");
    }

    private void setupImperialPickers() {
        // Set up the picker for feet and inches
        meterPicker.setMinValue(0);
        meterPicker.setMaxValue(8);  // 0 to 8 feet
        cmPicker.setMinValue(0);
        cmPicker.setMaxValue(11);  // 0 to 11 inches

        TextView meterLabel = findViewById(R.id.meter_label);
        TextView cmLabel = findViewById(R.id.cm_label);
        meterLabel.setText("ft");
        cmLabel.setText("in");
    }
}
