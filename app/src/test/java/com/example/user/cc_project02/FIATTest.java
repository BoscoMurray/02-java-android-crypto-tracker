package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 07/07/2017.
 */

public class FIATTest {

    FIAT fiat;

    @Before
    public void before() {
        fiat = new FIAT(CurrencyType.DOLLAR, "R.drawable.dollar", 50);
    }

    @Test
    public void canGetCurrency() {
        assertEquals(CurrencyType.DOLLAR, fiat.getCurrency());
    }

    @Test
    public void canGetImage() {
        assertEquals("R.drawable.dollar", fiat.getImage());
    }

    @Test
    public void canGetBasePrice() {
        assertEquals(50, fiat.getBasePrice());
    }

    @Test
    public void canGetPrice() {
        assertNotNull(fiat.getPrice().getPriceByDate("20170704"));
    }
}
