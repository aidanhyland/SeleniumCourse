package testNG;

import org.testng.annotations.Test;

public class TestnG_DataProviders {

    @Test(dataProvider = "inputs", dataProviderClass = TestData.class)
    public void testMethod(String input1, String input2) {

        System.out.println("Input 1: " + input1);
        System.out.println("Input 2: " + input2);

    }
}
