package com.example.user.cc_project02;

import behaviours.Tradable;

/**
 * Created by user on 07/07/2017.
 */

public class FIAT extends Currency implements Tradable {

    private int basePrice;
    private Price price;

    public FIAT(CurrencyType currency, String image,int basePrice) {
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