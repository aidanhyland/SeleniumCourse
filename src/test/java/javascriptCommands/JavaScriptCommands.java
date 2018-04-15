package javascriptCommands;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JavaScriptCommands {

    private WebDriver driver;
    private JavascriptExecutor js;
    private String baseUrl;
    private String mainWindow;

    @Before
    public void setUp() throws Exception {

        SystemProperties.setSystemProperties();

        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(PropertyPathLocator.PATH);
        prop.load(fs);

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        mainWindow = driver.getWindowHandle();
        baseUrl = prop.getProperty("baseUrl");
        driver.switchTo().window(mainWindow).manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void jsTest() {
        //driver.get(baseUrl);

        js.executeScript("window.location = '" + baseUrl + "';");

        WebElement textBox = (WebElement) js.executeScript("return document.getElementById('name');");
        textBox.sendKeys("test");
        driver.close();
    }

    @Test
    public void findWindowSize() {
        //driver.get(baseUrl);

        js.executeScript("window.location = '" + baseUrl + "';");

        // Size of the window

        long height = (Long) js.executeScript("return window.innerHeight;");
        long width = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("The height is: " + height + "\n" +
                           "The width  is: " + width);

        driver.switchTo().window(mainWindow).manage().window().fullscreen();

        long heightFull = (Long) js.executeScript("return window.innerHeight;");
        long widthFull = (Long) js.executeScript("return window.innerWidth;");

        System.out.println("The full height is: " + heightFull + "\n" +
                "The full width  is: " + widthFull);

        driver.close();
    }

    @Test
    public void scrollWindow() throws InterruptedException {
        //driver.get(baseUrl);

        js.executeScript("window.location = '" + baseUrl + "';");

        Thread.sleep(3000);
        // Scroll down
        js.executeScript("window.scrollBy(0, 1900);");

        Thread.sleep(3000);
        // Scroll Up
        js.executeScript("window.scrollBy(0, -1900);");

        Thread.sleep(3000);
        // Scroll Element into view
        WebElement element = driver.findElement(By.id("mousehover"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0, -190);");

        Thread.sleep(3000);


        driver.close();
    }

    @Test
    public void clickWithJS() throws InterruptedException {
        //driver.get(baseUrl);

        js.executeScript("window.location = '" + baseUrl + "';");

        Thread.sleep(3000);

        WebElement checkBox = driver.findElement(By.id("bmwcheck"));
        js.executeScript("arguments[0].click();", checkBox);


        driver.close();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}

