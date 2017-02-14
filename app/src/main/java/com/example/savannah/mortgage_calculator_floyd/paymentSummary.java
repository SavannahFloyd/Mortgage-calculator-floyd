package com.example.savannah.mortgage_calculator_floyd;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class paymentSummary extends AppCompatActivity {
    private TextView monthlyMortgage;
    private TextView HOAMonthly;
    private TextView totalMonthly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);
        Intent intent2 = getIntent();
        String message = intent2.getStringExtra("monthlyMortgage");
        monthlyMortgage = (TextView)findViewById(R.id.monthlyMortgagetxt);
        monthlyMortgage.setText(message);
        message = intent2.getStringExtra("HOAMonthly");
        HOAMonthly = (TextView)findViewById(R.id.HOAMonthlytxt);
        HOAMonthly.setText(message);
        message = intent2.getStringExtra("totalMonthly");
        totalMonthly = (TextView)findViewById(R.id.totalMonthlytxt);
        totalMonthly.setText(message);
    }
}
