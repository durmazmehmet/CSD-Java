package org.csystem.app.samples.objectgeneratorapp;

import org.csystem.util.IntNumber;
import org.csystem.util.datetime.Date;

import java.util.Random;

public class ObjectArrayGenerator {
    private Object [] m_objs;
    private Random m_random;
    private final static String [] NAMES = {
            "İsmail", "Ahmet", "Yağmur", "Umut", "Yasin", "İsmail", "Zozan", "Gülşah", "Tolga", "Barış", "Esma", "Kemal"
            , "Oğuz"
    };

    private void generate()
    {
        for (int i = 0; i < m_objs.length; ++i) {
            int val = m_random.nextInt(6);

            switch (val) {
                case 0:
                    m_objs[i] = NAMES[m_random.nextInt(NAMES.length)];
                    break;
                case 1:
                    m_objs[i] = Date.randomDate(m_random);
                    break;
                case 2:
                    m_objs[i] = IntNumber.valueOf(m_random.nextInt(100));
                    break;
                case 3:
                    m_objs[i] = m_random.nextDouble() * 100; //auto-boxing
                    break;
                case 4:
                    m_objs[i] = (char)('A' + m_random.nextInt(26)); //auto-boxing
                    break;
                case 5:
                    m_objs[i] = (char)('a' + m_random.nextInt(26)); //auto-boxing
                    break;
            }
        }
    }

    public ObjectArrayGenerator(int n)
    {
        m_objs = new Object[n];
        m_random = new Random();
    }

    public Object [] getObjs()
    {
        generate();
        return m_objs;
    }
}
