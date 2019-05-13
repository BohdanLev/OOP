import java.util.Scanner;

public class Time 
{
	public int hour;
	public int minute;
	public int second;
	
	public Time()
	{
		
	}
	
	public Time(Scanner in)
	{
		System.out.println("Enter hour");
		hour = Integer.parseInt(in.nextLine());
		System.out.println("Enter minute");
		minute = Integer.parseInt(in.nextLine());
		System.out.println("Enter second");
		second = Integer.parseInt(in.nextLine());
	}
	public void print()
	{
		System.out.println(hour + ":" + minute + ":" + second);
	}
}
