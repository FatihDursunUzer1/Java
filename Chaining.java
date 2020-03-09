package denemeler;

public class Chaining {
	Node [] hash;
	Node 
	int size;
	Node head;
	
	
	class Node
	{
		Node next;
		Object key;
		Object value;
		public Node()
		{
			key=null;
			value=null;
			next=null;
		}
		
		public Node(int key, int value)
		{
			this.key=key;
			this.value=value;
			next=null;
		}
	}
	
	public Chaining(int elemanSayisi)
	{
		hash=new Node[elemanSayisi];
	}
	
	public void add(int key, int value)
	{
		Node head=hash[hashKodu(key)];
		hash[hashKodu(key)]=new Node(key,value);
		while(head!=null)
		{
			head=head.next;
		}
		Node x=head;
		head=new Node(key,value);
		x.next=head;
		
	}
	
	
	public int hashKodu(int key)
	{
		return key%hash.length;
	}
	
	public static void main(String args [])
	{
		Chaining linkedlist=new Chaining(10);
		linkedlist.add(10, 1);
		linkedlist.add(20, 4);
		System.out.println(linkedlist.hash[0].key);
		System.out.println(linkedlist.hash[0].next.key);
	}

}
