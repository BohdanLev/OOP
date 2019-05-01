import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.Iterator;
import java.util.Scanner;


public class ListArray implements Iterable<String>, Serializable
{
	private static final long serialVersionUID = 1L;
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
			if(array[i].compareTo(data) == 0)
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
			if(array[i].compareTo(data) == 0)
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() // Дописати
	{
		if(pointer == 0)
			return null;
		return String.join(", ", array);
		
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
	
	public String at(int index)
	{
		if(index >= pointer)
			return null;
		return array[index];
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
		for(String i: array)
		{
			System.out.print(i + " ");
		}
	}
	
public boolean compareTo()
{
	if(this.size() == 0)
	{
		System.out.println("Object is clear");
		return false;
	}
	Scanner in = new Scanner(System.in);
	System.out.print("Enter path to file ");
	ListArray obj = ListArray.deserialize(in.nextLine());
	//in.close();
	if(this.containsAll(obj))
	{
		System.out.println("Equal");
		return true;
	}
	else
	{
		System.out.println("Not equal");
		return false;
	}
}
	
	public void sort()
	{
		boolean isSwapped = false;
		
		do 
		{
		    isSwapped = false;
		    
		    for(int i = 0; i < pointer; i++)
		    {
		        if(i+1 < pointer && array[i].compareTo(array[i + 1]) > 0)
		        {
		            String temp = array[i+1];
		            array[i+1] = array[i];
		            array[i] = temp;
		            
		            isSwapped = true;
		        }
		    }
		}
		while(isSwapped);
	}
	
	public static ListArray deserialize(String fname)
	{
		ListArray obj = null;
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			obj = (ListArray) ois.readObject();
			ois.close();
			return obj;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(
				"The file does not contain StringIterable class.");
		}
		catch(StreamCorruptedException e)
		{
			System.out.println(
				"Serialized data is corrupted."
			);
		}
		catch(IOException e)
		{
			System.out.println("Error with opening the file.");
		}

		return obj;
	}
	
	
	public void serialize(String fname) throws Exception
	{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
		oos.writeObject(this);
		oos.close();
	}
	
	public Iterator<String> iterator()
	{
		return new Iterator<String>()
		{

			private int ptr = 0;

			public boolean hasNext()
			{
				return ptr  < pointer && array[ptr] != null;
			}

			public String next()
			{
				return array[ptr++];
			}

			public void remove()
			{
				for(int i = 0;i < pointer;i++)
				{
					if(array[i] == array[ptr])
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
					}
				}
			}
		};

	};
}