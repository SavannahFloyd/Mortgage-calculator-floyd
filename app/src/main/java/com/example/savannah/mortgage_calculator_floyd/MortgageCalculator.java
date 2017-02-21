package com.example.savannah.mortgage_calculator_floyd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;
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

    private TextView homeValueEdit;
    private TextView loanAmountEdit;
    private TextView interestRateEdit;
    private TextView loanTermEdit;
    private TextView startDateEdit;
    private TextView propertyTaxEdit;
    private TextView homeInsPerYearEdit;
    private TextView monthlyHOAAmountEdit;

    private Button mortgageSummaryButton;
    private Button paymentSummaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_calculator);

        homeValueEdit = (TextView)findViewById(R.id.homeValue);
        loanAmountEdit = (EditText)findViewById(R.id.loanAmount);
        interestRateEdit = (EditText)findViewById(R.id.interestRate);
        loanTermEdit = (EditText)findViewById(R.id.loanTerm);
        startDateEdit = (EditText)findViewById(R.id.startDate);
        propertyTaxEdit = (EditText)findViewById(R.id.propertyTax);
        homeInsPerYearEdit = (EditText)findViewById(R.id.homeInsPerYear);
        monthlyHOAAmountEdit = (EditText)findViewById(R.id.monthlyHOAAmount);

        mortgageSummaryButton = (Button)findViewById(R.id.mortgageSummaryButton);
        paymentSummaryButton = (Button)findViewById(R.id.paymentSummaryButton);

        //homeValueEdit.setText(homeValue.toString());
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
        homeValue = savedInstanceState.getFloat("Home Value");
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
        String[] rtrnVal = new String[8];
        getValues();

        Double totalCost = loanAmount.doubleValue();
        Double totalInterest;
        Double paid = 0.00;
        Double monthlyMortgage;
        Double totalPaymentMonth;
        Double yearTax;
        Double taxes;
        Double HOA;
        Calendar calendar = Calendar.getInstance();
        int numYears = calendar.get(Calendar.YEAR)-startDate.intValue();
        int month = calendar.get(Calendar.MONTH);

        for(int i = 0; i<loanTerm.intValue();i++){
            totalCost = totalCost + totalCost*(interestRate.doubleValue()/100);
            totalCost = totalCost.doubleValue();
        }
        rtrnVal[0] = totalCost.toString();

        totalInterest = totalCost - loanAmount.doubleValue();
        rtrnVal[1] = totalInterest.toString();

        yearTax = homeValue*propertyTax.doubleValue()/100;
        rtrnVal[2] = yearTax.toString();

        monthlyMortgage = totalCost/loanTerm.doubleValue()/12;
        rtrnVal[3] = monthlyMortgage.toString();

        totalPaymentMonth = monthlyMortgage + monthlyHOAAmount.doubleValue()
                +(yearTax/12)+(homeInsPerYear.doubleValue()/12);
        rtrnVal[4] = totalPaymentMonth.toString();

        paid = totalPaymentMonth*numYears*12+(totalPaymentMonth*month);
        rtrnVal[5] = paid.toString();

        taxes = yearTax*numYears;
        rtrnVal[6] = taxes.toString();

        HOA = monthlyHOAAmount.doubleValue()*numYears*12+(monthlyHOAAmount.doubleValue()*month);
        rtrnVal[7] = HOA.toString();

        return rtrnVal;

    }
    private void getValues(){
        homeValue = Float.parseFloat(homeValueEdit.getText().toString());
        loanAmount = Float.parseFloat(loanAmountEdit.getText().toString());
        interestRate = Float.parseFloat(interestRateEdit.getText().toString());
        loanTerm = Float.parseFloat(loanTermEdit.getText().toString());
        startDate = Float.parseFloat(startDateEdit.getText().toString());
        propertyTax = Float.parseFloat(propertyTaxEdit.getText().toString());
        homeInsPerYear = Float.parseFloat(homeInsPerYearEdit.getText().toString());
        monthlyHOAAmount = Float.parseFloat(monthlyHOAAmountEdit.getText().toString());

    }
}
