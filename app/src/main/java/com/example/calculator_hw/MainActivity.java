package com.example.calculator_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

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
        MaterialButton transition = findViewById(R.id.passage);

        transition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, ActivityTwo.class);
                String answer = tv_result.getText().toString();
                intent.putExtra("answer", answer);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickNumber(View view) {
        Button passage = findViewById(R.id.passage);
        passage.setVisibility(View.GONE);
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

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onClickOperation(View view) {
        Button passage = findViewById(R.id.passage);
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
                Double result = (double) 0;
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
                passage.setVisibility(View.VISIBLE);
                break;

            case R.id.btn_percent:
                Double result1 = (double) 0;
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