package generalSelenium;

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

public class ImplicitWaitExample {

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
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); // every drive statement timeout
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_email")).sendKeys("test");

        driver.close();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}

