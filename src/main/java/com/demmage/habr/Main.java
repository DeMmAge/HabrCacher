package com.demmage.habr;

public class Main {

    public static void main(String[] args) {
        HabrCacher cacher = new HabrCacher();
        for (int i = 1; i <= 99999; i++) {
            if (cacher.checkPost(i)) {
                cacher.cache(i);
                System.out.println("Cached " + i);
            } else {
                System.out.println("Forbidden " + i);
            }
        }
    }
}
