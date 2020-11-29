import java.util.Scanner;
import java.util.Arrays;

public class DLL<E> implements Stack<E>
{	
	public Node head = null;    
    public Node tail = null; 
	// touch base for DLL getters and setters are for referencing
	// nested class ( static if the child class has nothing to do with the parent class )
	static class Node<E>
	{   
		// instance
        private E data;
        private Node<E> previous;
        private Node<E> next;
		private int size;
        // constructor 
        public Node(E dt) 
		{    
            this.data = dt;
			this.size = 0;
        }
		// getters
		public E getData() {return this.data;}
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
	// main class methods
	public void addfirst(E data)
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
	public void addlast(E data) 
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
	// traverse all
	public void printall() 
	{      
		Node current = head; 
		while(current != null) 
		{       
            System.out.print(current.getData() + " ");    
            current = current.getNext();    
        }    
        System.out.println();    
    }
	// traverse and count all
	public int calculateSize(Node nd_head) 
	{
		int sz = nd_head.getSz();
		Node hd_head = this.head;
		while(hd_head != null)
		{
			sz++;
			hd_head=hd_head.getNext();
		}
		nd_head.setSz(sz);
		return sz;
	}
	// re-assignment of the next head to the current head for removal
	public void removeFirst()
	{
		if (this.head==null)
		{
			System.out.print("Least is empty in the first place"); 
		}
		else
		{
			this.head = this.head.getNext();
			int sz = this.head.getSz();
			this.head.setSz(sz - 1);
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
	public Object first()
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
	public Object last()
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
	// gets another linked list for comparison
	public boolean isEqual(DLL nd)
	{
		// assigns head then traverse each
		Node node = this.head;
		Node param_node = nd.head;
		while( node != null && param_node != null)
		{
			if (node.getData() != param_node.getData())
			{
				return false;
			}
			node = node.getNext();
			param_node = param_node.getNext();
		}
		// if reached the last node with a value of a null, will then return true
		return ( node == null && param_node == null);
	}
	// traverse and count all
	public int getSize() 
	{
		Node hd = this.head;
		return this.calculateSize(hd);
	}
	public void push(E num)
	{
		this.addlast(num);
	}
	public E pop()
	{
		//System.out.println(this.size);
		Node prev = this.head;
		E e = (E) this.tail.getData();
		int n = this.getSize() - 1;
		for (int i = 0; i < n; i++)
		{
			//System.out.println(n + "*");
			//System.out.println(prev.getData());
			prev = prev.getNext();
		}
		prev.setNext(null);
		this.tail = prev;
		//int sz = this.getSize();
		//prev.setSize(sz--);
		return e;
	}
	public E getTop()
	{
		Node teyl = this.tail;
		E e = (E) teyl.getData();
		return e;
	}
	public static void main(String[] args) 
	{
		DLL dl = new DLL();
		DLL dl2 = new DLL();
		dl.addfirst(1);
		dl.addfirst(2);
		dl.addfirst(3);
		dl.removeFirst();
		dl.printall();
		
		/*dl2.addfirst(2);
		dl2.addfirst(3);
		dl2.addlast(4);
		dl2.printall();
		System.out.println(dl.isEqual(dl2));*/
		
		dl.push(6);
		System.out.println("Removing: " + dl.pop());	
		System.out.println(dl.getTop());
		dl.printall();
		
		
		// Singly test cases
		/*System.out.println(s.isEmpty()); 
        s.addfirst(1);    
        s.addfirst(2); 
		s.removeFirst();
        s.addfirst(4); 
		s.addlast(10);
		s.addfirst(12);
		System.out.println("First Item " + s.first()); 
		System.out.println("Last Item " + s.last()); 
		
		
		System.out.println(s.size()); 
		
		s.printall();
		System.out.println(s.isEmpty()); */
	}
}