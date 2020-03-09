

public class RollingHash {
	int Q;
	int RM1;
	int hash;
	String x;
	final int R=31;
	int m;
	
	public RollingHash(int m, int Q)
	{
		this.m=m;
		hash=0;
		this.Q=Q;
		x="";
		RM1=(int) Math.pow(R, m-1);
	}
	
	public void append(char c)
	{
		x=x+c;
		hash=(hash*R+c)%Q;
	}
	
	public void skip()
	{
		hash=(hash+Q-x.charAt(0)*RM1%Q)%Q;
		x=x.substring(1);
	}
	
	public int getHash()
	{
		return hash;
	}

	public static void main(String args[])
	{
		String a="Fatih Dursun Uzer";
		String b="ur";
		RollingHash yeni=new RollingHash(b.length(),997);
		RollingHash yenii=new RollingHash(b.length(),997);
		for(int i=0;i<b.length();++i)
		{
			yeni.append(b.charAt(i));
			yenii.append(a.charAt(i));
		}
		
		if(yeni.getHash()==yenii.getHash())
		{
			System.out.println("Hash ler esit");
			return;
		}
		for(int i=b.length();i<a.length();++i)
		{
			yenii.skip();
			yenii.append(a.charAt(i));
			if(yeni.getHash()==yenii.getHash())
			{
				System.out.println("Bu Hashler esit.");
				return;
			}
		}
		
		
		
	}
}
