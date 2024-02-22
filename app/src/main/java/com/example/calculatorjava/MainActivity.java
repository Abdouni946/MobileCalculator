package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.editText);

        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }
    public void zero(View view){
        updateText(getResources().getString(R.string.zeroText));}
    public void one(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void two(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void three(View view){
        updateText(getResources().getString(R.string.threeText));
    }

    public void four(View view){
        updateText(getResources().getString(R.string.fourText));
    }

    public void five(View view){
        updateText(getResources().getString(R.string.fiveText));
    }

    public void six(View view){
        updateText(getResources().getString(R.string.sixText));
    }


    public void seven(View view){
        updateText(getResources().getString(R.string.sevenText));
    }

    public void eight(View view){
        updateText(getResources().getString(R.string.eightText));
    }

    public void nine(View view){
        updateText(getResources().getString(R.string.nineText));
    }

    public void multiply(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }

    public void divide(View view){
        updateText(getResources().getString(R.string.divideText));
    }

    public void subtract(View view){
        updateText(getResources().getString(R.string.subtractText));
    }

    public void add(View view){
        updateText(getResources().getString(R.string.addText));
    }

    public void clear(View view){
        display.setText("");
    }

    public void pour(View view){
        updateText("%");
    }

    public void parOpen(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }

    public void parClose(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void decimal(View view){
        updateText(getResources().getString(R.string.decimalText));
    }

    public void equal(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }

    public void backspace(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }

    public void Sin(View view){
        updateText("sin(");
    }
    public void Cos(View view){
        updateText("cos(");
    }

    public void Tan(View view){
        updateText("tan(");
    }

    public void tArcSin(View view){
        updateText("arcsin(");
    }

    public void ArcCos(View view){
        updateText("arccos(");
    }

    public void ArcTan(View view){
        updateText("arctan(");
    }

    public void Ln(View view){
        updateText("ln(");
    }

    public void log(View view){
        updateText("log(");
    }

    public void sqrt(View view){
        updateText("sqrt(");
    }

    public void abs(View view){
        updateText("abs(");
    }

    public void pi(View view){
        updateText("pi");
    }

    public void e(View view){
        updateText("e");
    }

    public void xSquare(View view){
        updateText("^(2)");
    }

    public void xPowerY(View view){
        updateText("^(");
    }

}