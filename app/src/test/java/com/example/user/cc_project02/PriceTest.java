package com.example.user.cc_project02;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 07/07/2017.
 */

public class PriceTest {

    private Price moneroPrice;

    @Before
    public void before() {
        moneroPrice = new Price(100);
    }

    @Test
    public void canGetPriceList() {
        assertNotNull(moneroPrice.getPriceList().get("20170701"));
    }

    @Test
    public void canGetDate() {
        assertEquals("20170708", moneroPrice.getDate());
    }

    @Test
    public void canGetPriceByDate() {
        assertNotNull(moneroPrice.getPriceByDate("20170630"));
    }

}
