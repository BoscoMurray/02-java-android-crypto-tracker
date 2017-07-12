package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import enums.CurrencyName;
import enums.TransactionType;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 10/07/2017.
 */

public class TransactionListTest {

    private Currency bitcoin;
    private Currency monero;
    private Transaction txBuy01;
    private Transaction txBuy02;
    private Transaction txSell01;
    private TransactionList txList;

    @Before
    public void before() {
        bitcoin = new Currency(CurrencyName.BITCOIN, "bitcoin", 2500);
        monero = new Currency(CurrencyName.MONERO, "monero", 50);
        ArrayList<Transaction> txArrayList = new ArrayList<>();
        txBuy01 = new Transaction("20170526", TransactionType.BUY, bitcoin, 2);
        txBuy02 = new Transaction("20170528", TransactionType.BUY, monero, 10);
        txSell01 = new Transaction("20170701", TransactionType.SELL, monero, 1);
        txBuy01.setTxPrice(2500);
        txBuy02.setTxPrice(50);
        txSell01.setTxPrice(50);
        txArrayList.add(txBuy01);
        txArrayList.add(txBuy02);
        txArrayList.add(txSell01);
        txList = new TransactionList(txArrayList);
    }

    @Test
    public void canGetTxList() {
        assertEquals(3, txList.getTxList().size());
    }

    @Test
    public void canGetTxByIndex() {
        assertEquals(monero, txList.getTxByIndex(1).getCurrency());
    }

    @Test
    public void canGetSumOfTxs() {
        assertEquals((Integer) 5450, txList.getSumOfTxs());
    }

    @Test
    public void canAddTx() {
        txList.addTx(txBuy01);
        assertEquals(4, txList.getTxList().size());
    }


}
