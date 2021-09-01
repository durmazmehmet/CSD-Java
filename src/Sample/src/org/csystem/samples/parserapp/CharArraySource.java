package org.csystem.samples.parserapp;

import java.util.Arrays;

public class CharArraySource implements ISource {
    private char [] m_chars;
    private int m_index;
    public CharArraySource(char [] chars)
    {
        m_chars = Arrays.copyOf(chars, chars.length);
    }

    public CharArraySource(String str)
    {
        this(str.toCharArray());
    }

    public int getChar()
    {
        return m_index == m_chars.length ? -1 : m_chars[m_index++];
    }
}
