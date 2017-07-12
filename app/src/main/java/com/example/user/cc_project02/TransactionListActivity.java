package com.example.user.cc_project02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class TransactionListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        //Get SharedPreferences "db" called "crypto-tracker" into "sharedPrefs" object
        SharedPreferences sharedPrefs = getSharedPreferences("crypto-tracker", MODE_PRIVATE);

        //Create a string "transactions" of the sharedPref item "myTransactions"
        String transactions = sharedPrefs.getString("myTransactions", new ArrayList<Transaction>().toString());

        //Convert the "transactions" string into an ArrayList<Transaction> called txList
        Gson gson = new Gson();
        TypeToken<ArrayList<Transaction>> txArrayList = new TypeToken<ArrayList<Transaction>>(){};
        ArrayList<Transaction> txList = gson.fromJson(transactions, txArrayList.getType());

        //Use txList in TransactionListAdapter
        TransactionListAdapter transactionListAdapter = new TransactionListAdapter(this, txList);

        ListView listView = (ListView) findViewById(R.id.txlist);
        listView.setAdapter(transactionListAdapter);
    }

    public void getTx(View listItem) {
        Transaction tx = (Transaction) listItem.getTag();
        Log.d(getClass().toString(), tx.getCurrency().getName().toString());

        Intent intent = new Intent(this, TransactionDetailActivity.class);
        intent.putExtra("tx", tx);
        startActivity(intent);
    }
}
