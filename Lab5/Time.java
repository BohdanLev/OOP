import java.io.Serializable;
import java.util.Scanner;

public class Time implements Serializable
{
	private int hour;
	private int minute;
	private int second;
	
	public void setHour(int hour)
	{
		if(Reg.isHour(hour))
			this.hour = hour;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public int getHour()
	{
		return this.hour;
	}
	public void setMinute(int minute)
	{
		if(Reg.isMinSec(minute))
			this.minute = minute;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public int getMinute()
	{
		return this.minute;
	}
	public void setSecond(int second)
	{
		if(Reg.isMinSec(second))
			this.second = second;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
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
		int tmp;
		do
		{
			System.out.println("Enter hour"); 
			tmp = Integer.parseInt(in.nextLine());		
		}
		while(!Reg.isHour(tmp));
		this.hour = tmp;
		do
		{
			System.out.println("Enter minute");  
			tmp = Integer.parseInt(in.nextLine());		
		}
		while(!Reg.isMinSec(tmp));
		this.minute = tmp;
		do
		{
			System.out.println("Enter second");  
			tmp = Integer.parseInt(in.nextLine());
		}
		while(!Reg.isMinSec(tmp));
		this.second = tmp;
	}
	public void print()
	{
		System.out.println(hour + ":" + minute + ":" + second);
	}
}
