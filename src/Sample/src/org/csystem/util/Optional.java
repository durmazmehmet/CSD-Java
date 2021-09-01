package org.csystem.util;

public class Optional<T> {
    private Pair<T, Boolean> m_data;

    private Optional(Pair<T, Boolean> data)
    {
        m_data = data;
    }

    public static <T> Optional<T> of(T t)
    {
        return new Optional<>(Pair.create(t, true));
    }

    public static <T> Optional<T> empty()
    {
        return new Optional<>(Pair.create(null, false));
    }

    public static <T> Optional<T> ofNullable(T t)
    {
        return t == null ? empty() : of(t);
    }

    public boolean isPresent() {return m_data.getSecond();}
    public T get() {return m_data.getFirst();}
    //...
}
