package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestnG_Groups {

    @Test(groups = {"cars"})
    public void test1(){
        System.out.println("Running test --> cars");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addNumbers(1,3), 4);
    }

    @Test(groups = {"trucks"})
    public void test2(){
        System.out.println("Running test --> trucks");
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.addStrings("Aidan", "Hyland"), "AidanHyland");
    }

    @Test(groups = {"bikes"})
    public void test3(){
        System.out.println("Running test --> bikes");
        int[] testArray =  new int[]{1,2,3,4};
        SomeClassToTest c = new SomeClassToTest();
        Assert.assertEquals(c.getArray(), testArray);
    }

}
