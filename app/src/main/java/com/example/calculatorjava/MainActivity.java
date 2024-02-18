package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstValue=0.0  , secondValue=0.0;
    String currentOperator = "";
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);
        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.OFF);
        Button plus = findViewById(R.id.plus);
        Button multi = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button point = findViewById(R.id.point);
        Button div = findViewById(R.id.div);
        Button equal = findViewById(R.id.equal);
        Button del = findViewById(R.id.Del);
        Button Ac = findViewById(R.id.AC);
        TextView screen = findViewById(R.id.textView);

        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                screen.append(b.getText().toString());
            }
        };

        View.OnClickListener operatorButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                firstValue = Double.valueOf(screen.getText().toString());
                screen.setText("");
                currentOperator = b.getText().toString();
            }
        };

        num0.setOnClickListener(numberButtonClickListener);
        num1.setOnClickListener(numberButtonClickListener);
        num2.setOnClickListener(numberButtonClickListener);
        num3.setOnClickListener(numberButtonClickListener);
        num4.setOnClickListener(numberButtonClickListener);
        num5.setOnClickListener(numberButtonClickListener);
        num6.setOnClickListener(numberButtonClickListener);
        num7.setOnClickListener(numberButtonClickListener);
        num8.setOnClickListener(numberButtonClickListener);
        num9.setOnClickListener(numberButtonClickListener);
        plus.setOnClickListener(numberButtonClickListener);
        minus.setOnClickListener(operatorButtonClickListener);
        multi.setOnClickListener(operatorButtonClickListener);
        point.setOnClickListener(operatorButtonClickListener);
        div.setOnClickListener(operatorButtonClickListener);

        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondValue = Double.valueOf(screen.getText().toString());
                switch (currentOperator) {
                    case "+":
                        screen.setText(String.valueOf(firstValue + secondValue));
                        break;
                    case "-":
                        screen.setText(String.valueOf(firstValue - secondValue));
                        break;
                    case "*":
                        screen.setText(String.valueOf(firstValue * secondValue));
                        break;
                    case "/":
                        screen.setText(String.valueOf(firstValue / secondValue));
                        break;
                }
            }
        });

    }
}