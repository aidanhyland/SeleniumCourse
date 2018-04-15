package generalSelenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExplicitWaitExample {

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
    }

    @Test
    public void test() {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Login")).click();

        WebDriverWait wait = new WebDriverWait(driver, 3);

        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));

        emailField.sendKeys("test");

        driver.close();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}

