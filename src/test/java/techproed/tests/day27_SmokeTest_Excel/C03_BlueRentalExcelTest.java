package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPages;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;



public class C03_BlueRentalExcelTest {
    @Test
    public void test01() {
        /*
            Test yaptığımız sayfadaki dataları .properties ya da excel dosyasından
        alabilliriz .properties dosyasından verileri okuyabilmemiz için ConfigReader
        class'ı oluşturmuştuk, aynı şekilde excel dosyasındaki verileri okuyabilmek
        için ExcelReader class'ı oluşturduk.Burdan alacağımız email ve password
        bilgilerini String bir değişkene assing edip login testi yapacağımız sitede
        sendKeys() methosu ile çok rahat kullanabiliriz.
         */

        ExcelReader reader=new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email=reader.getCellData(1,0);
        String password=reader.getCellData(1,1);

        //Blue Rental Car sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //mysmoketestdata excel dosyasından bir kullanıcı ile login olalım
        BlueRentalPages rentalPages=new BlueRentalPages();
        rentalPages.login.click();
        ReusableMethods.bekle(2);
        rentalPages.email.sendKeys(email,Keys.TAB,password, Keys.ENTER);

        //login oldugumuzu doğrulayalım
        /*
    Login webelementi login olduktan sonrada aynı locate sahip olabilme ihtimaline karşı
daha garanti bir doğrulama yapmak için login olduktan sonra login webelementinin olduğu
yerde login olduğumuz kullanıci ismi çıkacaktır. Bu webelementin yazısını getText() methodu
ile alıp kullanıcı ismini içeriyomu içermiyomu olarak test ederiz

 */
        ReusableMethods.bekle(3);
        Assert.assertTrue(rentalPages.loginVerify.getText().contains("Sam"));

        //sayfayı kapatalım
        Driver.closeDriver();

    }
}
