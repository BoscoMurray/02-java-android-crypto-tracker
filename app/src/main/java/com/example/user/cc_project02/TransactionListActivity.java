package com.example.user.cc_project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class TransactionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_list);

        TransactionBundle txBundle = new TransactionBundle();
        ArrayList<Transaction> txList = txBundle.getList();

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
