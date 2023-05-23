package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroPage {
    public ZeroPage (){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="signin_button")
    public WebElement ilkSigninButonu;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginKutusu;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement ikinciSigninButonu;

    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//*[@id= 'pay_bills_link']")
    public WebElement payBills;

    @FindBy(xpath = "//*[text()= 'Purchase Foreign Currency']")
    public WebElement purchaseFCurrency;

    @FindBy(xpath = "//*[@id= 'pc_currency']")
    public WebElement dropDown;

    @FindBy(xpath = "//*[text()= 'Eurozone (euro)']")
    public WebElement eurozone;

    @FindBy(xpath = "//span[@id='sp_sell_rate']")
    public WebElement euroZoneGorunurlugu;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public List<WebElement> dropDownList;
}
