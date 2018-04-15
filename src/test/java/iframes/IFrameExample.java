package iframes;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class IFrameExample {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws IOException {

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(PropertyPathLocator.PATH);
        prop.load(fs);

        SystemProperties.setSystemProperties();

        driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        baseUrl = prop.getProperty("baseUrl");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test_iframe() {
        driver.get(baseUrl);

        driver.switchTo().frame("courses-iframe");
        driver.findElement(By.id("search-courses")).sendKeys("testing");

        driver.switchTo().parentFrame();
        driver.close();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
