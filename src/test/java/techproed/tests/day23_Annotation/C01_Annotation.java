package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    @BeforeSuite
    public void suite(){
        System.out.println("Her şeyden önce bir kez BeforeSuite çalışır");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce bir kez çalışır");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Her class'dan önce bir kez çalışır");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Junitteki @Before notasyonu gibi her methoddan önce çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test1 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test2 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test3 çalıştı");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Her şeyden sonra bir kez çalışır");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Testlerden sonra bir kez çalışır");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("Her class'tan sonra bir kez çalışır");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Junit'teki @After notasyonu gibi her methoddan sonra çalışır");
    }
}
