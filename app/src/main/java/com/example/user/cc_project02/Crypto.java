package com.example.user.cc_project02;

import behaviours.Tradable;
import enums.CurrencyType;

/**
 * Created by user on 07/07/2017.
 */

public class Crypto extends Currency implements Tradable {

    private int basePrice;
    private Price priceList;

    public Crypto(CurrencyType currency, String image, int basePrice) {
        super(currency, image);
        this.basePrice = basePrice;
        createPriceList(basePrice);
    }

    private void createPriceList(int basePrice) {
        priceList = new Price(basePrice);
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Price getPriceList() {
        return priceList;
    }

}