import java.util.Scanner;

//FIFO
public class Deque<E> implements Queue<E>
{
    private E arr[];
    private int top;
    private int size;
	private int n_size;
	private E tmp_arr[];
	private int f;
	private int b;
    public Deque(int size)
    {
		this.arr = (E[]) new Object [size];
		this.tmp_arr = (E[]) new Object [size--];
        this.size = size;
		this.n_size = 0;
        this.top = -1;
		this.f = -1;
		this.b = -1;
	}
	// MANIPULATORS
	// last in
	// insert front
    public void enQBack(E num)
    {
		// todo: check if full
		// check if empty
		if(this.f == -1)
		{
			this.f = 0;
			this.b = 0;
		}
		// points first pos.
		else if(this.f == 0)
		{
			this.f = this.size;
		}
		else
		{
			--this.f;
		}
		
		this.arr[this.f] = num;
    }
	public void enQ(E num)
    {
        // todo: check if full
		// check if empty
		if(this.f == -1)
		{
			this.f = 0;
			this.b = 0;
		}
		// points first pos.
		else if(this.b == this.size-1)
		{
			this.b = 0;
		}
		else
		{
			++this.b;
		}
		this.arr[this.b] = num;
    }
    // pop b
    public E deQFront()
    //public int deQ(E[] arr, int indx, int curr_size)
    {
		E pos_val = this.arr[this.b];
		this.arr[this.b] = this.arr[(this.b + 1)%this.size];
		this.arr[this.b] = null;
		//this.f = (this.b + 1) % this.size;
		//this.size--;
		if(this.f == this.b)
		{
			this.f = -1;
			this.b = -1;
		}
		else if(this.b == 0)
		{
			this.b = this.size - 1;
		}
		else
		{
			--this.b;
		}
		return pos_val;
		/*int sz = this.size--;
		E[] genArr = (E[]) this.arr;
		this.printAll();
		return genArr;*/
    }
	// pop f
	public E deQ()
    {
		//System.out.println(this.f + "..");
		E tmp_val = this.arr[this.f];
		this.arr[this.f] = null;
		if(this.f == this.b)
		{
			this.f = - 1;
			this.b = - 1;
		}
		else if(this.f == this.size - 1)
		{
			this.f = 0;
		}
		else
		{
			++this.f;
		}
		return tmp_val;
    }
	public E getTop()
    {
		for (int i = 0; i < this.size; i++)
		{
			if (this.arr[i] == null)
			{
				return this.arr[i];
			}
			i++;
		}
		return null;
    }
	// ACCESSORS
    public int getSize()
    {
        return this.n_size;
    }
    public boolean isEmpty()
    {
        return this.top == -1;
    }
	public void printAll()
	{
		for(E each: this.arr)
		{
			System.out.println(each);
		}
	}
    public static void main (String[] args)
    {
		Deque<Integer> qq = new Deque<Integer>(10);
		qq.enQ(1);
		qq.enQ(2);
		qq.enQ(3);
		//qq.enQBack(3);
		//qq.printAll();
		//System.out.println("Removing: " + qq.deQ());
		//System.out.println("Removing: " + qq.deQFront());
		System.out.println("Removing: " + qq.deQ());
		System.out.println("Removing: " + qq.deQFront());
		//System.out.println("Removing: " + qq.deQ());
		
		System.out.println("Top: " + qq.getTop());
		//System.out.println("Size: " + qq.getSize());
		//qq = qq.deQ(0, qq.getSize());
		//qq.deQ();
		//qq.deQ();
		//qq.enQ(1);
		//System.out.println("Removing: " + qq.deQFront());
		qq.printAll();
	}
}