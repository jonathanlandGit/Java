package A_ReverseSinglyLL;

public class ReverseSinglyLL<T> 
{
	//beginning node
	private Node<T> head;

	//method to add an element (generics)
	public void add(T element) 
	{
		//create new node object
		Node<T> nd = new Node<T>();
		
		//pass the parameter to node object to add
		nd.setValue(element);
		
		//print statement that it's added
		System.out.println("Adding the element: " + element);
		
		//now set a temp var to first node
		Node<T> tmp = head;
		
		//while something is added, keep on putting in list
		while (true) 
		{
			if (tmp == null) 
			{
				// since there is only one element, both head and
				// tail points to the same object.
				head = nd;
				break;
			} 
			
			else if (tmp.getNextRef() == null) 
			{
				tmp.setNextRef(nd);
				break;
			} 
			
			else 
			{
				tmp = tmp.getNextRef();
			}
		}
	}

	//method to traverse
	public void traverse() 
	{
		Node<T> tmp = head;
		
		while (true) 
		{
			if (tmp == null) 
			{
				break;
			}
			System.out.print(tmp.getValue() + "\t");
			tmp = tmp.getNextRef();
		}
	}

	public void reverse() 
	{
		System.out.println("\nreversing the linked list\n");
		
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next = null;
		
		while (current != null) 
		{
			next = current.getNextRef();
			current.setNextRef(prev);
			prev = current;
			current = next;
		}
		
		head = prev;
	}

	public static void main(String a[]) 
	{
		ReverseSinglyLL<Integer> sl = new ReverseSinglyLL<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		System.out.println();
		sl.traverse();
		System.out.println();
		sl.reverse();
		sl.traverse();
	}
}

class Node<T> implements Comparable<T> 
{
	private T value;
	private Node<T> nextRef;

	public T getValue() 
	{
		return value;
	}

	public void setValue(T value) 
	{
		this.value = value;
	}

	public Node<T> getNextRef()
	{
		return nextRef;
	}

	public void setNextRef(Node<T> ref) 
	{
		this.nextRef = ref;
	}

	@Override
	public int compareTo(T arg) 
	{
		if (arg == this.value) 
		{
			return 0;
		} 
		
		else 
		{
			return 1;
		}
	}
}