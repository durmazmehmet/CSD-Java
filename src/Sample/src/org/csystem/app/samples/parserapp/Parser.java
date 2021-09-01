package org.csystem.app.samples.parserapp;

public class Parser {
    private ISource m_source;

    public Parser(ISource source)
    {
        setSource(source);
    }

    public ISource getSource() {return m_source;}

    public void setSource(ISource source)
    {
        //...
        m_source = source;
    }

    public void doParse()
    {
        int ch;
        int count = 0;

        while ((ch = m_source.getChar()) != -1)
            if (Character.isWhitespace((char)ch))
                ++count;

        System.out.printf("Boşluk sayısı:%d%n", count);
    }
}
