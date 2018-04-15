package listenerpackage;

import org.testng.*;

public class CustomListener3 implements ISuiteListener {


    @Override
    public void onStart(ISuite suite) {

        System.out.println("onStart: before suite starts");

    }

    @Override
    public void onFinish(ISuite suite) {

        System.out.println("onFinish: after suite completes");

    }
}
