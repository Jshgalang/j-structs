import java.util.Scanner;

public interface Stack<E>
{
	E getTop();
	E pop();
	void push(E num);
	boolean isEmpty();
	int getSize();
}