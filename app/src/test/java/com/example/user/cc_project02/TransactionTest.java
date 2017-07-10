package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import enums.CurrencyName;
import enums.TransactionType;
import static org.junit.Assert.*;

/**
 * Created by user on 08/07/2017.
 */

public class TransactionTest {

    private Currency bitcoin;
    private Currency monero;
    private Transaction txBuy01;
    private Transaction txBuy02;
    private Transaction txSell01;

    @Before
    public void before() {
        bitcoin = new Currency(CurrencyName.BITCOIN, "bitcoin", 1000);
        monero = new Currency(CurrencyName.MONERO, "monero", 50);
        txBuy01 = new Transaction("20170626", TransactionType.BUY, bitcoin, 2);
        txBuy02 = new Transaction("20170628", TransactionType.BUY, monero, 100);
        txSell01 = new Transaction("20170701", TransactionType.SELL, monero, -10);
    }

    @Test
    public void canGetTxDate() {
        assertEquals("20170626", txBuy01.getTxDate());
    }

    @Test
    public void canGetTxType() {
        assertEquals(TransactionType.BUY, txBuy01.getTxType());
    }

    @Test
    public void canGetCurrency() {
        assertEquals(bitcoin, txBuy01.getCurrency());
    }

    @Test
    public void canGetTxQuantity() {
        assertEquals((Integer) 2, txBuy01.getTxQuantity());
    }

    @Test
    public void canGetTxPrice() {
        assertNotNull(txBuy01.getTxPrice());
    }

    @Test
    public void canSetTxPrice() {
        txBuy01.setTxPrice(500);
        assertEquals((Integer) 500, txBuy01.getTxPrice());
    }

    @Test
    public void canGetTxSum() {
        txBuy01.setTxPrice(500);
        assertEquals((Integer) 1000, txBuy01.getTxSum());
    }

    @Test
    public void canGetSumOfTxs() {
        ArrayList<Transaction> arrayTxs = new ArrayList<>();
        txBuy01.setTxPrice(1000);
        txSell01.setTxPrice(55);
        arrayTxs.add(txBuy01);
        arrayTxs.add(txSell01);
        assertEquals((Integer) 1450, txBuy01.getSumOfTxs(arrayTxs));
    }
}
