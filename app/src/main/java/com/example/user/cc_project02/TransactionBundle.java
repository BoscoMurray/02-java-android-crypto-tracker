package com.example.user.cc_project02;

import java.util.ArrayList;

import enums.CurrencyName;
import enums.TransactionType;

/**
 * Created by user on 09/07/2017.
 */

public class TransactionBundle {

    private ArrayList<Transaction> txList;
    private static ArrayList<Currency> currencies;

    public TransactionBundle() {
        txList = new ArrayList<>();
        currencies = new ArrayList<>();

        Currency bitcoin = new Currency(CurrencyName.BITCOIN, "bitcoin", 2500);
        Currency monero = new Currency(CurrencyName.MONERO, "monero", 50);
        Currency litecoin = new Currency(CurrencyName.LITECOIN, "litecoin", 25);
        Currency ethereum = new Currency(CurrencyName.ETHEREUM, "ethereum", 250);
        Currency nem = new Currency(CurrencyName.MAIDSAFE, "nem", 10);
        Currency ripple = new Currency(CurrencyName.RIPPLE, "ripple", 20);
        Currency ubiq = new Currency(CurrencyName.UBIQ, "ubiq", 15);


        currencies.add(bitcoin);
        currencies.add(monero);
        currencies.add(litecoin);
        currencies.add(ethereum);
        currencies.add(nem);
        currencies.add(ripple);
        currencies.add(ubiq);

        txList.add(new Transaction("20170526", TransactionType.BUY, bitcoin, 2));
        txList.add(new Transaction("20170528", TransactionType.BUY, monero, 500));
        txList.add(new Transaction("20170601", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170604", TransactionType.BUY, litecoin, 10));
        txList.add(new Transaction("20170610", TransactionType.BUY, ethereum, 2));
        txList.add(new Transaction("20170612", TransactionType.BUY, nem, 15));
        txList.add(new Transaction("20170614", TransactionType.BUY, monero, 100));
        txList.add(new Transaction("20170701", TransactionType.BUY, ubiq, 10));
        txList.add(new Transaction("20170701", TransactionType.BUY, ripple, 500));
        txList.add(new Transaction("20170701", TransactionType.SELL, bitcoin, 1));
        txList.add(new Transaction("20170701", TransactionType.SELL, monero, 10));
        txList.add(new Transaction("20170701", TransactionType.SELL, nem, 10));
    }

    public static Currency getCurrencyBasedOnCurrencyName(CurrencyName curName) {

        for(Currency cur : currencies) {
            if(cur.getName() == curName) {
                return cur;
            }
        }

        return null;
    }

    public ArrayList<Transaction> getList() {
        return new ArrayList<>(txList);
    }

}
