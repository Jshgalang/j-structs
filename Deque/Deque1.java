import java.util.Scanner;

class Deque1<E> implements Queue<E>
{
    private E arr[];
    private int top;
    private int size;
	private int n_size;
	private E tmp_arr[];
	private int f;
	private int b;
    public Deque1(int size)
    {
		this.arr = (E[]) new Object [size];
		this.tmp_arr = (E[]) new Object [size--];
        this.size = size;
		this.n_size = 0;
        this.top = -1;
		this.f = 0;
		this.b = 0;
	}
	// MANIPULATORS
	// last in
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
		else if(this.f == 0)
			this.f = this.size - 1;
		else
			this.f--;
		
		this.arr[this.f] = num;
    }
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
		else if(this.b == this.size-1)
			this.b = 0;
		else
			this.b++;
		
		this.arr[this.f] = num;
    }
    // first out
    public E deQ()
    //public int deQ(E[] arr, int indx, int curr_size)
    {
		E pos_val = this.arr[this.f];
		this.arr[this.f] = this.arr[(this.f + 1)%this.size];
		this.printAll();
		this.arr[this.f] = null;
		//this.f = (this.f + 1) % this.size;
		this.size--;
		return pos_val;
		
		/*int sz = this.size--;
		E[] genArr = (E[]) this.arr;
		this.printAll();
		return genArr;*/
    }
	public E deQBack()
    {
		if(this.isEmpty())
        {
			return null;
        }
        return this.arr[this.top--];
    }
	public E getTop()
    {
        if (!this.isEmpty())
		{
            return this.arr[this.top];
		}	
        else
		{
            return null;
		}
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
		Deque<Integer> qq1 = new Deque<Integer>(5);
		qq.enQ(12);
		qq.enQ(6);
		qq.enQ(9);
		//qq.printAll();
		//System.out.println("Top: " + qq.getTop());
		//System.out.println("Size: " + qq.getSize());
		//qq = qq.deQ(0, qq.getSize());
		//System.out.println("Removing: " + qq.deQ());
		qq.deQ();
		qq.enQ(1);
		//System.out.println("Removing: " + qq.deQBack());
		qq.printAll();
	}
}