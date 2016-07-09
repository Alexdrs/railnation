package railnationtestpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import railnationpackage.Properties;
import railnationpackage.Steps;

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
    public void distanceCalculation() {
        String mt = "3"; // Общее время минуты
        String st = "30"; // Общее время секунды
        String mw = "1"; // Время ожидания минуты
        String sw = "10"; // Время ожидания секунды
        String ch = "89"; // Состояние поезда в процентах
        steps.findFieldTotalTimeM(mt);
        steps.findFieldTotalTimeS(st);
        steps.findFieldWaitTimeM(mw);
        steps.findFieldWaitTimeS(sw);
        steps.findFieldChoise1(ch);
        steps.clickButton1();
        steps.chekCalculateTrue();

    }

    @Test
    public void testForBugWithNegativeValueField() {
        String mt = "-1"; // Общее время минуты
        steps.findFieldTotalTimeM(mt);
        steps.clickButton1();
        steps.chekEror();
    }

    @Test
    public void testForBugWithZeroValueField() {
        String mt = "0"; // Общее время минуты
        steps.findFieldTotalTimeM(mt);
        steps.clickButton1();
        steps.chekEror();
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
