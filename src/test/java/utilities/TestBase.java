package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestBase {
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public static void click(WebElement element){

        //Tiklanan alanlari kirmizi cerceve ve sarı arkaplan ile gösterir
        jse.executeScript("arguments[0].setAttribute('style','background:yellow;border:1px solid red;')", element);
        element.click();
    }


}
