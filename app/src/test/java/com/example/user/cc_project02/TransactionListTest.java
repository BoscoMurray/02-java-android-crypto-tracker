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
        txList = new TransactionList();
        txBuy01 = new Transaction("20170526", TransactionType.BUY, bitcoin, 2);
        txBuy02 = new Transaction("20170528", TransactionType.BUY, monero, 500);
        txSell01 = new Transaction("20170701", TransactionType.SELL, monero, -10);
        txList.addTx(txBuy01);
    }

    @Test
    public void canGetTxList() {
        assertEquals(1, txList.getTxList().size());
    }

    @Test
    public void canGetTxByIndex() {
        txList.addTx(txBuy02);
        assertEquals(monero, txList.getTxByIndex(1).getCurrency());
    }

    @Test
    public void canGetSumOfTxs() {
        txList = new TransactionList();
        txBuy01.setTxPrice(1000);
        txSell01.setTxPrice(55);
        txList.addTx(txBuy01);
        txList.addTx(txSell01);
        assertEquals((Integer) 1450, txList.getSumOfTxs());
    }


}
