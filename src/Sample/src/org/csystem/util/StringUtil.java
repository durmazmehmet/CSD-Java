/*----------------------------------------------------------------------------------------------------------------------
    StringUtil sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.util;

import java.util.Random;

public final class StringUtil {
	private static char getRandomChar(Random r, String s)
	{
		return s.charAt(r.nextInt(s.length()));
	}

	private StringUtil() {}

	public static int getCount(String s1, String s2)
	{
		int count = 0;		
		int index = 0;
		
		while ((index = s1.indexOf(s2, index)) != -1) {
			++count;
			++index;
		}
		
		return count;
	}

	public static String getLetters(String s)
	{
		String str = "";
		int len = s.length();
		
		for (int i = 0; i < len; ++i) {
			char ch = s.charAt(i);
			
			if (Character.isLetter(ch))
				str += ch;
		}
		
		return str;
	}

	public static String getRandomString(int n, String str)
	{
		return getRandomString(new Random(), n, str);
	}

	public static String getRandomString(Random r, int n, String str)
	{
		char [] c = new char[n];

		for (int i = 0; i < n; ++i)
			c[i] = getRandomChar(r, str);

		return new String(c);
	}

	public static String getRandomStringTR(int n)
	{
		return getRandomStringTR(new Random(), n);
	}

	public static String getRandomStringTR(Random r, int n)
	{
		String alphabet = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz";

		return getRandomString(r, n, alphabet);
	}

	public static boolean isPalindirome(String s)
	{
		String str = getLetters(s);
		
		int halfLen = str.length() / 2;
		int len = str.length();
		
		for (int i = 0; i < halfLen; ++i) {
			char chLeft = Character.toLowerCase(str.charAt(i));
			char chRight = Character.toLowerCase(str.charAt(len - 1 - i));
			
			if (chLeft != chRight)
				return false;
		}
		
		return true;
	}
	
	public static boolean isPangramEN(String str)
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		return isPangram(str.toLowerCase(), alphabet);
	}
	
	public static boolean isPangramTR(String str)
	{
		String alphabet = "abcçdefgğhıijklmnoöprsştuüvyz";		
		
		return isPangram(str.toLowerCase(), alphabet);
	}
	
	public static boolean isPangram(String str, String alphabet)
	{
		int len = alphabet.length();
		
		for (int i = 0; i < len; ++i) {
			char ch = alphabet.charAt(i);
			
			if (!str.contains(ch + ""))
				return false;			
		}
		
		return true;
	}
	
	public static String padLeft(String s, int len, char ch)
	{
		int sLen = s.length();
		
		if (len <= sLen)
			return s;
		
		return repeat(len - sLen, ch) + s;
		
	}
	
	public static String padLeft(String s, int len)
	{
		return padLeft(s, len, ' ');
	}
	
	public static String padRight(String s, int len, char ch)
	{
		int sLen = s.length();
		
		if (len <= sLen)
			return s;
		
		return s + repeat(len - sLen, ch);		
		
	}
	
	public static String padRight(String s, int len)
	{
		return padRight(s, len, ' ');
	}

	public static String removeWhitespaces(String s)
	{
		String str = "";
		
		int len = s.length();
		
		for (int i = 0; i < len; ++i) {
			char ch = s.charAt(i);
			
			if (!Character.isWhitespace(ch))
				str += ch;
		}
		
		return str;
	}
	
	public static String repeat(int n, char ch)
	{
		return repeat(n, ch + "");	
	}
	
	public static String repeat(int n, String s)
	{
		int len = s.length();
		char [] c = new char[n * len];

		for (int i = 0; i < c.length; i += len) {
			for (int k = 0; k < len; ++k)
				c[i + k] = s.charAt(k);
		}

		return new String(c);
	}
	
	public static String reverse(String s)
	{
		return new String(ArrayUtil.reverse(s.toCharArray()));
	}

	public static String [] split(String str, String delim, StringSplitOptions options)
	{
		String regex = "[";

		int delimLen = delim.length();

		for (int i = 0; i < delimLen; ++i) {
			char ch = delim.charAt(i);

			regex += ch == ']' || ch == '[' ? "\\" + ch : ch;
		}

		regex += ']';
		if (StringSplitOptions.REMOVE_EMPTY_ENTRIES == options)
			regex += '+';

		return str.split(regex);
	}

	public static String toUpper(String str)
	{
		return str.toUpperCase();
	}

	public static String trimLeft(String s)
	{
		int i = 0;
		int len = s.length();
		
		for (; i < len && Character.isWhitespace(s.charAt(i)); ++i)
			;
		
		return s.substring(i);		
	}
	
	public static String trimRight(String s)
	{
		int i = s.length() - 1;
		
		for (; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
			;
		
		return s.substring(0, i + 1);
	}
	
}
	