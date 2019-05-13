import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyIterator implements Iterator<String> {
	
	private ListArray arr;
	private int ptr = 0;
	int stop;
	public MyIterator(ListArray array, int pointer) {
		this.arr = array;
		 stop = pointer-1;
	}

	public boolean hasNext() {
		
		return  ptr <= stop &&  arr.at(ptr) != null;
	}

	@Override
	public String next() {
		if(hasNext())
		{
			return (String) arr.at(ptr++);
		}
		return null;
	}
	
	public void remove()
	{
		arr.remove(arr.at(ptr++));
	}

}
