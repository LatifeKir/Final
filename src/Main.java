
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.util.Random;



public class Main {
    public static void main(String[] args) {


        for (; ; ) {

            Scanner myInput = new Scanner(System.in);

            int ProjeNo;

            System.out.println("Merhabalar Lütfen istediğiniz proje numarasını yazınız");
            System.out.println(" 1. Şekil Oluşturma");
            System.out.println(" 2. Tarih Farkı");
            System.out.println(" 3. Sayı Tahmin Oyunu");
            System.out.println(" 4. Sayı Oranı Bulma");
            System.out.println(" 5. Basit Hesap Makinesi");
            System.out.println(" 6. En Büyük Sayı ve Sırasını Bulma");
            System.out.println(" 7. Fibonacci Serisi");
            System.out.println(" 8. Kaydırma Problemi");
            System.out.println(" 9. Sesli ve Sessiz Harfler");
            System.out.println(" 10. Sayı Çevirme");


            ProjeNo = myInput.nextInt();

            if (ProjeNo == 1) {

                for (int i = 0; i<5;i++)
                {
                    for(int j = 0; j<5;j++)
                    {
                        if (j<=i && i<5) {
                            System.out.print("*");
                        }
                    }
                    System.out.print("\n");
                }

                for (int i = 0; i<9;i++)
                {
                    for(int j = 4; j>0;j--)
                    {
                        if (j>i && i<=4) {
                            System.out.print("*");
                        }
                    }
                    System.out.print("\n");
                }

            }

            else if (ProjeNo == 2) {
                Scanner scanner = new Scanner(System.in);


                System.out.print("İlk tarihi (GG.AA.YYYY formatında) girin: ");
                String ilkTarihStr = scanner.nextLine();
                LocalDate ilkTarih = parseTarih(ilkTarihStr);


                System.out.print("İkinci tarihi (GG.AA.YYYY formatında) girin: ");
                String ikinciTarihStr = scanner.nextLine();
                LocalDate ikinciTarih = parseTarih(ikinciTarihStr);


                long gunFarki = Math.abs(ikinciTarih.toEpochDay() - ilkTarih.toEpochDay());


                long yilFarki = gunFarki / 365;
                long ayFarki = (gunFarki % 365) / 30;
                long kalanGunFarki = (gunFarki % 365) % 30;

                System.out.println("Tarih farkı:");
                System.out.println("Yıl: " + yilFarki);
                System.out.println("Ay: " + ayFarki);
                System.out.println("Gün: " + kalanGunFarki);

            }

            else if (ProjeNo == 3) {

                Scanner scan = new Scanner(System.in);
                Random rastgele = new Random();
                int rastgele_sayi = 1 + rastgele.nextInt(99);

                System.out.println("Rastgele sayi 1 ile 100 arasındadır.");
                int sayi,sayac = 0;

                do {
                    System.out.print("Bir sayi giriniz: ");
                    sayi = scan.nextInt();
                    if(sayi != rastgele_sayi) {
                        System.out.println("Aradaki Fark."+ (rastgele_sayi - sayi));
                    }

                    sayac++;
                }
                while(sayi != rastgele_sayi);

                if(sayac==1)
                {System.out.println("Tebrikler!! " + sayac + ". denemede sayıyı buldunuz.");}
                else{
                    System.out.println( sayac + ". denemede sayıyı buldunuz.");
                }

            }

            else if (ProjeNo == 4)
            {

                Scanner scanner = new Scanner(System.in);


                System.out.println("0-100 arasında 10 sayı giriniz:");

                int buyukToplam = 0; // 50 ve üstü sayıların toplamı
                int kucukToplam = 0; // 50'den küçük sayıların toplamı

                for (int i = 0; i < 10; i++) {
                    System.out.print("Sayı " + (i + 1) + ": ");
                    int sayi = scanner.nextInt();


                    if (sayi >= 50) {
                        buyukToplam += sayi;
                    } else {
                        kucukToplam += sayi;
                    }
                }


                double oran = (double) buyukToplam / kucukToplam;


                System.out.println("50 ve üstü sayıların toplamı: " + buyukToplam);
                System.out.println("50'den küçük sayıların toplamı: " + kucukToplam);
                System.out.println("Toplam Oran: " + oran);

            }

            else if (ProjeNo == 5)
            {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Yapmak istediğiniz işlemi seçin:");
                System.out.println("1. Toplama (+)");
                System.out.println("2. Çıkarma (-)");
                System.out.println("3. Çarpma (*)");
                System.out.println("4. Bölme (/)");

                // Kullanıcının seçimini al
                System.out.print("Seçim (1-4): ");
                int secim = scanner.nextInt();

                // İki sayıyı kullanıcıdan al
                System.out.print("Birinci sayıyı girin: ");
                double sayi1 = scanner.nextDouble();

                System.out.print("İkinci sayıyı girin: ");
                double sayi2 = scanner.nextDouble();

                // Seçime göre işlem yap
                double sonuc = 0;

                switch (secim) {
                    case 1:
                        sonuc = sayi1 + sayi2;
                        break;
                    case 2:
                        sonuc = sayi1 - sayi2;
                        break;
                    case 3:
                        sonuc = sayi1 * sayi2;
                        break;
                    case 4:

                        if (sayi2 != 0) {
                            sonuc = sayi1 / sayi2;
                        } else {
                            System.out.println("Hata: Sıfıra bölme hatası!");
                            return;
                        }
                        break;
                    default:
                        System.out.println("Geçersiz seçim!");
                        return;
                }


                System.out.println("Sonuç: " + sonuc);


            }

            else if (ProjeNo == 6)
            {
                Scanner scanner = new Scanner(System.in);

                int enBuyuk = Integer.MIN_VALUE;
                int enBuyukSira = -1;

                for (int i = 1; i <= 10; i++) {
                    System.out.print("Sayı " + i + ": ");
                    int sayi = scanner.nextInt();


                    if (sayi > enBuyuk) {
                        enBuyuk = sayi;
                        enBuyukSira = i;
                    }
                }

                System.out.println("En büyük sayı: " + enBuyuk);
                System.out.println("En büyük sayının girildiği sıra: " + enBuyukSira);

            }

            else if (ProjeNo == 7)
            {
                int n = 20;


                int[] fibonacciSerisi = new int[n];


                fibonacciSerisi[0] = 0;
                fibonacciSerisi[1] = 1;


                for (int i = 2; i < n; i++) {
                    fibonacciSerisi[i] = fibonacciSerisi[i - 1] + fibonacciSerisi[i - 2];
                }

                System.out.println("Fibonacci Serisi 20 sayı:");
                for (int i = 0; i < n; i++) {
                    System.out.print(fibonacciSerisi[i] + " \n");
                }
            }

            else if (ProjeNo == 8){
                Scanner scanner = new Scanner(System.in);

                System.out.print("Bir kelime girin: ");
                String kelime = scanner.nextLine();

                System.out.print("Sağa kaydırma miktarını girin: ");
                int kaydirmaMiktari = scanner.nextInt();

                String sonuc = sagKaydir(kelime, kaydirmaMiktari);
                System.out.println("Sonuç: " + sonuc);

            }

            else if (ProjeNo == 9){

                Scanner scanner = new Scanner(System.in);

                System.out.print("Bir kelime girin: ");
                String kelime = scanner.nextLine().toLowerCase();

                int sesliHarfSayisi = 0;
                int sessizHarfSayisi = 0;

                for (int i = 0; i < kelime.length(); i++) {
                    char harf = kelime.charAt(i);

                    if (harf >= 'a' && harf <= 'z') {
                        if (harf == 'a' || harf == 'e' || harf == 'ı' || harf == 'i' || harf == 'o' ||
                                harf == 'ö' || harf == 'u' || harf == 'ü') {
                            sesliHarfSayisi++;
                        } else {
                            sessizHarfSayisi++;
                        }
                    }
                }

                System.out.println("Sesli harf sayısı: " + sesliHarfSayisi);
                System.out.println("Sessiz harf sayısı: " + sessizHarfSayisi);

            }

            else if (ProjeNo == 10){


                Scanner scan= new Scanner(System.in);
                System.out.println("Sayı Giriniz: ");
                int sayi2= scan.nextInt();
                cevir(sayi2);
                System.out.print("n");

            }

        }

    }

    public static void cevir(int sayi){
        int dizi[] = new int[40];
        int index = 0;
        while(sayi > 0){
            dizi[index++] = sayi%2;
            sayi = sayi/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(dizi[i]);
        }
    }
    public static LocalDate parseTarih(String tarihStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(tarihStr, formatter);
    }

    public static String sagKaydir(String kelime, int miktar) {
        int uzunluk = kelime.length();
        miktar = miktar % uzunluk;

        String yeniKelime = kelime.substring(uzunluk - miktar) + kelime.substring(0, uzunluk - miktar);

        return yeniKelime;

    }
}