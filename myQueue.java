

public class myQueue {
	Node front;
	Node back;
	int size;
	
	class Node
	{
		Node next;
		Node prev;
		int key;
		
		public Node(int key)
		{
			this.key=key;
			next=null;
			prev=null;
		}
	}
	
	public myQueue(int key)
	{
		front=new Node(key);
		back=front;
	}
	
	public void add(int key)
	{
		Node yeni=new Node(key);
		back.next=yeni;
		yeni.prev=back;
		back=yeni;
		size++;
	}
	
	public void remove()
	{
		front.next.prev=null;
		front=front.next;
		size--;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	public static void main(String [] args)
	{
		myQueue a=new myQueue(5);
		a.add(50);
		a.add(70);
		a.remove();
		a.remove();
		System.out.println(a.back.key);
		System.out.println(a.front.key);
	}
	
}
