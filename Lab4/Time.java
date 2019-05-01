import java.io.Serializable;
import java.util.Scanner;

public class Time implements Serializable
{
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	public int getHour()
	{
		return this.hour;
	}
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
	public int getMinute()
	{
		return this.minute;
	}
	public void setSecond(int second)
	{
		this.second = second;
	}
	public int getSecond()
	{
		return this.second;
	}
	
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
