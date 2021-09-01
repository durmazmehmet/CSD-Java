package org.csystem.util;

import java.util.ArrayList;
import java.util.Random;

public final class ArrayUtil {
    private ArrayUtil() {}

    public static boolean canAdd(int [][] a, int [][] b)
    {
        return isMatrix(a) && isMatrix(b) && a.length == b.length && a[0].length == b[0].length;
    }

    public static double average(int [] a)
    {
        return (double)sum(a) / a.length;
    }

    public static void display(int [] a)
    {
        display(a, 1);
    }

    public static void display(int [] a, int n)
    {
        String fmt = String.format("%%0%dd ", n);
        for (int val : a)
            System.out.printf(fmt, val);

        System.out.println();
    }

    public static void display(char [] a)
    {
        for (char ch : a)
            System.out.println(ch);
    }

    public static void display(String [] s)
    {
       for (String str : s)
            System.out.println(str);
    }

    public static void display(int [][] a)
    {
        display(a, 1);
    }

    public static void display(int [][] a, int n)
    {
        for (int [] array : a)
            display(array, n);
    }

    public static void drawHistogram(int [] hist, int n, char ch)
    {
        int maxValue = max(hist);

        for (int val : hist) {
            int count =(int) Math.round(val * n / (double)maxValue);

            while (count-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int[] getHistogramArray(int [] a, int n) //[0, n]
    {
        int [] histArray = new int[n + 1];

        for (int val : a)
            ++histArray[val];

        return histArray;
    }

    public static int [] getRandomArray(int n, int min, int max) //[min, max)
    {
        return getRandomArray(new Random(), n, min, max);
    }
    public static int [] getRandomArray(Random r, int n, int min, int max)
    {
        if (r == null || n <= 0 || min >= max)
            throw new IllegalArgumentException("Invalid arguments");

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
        int [][] a = new int[m][n];

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                a[i][j] = r.nextInt(max - min) + min;

        return a;
    }


    public static int [][] getRandomSquareMatrix(int n, int min, int max)
    {
        return getRandomSquareMatrix(new Random(), n, min, max);
    }
    public static int [][] getRandomSquareMatrix(Random r, int n, int min, int max)
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
            if (col != a[i].length)
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
        if (list.isEmpty())
            return "";

        String str = "";

        for (Object o : list) {
            String s = (String)o;

            str += s + delim;
        }

        return str.substring(0, str.length() - delim.length());
    }

    public static char [] makeUpper(char [] chars)
    {
        int len = chars.length;

        for (int i = 0; i < len; ++i)
            chars[i] = Character.toUpperCase(chars[i]);

        return chars;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        int len = a.length;

        for (int i = 1; i < len; ++i)
            if (a[i] < result)
                result = a[i];

        return result;
    }

    public static int max(int [] a)
    {
        int result = a[0];

        int len = a.length;

        for (int i = 1; i < len; ++i)
            if (a[i] > result)
                result = a[i];

        return result;
    }

    public static int min(int [][] a)
    {
        int result = Integer.MAX_VALUE;

        for (int [] array : a) {
            int minVal = min(array);
            if (result > minVal)
                result = minVal;
        }

        return result;
    }

    public static int max(int [][] a)
    {
        int result = Integer.MIN_VALUE;

        for (int [] array : a) {
            int maxVal = max(array);
            if (result < maxVal)
                result = maxVal;
        }

        return result;
    }

    public static int [] resize(int [] a, int size)
    {
        if (size <= a.length)
            return a;

        int [] result = new int[size];

        for (int i = 0; i < a.length; ++i)
            result[i] = a[i];

        return result;
    }

    public static int [] reverse(int [] a)
    {
        int len = a.length;
        int halfLen = len / 2;

        for (int i = 0; i < halfLen; ++i) {
            int temp = a[i];

            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;
        }

        return a;
    }

    public static char [] reverse(char [] a)
    {
        int len = a.length;
        int halfLen = len / 2;

        for (int i = 0; i < halfLen; ++i) {
            char temp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;
        }

        return a;
    }

    public static int sum(int [] a)
    {
        int total = 0;
        int len = a.length;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sumDiagonal(int [][] a)
    {
        int sum = 0;
        for (int i = 0; i < a.length; ++i)
            sum += a[i][i];

        return sum;
    }

    public static int [][] sumMatrices(int [][] a, int [][] b)
    {
        if (!canAdd(a, b)) {
            System.out.println("Can not add matrices");
            System.exit(-1); //exception konusuna kadar sabredin
        }

        int row = a.length;
        int col = a[0].length;

        int [][] sum = new int[row][col];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                sum[i][j] = a[i][j] + b[i][j];

        return sum;
    }

    public static int [][] transpose(int [][] a)
    {
        int row = a.length;
        int col = a[0].length;
        int [][] t = new int[col][row];

        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                t[j][i] = a[i][j];

        return t;
    }
}
