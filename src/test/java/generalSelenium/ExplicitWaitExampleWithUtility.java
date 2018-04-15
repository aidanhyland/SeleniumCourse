package generalSelenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;
import utilities.GenericMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExplicitWaitExampleWithUtility {

    private WebDriver driver;
    private String baseUrl;
    private GenericMethods gm;

    @Before
    public void setUp() throws IOException {

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(PropertyPathLocator.PATH);
        prop.load(fs);

        SystemProperties.setSystemProperties();

        driver = new ChromeDriver();
        gm = new GenericMethods(driver);
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        baseUrl = prop.getProperty("baseUrl");
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Login")).click();

        WebElement emailField = gm.waitForElement(By.id("user_email"), 3);
        emailField.sendKeys("test");

        gm.clickWhenReady(By.name("commit"), 3);

        driver.close();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}

