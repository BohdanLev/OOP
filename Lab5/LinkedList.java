import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T>,Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Node<T> head;
	private int size;
		
	public LinkedList()
	{
		
	}
	
	public LinkedList(T data)
	{
		head = new Node<T>(data);
		size = 0;
	}
	
	public Node<T> getHead()
	{
		return head;
	}
	public int getSize()
	{
		return size;
	}
	public void setHead(Node<T> head)
	{
		this.head = head;
	}
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public void addFirst(T data)
	{
		size++;
		if(head == null)
		{
			head = new Node<T>(data);
			return;
		}
		Node<T> tmp = new Node<T>(data);
		tmp.setNext(head);
		head = tmp;
	}
	
	public void addLast(T data)
	{
		size++;
		Node<T> tmp = new Node<T>(data);
		if(head == null)
		{
			head = tmp;
			return;
		}
		Node<T> current = head;
		while(current.getNext()!= null)
		{
			current = current.getNext();
		}
		current.setNext(tmp);
	}
	
	public void clear()
	{
		head = null;
		size = 0;
	}
	
	public T[] toArray()
	{
		T[] arr = (T[]) new Object[size];
		int count = 0;
		Node<T> current = head;
		while(current != null)
		{
			arr[count++] = current.getData();	
			current = current.getNext();
		}
		return arr;
	}
	
	public String toString()
	{
		StringBuilder res = new StringBuilder();
		Node<T> current = head;
		while(current != null)
		{
			res.append(current.getData().toString());
			res.append(" ");
			current = current.getNext();
		}
		return res.toString();
	}
	
	public boolean isClear()
	{
		return head == null;
	}
	
	public T getElement(int index)
	{
		if(head == null || index >= size || index < 0)
			return null;
		Node<T> current = head;
		int count = 0;
		while(current != null && count++ < index)
		{
			current = current.getNext();
		}
		if(current == null)
			return null;
		return current.getData();
	}
	
	public boolean remove(int index)
	{
		if(index >= size || index < 0)
			return false;
		Node<T> current = head;
		int count = 0;
		while(count < index-1)
		{
			current = current.getNext();
			count++;
		}
		if(current == null)
			return false;
		if(index == 0)
		{
			head = current.getNext();
			size--;
			return true;
		}
		current.setNext(current.getNext().getNext()); 
		size--;
		return true;
	}
	
	@Override
	public Iterator iterator() {
		return new Iterator()
				{
					int count = 0;
					@Override
					public boolean hasNext() {
						return count < size;
					}

					@Override
					public Object next() {
						if(!hasNext())
						{
							throw new NoSuchElementException();
						}
						return getElement(count++);
					}
					
				};
	}
}
