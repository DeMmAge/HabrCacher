package com.demmage.habr;

import java.util.Calendar;

public class Main {

    private static void log(String s) {
        System.out.println(s + " " + Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        HabrCacher cacher = new HabrCacher();
        for (int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i++) {
            if (cacher.cache(i)) {
                log("Cached " + i);
            } else {
                log("Forbidden " + i);
            }
        }
    }
}
