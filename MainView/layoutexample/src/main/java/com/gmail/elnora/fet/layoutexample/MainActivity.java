package com.gmail.elnora.fet.layoutexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber1;
    private EditText editTextNumber2;
    private Button buttonAdd;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editNumber1);
        editTextNumber2 = findViewById(R.id.editNumber2);
        textResult = findViewById(R.id.textResult);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberAText = editTextNumber1.getText().toString();
                String numberBText = editTextNumber2.getText().toString();

                int numberA = Integer.parseInt(numberAText);
                int numberB = Integer.parseInt(numberBText);
                int result = numberA + numberB;

                textResult.setText(String.valueOf(result));
            }
        });
    }


}
