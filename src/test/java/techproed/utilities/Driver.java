package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
        /*
            Driver classından obje oluşturmanın önüne geçebilmek için default
        constructor'ı private yaparak bunu engellemiş oluruz.
        Bu kalıba da Singleton patter denir.
         */
    }
    /*
    POM(Page Object Model)
        Test seneryolarının daha az kod ile yazılmasına ve bakımının daha kolay
    yapılmasına olanak sağlayan yazılım test yöntemidir.TestNG ve Cucumber
    frameworklerinde POM kalıbı kullanılır.
     */
    static WebDriver driver;
    public static WebDriver getDriver(){
          /*
                Driver'ı her çağırdığımızda yeni bir pencere açılmasının önüne geçmek
           için if bloğu içinde eğer driver'a değer atanmamışsa değer ata,eğer
           değer atanmışsa driver'ı aynı sayfada return et
           */
        if (driver==null){//-->Driver a değer atanmamışsa
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null){//-->Driver'a değer atanmışsa,boş değilse
            driver.close();
            driver=null;//-->Driver'ı kapattıktan sonra boşalt
        }

    }
    public static void quitDriver(){
        if (driver!=null){//-->Driver'a değer atanmışsa,boş değilse
            driver.quit();
            driver=null;//-->Driver'ı kapattıktan sonra boşalt
        }

    }
}
