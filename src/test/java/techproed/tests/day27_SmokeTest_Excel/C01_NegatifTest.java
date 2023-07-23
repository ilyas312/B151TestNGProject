package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegatifTest {
    //Description:
    //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found
    @Test(groups="smoke")
    public void test01() {
        //https://www.bluerentalcars.com/ adresine gidelim negatif senaryo ile login olamadığımızı test edelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPages rentalPages=new BlueRentalPages();
        rentalPages.login.click();
        rentalPages.email.sendKeys(ConfigReader.getProperty("fakeEmail"),Keys.TAB,
                ConfigReader.getProperty("fakePassword"),Keys.ENTER);
        ReusableMethods.visibleWait(rentalPages.mesajVerify,5);
        Assert.assertTrue(rentalPages.mesajVerify.isDisplayed());
    }
}
