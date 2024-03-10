package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.SeturPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ReusableMethods extends TestBase {

    static SeturPage seturPage;

    public ReusableMethods() {

        seturPage = new SeturPage();
    }

    static int seciliOtelSayisi = 0;

    public static void bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void anasayfaAcilis() {
        Driver.getDriver().get(ConfigReader.getProperty("seturUrl"));
    }

    public void anasayfaUrlKontrol() {
        String expectedSeturUrl = "https://www.setur.com.tr/";
        String actualSeturUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualSeturUrl, expectedSeturUrl);
    }

    public void dialogVeCookiesKapatma() {
        click(seturPage.ilkReklamElementi);
        click(seturPage.cookiesKabulElementi);
    }

    public void defaultOtelTab() {

        String attribute = seturPage.otelTabElementi.getAttribute("class");
        Assert.assertTrue(attribute.contains("jmbIRo"));
    }

    public void csvIleGidilecekYer() {
        String cityName = CsvReader.getCityName();
        seturPage.nereyeGideceksinizElementi.sendKeys(cityName);
        click(seturPage.nereyeGideceksinizElementi);
        click(seturPage.antalyaIlkSecenekElementi);
    }

    public void girisCikisTarihElementi(){
        click(seturPage.girisCikisTarihElementi);
        click(seturPage.girisTarihElementi);
        click(seturPage.cikisTarihElementi);
    }

    public void yetişkinSayisiniArttirma(){
        WebElement element = seturPage.kisiSayisiElementi;
        String defaultKisiSayisi = element.getText();

        click(seturPage.kisiSayisiElementi);
        click(seturPage.kisiSayisiArtisElementi);

        String artmisKisiSayisi = element.getText();
        Assert.assertNotEquals(defaultKisiSayisi, artmisKisiSayisi);
    }
    public void araButonuGorunurlugu(){
        assertTrue(seturPage.araButonuElementi.isDisplayed());
        click(seturPage.araButonuElementi);
    }
    public void urlAntalyaIcerikKontrol(){
        ReusableMethods.bekle(4);
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("antalya"));
    }
    public void rastgeleSecilenOtelSayisi() {

        //Diger bölgeleri göster elementine tıklar
        click(seturPage.digerBolgeleriGosterElementi);

        //Diğer bölge elementindeki bölgeleri liste olarak kaydettik
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//div[@class='sc-e4b3cd20-0 ihtOYP']"));

        //Boş bir List oluşturulur
        List<WebElement> newElements = new ArrayList<WebElement>();

        //Sayfanın altında bulunan 'Antalya Otelleri ve En Uygun Antalya Otel Fiyatları' elementinin çıkması için
        //Otel sayisi 30 dan fazla olan bölgeleri oluşturulan Yeni List e eklenir.

        elements.forEach((WebElement e) -> {
            String eHotelNum = e.getText();
            int eHotelNumSystem = Integer.parseInt(eHotelNum.replaceAll("\\D", ""));
            if (eHotelNumSystem > 30)
                newElements.add(e);
        });

        //Yeni List içerisinden rastgele bir bölge seçimi yapılır
        Random random = new Random();
        int randomIndex = random.nextInt(newElements.size());
        WebElement randomLink = newElements.get(randomIndex);
        click(randomLink);
        String secilenBolgeninOtelSayisi = randomLink.getText();
        ReusableMethods.bekle(5);

        //Seçilen bölgenin otel sayisi kaydedilir
        this.seciliOtelSayisi = Integer.parseInt(secilenBolgeninOtelSayisi.replaceAll("\\D", ""));
        System.out.println(this.seciliOtelSayisi);

    }
    public void sayfaninAltindakiOtelSayisiKontrol() {

        // Sayfadaki elementin XPath'i
        String elementXPath = "//span[@class='sc-21021e1e-2 dQerZq']";

        // Belirli bir elementin pozisyonunu al
        WebElement element = Driver.getDriver().findElement(By.xpath(elementXPath));

        // Elemente odaklanarak klavye ok tuşlarına basarak sayfayı aşağı kaydır

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(element).sendKeys(Keys.ARROW_DOWN).build().perform();

        int sayfaninAltindakiOtelSayisiInt = Integer.parseInt(seturPage.sayfaninAltindakiOtelSayisi.getText());

        Assert.assertEquals(sayfaninAltindakiOtelSayisiInt, seciliOtelSayisi);

        Driver.quitDriver();
    }


}

