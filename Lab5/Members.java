import java.io.Serializable;
import java.util.Scanner;

public class Members implements Serializable
{
	private String name;
	private String surName;
	private int age;
	
	public void setName(String name)
	{
		if(Reg.isNameSurname(name))
			this.name = name;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public String getName()
	{
		return this.name;
	}
	public void setSurName(String surName)
	{
		if(Reg.isNameSurname(surName))
			this.surName = surName;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public String getSurName()
	{
		return this.surName;
	}
	public void setAge(int age)
	{
		if(Reg.isAge(age))
			this.age = age;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
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
		String tmp;
		do
		{
			System.out.print("Name: ");  
			tmp = in.nextLine();		
		}
		while(!Reg.isNameSurname(tmp));
		this.name = tmp;
		do
		{
			System.out.print("Surname: ");   
			tmp = in.nextLine();
		}
		while(!Reg.isNameSurname(tmp));
		this.surName = tmp;
		int age;
		do
		{
			System.out.print("Age: ");   
			age = Integer.parseInt(in.nextLine());
		}
		while(!Reg.isAge(age));
		this.age = age;
	}
	
	public void print()
	{
		System.out.println("Name: " + name + " ||" + " Surname:  " + surName + " ||"+ " Age: " + age);
	}
}
