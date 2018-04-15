package testNG;

import org.testng.annotations.Test;

public class TestnG_TestAttributes
{

    private SomeClassToTest sc;

    @Test
    public void setUp(){
      sc = new SomeClassToTest();
    }

    @Test (dependsOnMethods = "setUp")
    public void test10(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test(enabled = false)
    public void test3(){
        System.out.println("test3");
    }

    @Test(timeOut = 400)
    public void test4() throws InterruptedException {
        System.out.println("test4");
        Thread.sleep(300);
    }

    @Test
    public void test5(){
        System.out.println("test5");
    }

}
