package com.example.user.cc_project02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 10/07/2017.
 */

public class MainActivityAdapter extends ArrayAdapter<Transaction> {

    Context context;

    public MainActivityAdapter(Context context, ArrayList<Transaction> txList) {
        super(context, 0, txList);
        this.context = context;
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.transaction_item, parent, false);
        }

        Transaction currentTx = getItem(position);

        TextView currency = listItemView.findViewById(R.id.currency);
        currency.setText(currentTx.getCurrency().getName().toString());

        int drawableResourceId = context.getResources().getIdentifier(currentTx.getCurrency().getImage(), "drawable", context.getPackageName());

        ImageView image = listItemView.findViewById(R.id.imageView);
        image.setImageResource(drawableResourceId);

        TextView quantity = listItemView.findViewById(R.id.quantity);
        quantity.setText(currentTx.getTxQuantity().toString());

        TextView sum = listItemView.findViewById(R.id.sum);
        sum.setText(currentTx.getTxSum().toString());

        listItemView.setTag(currentTx);

        return listItemView;
    }



}
