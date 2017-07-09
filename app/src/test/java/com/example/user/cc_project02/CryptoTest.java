package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import enums.CurrencyType;

import static org.junit.Assert.*;

/**
 * Created by user on 07/07/2017.
 */

public class CryptoTest {

    Crypto crypto;

    @Before
    public void before() {
        crypto = new Crypto(CurrencyType.BITCOIN, "R.drawable.bitcoin", 100);
    }

    @Test
    public void canGetCurrency() {
        assertEquals(CurrencyType.BITCOIN, crypto.getCurrency());
    }

    @Test
    public void canGetImage() {
        assertEquals("R.drawable.bitcoin", crypto.getImage());
    }

    @Test
    public void canGetBasePrice() {
        assertEquals(100, crypto.getBasePrice());
    }

    @Test
    public void canGetPrice() {
        assertNotNull(crypto.getPriceList().getPriceByDate("20170704"));
    }

}
