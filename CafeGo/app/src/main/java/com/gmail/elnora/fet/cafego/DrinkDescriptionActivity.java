package com.gmail.elnora.fet.cafego;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DrinkDescriptionActivity extends AppCompatActivity {
    public static final String EXTRA_DRINK_ID = "drinkId";
    private ImageView imageViewPhoto;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_description);

        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINK_ID);
        Drink drink = Drink.drinks[drinkId];

        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        imageViewPhoto.setImageResource(drink.getImageResourceId());
        imageViewPhoto.setContentDescription(drink.getName());

        textViewName = findViewById(R.id.textViewName);
        textViewName.setText(drink.getName());

        textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(drink.getDescription());
    }
}
