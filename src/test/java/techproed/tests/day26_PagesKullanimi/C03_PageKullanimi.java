package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproTestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PageKullanimi {
    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        // Page object Model kullanarak sayfaya giriş yapildigini test edin
        TechproTestCenterPage centerPage = new TechproTestCenterPage();
        centerPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        centerPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        ReusableMethods.bekle(2);
        centerPage.loginButton.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(centerPage.girisverify.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        centerPage.logout.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(centerPage.loginPage.isDisplayed());

        //Sayfayı kapatınız
        Driver.closeDriver();


    }
}
