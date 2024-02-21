package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual, buttonDot; // +, -, *, /, =, C, .
    private Button pourcentage, ButtonAC, ButtonC; // %, AC,C
    private TextView textView; // to display the input and output
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        assignedId(button0, R.id.num0);
        assignedId(button1, R.id.num1);
        assignedId(button2, R.id.num2);
        assignedId(button3, R.id.num3);
        assignedId(button4, R.id.num4);
        assignedId(button5, R.id.num5);
        assignedId(button6, R.id.num6);
        assignedId(button7, R.id.num7);
        assignedId(button8, R.id.num8);
        assignedId(button9, R.id.num9);
        assignedId(buttonAdd, R.id.plus);
        assignedId(buttonSub, R.id.minus);
        assignedId(buttonMul, R.id.multiply);
        assignedId(buttonDiv, R.id.div);
        assignedId(buttonEqual, R.id.equal);
        assignedId(buttonDot, R.id.dot);
        assignedId(pourcentage, R.id.pourcentage);
        assignedId(ButtonAC, R.id.AC);
        assignedId(ButtonC, R.id.C);

    }

    void assignedId ( Button btn , int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = textView.getText().toString();

        switch (buttonText) {
            case "AC":
                textView.setText("0");
                break;
            case "C":
                if(dataToCalculate.equals("Invalid Input") || dataToCalculate.equals("Error: Division by Zero") || dataToCalculate.equals("Error: Invalid Number Format") || dataToCalculate.equals("Error: Unexpected"))
                    textView.setText("0");
                else
                    if (!dataToCalculate.isEmpty()) {
                    dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
                    textView.setText(dataToCalculate);
                }
                break;
            case "=":
                String result = calculateResult(dataToCalculate);
                textView.setText(result);
                break;
            default:
                if (dataToCalculate.equals("0")) {
                    dataToCalculate = buttonText;
                } else {
                    dataToCalculate += buttonText;
                }
                textView.setText(dataToCalculate);
                break;
        }
    }

    private String calculateResult(String data) {
        data = data.replaceAll("\\s", "");
        if (data.isEmpty() || data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")) {
            return "Invalid Input";
        }

        try {
            // Initial result and current number as a string
            double result = 0;
            StringBuilder currentNumber = new StringBuilder();
            char operation = '+';

            for (int i = 0; i < data.length(); i++) {
                char currentChar = data.charAt(i);

                if (Character.isDigit(currentChar) || currentChar == '.') {
                    currentNumber.append(currentChar); // Build the current number
                }

                if (!Character.isDigit(currentChar) && currentChar != '.' || i == data.length() - 1) {
                    // When we hit an operator or reach the end of the string, we evaluate
                    // what we have so far
                    double number = currentNumber.length() > 0 ? Double.parseDouble(currentNumber.toString()) : 0;
                    switch (operation) {
                        case '+':
                            result += number;
                            break;
                        case '-':
                            result -= number;
                            break;
                        case '*':
                            result *= number;
                            break;
                        case '%':
                            result = result * number / 100;
                            break;
                        case '/':
                            if (number == 0) {
                                return "Error: Division by Zero"; // Prevent division by zero
                            }
                            result /= number;
                            break;
                    }

                    // Reset for the next number
                    currentNumber = new StringBuilder();
                    operation = currentChar; // Update the operation for the next loop
                }
            }

            // Formatting the result to remove unnecessary decimal places
            if (result == (long) result) {
                return String.format("%d", (long) result);
            } else {
                return String.format("%.2f", result); // Limiting to 2 decimal places for simplicity
            }
        } catch (NumberFormatException e) {
            return "Error: Invalid Number Format"; // Handle incorrect number formats gracefully
        } catch (Exception e) {
            return "Error: Unexpected"; // Catch-all for any other unexpected errors
        }
    }


}