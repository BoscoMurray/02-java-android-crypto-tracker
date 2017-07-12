package com.example.user.cc_project02;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import enums.CurrencyName;
import enums.TransactionType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TransactionNewActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    TextView dateEntry;
    Spinner txTypeSpinner;
    Spinner currencySpinner;
    TextView quantityEntry;
    Button saveTxButton;
    ArrayAdapter<TransactionType> txTypeAdapter;
    ArrayAdapter<CurrencyName> currencyAdapter;
    private TransactionType selectedTxType;
    private CurrencyName selectedCurrency;
    Currency currency;

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

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        dateEntry.setText(sdf.format(c.getTime()));
    }

    public void openDatePicker(View view) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getFragmentManager(), "datePicker");
    }

    public void onSaveTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onSaveTxButtonClicked was called");

        // Date
        String dateString = dateEntry.getText().toString();

            Log.e("Ahh", dateString);

        // Get Currencies, loop to find selected currency
        SharedPreferences sharedPrefs = getSharedPreferences("crypto-tracker", MODE_PRIVATE);
        Gson gsonCurr = new Gson();
        String myCurrencies = sharedPrefs.getString("myCurrencies", new ArrayList<Currency>().toString());
        TypeToken<ArrayList<Currency>> currencyArrayList = new TypeToken<ArrayList<Currency>>(){};
        ArrayList<Currency> currencies = gsonCurr.fromJson(myCurrencies, currencyArrayList.getType());
        for(Currency curr : currencies) {
            if(curr.getName() == selectedCurrency) {
                currency = curr;
            }
        }

        // Quantity
        int quantity = Integer.parseInt(quantityEntry.getText().toString());

        // Build tx
        Transaction tx = new Transaction(dateString, selectedTxType, currency, quantity);

        // Get existing txs
        Gson gsonTxs = new Gson();
        String myTxs = sharedPrefs.getString("myTransactions", new ArrayList<Transaction>().toString());
        TypeToken<ArrayList<Transaction>> transactionArrayList = new TypeToken<ArrayList<Transaction>>(){};
        ArrayList<Transaction> txList = gsonTxs.fromJson(myTxs, transactionArrayList.getType());

        // Add newTx
        txList.add(tx);

        // Save new txs to SharedPrefs
        Gson gsonNewTxs = new Gson();
        SharedPreferences.Editor editor;
        editor = sharedPrefs.edit();
        editor.putString("myTransactions", gsonNewTxs.toJson(txList));
        editor.apply();

        // Create intent, putExtra tx
        Intent intent = new Intent(this, TransactionDetailActivity.class);
        intent.putExtra("tx", tx);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch(adapterView.getId()) {
            case R.id.txtype_spinner:
                this.selectedTxType =  (TransactionType) adapterView.getItemAtPosition(i);
                break;
            case R.id.currency_spinner:
                this.selectedCurrency = (CurrencyName) adapterView.getItemAtPosition(i);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
