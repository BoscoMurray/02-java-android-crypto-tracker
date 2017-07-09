package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import enums.CurrencyName;
import enums.CurrencyType;
import enums.TransactionType;
import static org.junit.Assert.*;

/**
 * Created by user on 08/07/2017.
 */

public class TransactionTest {

    private Currency bitcoin;
    private Currency euro;
    private Transaction txBuy01;
    private Transaction txBuy02;
    private Transaction txSell01;

    @Before
    public void before() {
        bitcoin = new Currency(CurrencyType.CRYPTO, CurrencyName.BITCOIN, "R.drawable.bitcoin", 1000);
        euro = new Currency(CurrencyType.FIAT, CurrencyName.EURO, "R.drawable.euro", 2);
        txBuy01 = new Transaction("20170626", TransactionType.BUY, bitcoin, 2);
        txBuy02 = new Transaction("20170628", TransactionType.BUY, euro, 500);
        txSell01 = new Transaction("20170701", TransactionType.SELL, euro, 500);
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
        assertEquals(2, txBuy01.getTxQuantity());
    }

    @Test
    public void canGetTxPrice() {
        assertNotNull(txBuy01.getTxPrice());
    }

    @Test
    public void canSetTxPrice() {
        txBuy01.setTxPrice(500);
        assertEquals(500, txBuy01.getTxPrice());
    }

    @Test
    public void canGetTxTotal() {
        txBuy01.setTxPrice(500);
        assertEquals(1000, txBuy01.getTxTotal());
    }
}
