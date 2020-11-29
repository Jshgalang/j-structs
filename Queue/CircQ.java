import java.util.Scanner;
import java.util.Arrays;

public class CircQ<E> implements Queue<E>
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
	}
	public void addfirst(E data)
	{
		// instantiate new node wt data
		Node newnode = new Node(data);
		// first value to fill head and tail
		if(this.head == null) 
		{  
			this.head = newnode;
            this.tail = newnode;  
            newnode.next = this.head;  
		} 
        else 
		{
			// assign new node as new tail and point reference
			this.tail = newnode;  
            this.tail.next = newnode;   
            // the reference of the last tail will always be the head thus circular 
            this.tail.next = head;  
        } 
	}
	public void deletenode() 
	{   
		// to ensure list has > 2 nodes
        if(this.head != this.tail)
		{
			// check the next head for reference
			this.head = this.head.next;
			// the tail will be the new head ( the importance of visualization )
			this.tail.next = this.head;
		}
		// exception if list only has one node
		else
		{
			this.head = null;
			this.tail = null;
		}
    }
	public void printAll() 
	{   
		Node current = this.head;
		System.out.println(this.head.getData()); 
		System.out.println(this.getSize()); 
		/*do
		{       
            System.out.print(current.getData() + " ");    
            current = current.getNext(); 
			if (current == this.tail)
			{
				System.out.println("True");
			}
			else
				System.out.println("False");			
        }while(current != null);  */
        System.out.println(); 
		/*
		Node current = head; 
		while(current != null) 
		{       
            System.out.print(current.getData() + " ");    
            current = current.getNext();    
        }    
        System.out.println();  
		
		Node current = this.head;
		System.out.println(current.getData()); 
		do
		{       
            System.out.print(current.getData() + " ");    
            current = current.next;    
        }while(current != this.tail);  
		*/
    }    
	public E getTop()
	{
		E e = (E) this.tail.getData();
		return e;
	}
	public E deQ()
	{
		E e = (E) new Node(null);
		return e;
	}
	public void enQ(E num)
	{
		System.out.print("josh");   
	}
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
	public boolean isEmpty()
	{
		if (this.head == null)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) 
	{
		CircQ<Integer> cll = new CircQ<Integer>();
        cll.addfirst(1);   
        cll.addfirst(2);   
        cll.addfirst(3);   
        cll.addfirst(4);   
		cll.deletenode();
		cll.printAll();
		//cl.deletenode();
	}
}