package tests.Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SaucedemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;

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

        List<WebElement> fiyatlarList=saucedemoPage.fiyatlarList;

        SoftAssert softAssert=new SoftAssert();

        for (int i = 0; i <fiyatlarList.size()-1 ; i++) {
            String price1=fiyatlarList.get(i).getText().substring(1);
            System.out.println("price 1: "+price1);
            String price2=fiyatlarList.get(i+1).getText().substring(1);
            System.out.println("price 2: "+price2);

            ReusableMethods.bekle(2);

            double priceValue1=Double.parseDouble(price1);
            double priceValue2=Double.parseDouble(price2);
            softAssert.assertTrue(priceValue1<=priceValue2);

        }
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
