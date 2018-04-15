package generalSelenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class seleniumTests {

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
    public void testApp1() {
        driver.get(baseUrl);
        driver.findElement(By.id("bmwradio")).click();
        System.out.println("The BMW checkbox is clicked: " + driver.findElement(By.id("bmwradio")).isSelected());
        driver.close();
    }

    @Test
    public void testApp2() {
        driver.get(baseUrl);
        boolean textAppears = driver.getPageSource().contains("Kode");
        Assert.assertTrue(textAppears);
        System.out.print("'Kode' appears in the page source : " + textAppears + "\n");
        driver.close();
    }

    @Test
    public void testApp3() {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.id("lst-ib"));
        System.out.println("Is <" + element + "> enabled? " + element.isEnabled());
        driver.close();
    }



    @After
    public void tearDown() {
        driver.quit();
    }

}
