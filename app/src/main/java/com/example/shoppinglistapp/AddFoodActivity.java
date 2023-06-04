package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddFoodActivity extends AppCompatActivity {
    public static final String EXTRA_FOOD_ARRAY = "com.example.android.shoppinglistapp.extra.FOOD_ARRAY";
    private final EditText[] food_add = new EditText[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        food_add[0] = findViewById(R.id.add_1);
        food_add[1] = findViewById(R.id.add_2);
        food_add[2] = findViewById(R.id.add_3);
        food_add[3] = findViewById(R.id.add_4);
        food_add[4] = findViewById(R.id.add_5);
    }
    
    public void AddFood(View view) {
        Intent addIntent = new Intent(this, MainActivity.class);
        String[] foodArray = new String[5];

        for (int i = 0; i < foodArray.length; i++) {
            foodArray[i] = food_add[i].getText().toString();
        }

        addIntent.putExtra(EXTRA_FOOD_ARRAY, foodArray);
        startActivity(addIntent);
    }
}