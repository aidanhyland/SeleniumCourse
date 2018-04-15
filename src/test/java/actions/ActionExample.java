package actions;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import preRequisitSetUp.PropertyPathLocator;
import preRequisitSetUp.SystemProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ActionExample {

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
        js = (JavascriptExecutor)driver;
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        baseUrl = prop.getProperty("baseUrl");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void button_hoverOver() throws InterruptedException {
        driver.get(baseUrl);
        js.executeScript("window.scrollBy(0, 600);");
        Thread.sleep(3000);

        WebElement mainElement =  driver.findElement(By.xpath("//*[@id=\"mousehover\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        Thread.sleep(3000);

        WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
        action.moveToElement(subElement).click().perform();
    }

    @Test
    public void drag_drop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(3000);
        driver.switchTo().frame(0);

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions action =  new Actions(driver);

        // Drag and drop
        action.dragAndDrop(drag,drop).build().perform();

        // Click and hold
        //action.clickAndHold(drag).moveToElement(drag).release().build().perform();
    }

    @Test
    public void slider() throws InterruptedException {
        driver.get("https://jqueryui.com/slider/");
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        WebElement slider = driver.findElement(By.xpath("//*[@id='slider']//span"));

        Actions action =  new Actions(driver);
        action.dragAndDropBy(slider, 100, 0).perform();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
