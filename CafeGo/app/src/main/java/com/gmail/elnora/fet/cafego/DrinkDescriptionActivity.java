package com.gmail.elnora.fet.cafego;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        imageViewPhoto = findViewById(R.id.imageViewPhoto);
        textViewName = findViewById(R.id.textViewName);
        textViewDescription = findViewById(R.id.textViewDescription);

        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINK_ID);

        SQLiteOpenHelper cafeGoDatabaseHelper = new CafeGoDatabaseHelper(this);
        try {
            SQLiteDatabase db = cafeGoDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[] {Integer.toString(drinkId)},
            null, null, null);
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                imageViewPhoto.setImageResource(photoId);
                imageViewPhoto.setContentDescription(nameText);
                textViewName.setText(nameText);
                textViewDescription.setText(descriptionText);
            }
            cursor.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
