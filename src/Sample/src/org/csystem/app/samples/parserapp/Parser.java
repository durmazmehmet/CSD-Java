package org.csystem.app.samples.parserapp;

public class Parser {
    private Source m_source;

    public Parser()
    {}

    public Parser(Source source)
    {
        this.setSource(source);
    }

    public void setSource(Source source)
    {
        //...
        m_source = source;
    }

    public void doParse()
    {
        int count = 0;
        int ch;

        while ((ch = m_source.getChar()) != -1)
            if (Character.isDigit((char)ch))
                ++count;

        System.out.printf("Count:%d%n", count);
    }
}
