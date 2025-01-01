package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Screenshot taken for failed test: " + result.getName());
            } catch (IOException e) {
                System.out.println("Exception while taking screenshot: " + e.getMessage());
            }
        }
        Driver.quitDriver();
    }
}
