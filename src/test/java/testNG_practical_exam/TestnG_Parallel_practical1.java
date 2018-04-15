package testNG_practical_exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import preRequisitSetUp.SystemProperties;

import java.util.concurrent.TimeUnit;

public class TestnG_Parallel_practical1 {


    WebDriver driver;
    String baseUrl;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser){
        baseUrl =  "http://letskodeit.teachable.com";
        if(browser.equalsIgnoreCase("chrome")) {
            SystemProperties.setSystemProperties();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {

        WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("user_email"));
        emailField.sendKeys("test@email.com");
        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("abc");
        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

    }


}
