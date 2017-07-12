package com.example.user.cc_project02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TransactionDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_detail);

        Transaction tx = (Transaction) getIntent().getExtras().getSerializable("tx");

        TextView txDate = (TextView) findViewById(R.id.date_detail);
        txDate.setText(tx.getTxDate());

        TextView txType = (TextView) findViewById(R.id.txtype_detail);
        txType.setText(tx.getTxType().toString());

        TextView txCurrency =(TextView) findViewById(R.id.currency_detail);
        txCurrency.setText(tx.getCurrency().getName().toString());

        int drawableResourceId = getResources().getIdentifier(tx.getCurrency().getImage(), "drawable", getPackageName());

        ImageView txImage = (ImageView) findViewById(R.id.image_detail);
        txImage.setImageResource(drawableResourceId);

        TextView txQuantity = (TextView) findViewById(R.id.quantity_detail);
        txQuantity.setText(tx.getTxQuantity().toString());

        TextView txPrice = (TextView) findViewById(R.id.price_detail);
        txPrice.setText(tx.getTxPrice().toString());

        TextView txValue = (TextView) findViewById(R.id.value_detail);
        txValue.setText(tx.getTxSum().toString());

    }

    public void onNewTxButtonClicked(View button) {
        Log.d(getClass().toString(), "onNewTxButtonClicked was called");
        Intent intent = new Intent(this, TransactionNewActivity.class);
        startActivity(intent);
    }
    
}
