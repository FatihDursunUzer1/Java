package myLinkedList;

public class myStack<T> {
	Node top;
	int size;
	
	class Node
	{
		Node prev;
		T key;
		public Node(T key)
		{
			this.key=key;
			prev=null;
		}
	}
	
	public myStack(T e)
	{
		top=new Node(e);
		size++;
	}
	
	public void add(T key)
	{
		Node newTop=new Node(key);
		newTop.prev=top;
		top=newTop;
	}
	
	public T pop()
	{
		Node oldTop=top;
		top=oldTop.prev;
		
		return oldTop.key;
	}
	
	public boolean isEmpty()
	{
		if( size==0)
			return true;
		return false;
	}
	public static void main(String args[])
	{
		myStack<Integer> a=new myStack<Integer>(50);
		a.add(58);
		System.out.println(a.top.prev.key);
		
	}

}
