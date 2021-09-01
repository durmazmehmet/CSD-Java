package org.csystem.samples.randomgenapp;

import java.util.Random;

public class RandomObjectsGenerator {
    private static final String [] ms_names = {
            "Berkan", "Ahmet", "Miray", "Baki", "Ezel", "Mehmet", "Tolga", "Rıza",
            "Özgün", "Sinem", "Meltem", "Akın", "Çağla", "Gizem", "Cem", "Oğuz"
        };

    private Object [] m_objs;
    private Random m_rand;

    private void setObject(int index)
    {
        int val = m_rand.nextInt(4);

        switch (val) {
            case 0:
                m_objs[index] = ms_names[m_rand.nextInt(ms_names.length)];
                break;
            case 1:
                m_objs[index] = m_rand.nextInt(100);
                break;
            case 2:
                m_objs[index] = m_rand.nextDouble() *  100;
                break;
            case 3:
                m_objs[index] = (char)(m_rand.nextInt(65536));
                break;

        }
    }

    public RandomObjectsGenerator(int n)
    {
        m_objs = new Object[n];
        m_rand = new Random();
    }

    public void run()
    {
        for (int i = 0; i < m_objs.length; ++i)
            setObject(i);
    }

    public Object [] getObjs() {return m_objs;}
}
