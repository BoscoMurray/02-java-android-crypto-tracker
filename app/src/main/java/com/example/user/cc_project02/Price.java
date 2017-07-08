package com.example.user.cc_project02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 07/07/2017.
 */

public class Price {

    private int basePrice;
    public HashMap<String, Integer> priceList;


    public Price(int basePrice) {
        this.basePrice = basePrice;
        createPriceList();
    }

    private void createPriceList() {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DATE, -30);
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DATE, +30);
        priceList = new HashMap<>();
        for (Calendar myDate = startDate; myDate.before(endDate); myDate.add(Calendar.DATE, +1)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String stringDate = sdf.format(new Date(myDate.getTimeInMillis()));
            Integer randomPrice = this.basePrice + this.getRandom();
            priceList.put(stringDate, randomPrice);
        }
    }

    public HashMap getPriceList() {
        return priceList;
    }

    public String getDate() {
        Calendar today  = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String result = sdf.format(new Date(today.getTimeInMillis()));
        return result;
    }

    public int getRandom() {
        Random rand = new Random();
        int randomNum = rand.nextInt((11 - 1) + 1) ;
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


    //    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
//
//    // Get a Date object from the date string
//    Date myDate = dateFormat.parse(dateString);
//
//// this calculation may skip a day (Standard-to-Daylight switch)...
////oneDayBefore = new Date(myDate.getTime() - (24 * 3600000));
//
//// if the Date->time xform always places the time as YYYYMMDD 00:00:00
////   this will be safer.
//        oneDayBefore = new Date(myDate.getTime() - 2);
//
//                String result = dateFormat.format(oneDayBefore);



    //for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
//        {
//        ...
//        }


//    public LocalDate getStartDate() {
//        LocalDate startDate = new LocalDate();
//        return startDate;
//    }

}

//    public static void findEvents(Map<Date, Event> dateEvents, Date targetDate) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        String target = dateFormat.format(targetDate);
//        for (Map.Entry<Date, Event> entry : dateEvents.entrySet()) {
//            if (dateFormat.format(entry.getKey()).equals(target)) {
//                System.out.println("Event " + entry.getValue() + " is on the specified date");
//            }
//        }
//    }

// HashMapDemo.java
//  import java.util.HashMap;
//
//public class HashMapDemo {
//    public static void main(String[] args) {
//        HashMap javaKnowledge = new HashMap();
//
//        javaKnowledge.put("John", "99%");
//        javaKnowledge.put("Ally", "101%");
//
//        System.out.println(javaKnowledge.get("John"));
//    }
//}


//    Calendar cal  = Calendar.getInstance();
////subtracting a day
//    cal.add(Calendar.DATE, -1);
//
//            SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
//            String result = s.format(new Date(cal.getTimeInMillis()));