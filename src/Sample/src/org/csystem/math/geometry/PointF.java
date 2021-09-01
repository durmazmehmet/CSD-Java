package org.csystem.math.geometry;

import static java.lang.Math.sqrt;

public class PointF {
	public float x, y;	
	//...

	PointF(PointF p)
	{
		x = p.x;
		y = p.y;
	}

	public PointF()
	{}
	
	public PointF(float x)
	{
		this(x, 0);
	}	
	
	public PointF(double radius, double theta)
	{
		this((float)(radius * Math.cos(theta)), (float)(radius * Math.sin(theta)));
	}
	
	public PointF(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double distance()
	{
		return this.distance(0, 0);
	}
	
	public double distance(PointF p)
	{		
		return this.distance(p.x, p.y);
	}
	
	public double distance(float a, float b)
	{
		return sqrt((x - a) * (x - a) + (y - b) * (y - b));				
	}
	
	public void offset(float dxy)
	{
		this.offset(dxy, dxy);
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



