package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        // Driver.getDriver().get("opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        //kullanici=Admin-->.properties dosyasında
        //kullaniciSifre=admin123-->.properties dosyasında
        /*
        Locateleri oluşturduğumuz page class'ındaki webelementlere ulaşabilmek
        için aşağıdaki örnekteki gibi classdaki const.dan obje oluşturduk.
         */
        OpenSourcePage sourcePage=new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("kullaniciAdi"));
        sourcePage.password.sendKeys(ConfigReader.getProperty("sifre"));
        ReusableMethods.bekle(3);//-->Thread.sleep methodu kullandık
        sourcePage.loginButton.click();


        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(sourcePage.verify.isDisplayed());

    }
}
