import java.util.Scanner;

public class Date 
{
	public int day;
	public int month;
	public int year;
	
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
