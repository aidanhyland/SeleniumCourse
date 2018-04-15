package testNG;

import base.BaseTestSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestnG_SoftAssert extends BaseTestSuite {

    private SoftAssert sa = new SoftAssert();

    @Test
    public void testAddNumber(){
        System.out.println("Running test --> testAddNumber");
        SomeClassToTest c = new SomeClassToTest();
        sa.assertEquals(c.addNumbers(1,3), 4);
        sa.assertEquals(c.addNumbers(1,3), 4);
        sa.assertEquals(c.addNumbers(1,1), 2);
        sa.assertEquals(c.addNumbers(1,5), 6);
        sa.assertAll();
    }

}
