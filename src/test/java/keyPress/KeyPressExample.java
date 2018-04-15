package keyPress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class KeyPressExample {

    private WebDriver driver;
    private String baseUrl;
    JavascriptExecutor js;

    @Before
    public void setUp() throws IOException {

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(PropertyPathLocator.PATH);
        prop.load(fs);

        SystemProperties.setSystemProperties();

        driver = new ChromeDriver();
       // js = (JavascriptExecutor)driver;
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        baseUrl = prop.getProperty("baseUrlHome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void KeyPress_enter() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("user_email")).sendKeys("aidan@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("user_password")).sendKeys("123232");
        Thread.sleep(2000);

        driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
    }

    @Test
    public void KeyPress_action_class() throws InterruptedException {
        driver.get("https://letskodeit.teachable.com/p/practice");
        Thread.sleep(2000);

        Actions action = new Actions(driver);

        action.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

