package org.csystem.app.samples.lottaryapp;

import java.util.Random;

public class Lottary {
    private Random m_rand;

    private int [] getColumn()
    {
        int [] column = new int[6];
        boolean [] status = getStatus();

        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (status[i])
                column[index++] = i;

        return column;
    }

    private boolean [] getStatus()
    {
        boolean [] status = new boolean[50];
        int val;

        for (int i = 0; i < 6; ++i) {
            for (;;) {
                val = m_rand.nextInt(49) + 1;
                if (!status[val])
                    break;
            }
            status[val] = true;
        }
        return status;
    }

    public Lottary()
    {
        m_rand = new Random();
    }


    public int [][] getColumns(int n)
    {
        int [][] c = new int[n][];

        for (int i = 0; i < n; ++i)
            c[i] = getColumn();

        return c;
    }
}
