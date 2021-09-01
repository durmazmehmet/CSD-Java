/*----------------------------------------------------------------------------------------------------------------------
	PointF sınıfı
----------------------------------------------------------------------------------------------------------------------*/

package org.csystem.math.geometry;

import static java.lang.Math.sqrt;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class PointF {
	public float x, y;

	public PointF()
	{}

	public PointF(float a)
	{
		this(a, 0);
	}

	public PointF(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public PointF(double radius, double theta) //theta in degrees
	{
		this((float)(radius * cos(toRadians(theta))), (float)(radius * sin(toRadians(theta))));
	}
	
	public static double distance(float x1, float y1, float x2, float y2)
	{
		return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public double distance(PointF p)
	{
		return distance(x, y, p.x, p.y);
	}
	
	public double distance(float a, float b)
	{
		return distance(x, y, a, b);
	}
	
	public void offset(float dxy)
	{
		offset(dxy, dxy); //Do not repeat yourself
	}
	
	public void offset(float dx, float dy)
	{
		x += dx;
		y += dy;
	}
	
	public String toString()
	{
		return String.format("(%f, %f)", x, y);
	}	
}
