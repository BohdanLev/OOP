import java.util.Scanner;

public class Members {
	public String name;
	public String surName;
	public int age;
	
	public Members()
	{
		
	}
	
	public Members(Scanner in)
	{
		this.set(in);
	}
	
	public void set(Scanner in)
	{
		System.out.print("Name: ");   this.name = in.nextLine();		
		System.out.print("Surname: ");   this.surName = in.nextLine();
		System.out.print("AgeA: ");   this.age = Integer.parseInt(in.nextLine());
	}
	
	public void print()
	{
		System.out.println("Name: " + name + " ||" + " Surname:  " + surName + " ||"+ " Age: " + age);
	}
}
