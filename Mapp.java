package denemeler;

import java.util.*;


public class Mapp<K,V>
{
	Node head;
	Node front;
	int size;
	public Mapp(K key,V value)
	{
		head=new Node(key,value);
		front=head;
		size++;
	}
	
	private class Node
	{
		Node next;
		K key;
		V value;
		public Node(K key, V value)
		{
			this.key=key;
			this.value=value;
			next=null;
		}
	}
	
	public void add(K key, V value)
	{
		if(size==0)
		{
			head=new Node(key,value);
		    front=head;
		}
		else
		{
			if(containsKey(key))
			{
				front.value=value;
			}
			else
			front=new Node(key,value);
			
		}
	}
	
	public boolean containsKey(K key)
	{
		head=front;
		while(front!=null)
		{
			if(front.key==key)
				return true;
			front.next=front;
		}
		return false;
	}
	
	public V get(K key) throws Exception
	{
		if(containsKey(key))
			return front.value;
		throw new Exception("KEY BULUNAMADI!Keyi bulamadýðýnda bir deðer döndüremeyeceði için Value degeri alamadiniz");
	}
	
	public void remove(K key)
	{
		if(containsKey(key))
			front=null;
	}
	
	public static void main(String [] args)
	{
		try
		{
		Mapp<Integer,Integer> a=new Mapp<Integer,Integer>(5,10);
		System.out.println(a.front.key);
		System.out.println(a.front.value);
		a.add(5, 30);
		System.out.println(a.front.key);
		System.out.println(a.front.value);
		System.out.println(a.get(5));
		a.remove(5);
		System.out.println(a.get(5));
		}
		
		catch(Exception a)
		{
			System.out.println("KEY BULUNAMADI!Keyi bulamadýðýnda bir deðer döndüremeyeceði için Value degeri alamadiniz");
		}
	}
}