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
		this.day = day;
	}
	public int getDay()
	{
		return this.day;
	}
	public void setMonth(int month)
	{
		this.month = month;
	}
	public int getMonth()
	{
		return this.month;
	}
	public void setYear(int year)
	{
		this.year = year;
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
		System.out.println("Enter day");
		day = Integer.parseInt(in.nextLine());
		System.out.println("Enter month");
		month = Integer.parseInt(in.nextLine());
		System.out.println("Enter year");
		year = Integer.parseInt(in.nextLine());
	}
	
	public void print()
	{
		System.out.println(day + "." + month + "." + year);
	}
}
