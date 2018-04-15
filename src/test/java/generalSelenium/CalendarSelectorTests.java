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

public class CalendarSelectorTests {

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
    public void findDateDirectly() throws InterruptedException {
        driver.get("http://www.expedia.com/");
        // click flights tab
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        // find departing field
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        // click departing field
        departingField.click();
        Thread.sleep(3000);
        // find the date to be selected
        WebElement dateToSelect = driver.findElement(
                By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[text()='31']"));
        dateToSelect.click();
        driver.close();
    }

    @Test
    public void findDateViaList() throws InterruptedException {
        driver.get("http://www.expedia.com/");
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
        departingField.click();
        Thread.sleep(3000);

        WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
        List<WebElement> allValidDates = calMonth.findElements(By.tagName("a"));

        for(WebElement d : allValidDates){
            if(d.getText().equals("31")) {
                d.click();
                break;
            }
        }
        driver.close();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
