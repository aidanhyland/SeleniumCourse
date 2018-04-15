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
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GenericMethodsTests {

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void elementTest_genericMethods() {
        driver.get(baseUrl);
        WebElement el = gm.getElement("bmwradio", "id");
        el.click();
        System.out.println("The BMW checkbox is clicked: " + driver.findElement(By.id("bmwradio")).isSelected());
        driver.close();
    }

    @Test
    public void elementListTest_genericMethods() {
        driver.get(baseUrl);
        List<WebElement> elementList = gm.getElementList("//input[@type='text']", "xpath");
        System.out.println("Element size: " + elementList.size());
        driver.close();
    }

    @Test
    public void isElementPresent_genericMethods() {
        driver.get(baseUrl);
        System.out.println("The element is present : " + gm.isElementPresent("name", "id"));
        System.out.println("The element is present : " + gm.isElementPresent("name-not-present", "id"));
        driver.close();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
