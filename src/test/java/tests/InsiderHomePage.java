package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CareersPage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class InsiderHomePage{
    HomePage homePage=new HomePage();
    CareersPage careerPage=new CareersPage();
    @Test
    public void homePage(){
        //1. Visit https://useinsider.com/ and check Insider home page is opened or not
        Driver.getDriver().get(ConfigReader.getProperty("insiderURL"));
        String title=Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("Insider"));

        //2. Select the “Company” menu in the navigation bar, select “Careers” and check Career
        //page, its Locations, Teams, and Life at Insider blocks are open or not
        homePage.companyMenu.click();
        homePage.careerOptions.click();
        String pageURL=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(pageURL,ConfigReader.getProperty("careersPageURL"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(careerPage.locations.isDisplayed());
        softAssert.assertTrue(careerPage.lifeAtInsider.isDisplayed());
        softAssert.assertTrue(careerPage.findYourCalling.isDisplayed());
        softAssert.assertAll();
    }

}
