package org.csystem.util;

public class Triple<F, S, T> {
    private F m_first;
    private S m_second;
    private T m_third;

    public static <F, S, T> Triple<F, S, T> create(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple(F first, S second, T third)
    {
        m_first = first;
        m_second = second;
        m_third = third;
    }

    public F getFirst()
    {
        return m_first;
    }

    public S getSecond()
    {
        return m_second;
    }

    public T getThird()
    {
        return m_third;
    }

    public String toString()
    {
        return String.format("(%s, %s, %s)", m_first, m_second, m_third);
    }
}
