package base;

import org.testng.annotations.*;

public class BaseTestSuite {

    @BeforeClass
    public void beforeClass(){
        System.out.println("BaseTestSuite --> before class");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("BaseTestSuite --> after class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BaseTestSuite --> before method");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("BaseTestSuite --> after method");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BaseTestSuite --> beforeTest");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("BaseTestSuite --> afterTest");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BaseTestSuite --> beforeSuite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("BaseTestSuite --> AfterSuite");
    }

}
