package org.csystem.util;

public final class Triple <F, S, T> {
    private final F m_first;
    private final S m_second;
    private final T m_third;

    public static <F1, S1, T1> Triple<F1, S1, T1> create(F1 first, S1 second, T1 third)
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

