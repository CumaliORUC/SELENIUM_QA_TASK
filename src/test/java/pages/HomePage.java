package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Company")
    public WebElement companyMenu;

    @FindBy(linkText = "Careers")
    public WebElement careerOptions;

    @FindBy(xpath ="//a[@id='wt-cli-accept-all-btn']")
    public WebElement acceptAllCookiesBtn;


    public void acceptAllCookies(){
        acceptAllCookiesBtn.click();
    }
}
