package utils;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomTestListener implements ITestListener, ILogger {

//    private final WebDriver driver = DriverManager.getDriver();

    public CustomTestListener() {
    }

    @Override
    public void onStart(ITestContext context) {
        log().info("=== Test Suite [{}] STARTED ===", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log().info("=== Test Suite [{}] FINISHED ===", context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String version = result.getTestContext().getCurrentXmlTest().getParameter("version");
        String platform = result.getTestContext().getCurrentXmlTest().getParameter("platform");

        log().info(
                ">>> Test [{}] STARTED with parameters: browser={}, version={}, platform={}",
                result.getMethod().getMethodName(), browser, version, platform
        );
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log().info(">>> Test [{}] PASSED", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log().error("=== Test Suite [{}] FAILED ===", result.getName());
        takeScreenshot();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] takeScreenshot() {
        WebDriver driver = DriverManager.getDriver();
        log().info("Attempting to take screenshot");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotToFile(screenshot);
        log().info("Screenshot is taken");
        return screenshot;
    }

    private void saveScreenshotToFile(byte[] screenshot) {
        String filePath = "screenshots/" + System.currentTimeMillis() + ".png";
        File screenshotFile = new File(filePath);
        screenshotFile.getParentFile().mkdirs(); // Создаем директории, если их нет

        try (FileOutputStream fileOutputStream = new FileOutputStream(screenshotFile)) {
            fileOutputStream.write(screenshot);
            log().info("Screenshot saved to " + filePath);
        } catch (IOException e) {
            log().error("Failed to save screenshot to file", e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log().warn(">>> Test [{}] SKIPPED", result.getMethod().getMethodName());
        log().warn(result.getThrowable());
        log().warn(result.getSkipCausedBy());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log().warn(">>> Test [{}] FAILED WITHIN SUCCESS PERCENTAGE", result.getMethod().getMethodName());
        log().warn("Success percentage [{}]", result.getMethod().getSuccessPercentage());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log().error(">>> Test [{}] FAILED DUE TO TIMEOUT", result.getMethod().getMethodName());
        log().error(result.getThrowable());
        takeScreenshot();
    }
}
