package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestnG_Priority {

    @Test(priority = 2)
    public void test1(){
        System.out.println("Running test --> test1");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addNumbers(1,3), 4);
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Running test --> test2");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addStrings("Aidan", "Hyland"), "AidanHyland");
    }

    @Test(priority = 0)
    public void test3(){
        System.out.println("Running test --> test3");
        int[] testArray =  new int[]{1,2,3,4};
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.getArray(), testArray);
    }

}
