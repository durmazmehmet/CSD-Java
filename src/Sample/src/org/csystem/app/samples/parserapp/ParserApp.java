package org.csystem.app.samples.parserapp;

import java.util.Scanner;

public class ParserApp {
    private ParserApp()
    {}
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Parser parser = new Parser();
        SourceFactory sourceFactory = new SourceFactory();

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String str = kb.nextLine();

            if ("quit".equals(str))
                break;

            parser.setSource(sourceFactory.getRandomSource(str));
            parser.doParse();
        }
    }
}
