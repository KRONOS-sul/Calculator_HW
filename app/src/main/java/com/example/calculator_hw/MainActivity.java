package com.example.calculator_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private double first, second;
    private Boolean isClickOperation = false;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = findViewById(R.id.tv_result);
    }

    public void onClickNumber(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_all_clear:
                tv_result.setText("0");
                isClickOperation = false;
                first = 0;
                second = 0;
                break;
        }
    }

    public void setNumber(String number) {
        if (tv_result.getText().toString().equals("0")) {
            tv_result.setText(number);
        } else if (isClickOperation) {
            tv_result.setText(number);
        } else {
            tv_result.append(number);
        }
        isClickOperation = false;
    }

    public void onClickOperation(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Double.parseDouble(tv_result.getText().toString());
                isClickOperation = true;
                operation = "+";
                break;

            case  R.id.btn_minus:
                first = Double.parseDouble(tv_result.getText().toString());
                isClickOperation = true;
                operation = "-";
                break;

            case R.id.btn_divide:
                first = Double.parseDouble(tv_result.getText().toString());
                isClickOperation = true;
                operation = "/";
                break;

            case  R.id.btn_multiply:
                first = Double.parseDouble(tv_result.getText().toString());
                isClickOperation = true;
                operation = "*";
                break;

            case R.id.btn_equal:
                second = Double.parseDouble(tv_result.getText().toString());
                Double result = Double.valueOf(0);
                switch (operation){
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                tv_result.setText(result.toString());
                isClickOperation = true;
                break;

            case R.id.btn_percent:
                Double result1 = Double.valueOf(0);
                first = Double.parseDouble(tv_result.getText().toString());
                isClickOperation = true;
                operation = "/";
                switch (operation){
                    case "/":
                    result1 = first / 100;
                    break;
                }
                tv_result.setText(new DecimalFormat("##.######").format(result1));
                break;
        }
    }
}