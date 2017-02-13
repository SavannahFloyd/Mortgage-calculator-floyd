package com.example.savannah.mortgage_calculator_floyd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class mortgageCalc extends AppCompatActivity {

    private TextView loanTotal;
    private TextView interestTotal;
    private TextView yearTaxes;
    private TextView amountPaid;
    private TextView taxesPaid;
    private TextView HOAPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent1 = getIntent();
    }
}
