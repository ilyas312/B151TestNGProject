package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C03_DataProviderTest {

    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{
                {"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}
        };
    }

    @Test(dataProvider = "blueRental")
    public void test01(String mail,String password) {
        //BlueRentalCar sitesine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //DataProvider'daki mail ve password bilgileri ile login olalım
        BlueRentalPages rentalPages=new BlueRentalPages();
        rentalPages.login.click();
        rentalPages.email.sendKeys(mail, Keys.TAB,password,Keys.ENTER);

        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}
