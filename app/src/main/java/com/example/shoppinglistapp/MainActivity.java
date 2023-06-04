package com.example.shoppinglistapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText locationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String[] foodArray = intent.getStringArrayExtra(AddFoodActivity.EXTRA_FOOD_ARRAY);

        TextView textView_1 = findViewById(R.id.food_1);
        TextView textView_2 = findViewById(R.id.food_2);
        TextView textView_3 = findViewById(R.id.food_3);
        TextView textView_4 = findViewById(R.id.food_4);
        TextView textView_5 = findViewById(R.id.food_5);

        if (foodArray != null) {
            textView_1.setText(foodArray[0]);
            textView_2.setText(foodArray[1]);
            textView_3.setText(foodArray[2]);
            textView_4.setText(foodArray[3]);
            textView_5.setText(foodArray[4]);
        }

        locationEditText = findViewById(R.id.location_edittext);

    }

    public void LaunchSecondActivity(View view) {
        Intent intent = new Intent(this, AddFoodActivity.class);
        startActivity(intent);
    }

    public void openLocation(View view) {
        String loc = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        intent.setPackage("com.google.android.apps.maps");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else Log.d("ImplicitIntents", "Can't handle this intent");
    }
}