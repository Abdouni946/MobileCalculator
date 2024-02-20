package com.example.calculatorjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    private Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual, buttonDot; // +, -, *, /, =, C, .
    private Button bracketOpen, BracketClose, ButtonAC, ButtonC; // (, ),AC,C
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
        assignedId(bracketOpen, R.id.openBracket);
        assignedId(BracketClose, R.id.closeBracket);
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

    public String calculateResult(String data) {
        data = data.replaceAll("\\s", ""); // Remove all whitespaces
        if (data.isEmpty()) {
            return "Invalid Input";
        }

        double result = 0;
        StringBuilder currentNumber = new StringBuilder();
        char operation = '+';

        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '.') {
                currentNumber.append(currentChar);
            } else {
                // Handle the end of a number and the start of an operation
                if (currentNumber.length() > 0) {
                    double number = Double.parseDouble(currentNumber.toString());
                    result = applyOperation(result, number, operation);
                    currentNumber = new StringBuilder(); // Reset for next number
                }
                operation = currentChar; // Update operation
            }

            // Handle operations that do not follow a number directly
            if (!Character.isDigit(currentChar) && currentChar != '.' && i == data.length() - 1) {
                result = applyOperation(result, 0, operation);
            }
        }

        // Handle last number
        if (currentNumber.length() > 0) {
            double number = Double.parseDouble(currentNumber.toString());
            result = applyOperation(result, number, operation);
        }

        // Formatting the result
        if (result == (long) result) {
            return String.format("%d", (long) result);
        } else {
            return String.format("%.2f", result);
        }
    }

    // Apply the operation
    private double applyOperation(double result, double number, char operation) {
        switch (operation) {
            case '+':
                return result + number;
            case '-':
                return result - number;
            case '*':
                return result * number;
            case '/':
                if (number == 0) throw new ArithmeticException("Division by zero");
                return result / number;
            case '%':
                return result % number;
            case '1': // For 1/x
                return 1 / number;
            case 'p': // Assuming 'p' for PI
                return Math.PI;
            case 'e': // Assuming 'e' for Euler's number
                return Math.E;
            case 'a': // Assuming 'a' for abs
                return Math.abs(number);
            case 'x': // Assuming 'x' for exp
                return Math.exp(number);
            case 's': // Assuming 's' for sin
                return Math.sin(number);
            case 'c': // Assuming 'c' for cos
                return Math.cos(number);
            case 't': // Assuming 't' for tan
                return Math.tan(number);
            case 'l': // Assuming 'l' for log
                return Math.log10(number);
            case 'n': // Assuming 'n' for ln
                return Math.log(number);
            case 'q': // Assuming 'q' for sqrt
                return Math.sqrt(number);
            case 'u': // Assuming 'u' for square (squart was probably meant square)
                return Math.pow(number, 2);
            case 'f': // Assuming 'f' for factorial
                return factorial(number);
            case 'o': // Assuming 'o' for power
                return Math.pow(result, number); // This needs clarification, used result as base
            default:
                return result;
        }
    }

    // Factorial function
    private double factorial(double number) {
        if (number < 0) throw new ArithmeticException("Factorial of a negative number is undefined");
        if (number == 0) return 1;
        double result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }



}