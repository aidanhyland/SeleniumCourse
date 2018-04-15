package generalSelenium;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.SystemProperties;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShotsTest {

    private WebDriver driver;

    @Before
    public void setUp(){

        SystemProperties.setSystemProperties();

        driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void findDateDirectly() throws IOException {
        driver.get("http://www.expedia.com/");

        driver.findElement(By.id("tab-flight-tab-hp")).click();

        takeScreenShot();

        driver.close();
    }

    private void takeScreenShot() throws IOException {
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("/Users/aidanhyland/Desktop/" + (int) (Math.random() * 10) + ".jpeg"));
    }


    @After
    public void tearDown() {


        driver.quit();
    }
}
