package com.example.user.cc_project02;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by user on 10/07/2017.
 */

public class TransactionList implements Serializable {

    private ArrayList<Transaction> txList;

    public TransactionList(ArrayList<Transaction> txArrayList) {

        this.txList = txArrayList;
    }

    public void addTx(Transaction tx) {
        this.txList.add(tx);
    }

    public ArrayList<Transaction> getTxList() {
        return this.txList;
    }

    public Transaction getTxByIndex(int index) {
        return this.txList.get(index);
    }

    public Integer getSumOfTxs() {
        int sum = 0;
        for(Transaction tx : this.txList) { sum += tx.getTxSum(); }
        return sum;
    }

}
