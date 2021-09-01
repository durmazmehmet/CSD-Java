/*----------------------------------------------------------------------------------------------------------------------
	Point sınıfı
----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class Point {
	public int x, y;

	Point(Point p)
	{
		this(p.x, p.y);
	}

	public Point()
	{}

	public Point(int a)
	{
		this(a, 0);
	}
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static double distance(int x1, int y1, int x2, int y2)
	{
		return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public double distance(Point p)
	{
		return distance(x, y, p.x, p.y);
	}
	
	public double distance(int a, int b)
	{
		return distance(x, y, a, b);
	}
	
	public void offset(int dxy)
	{
		offset(dxy, dxy); //Do not repeat yourself
	}
	
	public void offset(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("(%d, %d)", x, y);
	}	
}
