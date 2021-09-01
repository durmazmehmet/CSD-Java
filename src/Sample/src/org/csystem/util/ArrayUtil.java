/*----------------------------------------------------------------------------------------------------------------------
    ArrayUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;

public final class ArrayUtil {
    private ArrayUtil() {}

    public static int[][] addMatrices(int [][] a, int [][] b)
    {
        if (!isMatrix(a) || !isMatrix(b) || a.length != b.length || a[0].length != b[0].length)
            throw new IllegalArgumentException("Geçersiz matris(ler)");


        int row = a.length;
        int col = a[0].length;
        int [][] m = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                m[i][j] = a[i][j] + b[i][j];

        return m;
    }

    public static double average(int [] a)
    {
        return (double)sum(a) / a.length;
    }

    public static int [] copy(int [] src, int[]dest)
    {
        return copy(src, dest, src.length);
    }

    public static int [] copy(int [] src, int[]dest, int size)
    {
        for (int i = 0; i < size; ++i)
            dest[i] = src[i];

        return dest;
    }

    public static int copyIfLengthGreater(String [] src, String [] dest, int val)
    {
        int index = 0;

        for (String s : src)
            if (s.length() > val)
                dest[index++] = s;

        return index;
    }

    public static void display(int [] a)
    {
        display(a, 1);
    }

    public static void display(int [] a, int n)
    {
        display(a, n, true);
    }

    public static void display(int [] a, int n, boolean putZero)
    {
        String fmt = putZero ? String.format("%%0%dd ", n) : String.format("%%%dd ", n);

        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(String [] str)
    {
        display(str, str.length);
    }

    public static void display(String [] str, int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.println(str[i]);
    }

    public static void display(int [][] a)
    {
        display(a, 1);
    }

    public static void display(int [][] a, int n)
    {
        display(a, n, true);
    }

    public static void display(int [][] a, int n, boolean putZero)
    {
        for (int [] array : a)
            display(array, n, putZero);
    }

    public static void drawHistogram(int [] h, int n, char ch)
    {
        int maxVal = max(h);

        for (int val : h) {
            int count = Math.round(val * n / maxVal);

            while (count -- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int [] getHistogramData(int [] a, int n) //[0, n]
    {
        int [] hist = new int[n + 1];

        for (int val : a)
            ++hist[val];

        return hist;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }


    public static int [] getRandomArray(Random r, int n, int min, int max) //[min, max)
    {
        int [] a = new int[n];

        for (int i = 0; i < n; ++i)
            a[i] = r.nextInt(max - min) + min;

        return a;
    }

    public static int[][] getRandomMatrix(int m, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(new Random(), m, n, min, max);
    }

    public static int[][] getRandomMatrix(Random r, int m, int n, int min, int max) //[min, max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int[][] getRandomSquareMatrix(int n, int min, int max) //[min, max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }

    public static int[][] getRandomSquareMatrix(Random r, int n, int min, int max) //[min, max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static boolean isEmpty(int [] a)
    {
        return a.length == 0;
    }


    public static boolean isMatrix(int [][] a)
    {
        int col = a[0].length;

        for (int i = 1; i < a.length; ++i)
            if (a[i].length != col)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static String join(String [] s, char delim)
    {
        return join(s, delim + "");
    }

    public static String join(String [] s, String delim)
    {
        String str = "";

        for (String elem : s)
            str += elem + delim;

        return str.substring(0, str.length() - delim.length());
    }

    public static String join(ArrayList list, char delim)
    {
        return join(list, delim + "");
    }

    public static String join(ArrayList list, String delim)
    {
        String str = "";

        for (Object o : list)
            str += o + delim;

        return str.substring(0, str.length() - delim.length());
    }

    public static int max(int [] a)
    {
        int maxVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (maxVal < a[i])
                maxVal = a[i];

        return maxVal;
    }

    public static int max(int [][] a)
    {
        int maxVal = Integer.MIN_VALUE;

        for (int [] array : a)
            for (int val : array)
                if (maxVal < val)
                    maxVal = val;

        return maxVal;
    }

    public static int min(int [] a)
    {
        int minVal = a[0];

        for (int i = 1; i < a.length; ++i)
            if (minVal > a[i])
                minVal = a[i];

        return minVal;
    }

    public static int min(int [][] a)
    {
        int minVal = Integer.MAX_VALUE;

        for (int [] array : a)
            for (int val : array)
                if (minVal > val)
                    minVal = val;

        return minVal;
    }

    public static char [] reverse(char [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i) {
            char temp = a[i];

            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return a;
    }

    public static int[] resizeActual(int [] a, int size)
    {
        if (size == a.length)
            return a;

        if (size < a.length)
            return copy(a, new int[size], size);

        return copy(a, new int[size]);
    }

    public static int[] resize(int [] a, int size)
    {
        if (size <= a.length)
            return a;

        return copy(a, new int[size]);
    }

    public static int [] reverse(int [] a)
    {
        int halfLen = a.length / 2;

        for (int i = 0; i < halfLen; ++i) {
            int temp = a[i];

            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return a;
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        if (!isSquareMatrix(a))
            throw new IllegalArgumentException("Kare matris gereklidir");

        int total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static int [][] transpose(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
