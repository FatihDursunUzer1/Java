package myLinkedList;

public class LinearProb {
	String [] dizi;
	int size;
	
	public LinearProb(int size)
	{
		dizi=new String[size];
		this.size=size;
	}
	
	public void add(int key,String deger)
	{
		int a=0;
		if(dizi[hashCode(key)]==null)
			dizi[hashCode(key)]=deger;
		else if(dizi[hashCode(key)]!=null)
		{
			for(int i=hashCode(key)+1;i<size;++i)
			{
				if(dizi[i]==null)
				{
					a++;
					dizi[i]=deger;
					break;
				}
			}
			 if(a==0)
			   {
				for(int i=0;i<hashCode(key);++i)
				{
					if(dizi[i]==null)
					{
						dizi[i]=deger;
						break;
					}
				}
			  }
	     }
		
		
	}
	
	
	public int hashCode(int key)
	{
		return (key)% this.size;
	}
	
	public static void main(String args[])
	{
		LinearProb yeni=new LinearProb(10);
		yeni.add(10, "Deneme");
		yeni.add(20, "Deneme1");
		yeni.add(59, "fdu");
		yeni.add(69, "xxx");
		for(int i=0;i<yeni.dizi.length;++i)
		{
			System.out.println(yeni.dizi[i]);
		}
	}

}
