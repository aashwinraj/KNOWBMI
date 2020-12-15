package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;
    private Button calculate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        setupButtonClickListener();
    }

    private void setupButtonClickListener() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double b =calculateBmi();
                displaybmi(b);
            }
        });
    }

    private void displaybmi(double bmi) {
        DecimalFormat mdf=new DecimalFormat("0.00");
        String bmiText=mdf.format(bmi);

        String finalResult;
        if(bmi<18.5)
            finalResult= bmiText+" YOU ARE UNDERWEIGHT";
        else if(bmi>25)
            finalResult=bmiText+ " YOU ARE OVERWEIGHT";
        else
            finalResult= bmiText+ "YOU ARE HEALTHY";
        result.setText(finalResult);

    }


    private void findview() {
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculate = findViewById(R.id.calculateButton);
        result = findViewById(R.id.result);

    }

    private double calculateBmi()
    {
        String feetText=feetEditText.getText().toString();
        String inchText=inchesEditText.getText().toString();
        String weightText=weightEditText.getText().toString();
        String ageText=ageEditText.getText().toString();

        int feet=Integer.parseInt(feetText);
        int inch=Integer.parseInt(inchText);
        int weight=Integer.parseInt(weightText);
        int age=Integer.parseInt(ageText);

        double totalInch=(12*feet) + inch;
        double meters=totalInch*0.0254;
        return  weight/(meters* meters);

      }
}
