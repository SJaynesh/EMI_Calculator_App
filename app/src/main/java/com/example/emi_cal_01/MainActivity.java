package com.example.emi_cal_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ID Binding
        Button btncal = findViewById(R.id.calculate_emi);
        EditText edtamount = findViewById(R.id.loan_amount);
        EditText edtrate = findViewById(R.id.rate);
        EditText edtyear = findViewById(R.id.year);
        TextView txtamount = findViewById(R.id.txtamount);
        TextView txtrate = findViewById(R.id.txtrate);
        TextView txtyear = findViewById(R.id.txtyear);
        TextView txttotal = findViewById(R.id.txttotal);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String amountData = edtamount.getText().toString();
                String rateData = edtrate.getText().toString();
                String yearData = edtyear.getText().toString();


                if (amountData.isEmpty() && rateData.isEmpty() && yearData.isEmpty()) {
                    edtamount.setError("Enter loan amount..");
                    edtrate.setError("Enter Interest rate..");
                    edtyear.setError("Enter Total year..");
                } else {
                    double amount = Double.parseDouble(amountData);
                    double rate = Double.parseDouble(rateData);
                    int year = Integer.parseInt(yearData);

                    double P = amount;
                    double R = rate / 12 / 100;
                    int N = year;

                    double EMI;

                    EMI = P * R * (Math.pow((1 + R), N)) / (Math.pow((1 + R), N) - 1);

                    txtamount.setText(amount + "");
                    txtrate.setText(rate + "");
                    txtyear.setText(year + "");
                    txttotal.setText(EMI + "");

                    Toast.makeText(MainActivity.this, amount + " " + rate + " " + year, Toast.LENGTH_SHORT).show();
                    edtamount.setText(" ");
                    edtrate.setText(" ");
                    edtyear.setText(" ");

                    Toast.makeText(MainActivity.this, "Total EMI : " + EMI, Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}