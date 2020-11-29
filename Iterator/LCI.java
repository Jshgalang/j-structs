import java.util.Scanner;
import java.util.Arrays;
// Iterator always return the Iterable instance element
public class LCI<E>
{	
	// sentinels
	public Node<E> head = null;
    public Node<E> tail = null;
	private int size=0;
	public LCI()
	{
		this.head = new Node<E>(); // 3 params element - before cursor - after cursor
		this.tail = new Node<E>(); // 3 params element, head, tail
		this.head.setNext(this.tail);
	}
	private static class Node<E>
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
	// UTILS
	// wraps cursor to node instance ( cursor -> node )
	private Node<E> validate(Cursor<E> c)
	{
		if(!(c.instanceof(Node)))
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
	public boolean isEqual(Cursor<E> nd)
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
		
	}
}