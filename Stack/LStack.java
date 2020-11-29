import java.util.Scanner;

class LStack<E> implements Stack<E>
{
    // globals
	public Node head = null;    
    public Node tail = null; 
	public int size = 0;
	// nested class ( static if the child class has nothing to do with the parent class )
	static class Node<E>
	{   
		// instance
        private E data;    
        private Node<E> next;
        // constructor 
        public Node(E dt) 
		{    
            this.data = dt;    
            this.next = null;
        }
		// getters
		public E getData() {return this.data;}
		public Node<E> getNext() {return this.next;}
		// setters
		public void setData(E dt)
		{
			this.data = data;
		}
		public void setNext(Node nxt)
		{
			this.next = nxt;
		}
	}
	// main class methods
	public void addfirst(E data)
	{
		// create new node
		Node newnode = new Node(data);
		// if head is empty list is empty
		if (head == null) 
		{
			head = newnode;
			tail = newnode;
		}
		// set next node in tail
		else
		{
			tail.setNext(newnode);
			tail = newnode;
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
	// traverse all ndoe
	public void printall() 
	{      
		Node current = this.head; 
		while(current != null) 
		{       
            System.out.print(current.getData() + " ");    
            current = current.getNext();    
        }    
        System.out.println();    
    }
	// traverse and count all
	public int getSize() 
	{
		Node current = this.head;
		while(current != null)
		{
			size++;
			current=current.getNext();
		}
		return size;
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
			size--;
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
	public E getTop()
	{
		Node teyl = this.tail;
		E e = (E) teyl.getData();
		return e;
	}
	public E pop()
	{
		//System.out.println(this.size);
		Node prev = this.head;
		E e = (E) this.tail.getData();
		int n = this.getSize() - 2;
		for (int i = 0; i < n; i++)
		{
			//System.out.println(n + "*");
			//System.out.println(prev.getData());
			prev = prev.getNext();
		}
		prev.setNext(null);
		this.tail = prev;
		this.size--;
		return e;
	}
	public void push(E num)
	{
		this.addlast(num);
	}
    public static void main (String[] args)
    {
        LStack<Integer> ls = new LStack<Integer>();
		ls.addlast(1);
		ls.addlast(2);
		ls.removeFirst();
		ls.addlast(3);
		ls.addfirst(1);
		ls.addlast(4);
		ls.addlast(5);
		ls.push(6);
		System.out.println(ls.getTop());
		System.out.println("Removing: " + ls.pop());
		//ls.removeFirst();
		//ls.addlast(4);
		ls.printall();
		//System.out.println(ls.getSize());
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
		System.out.println(stack.pop());*/
    }
}
