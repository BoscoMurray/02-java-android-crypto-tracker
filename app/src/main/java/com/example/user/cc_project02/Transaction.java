package com.example.user.cc_project02;

import java.text.SimpleDateFormat;

import enums.TransactionType;

/**
 * Created by user on 08/07/2017.
 */

public class Transaction {

    private String dateString;
    private TransactionType txType;
    private Currency currency;
    private int quantity;

    public Transaction(String dateString, TransactionType txType, Currency currency, int quantity) {
        this.dateString = dateString;
        this.txType = txType;
        this.currency = currency;
        this.quantity = quantity;
    }

    public String getTxDate() {
        return this.dateString;
    }


}
