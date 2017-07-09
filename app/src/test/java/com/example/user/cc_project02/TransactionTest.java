package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import enums.CurrencyType;
import enums.TransactionType;
import static org.junit.Assert.*;

/**
 * Created by user on 08/07/2017.
 */

public class TransactionTest {

    private Transaction txBuy01;
    private Transaction txBuy02;
    private Transaction txSell01;

    @Before
    public void before() {
        Crypto bitcoin = new Crypto(CurrencyType.BITCOIN, "R.drawable.bitcoin", 1000);
        FIAT euro = new FIAT(CurrencyType.EURO, "R.drawable.euro", 2);
        txBuy01 = new Transaction("20170626", TransactionType.BUY, bitcoin, 2);
        txBuy02 = new Transaction("20170628", TransactionType.BUY, euro, 500);
        txSell01 = new Transaction("20170701", TransactionType.SELL, euro, 500);
    }

    @Test
    public void canGetTxDate() {
        assertEquals("20170626", txBuy01.getTxDate());
    }


}
