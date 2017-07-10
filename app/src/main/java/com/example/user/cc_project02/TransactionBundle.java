package com.example.user.cc_project02;

import java.util.ArrayList;

import enums.CurrencyName;
import enums.TransactionType;

/**
 * Created by user on 09/07/2017.
 */

public class TransactionBundle {

    private ArrayList<Transaction> txList;

    public TransactionBundle() {
        txList = new ArrayList<>();
        Currency bitcoin = new Currency(CurrencyName.BITCOIN, "bitcoin", 2500);
        Currency monero = new Currency(CurrencyName.MONERO, "monero", 50);
        Currency litecoin = new Currency(CurrencyName.LITECOIN, "litecoin", 25);
        Currency ethereum = new Currency(CurrencyName.ETHEREUM, "ethereum", 250);
        Currency nem = new Currency(CurrencyName.MAIDSAFE, "nem", 10);
        Currency ripple = new Currency(CurrencyName.RIPPLE, "ripple", 20);
        txList.add(new Transaction("20170526", TransactionType.BUY, bitcoin, 2));
        txList.add(new Transaction("20170528", TransactionType.BUY, monero, 500));
        txList.add(new Transaction("20170601", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170604", TransactionType.BUY, litecoin, 10));
        txList.add(new Transaction("20170610", TransactionType.BUY, ethereum, 2));
        txList.add(new Transaction("20170612", TransactionType.BUY, nem, 15));
        txList.add(new Transaction("20170614", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170701", TransactionType.BUY, ripple, 500));
        txList.add(new Transaction("20170701", TransactionType.SELL, bitcoin, 1));
        txList.add(new Transaction("20170701", TransactionType.SELL, monero, 10));
        txList.add(new Transaction("20170701", TransactionType.SELL, nem, 10));
    }

    public ArrayList<Transaction> getList() {
        return new ArrayList<>(txList);
    }

}
