package utilities;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseAPI {
    @BeforeClass
    public void setupReport() {
        ExtentReportManager.initializeReport("PetAPI_Test_Report");
    }

    @AfterClass
    public void tearDownReport() {
        ExtentReportManager.flushReport();
    }

    protected void logResponse(Response response, ExtentTest test) {
        String responseBody = response.getBody().asPrettyString();
        test.info("Status Code: " + response.getStatusCode());
        test.info("Response Body: \n" + responseBody);
    }
}
