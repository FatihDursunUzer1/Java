/*Fatih Dursun Üzer
 * 18120205041
 * Ýstanbul Medeniyet Üniversitesi 2.Sýnýf
 * Bu oyunda her bir sesli harf (her bir hece) bir oyuncuya gelecek þekilde oyuncular sýrasýyla sayýlmakta ve son harfe gelen oyuncu seçilmektedir.
Seçilen oyuncu listeden çýkarýlýp kullanýcýdan yeni bir tekerleme alarak oyun listede sadece bir oyuncu kalana kadar çalýþmaya devam eden bir Java programý..
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
        System.out.println("Oyunda kaç oyuncunun bulunmasýný istediðinizi bildiriniz");
        final int oyuncuSayisi=sc.nextInt();
        if(oyuncuSayisi>=30 || oyuncuSayisi<=0) //Büyük sayýlarý engellemek amacýyla 30 sýnýrý koyulmuþtur.
        {  System.out.println("Oyuncu Sýnýrýný Aþtýnýz ve ya geçerli bir oyuncu sayisi girmediniz.");
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
            	System.out.println("Lutfen tekerleme kýsmýný boþ býrakmayýnýz");
            	continue;
            }
            System.out.print(tekerleme);
            for(int i=0;i<tekerleme.length();++i) //Tekerleme içerisinde ünlü harf var mý diye kontrol eder.
            {
                if(tekerleme.charAt(i)=='a' ||tekerleme.charAt(i)=='ö'||tekerleme.charAt(i)=='e'||tekerleme.charAt(i)=='ý'||tekerleme.charAt(i)=='i'||
                        tekerleme.charAt(i)=='o'||tekerleme.charAt(i)=='u'||tekerleme.charAt(i)=='ü'||tekerleme.charAt(i)=='A' ||tekerleme.charAt(i)=='Ö'||tekerleme.charAt(i)=='E'||tekerleme.charAt(i)=='I'||tekerleme.charAt(i)=='Ý'||
                        tekerleme.charAt(i)=='O'||tekerleme.charAt(i)=='U'||tekerleme.charAt(i)=='Ü')
                {
                    heceSayisi++;
                }
            }
            if(heceSayisi%oyuncuLinkedList.size()==0 && heceSayisi!=0) // xxdfgh,klmn gibi tekerleme olmayan þeyler girildiðinde oyuncu elemez.
            {
                oyuncuLinkedList.remove(oyuncuLinkedList.size()-1);//o indexteki deðeri kaldýracaðý için eleman sayýsýnýn bir eksiðini argüman olarak yolladýk
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
	


