package com.example.user.cc_project02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TransactionBundle txBundle = new TransactionBundle();
        ArrayList<Transaction> txList = txBundle.getList();

        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter(this, txList);

        ListView listView = (ListView) findViewById(R.id.main);
        listView.setAdapter(mainActivityAdapter);

    }
}
