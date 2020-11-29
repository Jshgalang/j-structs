import java.util.Scanner;

public interface Queue<E>
{
	E getTop();
	E deQ();
	void enQ(E num);
	boolean isEmpty();
	int getSize();
	void printAll();
}