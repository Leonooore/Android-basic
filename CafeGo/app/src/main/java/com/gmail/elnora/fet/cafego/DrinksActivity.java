package com.gmail.elnora.fet.cafego;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DrinksActivity extends AppCompatActivity {
    private ListView listDrinks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Drink.drinks);

        listDrinks = findViewById(R.id.listViewDrinks);
        listDrinks.setAdapter(listAdapter);

        //Создание слушателя
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long id) {
                //Передача напитка, выбранного пользователем, DrinkActivity
                Intent intent = new Intent(DrinksActivity.this, DrinkDescriptionActivity.class);
                intent.putExtra(DrinkDescriptionActivity.EXTRA_DRINK_ID, (int) id);
                startActivity(intent);
            }
        };
        //Назначение слушателя для спискового представления
        listDrinks.setOnItemClickListener(itemClickListener);
    }

}
