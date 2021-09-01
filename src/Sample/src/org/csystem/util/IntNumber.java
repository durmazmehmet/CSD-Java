/*----------------------------------------------------------------------------------------------------------------------
    IntNumber sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class IntNumber {
    private static final IntNumber [] CACHE = new IntNumber[256];
    private final int m_val;

    private IntNumber(int val)
    {
        m_val = val;
    }

    public static final IntNumber ONE = valueOf(1);
    public static final IntNumber ZERO = valueOf(0);

    public static IntNumber valueOf(int val)
    {
        if (val < -128 || val > 127)
            return new IntNumber(val);

        if (CACHE[val + 128] == null)
            CACHE[val + 128] = new IntNumber(val);

        return CACHE[val + 128];
    }

    public IntNumber add(int val)
    {
        return valueOf(m_val + val);
    }

    public IntNumber add(IntNumber n)
    {
        return add(n.m_val);
    }

    public IntNumber sub(int val)
    {
        return add(-val);
    }

    public IntNumber sub(IntNumber n)
    {
        return sub(n.m_val);
    }
    public int getVal() {return m_val;}

    public String toString()
    {
        return m_val + "";
    }
}
