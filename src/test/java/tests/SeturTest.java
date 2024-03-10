package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import utilities.*;

public class SeturTest extends TestBase {

    ReusableMethods reusableMethods = new ReusableMethods();
    Logger logger = LogManager.getLogger();

    @Test
    public void Test01() {
        logger.info("Driver kuruldu, Browser olarak Chrome secildi. https://www.setur.com.tr/ Url'e gidildi.");
        reusableMethods.anasayfaAcilis();
    }
    @Test
    public void Test02(){
        logger.info("Anasayfadan gidilen Url'in dogrulugu test edildi.");
        reusableMethods.anasayfaUrlKontrol();
    }
    @Test
    public void Test03(){
        logger.info("Dialog kapatildi ve Cookies Kabulu yapildi");
        reusableMethods.dialogVeCookiesKapatma();
    }
    @Test
    public void Test04() {
        logger.info("Ana sayfada Otel tabininin default geldiği kontrol edildi");
        reusableMethods.defaultOtelTab();
    }
    @Test
    public void Test05() {
        logger.info("'Nereye Gideceksiniz?' alanına csv dosyasından 'Antalya' yazılır ve en üsteki Antalya seçeneğine" +
                "tiklandi");
        reusableMethods.csvIleGidilecekYer();
    }
    @Test
    public void Test06() {
        logger.info("Tarih alaninda Nisan’in ilk haftasi için bir haftalik aralik seçildi");
        reusableMethods.girisCikisTarihElementi();
    }
    @Test
    public void Test07() {
        logger.info("Yetişkin sayisi 1 artirilir ve Yetişkin sayisinin değiştiği kontrol edildi");
        reusableMethods.yetişkinSayisiniArttirma();
    }
    @Test
    public void Test08() {
        logger.info("'Ara' butonu’nun gorunurlugu kontrol edildi ve tiklandi");
        reusableMethods.araButonuGorunurlugu();
    }
    @Test
    public void Test09() {
        logger.info("Acilan url içinde 'antalya' kelimesini içerdiği kontrol edildi");
        reusableMethods.urlAntalyaIcerikKontrol();
    }
    @Test
    public void Test10() {
        logger.info("'Diğer Bölgeleri Göster' alaninda rastgele tiklama metotu kullanilarak bir seçim yapildi ve '()'" +
                "içerisinde bulunan sayi kaydedildi");
        reusableMethods.rastgeleSecilenOtelSayisi();
    }
    @Test
    public void Test11 (){
        logger.info("Sayfanın altinda bulunan 'Antalya Otelleri ve En Uygun Antalya Otel Fiyatları' alanina" +
                "kadar ekranda kaydirma yapildi.Bir onceki adimda kayit edilen otel sayi degeri ile sayfanin" +
                "altindaki otel sayi degerinin esit oldugu test edildi ") ;
       reusableMethods.sayfaninAltindakiOtelSayisiKontrol();
    }




}




