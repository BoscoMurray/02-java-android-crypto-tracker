package com.example.user.cc_project02;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Enumeration;

import enums.CurrencyName;
import enums.TransactionType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TransactionNewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView dateEntry;
    Spinner txTypeSpinner;
    Spinner currencySpinner;
    TextView quantityEntry;
    Button saveTxButton;
    ArrayAdapter<TransactionType> txTypeAdapter;
    ArrayAdapter<CurrencyName> currencyAdapter;
    private TransactionType selectedTxType;
    private CurrencyName selectedCurrencyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_new);

        dateEntry = (TextView) findViewById(R.id.date_entry);
        txTypeSpinner = (Spinner) findViewById(R.id.txtype_spinner);
        currencySpinner = (Spinner) findViewById(R.id.currency_spinner);
        quantityEntry = (TextView) findViewById(R.id.quantity_entry);

        txTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TransactionType.values());
        txTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txTypeSpinner.setAdapter(txTypeAdapter);

        currencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CurrencyName.values());
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(currencyAdapter);

        txTypeSpinner.setOnItemSelectedListener(this);
        currencySpinner.setOnItemSelectedListener(this);

        saveTxButton = (Button) findViewById(R.id.savetx_button);
    }

    public void setDate(int year, int month, int day) {
        dateEntry.setText(day + " - " + month + " - " + year);
    }

    public void openDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "datePicker");
    }

    public void onSaveTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onSaveTxButtonClicked was called");

        String dateString = dateEntry.getText().toString();
//        TransactionType txType = TransactionType.valueOf(selectedTxType);
//        CurrencyName currName = CurrencyName.valueOf(selectedCurrencyType);

       // Enum currency = currencySpinner;
        int quantity = Integer.parseInt(quantityEntry.getText().toString());

        Currency currency = TransactionBundle.getCurrencyBasedOnCurrencyName(selectedCurrencyType);

        Transaction tx = new Transaction(dateString, selectedTxType, currency, quantity);

//        Gson gson = new Gson

        Intent intent = new Intent(this, TransactionDetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()) {
            case R.id.txtype_spinner:
                this.selectedTxType =  (TransactionType) adapterView.getItemAtPosition(i);
                break;
            case R.id.currency_spinner:
                this.selectedCurrencyType = (CurrencyName) adapterView.getItemAtPosition(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
