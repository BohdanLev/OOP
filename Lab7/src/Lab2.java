import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Lab2{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Event> test = new ArrayList<Event>();
		
		System.out.println("Available Commands:\n\n"
				+ "Add-\t add new element\n"
				+ "Print-\t print all the elements\n"
				+ "Clear-\t clear all the elements\n"
				+ "Sort-\t sort events by members"
				+ "Remove-\t remove element by index"
				+ "At-\t print info of element by index"
				+ "Serialize-\t write objects to xml file\n"
				+ "Deserialize-\t read object from xml file\n"
				+ "Exit-\t exit\n\n\n");
		
		
		while(true)
		{
			System.out.print("Enter command: ");
			switch(in.nextLine())
			{
				case"Add":
				{
					test.add(new Event(in));
					System.out.println("Added");
					break;
				}
				case"Print":
				{
					for(Event go: test)
					{
						go.getInfo();
					}
					break;
				}
				case"Clear":
				{
					test.clear();
					System.out.println("Clear");
					break;
				}
				case"Sort":
				{
					Collections.sort(test,new Comparator<Event>()
							{
								public int compare(Event first, Event second)
								{
									return first.members.size() > second.members.size() ? -1 :(first.members.size() < second.members.size()) ? 1 : 0 ;
								}
							});
							break;
				}
				case"Remove":
				{
					System.out.println("Enter index");
					remove(test,in.nextInt());
					break;
				}
				case"At":
				{
					System.out.println("Enter index");
					at(test,in.nextInt());
					break;
				}
				case"Serialize":
				{
					serialize(test);
					System.out.println("Serialized");
					break;
				}
				case"Deserialize":
				{
					test = deserialize();
					System.out.println("Deserialized");
					break;
				}
				case"Exit":
				{
					return;
				}
			}
			
		}
	}

	static boolean remove(ArrayList<Event> test, int index)
	{
		if(index >= test.size())
			return false;
		test.remove(index);
		return true;
	}
	
	static void at(ArrayList<Event> test, int index)
	{
		if(index >= test.size())
			return;
		test.get(index).getInfo();;
	}
	
	static void serialize(ArrayList<Event> test)
	{
		try
		{
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new PathMover().directory())));
			encoder.writeObject(test);
			encoder.close();
			System.out.println("Successfully serialized " + test.size() + " objects");
			return;
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			return;
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
			return;
		}
		
	}
	
	
	static ArrayList<Event> deserialize()
	{
         try 
         {
        	 XMLDecoder decoder = new XMLDecoder(new FileInputStream(new PathMover().directory()));
        	 ArrayList<Event> test = (ArrayList<Event>) decoder.readObject();
        	 System.out.println("Successfully deserialized " + test.size() + " objects");
        	 return test;
         } 
         catch (FileNotFoundException e) 
         {
             System.out.println(e);
             return null;
         }
         catch(NullPointerException e)
         {
        	 System.out.println(e);
        	 return null;
         }
		
	}
}
