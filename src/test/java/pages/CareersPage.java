package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CareersPage {
    public CareersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@data-id='21cea83']")
    public WebElement lifeAtInsider;

    @FindBy(xpath = "//div[@data-id='b1a909d']")
    public WebElement locations;

    @FindBy(xpath = "//div[@data-id='4a40266']")
    public WebElement findYourCalling;
}
