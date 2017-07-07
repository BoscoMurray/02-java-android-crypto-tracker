package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 07/07/2017.
 */

public class FIATTest {

    FIAT fiat;

    @Before
    public void before() {
        fiat = new FIAT(CurrencyType.DOLLAR, "R.drawable.dollar");
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
    public void canGetPrice() {
        assertEquals(10, fiat.getPrice());
    }
}
