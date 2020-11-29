import java.util.Scanner;

class ArrStack<E> implements Stack<E>
{
    private E arr[];
    private int top;
    private int size;
	private int n_size;
	private E tmp_arr[];
    public ArrStack(int size)
    {
        this.arr = (E[]) new Object [size];
        this.size = size;
		this.n_size = 0;
        this.top = -1;
    }
	// MANIPULATORS
	// last in
    public void push(E num)
    {
		if(this.top == this.size - 1)
		{
			System.out.println("Full stacked!");
            System.exit(0);
		}
		this.n_size += 1;
        this.arr[++this.top] = num;
    }
    // first out
    public E pop()
    {
        if(this.isEmpty())
        {
			return null;
        }
        return this.arr[this.top--];
    }
	// ung last na ma pop un ung first
	// new hack void return 'literally returns nothing == system.exit only in a method
	public <E> void reversal(Stack<E> stck)
	{
		if(this.isEmpty())
		{
			return;
		}
		E bot = this.popBot(stck);
		reversal(stck);
		stck.push(bot);
	}
	// second hack Object E with a return type of E
	public <E> E popBot(Stack<E> stck)
	{
		E top = stck.pop();
		if(this.isEmpty())
		{
			return top;
		}
		else
		{
			E bot = this.popBot(stck);
			stck.push(top);
			return bot;
		}
	}
	public boolean equation_check(Stack<Character> eq, String str_eval)
	{
		for(int i=0;i<str_eval.length();i++)
		{
			char ch = str_eval.charAt(i);
			System.out.println(ch);
			if (ch == '(' || ch == '{' || ch == '[')
			{
				eq.push(ch);
			}
			// check closing
			if (ch == ')' || ch == '}' || ch == ']')
			{
				eq.pop();
			}
		}
		return eq.isEmpty();
	}
	// ACCESSORS
	public E[] getArr()
	{
		return this.arr;
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
    public int getSize()
    {
        return this.n_size;
    }
    public boolean isEmpty()
    {
        return this.top == -1;
    }
    public static void main (String[] args)
    {
        ArrStack<Integer> stack = new ArrStack<Integer>(10);
        ArrStack<Character> stack1 = new ArrStack<Character>(10);
		stack.push(123);
		stack.pop();
		stack.push(456);
		stack.push(123);
		stack.push(23);
		System.out.println("Top: " + stack.getTop());
		stack.reversal(stack);
		System.out.println("Top: " + stack.getTop());
		//System.out.println(stack.equation_check(stack1, "[(5+x)-(y+z)]"));
		/*System.out.println("No. of Elements: " + stack.getSize());
		System.out.println(stack.pop());
		if(stack.isEmpty())
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		System.out.println(stack.pop());
		if(stack.isEmpty())
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		System.out.println(stack.pop());
		stack.push(7);
		stack.push(9);
		System.out.println("Top: " + stack.getTop());
		stack.push(4);
		System.out.println("No. of Elements: " + stack.getSize());
		System.out.println(stack.pop());
		stack.push(6);
		stack.push(8);
		System.out.println(stack.pop());*/
    }
}
