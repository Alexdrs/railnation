import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    Steps steps;
    Properties properties = new Properties();

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getDRIVER_PATCH());
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(properties.getUrl());
        driver.manage().window().maximize();
        steps = new Steps(driver);
    }

    @BeforeMethod
    public void loadingPage() {
        driver.get(properties.getUrl());
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
    public void test2() {
        steps.findFieldTotalTimeM("-1");
        steps.clickButton1();
        steps.chekEror();
    }

    @Test
    public void test3() {
        steps.findFieldTotalTimeM("0");
        steps.clickButton1();
        steps.chekEror();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
