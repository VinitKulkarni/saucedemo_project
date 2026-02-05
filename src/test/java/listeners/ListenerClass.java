package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " Test case started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " Test case sucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " Test case failed");
		System.out.println("=======");
		System.out.println("screenshot code");
		System.out.println("=======");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " Test case skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("WELCOME TO SAUCEDEMO TESTING");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("END OF SAUCEDEMO TESTING");
	}
}
