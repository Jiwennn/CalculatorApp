package com.example.jiwen.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    //variable to hold the operands and type of calculations

    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        result = findViewById(R.id.result);
        newNumber = findViewById(R.id.newNumber);
        displayOperation = findViewById(R.id.operation);


        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button_Dot = findViewById(R.id.button_Dot);


        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newNumber.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        button_Dot.setOnClickListener(listener);

        //operation buttons
        Button button_Add = findViewById(R.id.button_Add);
        Button button_Minus = findViewById(R.id.button_Minus);
        Button button_Multiply = findViewById(R.id.button_Multiply);
        Button button_Divide = findViewById(R.id.button_Divide);
        Button button_Equal = findViewById(R.id.button_Equal);

        View.OnClickListener listener1 = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String op = ((Button) view).getText().toString();
                String value = newNumber.getText().toString();
                if(value.length() != 0){
                    performOperation(value, op);
                }

                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        button_Add.setOnClickListener(listener1);
        button_Divide.setOnClickListener(listener1);
        button_Equal.setOnClickListener(listener1);
        button_Minus.setOnClickListener(listener1);
        button_Multiply.setOnClickListener(listener1);

    }

    private void performOperation(String value, String operation){
        if(null == operand1){
            operand1 = Double.valueOf(value);
        }else{
            operand2 = Double.valueOf(value);

            if(pendingOperation.equals("=")){
                pendingOperation = operation;
            }
            switch (pendingOperation){
                case "=":
                    operand1 = operand2;
                    break;
                case "/":
                    if(operand2 == 0){
                        operand1 = 0.0;
                    }else{
                        operand1 /= operand2;
                    }
                    break;
                case "X":
                    operand1 *= operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "+":
                    operand1 += operand2;
                    break;
            }
        }

        result.setText(operand1.toString());
        newNumber.setText("");
    }
}
