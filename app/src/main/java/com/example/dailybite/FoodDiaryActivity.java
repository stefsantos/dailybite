package com.example.dailybite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FoodDiaryActivity extends AppCompatActivity {

    private TextView title;
    private TextView todayDate;
    private ImageView calendarIcon;
    private LinearLayout recipesTab;
    private LinearLayout diaryTab;
    private LinearLayout reportsTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddiary);

        // Initialize UI elements
        title = findViewById(R.id.title);
        todayDate = findViewById(R.id.today_date);
        calendarIcon = findViewById(R.id.calendar_icon);
        recipesTab = findViewById(R.id.recipes_tab);
        diaryTab = findViewById(R.id.diary_tab);
        reportsTab = findViewById(R.id.reports_tab);

        // Set title and date (you can replace with dynamic data if necessary)
        title.setText("Itami");
        todayDate.setText("Today");

        // Set click listeners for bottom navigation tabs
        recipesTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Recipes tab click event
                Intent intent = new Intent(FoodDiaryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        diaryTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Diary tab click event (already on this screen, so no action needed)
            }
        });

        reportsTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the Reports tab click event
                Intent intent = new Intent(FoodDiaryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for calendar icon (you can handle the event based on your app's functionality)
        calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle calendar icon click event, for example, open a date picker or calendar screen
                openCalendar();
            }
        });
    }

    private void openCalendar() {
        // Implement your calendar logic here, such as opening a date picker dialog
    }
}
