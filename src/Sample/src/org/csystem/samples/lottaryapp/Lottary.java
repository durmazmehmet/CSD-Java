package org.csystem.samples.lottaryapp;

import java.util.Random;

public class Lottary {
    private Random m_rand;

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

    private int[] getNumbers()
    {
        int [] numbers = new int[6];
        boolean [] status;

        status = getStatus();

        int index = 0;

        for (int i = 1; i < 50; ++i)
            if (status[i])
                numbers[index++] = i;

        return numbers;
    }

    public Lottary()
    {
        m_rand = new Random();
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
