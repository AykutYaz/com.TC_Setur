package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SeturPage {

    public SeturPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//span[@class='ins-close-button']")
    public WebElement ilkReklamElementi;

    @FindBy(xpath ="//div[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelectionWrapper']//a[contains(text(),'Tümüne izin ver')]")
    public WebElement cookiesKabulElementi;

    @FindBy(xpath = "(//div[@class='sc-e1263d42-0 jDCMfh']//button)[1]")
    public WebElement otelTabElementi;

    @FindBy(xpath = "//input[@class='sc-bde938b1-0 kLxiFo']")
    public WebElement nereyeGideceksinizElementi;

    @FindBy(xpath = "(//div[@class='sc-f548111d-5 jIfcUs'])[1]")
    public WebElement antalyaIlkSecenekElementi;

    @FindBy(xpath = "//div[@class='sc-33fb603-3 cegFjU']")
    public WebElement girisCikisTarihElementi;

    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='1']")
    public WebElement girisTarihElementi;
    @FindBy(xpath = "(//div[@class='CalendarMonth CalendarMonth_1'])[3]//table//td//span[text()='7']")
    public WebElement cikisTarihElementi;

    @FindBy(xpath = "//span[@class='sc-b2c3f6ee-21 bSPwxV']")
    public WebElement kisiSayisiElementi;

    @FindBy(xpath = "(//button[@class='sc-423a98f0-1 fYtyaG'])[2]")
    public WebElement kisiSayisiArtisElementi;

    @FindBy(xpath = "//button[@class='sc-8de9de7b-0 dYTYAP']")
    public WebElement araButonuElementi;

    @FindBy(xpath = "//div[@data-testid='show-more-regions-button']")
    public WebElement digerBolgeleriGosterElementi;

    @FindBy(xpath = "(//span[@class='sc-21021e1e-3 eqVmWj'])[1]")
    public WebElement sayfaninAltindakiOtelSayisi;

}
