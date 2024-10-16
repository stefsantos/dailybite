package com.example.dailybite;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

    // Declare all the views
    private TextView itami, today, nutrients_i, tv_protein, proteins, tv_fats, fats, tv_carbs, carbs, tv_calories, calories, tv_water_intak, water, liters_water, last_time_1, water_percent, tv_meals, breakfast, time_breakfast, meal_cal_breakfast, lunch, time_lunch, meal_cal_lunch, diary;
    private ProgressBar progressBarDeterminate_proteins, progressBarDeterminate_fats, progressBarDeterminate_Carbs, progressBarDeterminate_calories;
    private ImageView calendar_icon, plus_icon, minus_icon, user_image, imageView_clock, imageView_clock_2, plus_icon_meal, imageView_diary;
    private RelativeLayout nutrients_box, water_box, icon_button_plus, icon_button_minus, meal_1, meal_2, selected_na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage); // Set the content view to the corresponding XML file

        // Initialize the views
        itami = findViewById(R.id.itami);
        today = findViewById(R.id.today);
        nutrients_i = findViewById(R.id.nutrients_i);
        tv_protein = findViewById(R.id.tv_protein);
        proteins = findViewById(R.id.proteins);
        tv_fats = findViewById(R.id.tv_fats);
        fats = findViewById(R.id.fats);
        tv_carbs = findViewById(R.id.tv_carbs);
        carbs = findViewById(R.id.carbs);
        tv_calories = findViewById(R.id.tv_calories);
        calories = findViewById(R.id.calories);
        tv_water_intak = findViewById(R.id.tv_water_intak);
        water = findViewById(R.id.water);
        liters_water = findViewById(R.id.liters_water);
        last_time_1 = findViewById(R.id.last_time_1);
        water_percent = findViewById(R.id.water_percent);
        tv_meals = findViewById(R.id.tv_meals);
        breakfast = findViewById(R.id.breakfast);
        time_breakfast = findViewById(R.id.time_breakfast);
        meal_cal_breakfast = findViewById(R.id.meal_cal_breakfast);
        lunch = findViewById(R.id.lunch);
        time_lunch = findViewById(R.id.time_lunch);
        meal_cal_lunch = findViewById(R.id.meal_cal_lunch);


        // ProgressBars
        progressBarDeterminate_proteins = findViewById(R.id.progressBarDeterminate_proteins);
        progressBarDeterminate_fats = findViewById(R.id.progressBarDeterminate_fats);
        progressBarDeterminate_Carbs = findViewById(R.id.progressBarDeterminate_Carbs);
        progressBarDeterminate_calories = findViewById(R.id.progressBarDeterminate_calories);

        // ImageViews
        calendar_icon = findViewById(R.id.calendar_icon);
        plus_icon = findViewById(R.id.plus_icon);
        minus_icon = findViewById(R.id.minus_icon);
        user_image = findViewById(R.id.user_image);
        imageView_clock = findViewById(R.id.imageView_clock);
        imageView_clock_2 = findViewById(R.id.imageView_clock_2);
        plus_icon_meal = findViewById(R.id.plus_icon_meal);

        // RelativeLayouts
        nutrients_box = findViewById(R.id.nutrients_box);
        water_box = findViewById(R.id.water_box);
        icon_button_plus = findViewById(R.id.icon_button_plus);
        icon_button_minus = findViewById(R.id.icon_button_minus);
        meal_1 = findViewById(R.id.meal_1);
        meal_2 = findViewById(R.id.meal_2);

        // Here you can add click listeners or other functionalities for each view
    }
}
