/*Fatih Dursun �zer
 * 18120205041
 * �stanbul Medeniyet �niversitesi 2.S�n�f
 * Bu oyunda her bir sesli harf (her bir hece) bir oyuncuya gelecek �ekilde oyuncular s�ras�yla say�lmakta ve son harfe gelen oyuncu se�ilmektedir.
Se�ilen oyuncu listeden ��kar�l�p kullan�c�dan yeni bir tekerleme alarak oyun listede sadece bir oyuncu kalana kadar �al��maya devam eden bir Java program�..
 */

import java.util.LinkedList;
import java.util.Scanner;


public class Oyuncu {
    String isim;
    public Oyuncu()
    {
        this.isim="";
    }

    public Oyuncu(final String isim)
    {
        this.isim=isim;
    }

    public static void main(String args[])
    {
        final Scanner sc=new Scanner(System.in);
        System.out.println("Oyunda ka� oyuncunun bulunmas�n� istedi�inizi bildiriniz");
        final int oyuncuSayisi=sc.nextInt();
        if(oyuncuSayisi>=30 || oyuncuSayisi<=0) //B�y�k say�lar� engellemek amac�yla 30 s�n�r� koyulmu�tur.
        {  System.out.println("Oyuncu S�n�r�n� A�t�n�z ve ya ge�erli bir oyuncu sayisi girmediniz.");
            System.exit(0);
        }
        LinkedList<Oyuncu> oyuncuLinkedList=new LinkedList<Oyuncu>();
        for(int i=0;i<oyuncuSayisi;++i)
        {
            System.out.println((i+1)+".ci oyuncunun ismini giriniz");
            String oyuncuIsmi=sc.next();
            Oyuncu yeniOyuncu=new Oyuncu(oyuncuIsmi);
            oyuncuLinkedList.add(yeniOyuncu);
        }
        for(int i=0;i<oyuncuLinkedList.size();++i)
            System.out.println(oyuncuLinkedList.get(i).isim);
        System.out.println(oyuncuLinkedList.size());
        sc.nextLine();
        int heceSayisi=0;
        while(oyuncuLinkedList.size()>1)
        {
            heceSayisi=0;
            System.out.println("Lutfen tekerlemeyi giriniz");
            String tekerleme;
            tekerleme=sc.nextLine();
            if(tekerleme.length()==0)
            {
            	System.out.println("Lutfen tekerleme k�sm�n� bo� b�rakmay�n�z");
            	continue;
            }
            System.out.print(tekerleme);
            for(int i=0;i<tekerleme.length();++i) //Tekerleme i�erisinde �nl� harf var m� diye kontrol eder.
            {
                if(tekerleme.charAt(i)=='a' ||tekerleme.charAt(i)=='�'||tekerleme.charAt(i)=='e'||tekerleme.charAt(i)=='�'||tekerleme.charAt(i)=='i'||
                        tekerleme.charAt(i)=='o'||tekerleme.charAt(i)=='u'||tekerleme.charAt(i)=='�'||tekerleme.charAt(i)=='A' ||tekerleme.charAt(i)=='�'||tekerleme.charAt(i)=='E'||tekerleme.charAt(i)=='I'||tekerleme.charAt(i)=='�'||
                        tekerleme.charAt(i)=='O'||tekerleme.charAt(i)=='U'||tekerleme.charAt(i)=='�')
                {
                    heceSayisi++;
                }
            }
            if(heceSayisi%oyuncuLinkedList.size()==0 && heceSayisi!=0) // xxdfgh,klmn gibi tekerleme olmayan �eyler girildi�inde oyuncu elemez.
            {
                oyuncuLinkedList.remove(oyuncuLinkedList.size()-1);//o indexteki de�eri kald�raca�� i�in eleman say�s�n�n bir eksi�ini arg�man olarak yollad�k
            }
            else
            {
                for(int j=1;j<10;++j)
                {
                    if(heceSayisi%oyuncuLinkedList.size()==j)
                    {
                        oyuncuLinkedList.remove(j-1);
                    }

                }
            }

            System.out.println(heceSayisi);
            for(int i=0;i<oyuncuLinkedList.size();++i)
                System.out.println(oyuncuLinkedList.get(i).isim);
        }
        sc.close();
        System.out.println("Son Kalan Oyuncu : "+oyuncuLinkedList.getFirst().isim);

    }

}
	


