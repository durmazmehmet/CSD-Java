/*----------------------------------------------------------------------------------------------------------------------
    NumberUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

public final class NumberUtil {
	private static int [] getDigits(long val, int n)
	{
		val = Math.abs(val);
		int count = val == 0 ? 1 : (int)(Math.log10(val) / n + 1);
		int divisor = (int)Math.pow(10, n);
		int [] digits = new int[count];

		for (int i = count - 1; i >= 0; --i) {
			digits[i] = (int)(val % divisor);
			val /= divisor;
		}

		return digits;
	}

	private static String numToStrMax3DigitsTR(int n)
	{
		if (n == 0)
			return "sıfır";

		String [] ones = {"", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz"};
		String [] tens = {"", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan"};
		String str = n < 0 ? "eksi" : "";

		n = Math.abs(n);

		int a = n / 100;
		int b = n / 10 % 10;
		int c = n % 10;

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

	private NumberUtil() {}

	public static int factorial(int n) 
	{
		if (n < 0)
			return  -1;
		
		int result = 1;
		
		for (int i = 2; i <= n; ++i)
			result *= i;
		
		return result;		
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
		return val == 0 ? 1 : (int)(Math.log10(Math.abs(val)) + 1);
	}

	public static int getDigitsSum(int val) 
	{
		int sum = 0;
		
		while (val != 0) {
			sum += val % 10;
			val /= 10;
		}
		
		return Math.abs(sum);		
	}
	
	public static int getFibonacciNumber(int n)
	{
		if (n <= 0)
			return -1;
		
		if (n <= 2)
			return n - 1;
		
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
		
		int count = 0, val = 0;
		
		for (int i = 2; count < n; ++i)
			if (isPrime(i)) {
				++count;
				val = i;
			}
		
		return val;		
	}

	public static int [] getPrimes(int n)
	{
		int count = 0;
		int [] primes = new int[n];

		for (int i = 2; count < n; ++i)
			if (isPrime(i)) {
				primes[count] = i;
				++count;
			}

		return primes;
	}
	
	public static int getReverse(int val)
	{
		int rev = 0;
		
		while (val != 0) {
			rev = rev * 10 + val % 10;
			val /= 10;
		}
		
		return rev;
	}
	
	public static boolean isArmstrong(int val)
	{
		if (val < 0)
			return false;
		
		int n = getDigitsCount(val);		
		int temp = val;
		int sum = 0;
		
		while (temp != 0) {
			sum += pow(temp % 10, n);
			temp /= 10;
		}
		
		return sum == val;		
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
		return getReverse(val) == val;
	}
	
	public static boolean isPositive(int val)
	{
		return val > 0;
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
	
	public static int min(int a, int b, int c)
	{
		return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
	}

	public static int max(int a, int b, int c)
	{
		return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
	}

	public static String numToStrTR(long n)
	{
		//TODO:Homework
		return numToStrMax3DigitsTR((int)n);
	}
	
	public static int pow(int a, int b)
	{
		b = Math.abs(b);
		
		int result = 1;
		
		for (int i = 0; i < b; ++i)
			result *= a;
		
		return result;
	}
}
