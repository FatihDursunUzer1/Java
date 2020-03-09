

public class myLinkedList<T>
{
	Node head;
	Node tail;
	
	public myLinkedList(T key)
	{
	  head=new Node(key);
	  tail=head;
	}
	
	public class Node
	{
		Node next=null;
		Node prev=null;
		T key;
		
		public Node(T key)
		{
			this.key=key;
		}
	}
	
	public void basaEkle(T key)
	{
	  Node yeni=new Node(key);
	  yeni.next=head;
	  if(head!=null)
		  head.prev=yeni;
	  //tail=head;
	  head=yeni;
	  //yeni.prev=null;
	  head.prev=null;
	}
	
	public void sonaEkle(T key)
	{
		Node yeni=new Node(key);
		tail=head;
		if(tail!=null)
		{
			tail=tail.next;
		}
		tail=yeni;
	}
	
	public Node search(T key)
	{
		tail=head;
		while(tail!=null && tail.key!=key)
			tail=tail.next;
		return tail;
	}
	
	public static void main(String args[])
	{
		myLinkedList<Integer> yeni=new myLinkedList<Integer>(50);
		
		yeni.basaEkle(34);
		yeni.sonaEkle(44);
		yeni.basaEkle(45);
		System.out.println(yeni.head.key);
		System.out.println(yeni.tail.key);
		yeni.search(44);
		
	}
	
}
	
