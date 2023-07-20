package techproed.tests.day26_PagesKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {
    @Test
    public void test01() {

        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPages blueRentalPages=new BlueRentalPages();
        blueRentalPages.login.click();
        ReusableMethods.bekle(1);
        blueRentalPages.email.sendKeys(ConfigReader.getProperty("blueRentalEmail"), Keys.TAB,
                                       ConfigReader.getProperty("blueRentalPassword"),Keys.ENTER);

        //Giriş yapıldığını doğrulayınız
        ReusableMethods.bekle(3);
        Assert.assertTrue(blueRentalPages.loginVerify.getText().contains("Jack"));


        //Admin email: jack@gmail.com
        //Admin password: 12345

    }
}
