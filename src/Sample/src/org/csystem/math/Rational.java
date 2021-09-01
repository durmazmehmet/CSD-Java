/*----------------------------------------------------------------------------------------------------------------------
    Rational sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public final class Rational {
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
                throw new RationalException("Belirsiz", RationalExceptionStatus.INDEFINITE);

            throw new RationalException("Tanımsız", RationalExceptionStatus.UNDEFINED);
        }
    }

    private void calibrateSigns(int a, int b)
    {
        m_a = a;
        m_b = b;

        if (m_b < 0) {
            m_a = -m_a;
            m_b = -m_b;
        }
    }

    private void simplify()
    {
        int a = Math.abs(m_a);

        int min = a > m_b ? m_b : a;

        for (int i = min; i >= 2; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a /= i;
                m_b /= i;
                break;
            }
    }

    private void set(int a, int b)
    {
        if (a == 0) {
            m_a = 0;
            m_b = 1;
            return;
        }

        calibrateSigns(a, b);
        simplify();
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

    public int getNumerator() {return m_a;}
    public int getDenominator() {return m_b;}
    public double getRealValue() {return (double)m_a / m_b;}

    public void setNumerator(int a)
    {
        if (a == m_a)
            return;

        set(a, m_b);
    }

    public void setDenominator(int b)
    {
        if (b == m_b)
            return;

        control(m_a, b);
        set(m_a, b);
    }

    //add methods
    public Rational add(Rational r)
    {
        return add(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational add(int val)
    {
        return add(m_a, m_b, val, 1);
    }

    //sub methods
    public Rational sub(Rational r)
    {
        return sub(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational sub(int val)
    {
        return sub(m_a, m_b, val, 1);
    }

    //mul methods
    public Rational mul(Rational r)
    {
        return mul(m_a, m_b, r.m_a, r.m_b);
    }

    public Rational mul(int val)
    {
        return mul(m_a, m_b, val, 1);
    }

    //div methods
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
        inc(1);
    }

    public void inc(int val)
    {
        m_a += m_b * val;
        simplify();
    }

    //dec method
    public void dec()
    {
        dec(1);
    }

    public void dec(int val)
    {
        inc(-val);
    }


    public String toString()
    {
        return String.format("%d / %d = %f", m_a, m_b, getRealValue());
    }
}
