package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@value='1']")
    public WebElement loginElement;

    @FindBy(xpath = "(//button[@value='1'])[2]")
    public WebElement fbCerezRed;
}
