package findAllLinks;

import org.apache.http.HttpConnection;
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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FindLinks {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() {
        SystemProperties.setSystemProperties();
        driver = new ChromeDriver();
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow).manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void find_all_links() {
        driver.get("http://www.expedia.com/");
        List<WebElement> linksList = clickableLinks(driver);
        for (WebElement e : linksList) {
            String href = e.getAttribute("href");
            try {
                System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }


    public static List<WebElement> clickableLinks(WebDriver driver) {

        List<WebElement> linksToClick = new ArrayList<WebElement>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements)
            if(e.getAttribute("href") != null)
                linksToClick.add(e);

        return linksToClick;
    }

    public static String linkStatus (URL url) {
       try {
           HttpURLConnection http = (HttpURLConnection) url.openConnection();
           http.connect();
           return http.getResponseMessage();
       }
       catch (Exception e){
           return e.getMessage();
       }
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}

