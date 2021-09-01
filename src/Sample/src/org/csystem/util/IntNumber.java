package org.csystem.util;

public class IntNumber {
    private final int m_val;
    private static final IntNumber [] CACHE = new IntNumber[256]; //[-128, 127]

    private IntNumber(int val)
    {
        m_val = val;
    }

    public static IntNumber valueOf(int val)
    {
        if (val < -128 || val > 127)
            return new IntNumber(val);

        if (CACHE[val + 128] == null)
            CACHE[val + 128] = new IntNumber(val);

        return CACHE[val + 128];
    }

    public int getVal() {return m_val;}

    public String toString()
    {
        return m_val + "";
    }
}
