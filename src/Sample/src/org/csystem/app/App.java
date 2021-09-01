/*----------------------------------------------------------------------------------------------------------------------
	CSDArrayList sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Console;

import java.util.Scanner;

class App {
    public static void main(String [] args)
    {
        Scanner kb = new Scanner(System.in);
        String s = "ankara";
        String k = kb.nextLine();

        System.out.println(s.hashCode());
        System.out.println(k.hashCode());
    }
}

