package testNG;

import org.testng.annotations.Test;

public class TestnG_Parallel2 {

    @Test
    public void test1() throws InterruptedException {
        System.out.println("TestnG_Parallel2 --> test1");
        Thread.sleep(6000);
        System.out.println("TestnG_Parallel2 --> test1 --> more steps");
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("TestnG_Parallel2 --> test2");
        Thread.sleep(6000);
        System.out.println("TestnG_Parallel2 --> test2 --> more steps");
    }

}
