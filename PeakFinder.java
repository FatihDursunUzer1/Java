

/*
 * Fatih Dursun Uzer
 * 18120205041
 * 1 Ekim 2019 
 * Tepe noktasý bulan Greedy ve Divide And Conquer methodlu Class yapýmý
 */

import java.util.Random;
import java.util.Scanner;

public class PeakFinder {
	private int[][] dizi;
	private int satirSayisi;
	private int sutunSayisi;
	private int max;
	private int maxinBulunduguSatir;
	public PeakFinder(int satirSayisi,int sutunSayisi)
	{
		if(satirSayisi<0 || sutunSayisi<0)
			System.exit(0);
		this.satirSayisi=satirSayisi;
		this.sutunSayisi=sutunSayisi;
		this.dizi=new int[this.satirSayisi][this.sutunSayisi];
		Random generator=new Random();
		for(int m=0;m<this.satirSayisi;++m)
		{
			for(int n=0;n<this.sutunSayisi;++n)
			{
				this.dizi[m][n]=generator.nextInt(70);
			}
		}   
	}
	/**
	 * Belirtilen orta sutundaki maximum degeri bulan method.
	 * @param mid orta sutunun index degeridir.
	 * @return maximum sayinin bulundugu satirin index degerini donderir.
	 */
	public int findMax(int mid)
	{
		for(int i=0;i<this.satirSayisi;++i)
		{
			if(dizi[i][mid]>max)
			{
				max=dizi[i][mid];
				maxinBulunduguSatir=i;
			}
		}
		return maxinBulunduguSatir;
	}
	
	/**
	 * Divide And Conquer algoritmasý ile peak bulan method. Parametre deðerleri pozitif olmak zorundadir.
	 * @param baslangicSutunu Peak'i aramaya hangi sutundan baslanacagini belirtir.
	 * @param sonSutun Peak'in hangi sutuna kadar aranacagini belirtir.
	 * @return Peak noktasinin  degerini donderir.Eger Peak noktasi yoksa -1 donderir.
	 */
	public int findPeakDivideAndConquer(int baslangicSutunu,int sonSutun)
	{
		if(baslangicSutunu<0 || sonSutun<0)
			System.exit(0);
		int mid=(baslangicSutunu+sonSutun)/2;
		this.findMax(mid);
		if(mid==0 || mid==sutunSayisi-1)
			return max;
		else if (max >=dizi[maxinBulunduguSatir][mid - 1] && 
				max >= dizi[maxinBulunduguSatir][mid + 1]) 
				return max; 
		else if(max<dizi[maxinBulunduguSatir][mid-1])
			return findPeakDivideAndConquer(baslangicSutunu,mid-1);
		
		else if(max<dizi[maxinBulunduguSatir][mid+1])
			return findPeakDivideAndConquer(mid+1,sonSutun);
		
		return -1;
	}
	
	/**
	 * Greedy ascent algoritmasý ile peak noktasý bulan method. Parametre degerleri pozitif olmak zorundadir. 
	 * @param baslangicSatiri Peak'i aramaya hangi satýrdan baslanacagini belirtir.
	 * @param baslangicSutunu Peak'i aramaya hangi sutundan baslanacagini belirtir.
	 * @return Peak noktasinin  degerini donderir.
	 */
	
	public int findPeakGreedy(int baslangicSatiri,int baslangicSutunu)
	{
		if(baslangicSatiri<0 || baslangicSutunu<0)
			System.exit(0);
		if(baslangicSatiri>0 && 
		   dizi[baslangicSatiri-1][baslangicSutunu]>=dizi[baslangicSatiri][baslangicSutunu])
			return findPeakGreedy(baslangicSatiri-1,baslangicSutunu);
		else if(baslangicSatiri<satirSayisi-1 && 
				dizi[baslangicSatiri+1][baslangicSutunu]>=dizi[baslangicSatiri][baslangicSutunu])
			return findPeakGreedy(baslangicSatiri+1,baslangicSutunu);
		else if(baslangicSutunu>0 && 
				dizi[baslangicSatiri][baslangicSutunu-1]>=dizi[baslangicSatiri][baslangicSutunu])
			return findPeakGreedy(baslangicSatiri,baslangicSutunu-1);
		else if(baslangicSutunu<sutunSayisi-1 && 
				dizi[baslangicSatiri][baslangicSutunu+1]>=dizi[baslangicSatiri][baslangicSutunu])
			return findPeakGreedy(baslangicSatiri,baslangicSutunu+1);
		else
			return dizi[baslangicSatiri][baslangicSutunu];
		
	}
	
	public static void main(String [] args)
	{
		System.out.println("Lutfen random olusturulacak olan dizinin satýr ve sutun sayisini giriniz");
		Scanner sc=new Scanner(System.in);
		int satir=sc.nextInt();
		int sutun=sc.nextInt();
		sc.close();
		PeakFinder yeni=new PeakFinder(satir,sutun);
		for(int i=0;i<yeni.satirSayisi;++i)
		{
			for(int j=0;j<yeni.sutunSayisi;++j)
			{
				System.out.print(yeni.dizi[i][j]);
			System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println(yeni.findPeakDivideAndConquer(0,yeni.sutunSayisi-1));
		System.out.println(yeni.findPeakGreedy(0, 0));
		
	}
}
