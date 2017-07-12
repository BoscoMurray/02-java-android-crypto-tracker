package com.example.user.cc_project02;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 07/07/2017.
 */

public class Price implements Serializable {

    private int basePrice;
    private HashMap<String, Integer> priceList;


    public Price(int basePrice) {
        this.basePrice = basePrice;
        createPriceList();
    }

    private void createPriceList() {
        Calendar today = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, -60);
        priceList = new HashMap<>();

        for (Calendar myDate = startDate; myDate.before(today); myDate.add(Calendar.DATE, +1)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateString = sdf.format(new Date(myDate.getTimeInMillis()));
            Integer randomPrice = this.basePrice + this.getRandom();
            priceList.put(dateString, randomPrice);
        }
    }

    public HashMap getPriceList() {
        return priceList;
    }

    public String getDate() {
        Calendar today = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String result = sdf.format(new Date(today.getTimeInMillis()));
        return result;
    }

    public int getRandom() {
        Random rand = new Random();
        int randomNum = rand.nextInt((11 - 1) + 1);
        return randomNum;
    }

    public Integer getPriceByDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar myDate = Calendar.getInstance();
        try {
            myDate.setTime(sdf.parse(dateString));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : this.priceList.entrySet()) {
            if (entry.getKey().equals(dateString)) {
                return entry.getValue();
            }
        }
        return null;
    }
}