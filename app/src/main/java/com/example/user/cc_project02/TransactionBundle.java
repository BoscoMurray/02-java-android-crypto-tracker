package com.example.user.cc_project02;

import java.util.ArrayList;

import enums.CurrencyName;
import enums.CurrencyType;
import enums.TransactionType;

/**
 * Created by user on 09/07/2017.
 */

public class TransactionBundle {

    private ArrayList<Transaction> txList;

    public TransactionBundle() {
        txList = new ArrayList<>();
        Currency bitcoin = new Currency(CurrencyName.BITCOIN, "R.drawable.bitcoin", 2500);
        Currency monero = new Currency(CurrencyName.MONERO, "R.drawable.monero", 50);
        Currency litecoin = new Currency(CurrencyName.LITECOIN, "R.drawable.litecoin", 25);
        Currency ethereum = new Currency(CurrencyName.ETHEREUM, "R.drawable.ethereum", 250);
        Currency maidsafe = new Currency(CurrencyName.MAIDSAFE, "R.drawable.euro", 2);
        Currency ubiq = new Currency(CurrencyName.UBIQ, "R.drawable.pound", 3);
        txList.add(new Transaction("20170526", TransactionType.BUY, bitcoin, 2));
        txList.add(new Transaction("20170528", TransactionType.BUY, monero, 500));
        txList.add(new Transaction("20170601", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170604", TransactionType.BUY, litecoin, 10));
        txList.add(new Transaction("20170610", TransactionType.BUY, ethereum, 2));
        txList.add(new Transaction("20170612", TransactionType.BUY, maidsafe, 15));
        txList.add(new Transaction("20170614", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170701", TransactionType.BUY, maidsafe, 500));
        txList.add(new Transaction("20170701", TransactionType.SELL, bitcoin, 1));
        txList.add(new Transaction("20170701", TransactionType.SELL, monero, 10));
        txList.add(new Transaction("20170701", TransactionType.SELL, litecoin, 10));
    }

    public ArrayList<Transaction> getList() {
        return new ArrayList<>(txList);
    }

}
