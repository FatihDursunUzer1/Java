

public class arrayBasedList {
	Integer [] dizi;
	int numberOfElements;
	int maxCapacity;
	
	
	public arrayBasedList(int maxCapacity)
	{
		this.maxCapacity=maxCapacity;
		numberOfElements=0;
		dizi=new Integer[this.maxCapacity];
	}
	
	public void add(int e)
	{
		if(numberOfElements<maxCapacity)
		{
			this.dizi[numberOfElements]=e;
			numberOfElements++;
		}
	}
	
	public void remove(int e)
	{
		int a=0;
		int b=0;
		for(int i=0;i<numberOfElements;++i)
		{
			if(dizi[i]==e)
			{
				a=i;
				numberOfElements--;
				break;
			}
		}
		for(int i=0;i<numberOfElements;++i)
		{
			if(i!=a)
			dizi[i]=dizi[b];
			else
			{
				dizi[i]=dizi[b+1];
				b++;
			}
			b++;	
		}
  dizi[numberOfElements]=null;
	}
	
	public static void main(String args[])
	{
		arrayBasedList a=new arrayBasedList(15);
		a.add(5);
		a.add(10);
		a.add(44);
		
		System.out.println(a.dizi[2]);
		System.out.println(a.dizi[0]);
		System.out.println(a.dizi[1]);
		System.out.println(a.dizi[2]);
		System.out.println(a.dizi[3]);

	}

}
