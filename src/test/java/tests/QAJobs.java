package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.QAJobsPage;
import utilities.BaseTest;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReuseableMethods;

public class QAJobs extends BaseTest {
    HomePage homePage=new HomePage();
    QAJobsPage qaJobsPage=new QAJobsPage();

    @Test
    public void QAjobs() throws InterruptedException {
        // 3.    Go to https://useinsider.com/careers/quality-assurance/,
        Driver.getDriver().get(ConfigReader.getProperty("qualityAssurancePage"));
        homePage.acceptAllCookies();
        String pagetitle=Driver.getDriver().getTitle();
        Assert.assertTrue(pagetitle.contains("quality assurance"));

        //click “See all QA jobs”, filter
        //jobs by Location: “Istanbul, Turkey”, and
        // Department: “Quality Assurance”, check the
        qaJobsPage.seeAllQaJobs.click();
        qaJobsPage.allLocationsSection.click();
        qaJobsPage.selectDropDownMenu("Istanbul, Turkey");
        System.out.println(qaJobsPage.selectedLocation.getText());
        Assert.assertTrue(qaJobsPage.selectedLocation.getText().contains("Istanbul"));
        qaJobsPage.departmentSection.click();
        qaJobsPage.selectDropDownMenu("Quality Assurance");

        //presence of the job list
        Assert.assertTrue(qaJobsPage.selectedDepartment.getText().contains("Quality Assurance"));

        // 4.    Check that all jobs’ Position contains “Quality Assurance”, Department contains
        //“Quality Assurance”, and Location contains “Istanbul, Turkey”
        ReuseableMethods.scrollToElement(Driver.getDriver(), qaJobsPage.searchList.get(0));
        Thread.sleep(5000);
        qaJobsPage.assertLocationAndJobType("Istanbul, Turkey","Quality Assurance");

        // 5.    Click the “View Role” button and
        // check that this action redirects us to the Lever
        //Application form page

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(qaJobsPage.firstResult).perform();
        qaJobsPage.viewRoleBtn.click();

        ReuseableMethods.switchToNewWindow(Driver.getDriver());
        String jobsLeverPageURL=Driver.getDriver().getCurrentUrl();
        System.out.println(jobsLeverPageURL);
        Assert.assertTrue(jobsLeverPageURL.contains("jobs.lever"));
        Driver.quitDriver();
    }
}
