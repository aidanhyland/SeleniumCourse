package testNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import preRequisitSetUp.SystemProperties;

public class SeleniumLoginTest {

    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;

    @BeforeClass
    public void beforeClass() {

        report = new ExtentReports("/Users/aidanhyland/Desktop/Reports.html");
        test = report.startTest("Verify welcome test");
        baseUrl = "http://www.letskodeit.com/";
        SystemProperties.setSystemProperties();
        driver = new ChromeDriver();

        test.log(LogStatus.INFO, "Browser Started...");
        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximised...");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web Application opened...");
    }

    @Test
    public void test1_validLoginTest() throws Exception {
        WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
        signupLink.click();
        test.log(LogStatus.INFO, "Clicked on logIn link...");

        WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
        loginLink.click();

        WebElement emailField = driver.findElement(By.id("memberLoginDialogemailInputinput"));
        emailField.sendKeys("test23@email.com");

        WebElement passwordField = driver.findElement(By.id("memberLoginDialogpasswordInputinput"));
        passwordField.sendKeys("abcabc");

        WebElement goButton = driver.findElement(By.id("memberLoginDialogoklink"));
        goButton.click();
        test.log(LogStatus.INFO, "Clicked the go button...");

        Thread.sleep(3000);

        WebElement welcomeText = null;

        try {
            welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        Assert.assertTrue(welcomeText != null);
        test.log(LogStatus.PASS, "Verified logIn test...");
    }

    @AfterMethod
    public void tearDown(ITestResult iTest) throws IOException {
        if(iTest.getStatus() == ITestResult.FAILURE) {
            String dir = "/Users/aidanhyland/Desktop/screenshot.png";
            File pic = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(pic, new File(dir));
            String path = test.addScreenCapture(dir);
            test.log(LogStatus.FAIL, "Verify LogIn test failed", path);
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        report.endTest(test);
        report.flush();

    }
}