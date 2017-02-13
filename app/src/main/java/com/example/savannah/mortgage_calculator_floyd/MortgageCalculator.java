package com.example.savannah.mortgage_calculator_floyd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
import java.util.Date;
import android.widget.Button;
import android.widget.TextView;

public class MortgageCalculator extends AppCompatActivity {
    private Float homeValue = new Float(0);
    private Float loanAmount = new Float(0);
    private Float interestRate= new Float(0);
    private Float loanTerm = new Float(0);
    private Float startDate = new Float(0);
    private Float propertyTax = new Float(0);
    private Float homeInsPerYear = new Float(0);
    private Float monthlyHOAAmount= new Float(0);

    private EditText homeValueEdit;
    private EditText loanAmountEdit;
    private EditText interestRateEdit;
    private EditText loanTermEdit;
    private EditText startDateEdit;
    private EditText propertyTaxEdit;
    private EditText homeInsPerYearEdit;
    private EditText monthlyHOAAmountEdit;

    private Button mortgageSummaryButton;
    private Button paymentSummaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator);

        homeValueEdit = (EditText)findViewById(R.id.editText);
        loanAmountEdit = (EditText)findViewById(R.id.editText2);
        interestRateEdit = (EditText)findViewById(R.id.editText3);
        loanTermEdit = (EditText)findViewById(R.id.editText4);
        startDateEdit = (EditText)findViewById(R.id.editText5);
        propertyTaxEdit = (EditText)findViewById(R.id.editText6);
        homeInsPerYearEdit = (EditText)findViewById(R.id.editText7);
        monthlyHOAAmountEdit = (EditText)findViewById(R.id.editText8);

        mortgageSummaryButton = (Button)findViewById(R.id.button3);
        paymentSummaryButton = (Button)findViewById(R.id.button);

        homeValueEdit.setText(homeValue.toString());
        loanAmountEdit.setText(loanAmount.toString());
        interestRateEdit.setText(interestRate.toString());
        loanTermEdit.setText(loanTerm.toString());
        startDateEdit.setText(startDate.toString());
        propertyTaxEdit.setText(propertyTax.toString());
        homeInsPerYearEdit.setText(homeInsPerYear.toString());
        monthlyHOAAmountEdit.setText(monthlyHOAAmount.toString());
        mortgageSummaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MortgageCalculator.this, mortgageCalc.class);
                String[] calcValues = Calculations();
                intent1.putExtra("totalLoan", calcValues[0]);
                intent1.putExtra("totalInterest", calcValues[1]);
                intent1.putExtra("yearlyTax", calcValues[2]);
                intent1.putExtra("totalPaid", calcValues[5]);
                intent1.putExtra("taxesPaid", calcValues[6]);
                intent1.putExtra("HOAPaid", calcValues[7]);
                startActivity(intent1);
                }
            });
        paymentSummaryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MortgageCalculator.this, paymentSummary.class);
                String[] calcValues = Calculations();
                intent2.putExtra("monthlyMort", calcValues[3]);
                intent2.putExtra("monthlyHOA",monthlyHOAAmount.toString());
                intent2.putExtra("totalMonthlyPayment", calcValues[4]);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getValues();
        outState.putFloat("homeValue",homeValue);
        outState.putFloat("loanAmount",loanAmount);
        outState.putFloat("interestRate",interestRate);
        outState.putFloat("loanTerm",loanTerm);
        outState.putFloat("startDate", startDate);
        outState.putFloat("propertyTax",propertyTax);
        outState.putFloat("homeInsPerYear",homeInsPerYear);
        outState.putFloat("monthlyHOAAmount",monthlyHOAAmount);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        homeValue = savedInstanceState.getFloat("homeValue");
        loanAmount = savedInstanceState.getFloat("loanAmount");
        interestRate = savedInstanceState.getFloat("interestRate");
        loanTerm = savedInstanceState.getFloat("loanTerm");
        startDate = savedInstanceState.getFloat("startDate");
        propertyTax = savedInstanceState.getFloat("propertyTax");
        homeInsPerYear = savedInstanceState.getFloat("homeInsPerYear");
        monthlyHOAAmount = savedInstanceState.getFloat("monthlyHOAAmount");
        getValues();
        homeValueEdit.setText(homeValue.toString());
        loanAmountEdit.setText(loanAmount.toString());
        interestRateEdit.setText(interestRate.toString());
        loanTermEdit.setText(loanTerm.toString());
        startDateEdit.setText(startDate.toString());
        propertyTaxEdit.setText(propertyTax.toString());
        homeInsPerYearEdit.setText(homeInsPerYear.toString());
        monthlyHOAAmountEdit.setText(monthlyHOAAmount.toString());
    }
    private String[] Calculations() {

    }
    private void getValues(){

    }
}
