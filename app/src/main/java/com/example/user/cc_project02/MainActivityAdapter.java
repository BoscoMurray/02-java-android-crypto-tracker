package com.example.user.cc_project02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 10/07/2017.
 */

public class MainActivityAdapter extends ArrayAdapter<Transaction> {

    public MainActivityAdapter(Context context, ArrayList<Transaction> txList) {
        super(context, 0, txList);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.portfolio_item, parent, false);
        }

        Transaction currentTx = getItem(position);

        TextView currency = (TextView) listItemView.findViewById(R.id.currency);
        currency.setText(currentTx.getCurrency().getName().toString());

        TextView currency = (TextView) listItemView.findViewById(R.id.quantity);
        currency.setText(currentTx.getTxQuantity());

        TextView currency = (TextView) listItemView.findViewById(R.id.sum);
        currency.setText(currentTx.getTxSum());

        return listItemView;
    }



}
