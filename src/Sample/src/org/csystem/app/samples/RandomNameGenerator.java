package org.csystem.app.samples;

import java.util.Random;

public class RandomNameGenerator {
    public static String [] getNames(int n)
    {
        String [] names = {"Oytun", "Yasin", "Umut", "Yağmur", "Sultan", "Zozan", "Fatma", "Kemal", "İsmail", "Oğuz"};

        Random r = new Random();

        String [] randomNames = new String[n];

        for (int i = 0; i < n; ++i)
            randomNames[i] = names[r.nextInt(names.length)];

        return randomNames;
    }
}
