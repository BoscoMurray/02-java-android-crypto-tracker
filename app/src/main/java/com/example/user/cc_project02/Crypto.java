package com.example.user.cc_project02;
import behaviours.Tradable;

/**
 * Created by user on 07/07/2017.
 */

public class Crypto extends Currency implements Tradable {

    public Crypto(CurrencyType currency, String image) {
        super(currency, image);
    }

    @Override
    public int getPrice() {
        return 10;
    }
}
