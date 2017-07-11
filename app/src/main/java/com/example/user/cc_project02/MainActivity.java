package com.example.user.cc_project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button newTxButton;
    Button listTxsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(getClass().toString(), "onCreate called");

        newTxButton = (Button) findViewById(R.id.newtx_button);
        listTxsButton = (Button) findViewById(R.id.listtxs_button);
    }
//        TransactionBundle txBundle = new TransactionBundle();
//        ArrayList<Transaction> txList = txBundle.getList();
//
//        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(this, txList);
//
//        ListView listView = (ListView) findViewById(R.id.main);
//        listView.setAdapter(mainActivityAdapter);
//
//    }

    public void onNewTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onNewTxButtonClicked was called");
    }

    public void onListTxsButtonClicked(View button) {
        Log.d(getClass().toString(), "onListTxsButtonClicked was called");

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }

//
//    public void getTx(View listItem) {
//        Transaction tx = (Transaction) listItem.getTag();
//        Log.d(getClass().toString(), tx.getCurrency().getName().toString());
//
//        Intent intent = new Intent(this, TransactionDetailActivity.class);
//        intent.putExtra("tx", tx);
//        startActivity(intent);
//
//    }
}
