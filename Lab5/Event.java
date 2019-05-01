import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Event implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Time timeStart;
	private Time duration;
	private String place;
	private String description;
	private ArrayList <Members> members = new ArrayList<Members>();
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	public Date getDate()
	{
		return date;
	}
	public void setTimeStart(Time timeStart)
	{
		this.timeStart = timeStart;
	}
	public Time getTimeStart()
	{
		return timeStart;
	}
	public void setDuration(Time duration)
	{
		this.duration = duration;
	}
	public Time getDuration()
	{
		return duration;
	}
	public void setPlace(String place)
	{
		if(Reg.isPlace(place))
			this.place = place;
		else
		{
			System.out.println("Data Error");
			System.exit(0);
		}
	}
	public String getPlace()
	{
		return this.place;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setMembers(ArrayList<Members> members)
	{
		this.members = members;
	}
	public ArrayList<Members> getMembers()
	{
		return this.members;
	}
	
	public Event()
	{
		
	}
		
	public Event(Scanner in)
	{
		date = new Date(in);
		timeStart = new Time(in);
		duration = new Time(in);
		do
		{
			System.out.println("Enter place");
			this.place = in.nextLine();
		}
		while(!Reg.isPlace(place));
		System.out.println("Enter description");
		setDescription(in.nextLine());
		System.out.println("Enter number of members");
		int num = Integer.parseInt(in.nextLine());
		for(int i = 0;i < num;i++)
		{
			members.add(new Members(in));
		}
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
		System.out.println("------------------------------------------------------");
	}	
}
