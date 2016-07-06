import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    Steps steps;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/_dev/chromedriver.exe");   //путь по которому лежит веб-драйвер
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://railnationhabr.ru/calc/poezda/");
        driver.manage().window().maximize();
        steps = new Steps(driver);
    }

    @Test
    public void test() {
        steps.findFieldTotalTimeM("3");
        steps.findFieldTotalTimeS("30");
        steps.findFieldWaitTimeM("1");
        steps.findFieldWaitTimeS("10");
        steps.checkOnAccelerationTrain1();
        steps.checkOnSpeedTrain1();
        steps.findFieldChoise1("87");
        steps.changeTrain1("80");
        steps.clickButton1();
        steps.findFieldIncomeTrade("500");
        steps.changeTrain2("60");
        steps.changeTrain2("80");
        steps.changeTrain2("150");
        steps.changeTrain2("300");
        steps.clickButton2();
        steps.clickLink();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }
}
