package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;

public class Landscape extends AppCompatActivity {

    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual, buttonDot; // +, -, *, /, =, C, .
    private Button bracketOpen, BracketClose, ButtonAC, ButtonC; // (, ),AC,C
    private TextView textView; // to display the input and output

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);


    }

}