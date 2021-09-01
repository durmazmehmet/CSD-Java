package org.csystem.app.samples.parserapp;

import java.util.Random;

public class SourceFactory {
    private final Random m_random;

    public SourceFactory()
    {
        this(new Random());
    }

    public SourceFactory(Random random)
    {
        m_random = random;
    }
    public Source getRandomSource(String str)
    {
        Source source;

        switch (m_random.nextInt(2)) {
            case 0:
                source = new StringSource(str);
                break;
            default:
                source = new CharArraySource(str);
        }

        return source;
    }
}
