package com.example.user.cc_project02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 09/07/2017.
 */

public class TransactionBundleTest {
    @Test
    public void getListTest() {
        TransactionBundle txBundle = new TransactionBundle();
        assertEquals(11, txBundle.getList().size());
    }
}
