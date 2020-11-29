import java.util.Scanner;
import java.util.Arrays;

public class ArrayCursor<E> implements Iterable<E>
{	
	private class ArrayIterator<E> implements Iterator<E>
	{   
		private int i = 0;
		private bool r=false;
		public bool hasNext()
		{
			return i<size;
		}
		public E next()
		{
			if(i==size)
			{
				r=true;
				return data[i++];
			}
		}
		public void remove() // throw exception
		{
			if(!r)
			{
				ArrayList.this.remove(i-1);
				i--;
				r=false;
			}
		}
		public Iterator<E> iterator()
		{
			return new ArrayIterator();
		}
	}
	public static void main(String[] args) 
	{
		
	}
}