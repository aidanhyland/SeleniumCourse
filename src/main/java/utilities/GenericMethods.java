package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GenericMethods {

    WebDriver driver;

    public GenericMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String locator, String type){

        type = type.toLowerCase();

        if (type.equals("id")){
            System.out.println("Finding element with id: " + locator);
            return this.driver.findElement(By.id(locator));
        }
        else if (type.equals("xpath")){
            System.out.println("Finding element with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        }
        else {
            System.out.println("Locator type not supported");
            return null;
        }

    }

    public List<WebElement> getElementList(String locator, String type){

        type = type.toLowerCase();
        List<WebElement> elementList;

        if (type.equals("id"))
            elementList =  this.driver.findElements(By.id(locator));
        else if (type.equals("xpath"))
            elementList = this.driver.findElements(By.xpath(locator));
        else {
            System.out.println("Locator type not supported");
            return null;
        }

        if(elementList.size() > 0) {
            System.out.println("Found element with " + type + " : " + locator);
            return elementList;
        }
        else {
            System.out.println("Did not find element with " + type + " : " + locator);
            return elementList;
        }

    }

    public boolean isElementPresent(String locator, String type){

        List<WebElement> elementList = getElementList(locator, type);
        return elementList.size() > 0;
    }

    public WebElement waitForElement (By locator, int timeout){

        WebElement element = null;

        try{
            System.out.println("Waiting for a max < " + timeout + " > seconds for the element to appear");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (Exception e){
            System.out.println("Element did not appear on the page");
        }

        return element;

    }

    public void clickWhenReady (By locator, int timeout){

        try{
            System.out.println("Waiting for a max < " + timeout + " > seconds for the element to be clickable");

            WebDriverWait wait = new WebDriverWait(driver, 3);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();

        } catch (Exception e){
            System.out.println("Element did not appear on the page");
        }

    }
}
