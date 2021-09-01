package org.csystem.math;

import static java.lang.Math.sqrt;

public class Complex {
	private static Complex add(double a1, double b1, double a2, double b2)
	{
		return new Complex(a1 + a2, b1 + b2);
	}

	private static Complex sub(double a1, double b1, double a2, double b2)
	{
		return add(a1, b1, -a2, -b2);
	}

	public double re, im;
	
	public Complex()
	{}
	
	public Complex(double re)
	{
		this(re, 0);
	}
	
	public Complex(double re, double im)
	{
		this.re = re;
		this.im = im;
	}
	
	public Complex getConjugate()
	{
		return new Complex(re, -im);
	}
	
	public double getNorm()
	{
		return sqrt(re * re + im * im);
	}
	
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.re, z.im);				
	}	
	
	public Complex add(double val)
	{
		return add(re, im, val, 0);
	}
	
	public Complex add(Complex z)
	{
		return add(re, im, z.re, z.im);		
	}
	
	public static Complex sub(double val, Complex z)
	{
		return sub(val, 0, z.re, z.im);				
	}	
	
	public Complex sub(double val)
	{
		return sub(re, im, val, 0);
	}
	
	public Complex sub(Complex z)
	{
		return sub(re, im, z.re, z.im);		
	}
	
	public void inc()
	{
		this.inc(1);
	}
	
	public void inc(int val)
	{
		re += val;
	}
	
	public Complex incremented()
	{
		return new Complex(re + 1, im);
	}	
	
	public void dec(int val)
	{
		this.inc(-val);
	}
	public void dec()
	{
		this.dec(1);
	}
	
	public Complex decremented()
	{
		return new Complex(re - 1, im);
	}

	public String toString()
	{
		return String.format("|%.2f + i*%.2f|=%.2f", re, im, this.getNorm());
	}
}