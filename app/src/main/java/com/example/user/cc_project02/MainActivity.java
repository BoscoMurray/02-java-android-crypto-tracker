package com.example.user.cc_project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import enums.CurrencyName;
import enums.TransactionType;

public class MainActivity extends BaseActivity {

    Button newTxButton;
    Button listTxsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getClass().toString(), "onCreate called");

        // Create Currencies (with Prices) and Transaction seed data, if it doesn't already exist
        SharedPreferences sharedPrefs = getSharedPreferences("crypto-tracker", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        if(!sharedPrefs.contains("initialized")){
            editor = sharedPrefs.edit();

            //Indicate that the default shared prefs have been set
            editor.putBoolean("initialized", true);

            //Set some default shared pref
            Currency bitcoin = new Currency(CurrencyName.BITCOIN, "bitcoin", 2500);
            Currency monero = new Currency(CurrencyName.MONERO, "monero", 50);
            Currency litecoin = new Currency(CurrencyName.LITECOIN, "litecoin", 25);
            Currency ethereum = new Currency(CurrencyName.ETHEREUM, "ethereum", 250);
            Currency nem = new Currency(CurrencyName.MAIDSAFE, "nem", 10);
            Currency ripple = new Currency(CurrencyName.RIPPLE, "ripple", 20);
            Currency ubiq = new Currency(CurrencyName.UBIQ, "ubiq", 15);

            ArrayList<Currency> currencies = new ArrayList<>();
            currencies.add(bitcoin);
            currencies.add(monero);
            currencies.add(litecoin);
            currencies.add(ethereum);
            currencies.add(nem);
            currencies.add(ripple);
            currencies.add(ubiq);

            ArrayList<Transaction> txList = new ArrayList<>();
            txList.add(new Transaction("20170526", TransactionType.BUY, bitcoin, 2));
            txList.add(new Transaction("20170528", TransactionType.BUY, monero, 500));
            txList.add(new Transaction("20170601", TransactionType.BUY, monero, 100));
            txList.add(new Transaction("20170604", TransactionType.BUY, litecoin, 10));
            txList.add(new Transaction("20170610", TransactionType.BUY, ethereum, 2));
            txList.add(new Transaction("20170612", TransactionType.BUY, nem, 15));
            txList.add(new Transaction("20170614", TransactionType.BUY, monero, 100));
            txList.add(new Transaction("20170701", TransactionType.BUY, ubiq, 10));
            txList.add(new Transaction("20170701", TransactionType.BUY, ripple, 500));
            txList.add(new Transaction("20170701", TransactionType.SELL, bitcoin, 1));
            txList.add(new Transaction("20170701", TransactionType.SELL, monero, 10));
            txList.add(new Transaction("20170701", TransactionType.SELL, nem, 10));

            Gson gsonCurr = new Gson();
            Gson gsonTxs = new Gson();
            editor.putString("myCurrencies", gsonCurr.toJson(currencies));
            editor.putString("myTransactions", gsonTxs.toJson(txList));

            editor.apply();
        }

        // Get allTxsSum to display as Portfolio value
        String allTransactions = sharedPrefs.getString("myTransactions", new ArrayList<Transaction>().toString());
        Gson gsonAllTxs = new Gson();
        TypeToken<ArrayList<Transaction>> txArrayList = new TypeToken<ArrayList<Transaction>>(){};
        ArrayList<Transaction> transactionsArrayList = gsonAllTxs.fromJson(allTransactions, txArrayList.getType());
        TransactionList txList = new TransactionList(transactionsArrayList);
        TextView value = (TextView) findViewById(R.id.portfolio_value);
        value.setText(txList.getSumOfTxs().toString());

        newTxButton = (Button) findViewById(R.id.newtx_button);
        listTxsButton = (Button) findViewById(R.id.listtxs_button);
    }

    public void onNewTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onNewTxButtonClicked was called");
        Intent intent = new Intent(this, TransactionNewActivity.class);
        startActivity(intent);
    }

    public void onListTxsButtonClicked(View button) {
        Log.d(getClass().toString(), "onListTxsButtonClicked was called");

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }

}
