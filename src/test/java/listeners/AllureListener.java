package listeners;

import base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

import java.io.ByteArrayInputStream;

public class AllureListener extends AllureTestNg implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("START TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS TEST: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAIL TEST: " + result.getName());

        Object testClass = result.getInstance();
        BaseTest baseTest = (BaseTest) testClass;

        try {
            byte[] screenshot = ((TakesScreenshot) baseTest.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment(
                    result.getName(),
                    new ByteArrayInputStream(screenshot)
            );

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}