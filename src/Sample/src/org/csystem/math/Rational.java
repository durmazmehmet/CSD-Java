package org.csystem.math;

public class Rational {
    private int m_a, m_b;

    private static Rational add(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * b2 + a2 * b1, b1 * b2);
    }

    private static Rational sub(int a1, int b1, int a2, int b2)
    {
        return add(a1, b1, -a2, b2);
    }

    private static Rational mul(int a1, int b1, int a2, int b2)
    {
        return new Rational(a1 * a2, b1 * b2);
    }

    private static Rational div(int a1, int b1, int a2, int b2)
    {
        return mul(a1, b1, b2, a2);
    }

    private static void control(int a, int b)
    {
        if (b == 0) {
            if (a == 0)
                throw new RationalException("Indefinite", RationalExceptionStatus.INDEFINITE);

            throw new RationalException("Undefined", RationalExceptionStatus.UNDEFINED);
        }
    }

    private void simplify()
    {
        int min = Math.min(Math.abs(m_a), m_b);

        for (int i = min; i >= 2; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void calibrateSign()
    {
        if (m_b < 0) {
            m_a *= -1;
            m_b *= -1;
        }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }

        m_a = a;
        m_b = b;

        this.calibrateSign();
        this.simplify();
    }

    public Rational()
    {
        m_b = 1;
    }

    public Rational(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Rational(int a, int b)
    {
        control(a, b);
        set(a, b);
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int a)
    {
        if (a == m_a)
            return;
        this.set(a, m_b);
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int b)
    {
        if (b == m_b)
            return;

        control(m_a, b);
        this.set(m_a, b);
    }

    public double getRealValue()
    {
        return (double) m_a / m_b;
    }

    //add methods
    public static Rational add(int val, Rational r)
    {
        return add(val, 1, r.m_a, r.m_b);
    }

    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    //sub methods
    public static Rational sub(int val, Rational r)
    {
        return sub(val, 1, r.m_a, r.m_b);
    }

    public Rational sub(Rational r)
    {
        return sub(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational sub(int val)
    {
        return sub(m_a, m_b, val, 1);
    }

    //mul methods
    public static Rational mul(int val, Rational r)
    {
        return mul(val, 1, r.m_a, r.m_b);
    }

    public Rational mul(Rational r)
    {
        return mul(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational mul(int val)
    {
        return mul(m_a, m_b, val, 1);
    }


    //div methods
    public static Rational div(int val, Rational r)
    {
        return div(val, 1, r.m_a, r.m_b);
    }

    public Rational div(Rational r)
    {
        return div(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational div(int val)
    {
        return div(m_a, m_b, val, 1);
    }

    //inc method
    public void inc()
    {
        m_a += m_b;
    }

    //dec method
    public void dec()
    {
        m_a -= m_b;
    }

    public String toString()
    {
        return String.format("%d / %d = %f", m_a, m_b, this.getRealValue());
    }
}
