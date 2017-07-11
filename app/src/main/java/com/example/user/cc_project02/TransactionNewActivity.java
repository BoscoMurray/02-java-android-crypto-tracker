package com.example.user.cc_project02;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class TransactionNewActivity extends AppCompatActivity {

    TextView dateEntry;
    Spinner txTypeSpinner;
    Spinner currencySpinner;
    TextView quantityEntry;
    Button saveTxButton;
    ArrayAdapter<CharSequence> txTypeAdapter;
    ArrayAdapter<CharSequence> currencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_new);

        dateEntry = (TextView) findViewById(R.id.date_entry);
        txTypeSpinner = (Spinner) findViewById(R.id.txtype_spinner);
        currencySpinner = (Spinner) findViewById(R.id.currency_spinner);
        quantityEntry = (TextView) findViewById(R.id.quantity_entry);
        txTypeAdapter = ArrayAdapter.createFromResource(this, R.array.txtype_array, android.R.layout.simple_spinner_item);
        txTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txTypeSpinner.setAdapter(txTypeAdapter);
        currencyAdapter = ArrayAdapter.createFromResource(this, R.array.currency_array, android.R.layout.simple_spinner_item);
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);


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
//        Intent intent = new Intent(this, TransactionDetailActivity.class);
//        startActivity(intent);
//    }
}
