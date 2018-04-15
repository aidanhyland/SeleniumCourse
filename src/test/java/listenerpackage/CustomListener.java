package listenerpackage;

import org.testng.*;

public class CustomListener implements IInvokedMethodListener, ITestListener, ISuiteListener{

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Before every method in the test class
        System.out.println("BeforeInvocation: " + testResult.getTestClass().getName()
                + " -> " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // After every method in the test class
        System.out.println("AfterInvocation: " + testResult.getTestClass().getName()
                + " -> " + method.getTestMethod().getMethodName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // When test method starts
        System.out.println("onTestStart -> NAME: " +  iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess -> SUCCESS " +  iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure -> FAILURE " +  iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped -> SKIP " +  iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //Ignore
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // before <test> tag of XML file
        System.out.println("onStart -> NAME: " +  iTestContext.getName());
        ITestNGMethod methods[] = iTestContext.getAllTestMethods();
        System.out.println("These methods will be executed");

        for(ITestNGMethod m : methods)
            System.out.println(m.getMethodName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // after <test> tag of XML file
        System.out.println("onFinish -> NAME: " +  iTestContext.getName());

    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart: before suite starts");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish: after suite completes");
    }
}
