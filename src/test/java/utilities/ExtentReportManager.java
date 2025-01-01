package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentTest test;

    /**
     * Initialize the ExtentReports instance.
     */
    public static void initializeReport(String reportName) {
        htmlReporter = new ExtentHtmlReporter("test-output/" + reportName + ".html");
        htmlReporter.config().setDocumentTitle("API Test Report");
        htmlReporter.config().setReportName("API Test Execution");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    /**
     * Create a test in the report.
     *
     * @param testName Name of the test.
     * @return ExtentTest instance.
     */
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    /**
     * Flush the ExtentReports to save the report.
     */
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}