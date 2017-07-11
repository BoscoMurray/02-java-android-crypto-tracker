package com.example.user.cc_project02;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransactionNewActivity extends AppCompatActivity {

    TextView dateEntry;
    TextView txTypeEntry;
    TextView currencyEntry;
    TextView quantityEntry;
    Button saveTxButton;
//    Transaction tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_new);

        dateEntry = (TextView) findViewById(R.id.date_entry);
        txTypeEntry = (TextView) findViewById(R.id.txtype_entry);
        currencyEntry = (TextView) findViewById(R.id.currency_entry);
        quantityEntry = (TextView) findViewById(R.id.quantity_entry);

        saveTxButton = (Button) findViewById(R.id.savetx_button);



    }

    public void setDate(int year, int month, int day) {
        dateEntry.setText(day + " - " + month + " - " + year);
    }

    public void openDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "datePicker");
    }

//    public void onSaveTxButtonClicked(View button) {
//        Log.d(getClass().toString(), "onSaveTxButtonClicked was called");
//
//        String dateString = dateEntry.getText().toString();
//
//        Transaction tx = new Transaction(dateString, txType, currency, quantity);
//
//        Intent intent = new Intent(this, TransactionListActivity.class);
//        startActivity(intent);
//    }
}
