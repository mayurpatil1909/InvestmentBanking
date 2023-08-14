package ai.ds.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerSetup implements ITestListener {


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Execution completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Execution failed");
		UtilClass.takeSS(result.getName()+System.currentTimeMillis());
		System.out.println("Screenshot taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Execution Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}
