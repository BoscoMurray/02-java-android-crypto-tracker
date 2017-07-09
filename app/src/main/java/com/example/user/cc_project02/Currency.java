package com.example.user.cc_project02;

import enums.CurrencyType;

/**
 * Created by user on 07/07/2017.
 */

public abstract class Currency {

    private CurrencyType currency;
    private String image;

    public Currency(CurrencyType currency, String image) {
        this.currency = currency;
        this.image = image;
    }

    public CurrencyType getCurrency() {
        return this.currency;
    }

    public String getImage() {
        return this.image;
    }

}