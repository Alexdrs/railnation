import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    Steps steps;

    @BeforeClass public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:/_dev/chromedriver.exe");   //путь по которому лежит веб-драйвер
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://railnationhabr.ru/calc/poezda/");
        driver.manage().window().maximize();
        steps = new Steps(driver);
    }
    @BeforeMethod
    public void loadingPage() {
            driver.get("http://railnationhabr.ru/calc/poezda/");
    }

    @Test
    public void test1() {
        steps.findFieldTotalTimeM("3");
        steps.findFieldTotalTimeS("30");
        steps.findFieldWaitTimeM("1");
        steps.findFieldWaitTimeS("10");
        steps.findFieldChoise1("89");
        steps.clickButton1();
        steps.chekCalculateTrue();
    }
    @Test
    public void test2(){
        steps.findFieldTotalTimeM("-1");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test3(){
        steps.findFieldTotalTimeM("0");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test4(){
        steps.findFieldTotalTimeM("1441");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test5(){
        steps.findFieldTotalTimeM("");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test6(){
        steps.findFieldTotalTimeS("-1");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test7(){
        steps.findFieldTotalTimeS("0");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test8(){
        steps.findFieldTotalTimeS("60");
        steps.clickButton1();
        steps.chekEror();
    }
    @Test
    public void test9(){
        steps.findFieldTotalTimeS("61");
        steps.clickButton1();
        steps.chekEror();
    }
//
//    @AfterMethod
//    public void quitBrowser() {
//        driver.quit();
//    }
}
