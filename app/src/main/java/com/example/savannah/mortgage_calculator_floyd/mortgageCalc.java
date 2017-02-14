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
        String message = intent1.getStringExtra("loanTotal");
        loanTotal = (TextView)findViewById(R.id.loanTotaltxt);
        loanTotal.setText(message);
        message = intent1.getStringExtra("interestTotal");
        interestTotal = (TextView)findViewById(R.id.interestTotaltxt);
        interestTotal.setText(message);
        message = intent1.getStringExtra("yearTaxes");
        yearTaxes = (TextView)findViewById(R.id.yearTaxestxt);
        yearTaxes.setText(message);
        message = intent1.getStringExtra("amountPaid");
        amountPaid = (TextView)findViewById(R.id.amountPaidtxt);
        amountPaid.setText(message);
        message = intent1.getStringExtra("taxesPaid");
        taxesPaid = (TextView)findViewById(R.id.taxesPaidtxt);
        taxesPaid.setText(message);
        message = intent1.getStringExtra("HOAPaid");
        HOAPaid = (TextView)findViewById(R.id.HOAPaidtxt);
        HOAPaid.setText(message);
    }
}
