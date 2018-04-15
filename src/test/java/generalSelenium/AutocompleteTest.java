package generalSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.SystemProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutocompleteTest {

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
    public void autoCompleteTest() throws InterruptedException {
        driver.get("http://www.southwest.com/");

        String searchingText = "York/Newark, NJ - EWR";
        String partialText = "New York";

        WebElement text = driver.findElement(By.id("air-city-departure"));
        text.sendKeys(partialText);

        WebElement autoList = driver.findElement(By.id("air-city-departure-menu"));

        List<WebElement> results =  autoList.findElements(By.tagName("li"));

        Thread.sleep(3000);

        for (WebElement result : results)
            System.out.println(result.getText());

        for( WebElement item : results) {
            if (item.getText().equals(searchingText))
                item.click();
        }
        driver.close();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
