package org.csystem.app.samples.ballshapeapp;

public class BallShape {
	private static void fillWithCharacter(int start, int end, char ch) //[start, end)
	{
		for (int i = start; i < end; ++i)
			System.out.print(ch);
	}
	
	public static void run(int width, int height)
	{
		boolean incFlag = true;
		int index = 0;
		
		for (int i = 1; i <= height; ++i) {
			System.out.print("|");
			
			fillWithCharacter(0, index, ' ');
			System.out.print("*");
			fillWithCharacter(index + 1, width, ' ');
			
			if (index == 0)
				incFlag = true;
			if (index == width - 1)
				incFlag = false;
			
			if (incFlag)
				++index;
			else
				--index;
			
			System.out.println("|");			
		}
		
	}
}
