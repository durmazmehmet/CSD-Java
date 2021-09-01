package org.csystem.app.samples.dategeneratorapp;

import org.csystem.util.datetime.Date;

import java.util.Scanner;

public class RandomDateGeneratorApp {
    private Date[] m_dates;

    private void displayDates()
    {
        for (Date d : m_dates)
            System.out.printf("%s %s%n", d.toLongDateStringTR(), d.isWeekend() ? "Hafta Sonu" : "Hafta içi");
    }

    private void generateDates(int n)
    {
        m_dates = new Date[n];

        while (n-- > 0)
            m_dates[n] = Date.randomDate();
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.print("Kaç tane tarih üretilsin?");
        int n = Integer.parseInt(kb.nextLine());

        generateDates(n);
        displayDates();
    }
}


