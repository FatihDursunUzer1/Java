package denemeler;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
public class Password {
	HashMap<Integer,String> yeni;
	int RM1;
	final int R=31;
	final int Q=997;
	int hx=0;
	String password;
	String [] kelimeler;
	int size;
	
	
	public Password(String[] kelimeler)
	{
		yeni=new HashMap<>();
		 this.kelimeler=kelimeler.clone();
			for(int i=0;i<this.kelimeler.length;++i)
			{
				yeni.put(i,this.kelimeler[i]);
			} 
	}  
	
	public boolean karsilastirma(String kelime) /*Ýki kelime eþitse yanlýþ dönderir */
	{
		int hc=0;
		for(int i=0;i<kelimeler.length;++i)
		{
			if(kelime.hashCode()==yeni.get(i).hashCode())
				if(kelime.equals(kelimeler[i]))
					return false;
		}
		
		return true;
	}
	
	public int getHX()
	{
		return hx;
	}

   public static void main(String args[]) throws IOException {
	   
	   Scanner sc=new Scanner(System.in);
	   String s=sc.nextLine();
	   String[]plitt=s.split("[0-9]");
	   for(int i=0;i<plitt.length;++i)
		   System.out.println(plitt[i]);
      FileReader in = null;

      try {
         in = new FileReader("deneme.txt");
         String kelime = "";
         int c;
         while ((c = in.read()) != -1) {
            kelime=kelime+(char)c;
         }
         String kelimeler[]=kelime.split("\n");
         Password a=new Password(kelimeler);
         boolean deger=true;
         for(int i=0;i<plitt.length;++i)
         {
	       deger=(a.karsilastirma(plitt[i]));                                                                
         }
         
         if(s.length()>=8 && deger)
         {
        	 System.out.println("Ýyi parola");
         }
         
      }finally {
         if (in != null) {
            in.close();
         }
      }
   }
}