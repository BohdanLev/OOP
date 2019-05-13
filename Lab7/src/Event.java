import java.util.ArrayList;
import java.util.Scanner;

public class Event 
{
	public Date date;
	public Time timeStart;
	public Time duration;
	public String place;
	public String description;
	public ArrayList <Members> members = new ArrayList<Members>();
	
	public Event()
	{
		
	}
		
	public Event(Scanner in)
	{
		date = new Date(in);
		timeStart = new Time(in);
		duration = new Time(in);
		setPlace(in);
		setDescription(in);
		setMembers(in);
	}

	void setPlace(Scanner in)
	{
		
		System.out.println("Enter name of place");
		this.place = in.nextLine();
	}
	
	void setDescription(Scanner in)
	{
		System.out.println("Write description");
		this.description = in.nextLine();
	}

	void setMembers(Scanner in)
	{
		System.out.println("Enter number of members");
		int num = Integer.parseInt(in.nextLine());
		for(int i = 0;i < num;i++)
			members.add(new Members(in));
	}
	
	public void getInfo()
	{
		date.print();
		timeStart.print();
		duration.print();
		System.out.println("Place: " + place + "\n"
				+"Description: " + description + "\n"
				+ "There are "+ members.size() + " members: ");
		for(Members mem: members)
		{
			mem.print();
		}
	}	
}
