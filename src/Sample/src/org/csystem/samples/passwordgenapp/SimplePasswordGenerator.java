package org.csystem.samples.passwordgenapp;

import org.csystem.util.StringUtil;

import java.util.Random;

public class SimplePasswordGenerator {
    private int m_min, m_max;
    private String[] m_passwords;

    private void generatePasswords(String [] passwords)
    {
        String chars =
                "ABCDEFGHIJKLMNOPQRSTUWXVYZabcdefghijklmnopqrstuwxvyz"
                        + "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZabcçdefgğhıijklmnoöprsştuüvyz"
                        + "0123456789_:-.";
        Random r = new Random();

        for (int i = 0; i < passwords.length; ++i) {
            int count = r.nextInt(m_max - m_min) + m_min;

            passwords[i] = StringUtil.getRandomString(r, count, chars);
        }
    }

    public String [] getPasswords() {return m_passwords;}
    public void run(int n, int minVal, int maxVal)
    {
        m_passwords = new String[n];

        m_min = minVal;
        m_max = maxVal;
        generatePasswords(m_passwords);
    }
}

