package preRequisitSetUp;

public class SystemProperties {

    public static void setSystemProperties() {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        System.setProperty("webdriver.chrome.silentOutput", "true");
    }
}
