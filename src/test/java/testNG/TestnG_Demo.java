package testNG;

import base.BaseTestSuite;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestnG_Demo extends BaseTestSuite{

    @Test
    public void testAddNumber(){
        System.out.println("Running test --> testAddNumber");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addNumbers(1,3), 4);
    }

    @Test
    public void testAddString(){
        System.out.println("Running test --> testAddString");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addStrings("Aidan", "Hyland"), "AidanHyland");
    }

    @Test
    public void testGetArray(){
        System.out.println("Running test --> testGetArray");
        int[] testArray =  new int[]{1,2,3,4};
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.getArray(), testArray);
    }

}
