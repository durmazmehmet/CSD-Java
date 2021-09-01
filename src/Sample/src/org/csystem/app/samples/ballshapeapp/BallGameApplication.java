package org.csystem.app.samples.ballshapeapp;

public class BallGameApplication {
	public static void run()
	{
		java.util.Scanner kb = new java.util.Scanner(System.in);
		System.out.print("Width:");
		int width = Integer.parseInt(kb.nextLine());
		System.out.print("Heigth:");
		int height = Integer.parseInt(kb.nextLine());
		
		//TODO: Geçerlilik kontrollerini yapınız
		BallShape.run(width, height);
	}	
}
