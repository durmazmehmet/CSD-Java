/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.collection;

public class CSDArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] m_elems;
    private int m_index;

    private static void controlForCapacity(int capacity, String msg)
    {
        if (capacity < 0)
            throw new IllegalArgumentException(msg);
    }

    private void allocateCapacity(int capacity)
    {
        T [] temp = (T [])new Object[capacity];

        for (int i = 0; i < m_index; ++i)
            temp[i] = m_elems[i];

        m_elems = temp;
    }


    private void controlForIndex(int index, String msg)
    {

        if (index < 0 || index >= m_index)
            throw new IndexOutOfBoundsException(msg);
    }


    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }


    public CSDArrayList(int initialCapacity)
    {
        controlForCapacity(initialCapacity, "illegal argument");

        m_elems = (T [])new Object[initialCapacity];
    }

    public boolean add(T elem)
    {
        if (m_index == m_elems.length)
            this.allocateCapacity(m_elems.length != 0 ? m_elems.length * 2 : 1);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, T elem)
    {
        //TODO:
    }

    public int capacity() {return m_elems.length;}

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int capacity)
    {
        //TODO:
    }

    public T get(int index)
    {
        this.controlForIndex(index, "Index out of bounds");

        return m_elems[index];
    }

    public T remove(int index)
    {
        //TODO:

        return null;
    }

    public T set(int index, T elem)
    {
        this.controlForIndex(index, "Index out of bounds");
        T oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }

    public int size() {return m_index;}

    public void trimToSize()
    {
        this.allocateCapacity(m_index);
    }
}
