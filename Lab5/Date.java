import java.io.Serializable;
import java.util.Scanner;

public class Date implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;
	
	public void setDay(int day)
	{
		if(Reg.isDay(day))
			this.day = day;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public int getDay()
	{
		return this.day;
	}
	public void setMonth(int month)
	{
		if(Reg.isMonth(month))
			this.month = month;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public int getMonth()
	{
		return this.month;
	}
	public void setYear(int year)
	{
		if(Reg.isYear(year))
			this.year = year;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public int getYear()
	{
		return this.year;
	}
	
	public Date()
	{
		
	}
    
	public Date(Scanner in)
	{
		int tmp;
		do
		{
			System.out.println("Enter day"); 
			tmp = Integer.parseInt(in.nextLine());		
		}
		while(!Reg.isDay(tmp));
		this.day = tmp;
		do
		{
			System.out.println("Enter month");  
			tmp = Integer.parseInt(in.nextLine());		
		}
		while(!Reg.isMonth(tmp));
		this.month = tmp;
		do
		{
			System.out.println("Enter year");  
			tmp = Integer.parseInt(in.nextLine());
		}
		while(!Reg.isYear(tmp));
		this.year = tmp;
	}
	
	public void print()
	{
		System.out.println(day + "." + month + "." + year);
	}
}
