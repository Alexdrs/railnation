package railnationtestpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        System.setProperty("webdriver.chrome.driver", properties.getDriverPatch());
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
        String totalTimeMinutes = "3";
        String totalTimeSeconds = "30";
        String waitingTimeMinutes = "1";
        String waitingTimeSeconds = "10";
        String conditionTrainPrecentage = "89";
        steps.findFieldTotalTimeMinutes(totalTimeMinutes);
        steps.findFieldTotalTimeSeconds(totalTimeSeconds);
        steps.findFieldWaitTimeMinutes(waitingTimeMinutes);
        steps.findFieldWaitTimeSeconds(waitingTimeSeconds);
        steps.findFieldChoiseTrainPercentage(conditionTrainPrecentage);
        steps.clickButton1();
        steps.chekCalculateTrue();
        steps.setCheckboxIsValeZero(false);
    }

    @Test
    public void testForBugWithNegativeValueField() {
        String totalTimeMinutes = "-1";
        steps.findFieldTotalTimeMinutes(totalTimeMinutes);
        steps.clickButton1();
        steps.chekEror();
    }

    @Test
    public void testForBugWithZeroValueField() {
        String totalTimeMinutes = "0";
        steps.findFieldTotalTimeMinutes(totalTimeMinutes);
        steps.clickButton1();
        steps.chekEror();
    }

//    @AfterClass
//    public void quitBrowser() {
//        driver.quit();
//    }
}
