package tests.Practice;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class P07 {
    //Navigate to https://www.saucedemo.com/
    //Enter the username as standard_user
    //Enter the password as secret_sauce
    //Click on login button
    //Test 1: Choose price Iow to high
    //Test 2:Verify item prices are sorted from Iow to high with soft Assert
    @Test
    public void suceDemo01(){
        Driver.getDriver().get(ConfigReader.getProperty("demoUrl"));
        ReusableMethods.bekle(2);

        SaucedemoPage saucedemoPage=new SaucedemoPage();
        saucedemoPage.username.sendKeys("standard_user");
        saucedemoPage.password.sendKeys("secret_sauce");
        ReusableMethods.bekle(2);

        saucedemoPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Select select=new Select(saucedemoPage.dropdownMenu);
        select.selectByVisibleText("Price (low to high)");
        ReusableMethods.bekle(2);
    }
    @Test
    public void suceDemo02(){
        SoftAssert softAssert=new SoftAssert();


        softAssert.assertAll();
    }
}
