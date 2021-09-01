/*----------------------------------------------------------------------------------------------------------------------
	Triple sınıfı ve test kodu
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.Triple;

class App {
    public static void main(String [] args)
    {
        Triple<Integer, String, Boolean> t = Triple.create(10, "ankara", false);

        System.out.println(t);
    }
}