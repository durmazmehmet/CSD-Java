package org.csystem.app.samples.addcomplex;

import org.csystem.math.Complex;

import java.util.Scanner;

public class ComplexAddApp {
    public Complex sum;

    public ComplexAddApp()
    {
        sum = new Complex();
    }

    public void run()
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Karmaşık sayıları girmeye başlayınız");

        for (;;) {
            System.out.print("Reel değeri giriniz:");
            double re = Double.parseDouble(kb.nextLine());

            if (re == 0)
                break;

            System.out.print("Sanal değeri giriniz:");
            double im = Double.parseDouble(kb.nextLine());

            sum = sum.add(new Complex(re, im));
        }
    }
}
