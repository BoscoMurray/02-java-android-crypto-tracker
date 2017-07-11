package com.example.user.cc_project02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TransactionDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);
    }

    public void onNewTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onNewTxButtonClicked was called");
    }

    public void onListTxsButtonClicked(View button) {
        Log.d(getClass().toString(), "onListTxsButtonClicked was called");

        Intent intent = new Intent(this, TransactionListActivity.class);
        startActivity(intent);
    }
    
}
