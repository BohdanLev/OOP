import java.io.Serializable;

public class Node<T> implements Serializable
	{
		 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private T data;
		private Node<T> next;
		
		public Node()
		{
			
		}
		
		public Node(T data)
		{
			this.data = data;
		}
		public Node<T> getNext()
		{
			return next;
		}
		public T getData()
		{
			return data;
		}
		public void setNext(Node<T> next)
		{
			this.next = next;
		}
		public void setData(T data)
		{
			this.data = data;
		}
	}
