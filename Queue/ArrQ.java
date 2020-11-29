import java.util.Scanner;

class ArrQ<E> implements Queue<E>
{
    private E arr[];
    private int top;
    private int size;
	private int n_size;
	private E tmp_arr[];
	private int f;
	private int b;
    public ArrQ(int size)
    {
		this.arr = (E[]) new Object [size];
		this.tmp_arr = (E[]) new Object [size--];
        this.size = size;
		this.n_size = 0;
        this.top = -1;
		this.f = 0;
		this.b = -1;
	}
	// MANIPULATORS
	// last in
    public void enQ(E num)
    {
        //this.arr[++this.top] = num;
		this.b = (this.b + 1) % this.size;
		//System.out.println(this.b + "*");
		this.arr[b] = num;
		this.n_size++;
		this.size++;
    }
    // first out
    public E deQ()
    //public int deQ(E[] arr, int indx, int curr_size)
    {
		E pos_val = this.arr[this.f];
		//System.out.println(this.f + "*");
		this.arr[this.f] = this.arr[(this.f + 1)%this.size];
		this.arr[this.f] = null;
		this.f = (this.f + 1) % this.size;
		this.size--;
		return pos_val;
		
		/*int sz = this.size--;
		E[] genArr = (E[]) this.arr;
		this.printAll();
		return genArr;*/
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
		ArrQ<Integer> qq = new ArrQ<Integer>(10);
		ArrQ<Integer> qq1 = new ArrQ<Integer>(5);
		qq.enQ(12);
		qq.enQ(6);
		qq.enQ(9);
		//qq.printAll();
		//System.out.println("Top: " + qq.getTop());
		//System.out.println("Size: " + qq.getSize());
		//qq = qq.deQ(0, qq.getSize());
		qq.deQ();
		qq.deQ();
		qq.enQ(1);
		qq.printAll();
	}
}