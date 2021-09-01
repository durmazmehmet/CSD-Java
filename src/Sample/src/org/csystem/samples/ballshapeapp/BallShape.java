package org.csystem.samples.ballshapeapp;

public class BallShape {
    private String m_shape;

    private void fillWithSpace(int start, int end) //[start, end)
    {
        for (int i = start; i < end; ++i)
            m_shape += ' ';
    }

    public BallShape()
    {
        m_shape = "";
    }

    public String getShape() {return m_shape;}

    public void run(int width, int height)
    {
        boolean incFlag = true;
        int index = 0;

        for (int i = 1; i <= height; ++i) {
            m_shape += "|";
            fillWithSpace(0, index);
            m_shape += '*';
            fillWithSpace(index + 1, width);

            if (index == 0)
                incFlag = true;
            else if (index == width - 1)
                incFlag = false;
            if (incFlag)
                ++index;
            else
                --index;

            m_shape += "|\n";
        }
        m_shape = m_shape.trim();
    }
}
