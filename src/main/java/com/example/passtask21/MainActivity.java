package com.example.passtask21;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Define the components

    Spinner converter;       //to choose option from spinner
    EditText enterNumber;    //to enter number
    TextView resultView1;    //for results - 1
    TextView resultView2;    //for results - 2
    TextView resultView3;    //for results - 3

    ImageButton  meterConverter;
    ImageButton  celsiusConverter;
    ImageButton  kiloConverter;

    //to format to two decimal places
    DecimalFormat precision = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Accessing widgets
        converter = findViewById(R.id.converter);        //to choose option from spinner
        enterNumber = findViewById(R.id.enterNumber);    //to enter number
        resultView1 = findViewById(R.id.resultView1);    //for results - 1
        resultView2 = findViewById(R.id.resultView2);    //for results - 2
        resultView3 = findViewById(R.id.resultView3);    //for results - 3

        //Buttons
        meterConverter = findViewById(R.id.meterConverter);
        celsiusConverter = findViewById(R.id.celsiusConverter);
        kiloConverter = findViewById(R.id.kiloConverter);


        //Buttons
        //Accessing widgets

            converter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    // get current item
                    String currentItem = parentView.getItemAtPosition(position).toString();

                    //-----------------------------------------------------------------------------------------------------------------
                    //check if meter is selected if so then do calculation else prompt error
                    try {
                        meterConverter.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(View v) {
                                if (currentItem.equals("Meter"))
                                {
                                    double result1 = Double.parseDouble(enterNumber.getText().toString()) * 100;
                                    double result2 = Double.parseDouble(enterNumber.getText().toString()) * 3.28084;
                                    double result3 = Double.parseDouble(enterNumber.getText().toString()) * 39.37;

                                    //Show results
                                    resultView1.setText(precision.format(result1) + "  Centirmeter");
                                    resultView2.setText(precision.format(result2) + "  Foot");
                                    resultView3.setText(precision.format(result3) + "  Inch");
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Select right item", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } catch (Exception e){}
                    //-----------------------------------------------------------------------------------------------------------------
                    //check if celsius is selected if so then do calculation else prompt error
                    try {
                        celsiusConverter.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(View v) {
                                if (currentItem.equals("Celsius"))
                                {

                                    double result1 = Double.parseDouble(enterNumber.getText().toString()) * 9 / 5 + 32;
                                    double result2 = Double.parseDouble(enterNumber.getText().toString()) + 273.15;

                                    //Show results
                                    resultView1.setText(precision.format(result1) + "  Fahrenheit");
                                    resultView2.setText(precision.format(result2) + "  Kelin");
                                    resultView3.setText(" ");
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Select right item", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } catch (Exception e){}
                    //-----------------------------------------------------------------------------------------------------------------
                    //check if kilo is selected if so then do calculation else prompt error
                    try {
                        kiloConverter.setOnClickListener(new View.OnClickListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onClick(View v) {
                                if (currentItem.equals("Kilogram"))
                                {
                                    double result1 = Double.parseDouble(enterNumber.getText().toString()) * 1000;
                                    double result2 = Double.parseDouble(enterNumber.getText().toString()) * 35.274;
                                    double result3 = Double.parseDouble(enterNumber.getText().toString()) * 2.20462;

                                    //Show results
                                    resultView1.setText(precision.format(result1) + "  Gram");
                                    resultView2.setText(precision.format(result2) + "  Ounce(Oz)");
                                    resultView3.setText(precision.format(result3) + "  Pound(lb)");
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Select right item", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } catch (Exception e){}
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    return;
                }
            });
        }
}
