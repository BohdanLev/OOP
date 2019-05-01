import java.io.Serializable;
import java.util.Scanner;

public class Members implements Serializable
{
	private String name;
	private String surName;
	private int age;
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setSurName(String surName)
	{
		this.surName = surName;
	}
	public String getSurName()
	{
		return this.surName;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}
	
	
	public Members()
	{
		
	}
	
	public Members(Scanner in)
	{
		this.in(in);
	}
	
	public void in(Scanner in)
	{
		System.out.print("Name: ");   this.name = in.nextLine();		
		System.out.print("Surname: ");   this.surName = in.nextLine();
		System.out.print("Age: ");   this.age = Integer.parseInt(in.nextLine());
	}
	
	public void print()
	{
		System.out.println("Name: " + name + " ||" + " Surname:  " + surName + " ||"+ " Age: " + age);
	}
}
