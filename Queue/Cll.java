import java.util.Scanner;
import java.util.Arrays;

public class Cll<E>
{
	// globals   
    public Node head = null;  
    public Node tail = null;  
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
        }
		// getters
		public E getData() {return this.data;}
		// setters
		public void setData(E dt)
		{
			this.data = data;
		}
	}
	// main class method
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
	// the usual traversal
	public void printall() 
	{   
		Node current = this.head;
		do
		{       
            System.out.print(current.getData() + " ");    
            current = current.next;    
        }while(current != this.head);  
        System.out.println();    
    }    
	
	
	public static void main(String[] args) 
	{
		Cll<Integer> cl = new Cll<Integer>();
        cl.addfirst(1);   
        cl.addfirst(2);   
        cl.addfirst(3);   
		cl.deletenode();
		cl.printall();
		//cl.deletenode();
	}
}