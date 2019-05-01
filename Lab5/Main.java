import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		LinkedList<Event> test = new LinkedList<Event>();
		
		boolean auto = false;
		
		for(String i:args)
		{
			if(i.equals("auto"));
				auto = true;
		}
		
		System.out.println("Add-\t add new elements.\n"
				+ "Print-\t print all the elements.\n"
				+ "IsClear-\t check if list is clear.\n"
				+ "Get-\t get element by index.\n"
				+ "Remove-\t remove element element by index.\n"
				+ "Clear-\t delete all elements.\n"
				+ "Serialize-\t save LinkedList.\n"
				+ "Deserialize-\t load LinkedList from file.\n"
				+ "SerializeXML-\t save LinkedList in XML.\n"
				+ "DeserializeXML-\t load LinkedList from file XML.\n");
				
		while(true)
		{
			if(auto)
			{
				test = deserialize();
				auto = false;
				System.out.println("Auto mode enabled.\n"
						+ "File succesfully deserialize");
			}
			System.out.print("$ ");
			switch(in.nextLine())
			{
				case"Add":
				{
					test.addLast(new Event(in));
					System.out.println("Added");
					break;
				}
				case"Print":
				{
					for(Event i: test)
					{
						i.getInfo();
					}
					break;
				}
				case"IsClear":
				{
					System.out.println(test.isClear());
					break;
				}
				case"Get":
				{
					System.out.println("Enter index");
					Event get = test.getElement(in.nextInt());
					if(get == null)
						System.out.println("NoSuchElement");
					else
						get.getInfo();
					break;
				}
				case"Remove":
				{
					System.out.println("Enter index");
					System.out.println(test.remove(in.nextInt()));
					break;
				}
				case"Clear":
				{
					if(test!=null)
					test.clear();
					System.out.println("Clear");
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
					if(test != null)
						System.out.println("Deserialized");
					break;
				}
				
				case"SerializeXML":
				{
					serializeXML(test);
					System.out.println("Serialized");
					break;
				}
				case"DeserializeXML":
				{
					test = deserializeXML();
					if(test != null)
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

	

	
	public static boolean serialize(LinkedList object) 
	  {
	         FileOutputStream fos;
	         try 
	         {
	             fos = new FileOutputStream(new PathMover().directory());
	         } 
	         catch (FileNotFoundException e) 
	         {
	             System.out.println(e);
	             return false;
	         }
	          
	         try 
	         {
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(object);
	             oos.flush();
	             oos.close();
	             fos.close();
	             return true;
	         } 
	         catch (IOException e) 
	         {
	             System.out.println(e);
	             return false;
	         }
	    }
	  
	  public static LinkedList deserialize()
	  {
	         FileInputStream fis;
	         try 
	         {
	             fis = new FileInputStream(new PathMover().directory());
	         } 
	         catch (FileNotFoundException e) 
	         {
	             System.out.println(e);
	             return null;
	         }
	         try 
	         {
	             ObjectInputStream ois = new ObjectInputStream(fis);
	             
	             LinkedList  temp = (LinkedList) ois.readObject();             
	             ois.close();
	             return temp;
	         } 
	         catch (IOException e) 
	         {
	             System.out.println(e);
	             return null;
	         }
	         catch (ClassNotFoundException e) 
	         {
	             System.out.println(e);	     
	             return null;
	         }
	     }
	  
	  
	  public static void serializeXML(LinkedList test)
		{
			try
			{
				XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new PathMover().directory())));
				encoder.writeObject(test);
				encoder.close();
				System.out.println("Successfully serialized ");
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
		
		
		public static LinkedList deserializeXML()
		{
	         try 
	         {
	        	 XMLDecoder decoder = new XMLDecoder(new FileInputStream(new PathMover().directory()));
	        	 LinkedList test = (LinkedList) decoder.readObject();
	        	 System.out.println("Successfully deserialized ");
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

