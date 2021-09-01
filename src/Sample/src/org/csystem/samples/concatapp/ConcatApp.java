package org.csystem.samples.concatapp;

import org.csystem.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ConcatApp {
    private ArrayList m_list;
    private String m_exitStr;
    private String m_resultStr;
    private String m_delim;

    public ConcatApp(String exitStr, char delim)
    {
        this(exitStr, delim + "");
    }

    public ConcatApp(String exitStr, String delim)
    {
        m_list = new ArrayList();
        m_exitStr = exitStr;
        m_delim = delim;
        m_resultStr = "";
    }

    public String getResult() {return m_resultStr;}

    public void run()
    {
        Scanner kb = new Scanner(System.in);

        for (;;) {
            System.out.print("Bir yazı giriniz:");
            String s = kb.nextLine();

            if (s.equals(m_exitStr))
                break;

            m_list.add(s);
        }

        m_resultStr = ArrayUtil.join(m_list, m_delim);
    }
}

