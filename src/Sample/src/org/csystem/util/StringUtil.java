package org.csystem.util;

import java.util.*;

public final class StringUtil {
	private StringUtil() {}
	public static String capitalize(String s)
	{
		if (s.isEmpty())
			return s;
		
		return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();		
	}

	public static String changeCase(String s)
	{
		char [] c = s.toCharArray();

		int len = c.length;

		for (int i = 0; i < len; ++i) {
			if (Character.isUpperCase(c[i]))
				c[i] = Character.toLowerCase(c[i]);
			else if (Character.isLowerCase(c[i]))
				c[i] = Character.toUpperCase(c[i]);
		}
		return new String(c);
	}
	
	public static int getCount(String s1, String s2)
	{
		int count = 0;
		
		int index = -1;
		
		for (;;) {
			index = s1.indexOf(s2, index + 1);
			
			if (index == -1)
				break;
			
			++count;			
		}		
		
		return count;
	}
	
	public static char getRandomChar(Random r, String text)
	{
		return text.charAt(r.nextInt(text.length()));
	}
	
	public static String getRandomText(int n)
	{
		return getRandomText(new Random(), n);		
	}

	public static String getRandomText(Random r, int n)
	{
		String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "abcçdefgğhıijklmnoöprsştuüvyzABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVXYZ"
				+ "0123456789"
				+ "_.;:?'";
		String str = "";
		
		while (n-- > 0)
			str += getRandomChar(r, text);		
		
		return str;		
	}
	
	public static boolean isBlank(String str)
	{
		return str.trim().isEmpty();
	}
	
	public static boolean isPalindrome(String str)
	{
		return reverse(str).equals(str);		
	}
	
	public static boolean isPalindromeSkipWS(String str)
	{
		str = removeWhitespaces(str);
		
		return reverse(str).equals(str);		
	}
	
	public static boolean isPangram(String str, String alphabet)
	{
		str = str.toLowerCase();
		int len = alphabet.length();
		
		for (int i = 0; i < len; ++i)
			if (str.indexOf(alphabet.charAt(i)) == -1)
				return false;
		
		return true;
	}
	
	public static boolean isPangramEN(String str)
	{
		return isPangram(str, "abcdefghijklmnopqrstuwxvyz");
	}
	
	public static boolean isPangramTR(String str)
	{
		return isPangram(str, "abcçdefgğhıijklmnoöprsştuüvyz");
	}

	public static String padLeft(String s, int len)
	{
		return padLeft(s, len, ' ');
	}

	public static String padLeft(String s, int len, char ch)
	{
		int length = s.length();
		
		if (len <= length)
			return s;
		
		return repeat(ch, len - length) + s;
	}
	
	public static String padRight(String s, int len)
	{
		return padRight(s, len, ' ');
	}
	
	public static String padRight(String s, int len, char ch)
	{
		int length = s.length();
		
		if (len <= length)
			return s;
		
		return s + repeat(ch, len - length);		
	}
	
	public static String removeStr(String str, String s)
	{
		return str.replace(s, "");
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
	
	public static String repeat(char ch, int n)
	{
		String str = "";
		
		for (int i = 0; i < n; ++i)
			str += ch;
		
		return str;
	}
	
	public static String reverse(String s)
	{
		return new String(ArrayUtil.reverse(s.toCharArray()));
	}
	
	public static String trimEnd(String s)
	{
		int i;
		
		for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
			;
		
		return s.substring(0, i + 1);
	}
	
	public static String trimStart(String s)
	{
		int i;
		int len = s.length();
		
		for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
			;
		
		return s.substring(i);
	}
}
