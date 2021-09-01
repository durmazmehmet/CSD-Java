public class CSDArrayList implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] m_elems;
    private int m_index;

    private static void copy(Object [] src, Object [] dest)
    {
        for (int i = 0; i < src.length; ++i)
            dest[i] = src[i];
    }

    private static void checkForBounds(int index, int bound, String msg)
    {
        if (index < 0 || index > bound)
            throw new IndexOutOfBoundsException(msg);
    }

    private static void checkForCapacity(int capacity, String msg)
    {
        if (capacity < 0)
            throw new IllegalArgumentException(msg);
    }

    private void allocateCapacity(int capacity)
    {
        Object [] temp = new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }

    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    public CSDArrayList(int initialCapacity)
    {
        checkForCapacity(initialCapacity, "ctor:Illegal Argument");
        m_elems = new Object[initialCapacity == 0 ? DEFAULT_CAPACITY : initialCapacity];
    }

    public void add(int index, Object elem)
    {
        //TODO:
    }

    public boolean add(Object elem)
    {
        if (m_elems.length == m_index)
            this.allocateCapacity(m_elems.length * 2);

        m_elems[m_index++] = elem;

        return true;
    }

    public int capacity() {return m_elems.length;}

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public Object clone()
    {
        CSDArrayList clone = new CSDArrayList(m_elems.length);

        copy(m_elems, clone.m_elems);

        clone.m_index = m_index;

        return clone;
    }

    public void ensureCapacity(int capacity)
    {
        if (capacity <= m_elems.length)
            return;

        if (capacity < 2 * m_elems.length)
            this.allocateCapacity(2 * m_elems.length);
        else
            this.allocateCapacity(capacity);
    }

    public Object get(int index)
    {
        checkForBounds(index, m_index - 1, "get:Index Out Of Bounds");

        return m_elems[index];
    }

    public int indexOf(Object o)
    {
        if (o == null) {
            for (int i = 0; i < m_index; ++i)
                if (m_elems[i] == null)
                    return i;
        }
        else {
            for (int i = 0; i < m_index; ++i)
                if (o.equals(m_elems[i]))
                    return i;
        }

        return -1;
    }

    public Object remove(int index)
    {
        //TODO:

        return null;
    }

    public Object set(int index, Object elem)
    {
        checkForBounds(index, m_index - 1, "set:Index Out Of Bounds");
        Object oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size() {return m_index;}

    public void trimToSize()
    {
        this.allocateCapacity(m_index == 0 ? DEFAULT_CAPACITY : m_index);
    }

    public String toString()
    {
        String str = "[";

        for (int i = 0; i < m_index; ++i)
            str += m_elems[i].toString() + ",";

        if (str.length() != 1)
            str = str.substring(0, str.length() - 1);

        return str + "]";
    }
}

