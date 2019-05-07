import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

public class ListArray implements Iterable<String>
{
	private int SIZE = 16;
	private String[] array = new String[SIZE];
	private int pointer = 0;
	public void add(String data)
	{
		if(pointer == array.length)
		{
			SIZE *= 2;
			resize();
		}
			
		array[pointer++] = data;	
	}
	
	private void resize()
	{
		String[] newArray = new String[SIZE];
		for(int i = 0;i < pointer;i++)
		{
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	public boolean remove(String data)
	{
		for(int i = 0;i < pointer;i++)
		{
			if(array[i] == data)
			{
				
				for(int j = i;j < pointer;j++)
				{
					array[j] = array[j+1];
				}
				pointer--;
				if(pointer == SIZE/2)
				{
					SIZE /= 2;
					resize();
				}
				return true;
			}
		}
		return false;
	}
	
	public void clear()
	{
		for(int i = 0;i < pointer;i++)
			array[i] = null;
		SIZE = 16;
		pointer = 0;
		array = new String[SIZE];
	}
	
	public boolean contains(String data)
	{
		for(int i = 0;i < pointer;i++)
		{
			if(array[i] == data)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() // Дописати
	{
		if(pointer == 0)
			return null;
		StringBuilder tmpResult = new StringBuilder();
		for(int i = 0;i < pointer;i++)
		{
			tmpResult.append(array[i]);
			tmpResult.append(' ');
		}
		return tmpResult.toString();
	}
	
	boolean containsAll(ListArray arr)
	{
		boolean contains = false;
		for(int i = 0;i < arr.size();i++)
		{
			for(int j = 0;j < pointer;j++)
			{
				if(arr.at(i).compareTo(array[j]) == 0)
				{
					contains = true;
					break;
				}		
			}
			if(!contains)
				return false;
			contains = false;
		}		
		return true;
	}
	
	Object[] toArray()
	{
		String[] arr = new String[pointer];
		for(int i = 0;i < pointer;i++)
		{
			arr[i] = array[i]; 
		}
		return arr;
	}
	
	public int size()
	{
		return pointer;
	}
	
	public int capacity()
	{
		return SIZE;
	}
	
	public String at(int index)
	{
		if(index >= pointer)
			return null;
		return array[index];
	}
	
	public int indexOf(String s)
	{
		for(int i = 0;i < pointer;i++)
		{
			if(s.compareTo(array[i]) == 0)
				return i;
		}
		return -1;
	}
	
	void print()
	{
		for(int i = 0;i < pointer;i++)
		{
			System.out.print(array[i] + "   ");
		}
	}
	

	
	boolean serialize(String FewFiles) 
	  {
	         FileOutputStream fos;
	         try 
	         {
	             fos = new FileOutputStream(FewFiles);
	         } 
	         catch (FileNotFoundException e) 
	         {
	             System.out.println("file not found");
	             return false;
	         }
	          
	         try 
	         {
	             ObjectOutputStream oos = new ObjectOutputStream(fos);
	             oos.writeObject(this);
	             oos.flush();
	             oos.close();
	             fos.close();
	             return true;
	         } 
	         catch (IOException e) 
	         {
	             System.out.println("IO - GOES CRAZY");
	             return false;
	         }
	    }
	  
	  boolean deserialize(String FewFiles)
	  {
	         FileInputStream fis;
	         try 
	         {
	             fis = new FileInputStream(FewFiles);
	         } 
	         catch (FileNotFoundException e) 
	         {
	             System.out.println("file not found");
	             return false;
	         }
	         try 
	         {
	             ObjectInputStream ois = new ObjectInputStream(fis);
	             
	             ListArray  temp = ( ListArray ) ois.readObject();
	             
	             if (temp.pointer > this.array.length) 
	             {
	                 System.out.println("too large container");
	                 ois.close();
	                 return false;
	             }
	             
	             this.array = temp.array;
	             
	             this.pointer  = temp.pointer ;
	             
	             ois.close();
	             return true;
	         } 
	         catch (IOException e) 
	         {
	             System.out.println("IO - GOES CRAZY");
	             
	             return false;
	         }
	         catch (ClassNotFoundException e) 
	         {
	             System.out.println("wrong file format");	     
	             return false;
	         }
	     }
	  public Iterator<String> iterator()
	  {
		  return new MyIterator(this,pointer);
	  }
}