package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_PropertiesKullanimi {
    @Test
    public void amazonTest() {
        //amazon sayfasına gidelim
       Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //başlığın amazon içerdiğini test edelim
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle=ConfigReader.getProperty("expectedTitle");
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //arama kutusunda iphone aratalım
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchText"),Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

        //google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //Sayfayı kapatınız
        Driver.closeDriver();

        //facebook sayfasına gidiniz
        Driver.getDriver().get("https://facebook.com/");
    }
}
