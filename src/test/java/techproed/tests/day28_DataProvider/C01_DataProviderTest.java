package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {

   /*
        Dataprovider, bir çok veriyi test caselerde loop kullanmadan aktarmak için
    kullanılır.TestNG den gelen bir özelliktir.2 boyutlu Object Array return eder.
    Kullanımı için @Test notasyonundan sonra parametre olarak
    (dataProvider="method ismi") yazılır.
    Kaç tane veri ile çalışacaksak test methoduna o kadar parametre eklenir.

    Data driven testing(DDT) de datalarımızı 3 farklı şekilde kullanabiliriz.
        1- .properties dosyasından dataları alabiliriz.-->ConfigReader.getProperty(9 ile
        2- Excel dosyasından dataları alabiliriz.-->Excelreader class'ı ile
        3- DataProvider kullanarak dataları alabiliriz.-->DataProvider methodu ile
    */

   @DataProvider(name = "test02")//-->Bu DataProvider'ı test02 methodu için kullan anlamına gelir.
   public static Object[][] isimler() {
       return new Object[][]{
               {"esen"},
               {"mehmet"},
               {"esma"},
               {"ali"},
               {"mert"},
               {"burcu"},
               {"yunus"}};
   }

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{
                {"ford"},
                {"mercedes"},
                {"volvo"},
                {"audi"}};
    }


   /*
   Oluşturduğumuz dataProvider methodunu başka bir test methodunda da kullanabiliriz.
   Bunun için @DataProvider notasyonundan sonra yeni oluşturduğumuz methodun
   ismini (name="test02") belirtmemiz gerekir.
    */

    @Test(dataProvider = "isimler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "test02")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "arabalar")
    public void test03(String arabalar) {
        System.out.println(arabalar);
    }
}
