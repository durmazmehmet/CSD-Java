package org.csystem.util;

public final class NumberUtil {
	private static int [] getDigits(long val, int n)
	{
		if (val == 0)
			return new int[] {0};

		val = Math.abs(val);

		int [] digits = new int[(int)Math.log10(val) / n + 1];
		int scale = (int)Math.pow(10, n);

		for (int i = digits.length  - 1; val != 0; digits[i] = (int)(val % scale), val /= scale, --i)
			;

		return digits;
	}

	private static String numToStr3DigitsTR(int val)
	{
		if (val == 0)
			return "sıfır";

		String [] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
		String [] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};

		String str = val >= 0 ? "" : "eksi";

		val = Math.abs(val);

		int a = val / 100;
		int b = val / 10 % 10;
		int c = val % 10;

		if (a != 0) {
			if (a != 1)
				str += ones[a];
			str += "yüz";
		}
		if (b != 0)
			str += tens[b];

		if (c != 0)
			str += ones[c];

		return str;
	}

	private static int getArmstrongSum(int val)
	{
		int n = getDigitsCount(val);
		int sum = 0;

		while (val != 0) {
			sum += pow(val % 10, n);
			val /= 10;
		}

		return sum;
	}

	private NumberUtil() {}
	
	public static int digitsSum(int val)
	{
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;			
			val /= 10;
		}
		
		return Math.abs(sum);		
	}

	public static int factorial(int n)
	{
		if (n < 0)
			return -1;
		
		int result = 1;		
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;
	}
	
	public static int [] getDigits(int val)
	{
		return getDigits((long)val);
	}

	public static int [] getDigitsInThrees(int val)
	{
		return getDigitsInThrees((long)val);
	}

	public static int [] getDigits(long val)
	{
		return getDigits(val, 1);
	}

	public static int [] getDigitsInThrees(long val)
	{
		return getDigits(val, 3);
	}
	
	public static int getDigitsCount(int val)
	{
		int count = 0;
		
		do {
			++count;
			val /= 10;
		} while (val != 0);
		
		return count;
		
	}

	public static int getFibonacciNumber(int n)
	{
		if (n < 1)
			return -1;

		if (n == 1)
			return 0;

		if (n == 2)
			return 1;

		int prev1 = 0, prev2 = 1, result = 0;

		for (int i = 2; i < n; ++i) {
			result = prev1 + prev2;
			prev1 = prev2;
			prev2 = result;
		}

		return result;
	}
	public static int getPrime(int n)
	{
		if (n <= 0)
			return -1;
		
		int count = 0;
		int val = 0;
		
		for (int i = 2; count < n; ++i)
			if (isPrime(i)) {
				++count;
				val = i;
			}		
		
		return val;				
	}

	public static int [] getPrimes(int n)
	{
		if (n <= 0)
			return new int[0];

		int count = 0;
		int val = 0;

		int [] a = new int[n];

		for (int i = 2; count < n; ++i)
			if (isPrime(i))
				a[count++] = i;

		return a;
	}
	
	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;
		
		return val == getArmstrongSum(val);		
	}
	
	public static boolean isEven(int val)
	{
		return val % 2 == 0;		
	}
	
	public static boolean isOdd(int val)
	{
		return !isEven(val);
	}
	
	public static boolean isPalindrome(int val)
	{
		return reverse(val) == val;		
	}
	
	public static boolean isPrime(int val)
	{
		if (val <= 1)
			return false;
		
		if (val % 2 == 0)
			return val == 2;
		
		if (val % 3 == 0)
			return val == 3;
		
		if (val % 5 == 0)
			return val == 5;
		
		if (val % 7 == 0)
			return val == 7;
		
		for (int i = 11; i * i <= val; i += 2)
			if (val % i == 0)
				return false;
		
		return true;
	}
	
	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
	
	public static int min(int a, int b)
	{
		return a > b ? b : a;
	}

	public static String numToStrTR(long val)
	{
		//...
		return numToStr3DigitsTR((int)val);
	}
	
	public static int pow(int a, int b)
	{
		b = Math.abs(b);
		
		int result = 1;
		
		for (int i = 0; i < b; ++i)
			result *= a;
		
		return result;
	}
	
	public static int reverse(int val)
	{
		int rev = 0;
		
		while (val != 0) {
			rev = rev * 10 + val % 10;
			val /= 10;
		}		
		
		return rev;
	}
}
