import java.util.Scanner;
import java.util.Arrays;

public class LCL<E> implements CPL<E>
{	
	// sentinels
	public Node<E> head = null;
    public Node<E> tail = null;
	private int size=0;
	public LCL()
	{
		this.head = new Node<E>(); // 3 params element - before cursor - after cursor
		this.tail = new Node<E>(); // 3 params element, head, tail
		this.head.setNext(this.tail);
	}
	private static class Node<E> implements Cursor<E>
	{   
        private E data;
        private Node<E> previous;
        private Node<E> next;
        // constructor 
        public Node(E dt, Node<E> previous, Node<E> next) 
		{    
            this.data = dt;
			this.previous = previous;
			this.next = next;
        }
		// getters
		public E getData() 
		{
			if (this.next == null)
				System.out.println("blank");
			return data;
		}
		public Node<E> getPrev() {return this.previous;}
		public Node<E> getNext() {return this.next;}
		public int getSz() {return this.size;}
		// setters
		public void setData(E dt)
		{
			this.data = data;
		}
		public void setPrev(Node prev)
		{
			this.previous = prev;
		}
		public void setNext(Node nxt)
		{
			this.next = nxt;
		}
		public void setSz(int sz)
		{
			this.size = sz;
		}
	}
	public Cursor<E> before(Cursor<E> c)
	{
		
	}
	public Cursor<E> after(Cursor<E> c)
	{
		
	}
	// UTILS
	// wraps cursor to node instance ( cursor -> node )
	private Node<E> validate(Cursor<E> c)
	{
		if(!(c instanceof Node))
		{
			Node<E> node = (Node<E>) C; // cast
		}
		if(node.getNext() == null)
		{
			return node;
		}
	}
	// to return node to cursor
	private Cursor<E> cursor(Node<E> node)
	{
		if(node==this.head || node==this.tail)
			return null;
		return node;
	}
	public E set(Cursor<E> c, E e);
	{
		System.out.print("asd");
	}
	// MAIN CLASS METHODS
	private Cursor<E> addBetween(E e, Node<E> prev, Node<E> next)
	{
		Node <E> latest = new Node<E>(e, prev, next);
		prev.setNext(latest);
		next.setPrev(latest);
		this.size++;
		return latest;
	}
	public E remove(Cursor<E> c)
	{
		Node <E> node = this.validate(c);
		Node <E> prev = node.getPrev();
		Node <E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		this.size--;
		E ans = node.getData();
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
	}
	public Cursor<E> addfirst(Cursor<E> e)
	{
		// create new node
		Node newnode = new Node(data);
		// if head is empty list is empty
		if (this.head == null) 
		{
			this.head = newnode;
			this.tail = newnode;
			// null assignments to determine the boundaries or not quite sure if this is the sentinels.
			this.head.setPrev(null);
			this.tail.setNext(null);
		}
		else
		{
			// will be set after tail
			this.tail.setNext(newnode);
			// with the new set previous setting tails will be much more easier.
			newnode.setPrev(this.tail);
			// value of newnode to the tail
			this.tail = newnode;
			// lastly is the null
			tail.setNext(null);
		}
	}
	// add in last address
	public Cursor<E> addlast(Cursor<E> e) 
	{    
        Node newnode = new Node(data);
		// created newnode that points the last tail to null which is the next ref_head
		newnode.setNext(null);
        // if head is empty list is empty
        if(head == null) {     
            head = newnode;    
            tail = newnode;    
        }
		// set current tail node to the newnode
        else 
		{
            tail.setNext(newnode);     
            tail = newnode;    
        }    
    }
	// check if head is null
	public boolean isEmpty()
	{
		if (this.head == null)
		{
			return true;
		}
		return false;
	}
	// amazeballs tried object and node as a return type..
	// same concept as removeFirst
	public Cursor<E> first()
	{
		Node curr = this.head;
		if (this.head == null)
		{
			return null;
		}
		else
		{
			return curr.getData();
		}
	}
	// addlast same concept
	public Cursor<E> last()
	{
		Node teyl = this.tail;
		if (this.head == null)
		{
			return null;
		}
		else
		{
			return teyl.getData();
		}
	}
	public Cursor<E> addafter(Cursor<E> c, E e)
	{
		System.out.print("asd");
	}
	public Cursor<E> addbefore(Cursor<E> c, E e)
	{
		System.out.print("asd");
	}
	public static void main(String[] args) 
	{
		
	}
}