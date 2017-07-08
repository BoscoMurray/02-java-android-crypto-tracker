package com.example.user.cc_project02;

import java.util.HashMap;

import behaviours.Tradable;

/**
 * Created by user on 07/07/2017.
 */

public class Crypto extends Currency implements Tradable {

    private int basePrice;
    private Price price;

    public Crypto(CurrencyType currency, String image, int basePrice) {
        super(currency, image);
        this.basePrice = basePrice;
        createPriceList(basePrice);
    }

    private void createPriceList(int basePrice) {
        price = new Price(basePrice);
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Price getPrice() {
        return price;
    }

}