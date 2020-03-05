package com.demmage.habr;

import com.demmage.habr.dao.postgres.backup.Backupper;

import java.util.Calendar;

public class Main {

    private static Thread backup = new Thread(Main::backup);

    private static void log(String s) {
        System.out.println(s + " " + Calendar.getInstance().getTime());
    }

    private static void backup() {
        Backupper backupper = new Backupper();
        while (true) {
            log(backupper.backup() ? "Backed up" : "Error during backing up");
            try {
                Thread.sleep(900_000); // 15 mins
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HabrCacher cacher = new HabrCacher();
        backup.start();
        for (int i = Integer.parseInt(args[0]); i <= Integer.parseInt(args[1]); i++) {
            if (cacher.checkPost(i)) {
                cacher.cache(i);
                log("Cached " + i);
            } else {
                log("Forbidden " + i);
            }
        }
    }
}
