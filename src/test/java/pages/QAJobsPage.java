package pages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;

public class QAJobsPage {
    public QAJobsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "See all QA jobs")
    public WebElement seeAllQaJobs;

    @FindBy (xpath = "//span[@class='select2-selection select2-selection--single']")
    public WebElement allLocationsSection;

    @FindBy (xpath = "//li[text()='Istanbul, Turkey']")
    public WebElement Istanbul;

    @FindBy(xpath = "//span[@id='select2-filter-by-location-container']")
    public WebElement selectedLocation;

    @FindBy(xpath = "//span[@data-select2-id='4']")
    public WebElement departmentSection;

    @FindBy(xpath = "//span[@id='select2-filter-by-department-container']")
    public WebElement selectedDepartment;

    @FindBy(css=".position-list-item-wrapper")
    public List<WebElement> searchList;

    @FindBy(xpath = "(//div[@class='position-list-item-wrapper bg-light'])[1]")
    public WebElement firstResult;

    @FindBy (linkText = "View Role")
    public WebElement viewRoleBtn;

    public void assertLocationAndJobType( String location, String jobType) {
        if (searchList.size() > 0) {
            for (WebElement element : searchList) {
                String elementText = element.getText();
                System.out.println(elementText);
                Assert.assertTrue(elementText.contains(location),
                        "The text does not contain the expected location: " + location);
                Assert.assertTrue(elementText.contains(jobType),
                        "The text does not contain the expected job type: " + jobType);
            }
            System.out.println("All elements contain the expected location and job type.");
        } else System.out.println("There is no job to be listed");
    }

    public void selectDropDownMenu(String location){
        String dynamicXPath = "//li[text()='" + location + "']";
        Driver.getDriver().findElement(By.xpath(dynamicXPath)).click();
    }
}
