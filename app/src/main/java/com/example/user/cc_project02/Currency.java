package com.example.user.cc_project02;

import enums.CurrencyName;

/**
 * Created by user on 07/07/2017.
 */

public class Currency {

    private CurrencyName name;
    private String image;
    private int basePrice;
    private Price priceList;

    public Currency(CurrencyName name, String image, int basePrice) {
        this.name = name;
        this.image = image;
        this.basePrice = basePrice;
        createPriceList(basePrice);
    }

    public CurrencyName getName() {
        return this.name;
    }

    public String getImage() {
        return this.image;
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