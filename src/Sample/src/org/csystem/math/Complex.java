/*----------------------------------------------------------------------------------------------------------------------
    Complex sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.math;

public final class Complex {
	public double re, im;
		
	private static Complex add(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 + re2, im1 + im2);	
	}
	
	private static Complex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}
	
	private static Complex multiply(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 * re2 - im1 * im2, re1 * im2 + im1 * re2);
	}
	
	private static Complex devide(double re1, double im1, double re2, double im2)
	{
		//TODO: Do your homework
		return multiply(re1, im1, re2, im2);
	}
	
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
		return Math.sqrt(re * re + im * im);
	}
	
	public void dec()
	{
		--re;
	}
	
	public void inc()
	{
		++re;
	}
	
	public Complex add(Complex z)
	{
		return add(re, im, z.re, z.im);				
	}
	
	public Complex add(double a, double b)
	{
		return add(re, im, a, b);
	}
	
	public Complex add(double a)
	{
		return add(a, 0);
	}	
	
	public Complex subtract(Complex z)
	{
		return subtract(re, im, z.re, z.im);				
	}
	
	public Complex subtract(double a, double b)
	{
		return subtract(re, im, a, b);
	}
	
	public Complex subtract(double a)
	{
		return subtract(a, 0);
	}	
	
	public Complex multiply(Complex z)
	{
		return multiply(re, im, z.re, z.im);				
	}
	
	public Complex multiply(double a, double b)
	{
		return multiply(re, im, a, b);
	}
	
	public Complex multiply(double a)
	{
		return multiply(a, 0);
	}
	
	public String toString()
	{
		return String.format("|%.2f + %.2fi| = %f", re, im, getNorm());
	}
}
