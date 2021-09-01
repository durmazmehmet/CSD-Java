/*----------------------------------------------------------------------------------------------------------------------
    Console sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Scanner;

public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }
    private Console() {}

    public static int readInt()
    {
        return readInt("");
    }

    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }
    public static int readInt(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);
                int val = Integer.parseInt(ms_kb.nextLine());

                return val;
            }
            catch (Throwable ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static int readIntLine(String msg)
    {
        return readIntLine(msg, "");
    }
    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }

    public static double readDouble()
    {
        return readDouble("");
    }

    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }
    public static double readDouble(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);
                double val = Double.parseDouble(ms_kb.nextLine());

                return val;
            }
            catch (Throwable ex) {
                System.out.print(errMsg);
            }
        }
    }

    public static double readDoubleLine(String msg)
    {
        return readDoubleLine(msg, "");
    }
    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }

    //////////////////////////////

    public static void writeLine()
    {
        writeLine("");
    }

    public static void write(String fmt, Object...args)
    {
        System.out.printf(fmt, args);
    }

    public static void writeLine(String fmt, Object...args)
    {
        write(fmt + "\n", args);
    }

}
