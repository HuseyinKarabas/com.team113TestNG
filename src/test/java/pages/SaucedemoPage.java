package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SaucedemoPage {
    public SaucedemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath ="(//input[@class='input_error form_input'])[1]")
    public WebElement username;

    @FindBy(xpath = "(//input[@class='input_error form_input'])[2]")
    public WebElement password;

    @FindBy(xpath = "//input[@class='submit-button btn_action']")
    public WebElement loginButonu;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement dropdownMenu;

    @FindBy(xpath="//div[@class='inventory_item_price']")
    public List<WebElement> fiyatlarList;
}
