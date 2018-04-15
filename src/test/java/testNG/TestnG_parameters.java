package testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestnG_parameters {

    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setUp(String browser, String platform) {
        System.out.println("TestnG_parameters --> setup");
        System.out.println("TestnG_parameters value 1 from xml - " + browser);
        System.out.println("TestnG_parameters value 2 from xml - " + platform);
    }

    @Test
    @Parameters({"response"})
    public void test1(String response){
        System.out.println("TestnG_parameters --> test1");
        System.out.println("TestnG_parameters value 3 from xml - " + response);
    }
}
