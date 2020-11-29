import java.util.Scanner;

public interface CPL<E>
{
	int size();
	boolean isEmpty();
	Cursor<E> first();
	Cursor<E> last();
	Cursor<E> before(Cursor<E> c); // or throw exception // validate first the node
	Cursor<E> after(Cursor<E> c); // or throwexception
	Cursor<E> addfirst(Cursor<E> e);
	Cursor<E> addlast(Cursor<E> e);
	Cursor<E> addbefore(Cursor<E> c, E e);
	Cursor<E> addafter(Cursor<E> c, E e);
	E set(Cursor<E> c, E e); // throw exception
	E remove(Cursor<E> c);
}