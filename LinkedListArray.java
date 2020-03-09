package denemeler;

import java.util.LinkedList;

public class LinkedListArray {
	LinkedList<Integer> [] dizi;
	int size;
	public LinkedListArray(int size)
	{
		this.size=size;
		dizi[0].add(10);
	}
	
	public int hashCode(int x)
	{
		return x%dizi.length;
	}
	
	public boolean put(int key,int value)
	{
		dizi[hashCode(key)].add(value);
		return true;
	}
	
	public static void main(String args[])
	{
		LinkedListArray a = new LinkedListArray(10);
		a.put(10, 20);
		a.put(10,30);
		
	}

}
