package com.example.iphone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;



    public class MainActivity extends AppCompatActivity {

        String oldNumber = "";
        String op = "+";
        boolean isNewOp = true;
        TextView ed1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ed1 = findViewById(R.id.editText);
        }

        public void numberEvent(View view) {
            if (isNewOp)
                ed1.setText("");
            isNewOp = false;
            String number = ed1.getText().toString();
            switch (view.getId()) {
                case R.id.button0:
                    number += "0";
                    break;
                case R.id.button1:
                    number += "1";
                    break;
                case R.id.button2:
                    number += "2";
                    break;
                case R.id.button3:
                    number += "3";
                    break;
                case R.id.button4:
                    number += "4";
                    break;
                case R.id.button5:
                    number += "5";
                    break;
                case R.id.button6:
                    number += "6";
                    break;
                case R.id.button7:
                    number += "7";
                    break;
                case R.id.button8:
                    number += "8";
                    break;
                case R.id.button9:
                    number += "9";
                    break;
                case R.id.buttonPM:
                    number = "-" + number;
                    break;
                case R.id.buttonCO:

                    if (number.indexOf(".") > -1) {
                        //la virgule existe
                    } else {
                        //la virgule n'existe pas
                        number += ".";
                    }
                    break;
            }
            ed1.setText(number);
        }

        public void operatorEvent(View view) {
            isNewOp = true;
            oldNumber = ed1.getText().toString();
            switch (view.getId()) {
                case R.id.buttonDI:
                    op = "/";
                    break;
                case R.id.buttonMU:
                    op = "*";
                    break;
                case R.id.buttonPL:
                    op = "+";
                    break;
                case R.id.buttonMI:
                    op = "-";
                    break;
            }
        }

        public void equalEvent(View view) {
            String newNumber = ed1.getText().toString();
            BigDecimal a = new BigDecimal(oldNumber);
            BigDecimal b = new BigDecimal(newNumber);
            BigDecimal result = new BigDecimal("0");
            //double result = 0.0;
            switch (op) {
                case "+":
                    result = a.add(b);
                    //result = Double.parseDouble(oldNumber)+ Double.parseDouble(newNumber);
                    break;
                case "-":
                    result = a.subtract(b);
                    //result = Double.parseDouble(oldNumber)- Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = a.multiply(b);
                    //result = Double.parseDouble(oldNumber)* Double.parseDouble(newNumber);
                    break;
                case "/":
                    result = a.divide(b);
                    //result = Double.parseDouble(oldNumber)/ Double.parseDouble(newNumber);
                    break;
            }
            ed1.setText(result + "");
        }

        public void acEvent(View view) {
            ed1.setText("0");
            isNewOp = true;
        }

        public void percentEvent(View view) {
            double no = Double.parseDouble(ed1.getText().toString()) / 100;
            ed1.setText(no + "");
            isNewOp = true;
        }
    }