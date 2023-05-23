package tests.Practice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.List;
public class P08 {
    @Test
    public void test01(){
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroBankUrl"));
        ReusableMethods.bekle(2);

        //2. Sign in butonuna basin
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.ilkSigninButonu.click();
        ReusableMethods.bekle(2);

        //3. Login kutusuna “username” yazin
        zeroPage.loginKutusu.sendKeys(ConfigReader.getProperty("zeroBankUsername"));

        //4. Password kutusuna “password” yazin
        zeroPage.password.sendKeys(ConfigReader.getProperty("zeroBankPassword"));
        ReusableMethods.bekle(2);

        //5. Sign in tusuna basin
        zeroPage.ikinciSigninButonu.click();
        ReusableMethods.bekle(2);

        //6. Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().navigate().back();
        zeroPage.onlineBanking.click();
        zeroPage.payBills.click();
        ReusableMethods.bekle(2);

        //7. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseFCurrency.click();

        //8. “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroPage.dropDown);
        select.selectByVisibleText(zeroPage.eurozone.getText());

        //9. soft assert kullanarak "Eurozone (euro) secildigini test edin
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(zeroPage.euroZoneGorunurlugu.isDisplayed());

        //10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        //"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China
        //(yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong
        //(dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand
        //(dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        String[] expectedOptions= {"Select One\\\", \\\"Australia (dollar)\\\", \\\"Canada (dollar)\\\",\\\"Switzerland (franc)\\\",\\\"China\\n\" +\n" +
                "                 \"         //(yuan)\\\",\\\"Denmark (krone)\\\",\\\"Eurozone (euro)\\\",\\\"Great Britain (pound)\\\",\\\"Hong Kong\\n\" +\n" +
                "                 \"         (dollar)\\\",\\\"Japan (yen)\\\",\\\"Mexico (peso)\\\",\\\"Norway (krone)\\\",\\\"New Zealand\\n\" +\n" +
                "                 \"         (dollar)\\\",\\\"Sweden (krona)\\\",\\\"Singapore (dollar)\\\",\\\"Thailand (baht)"};

        List<WebElement> actualOptions= select.getOptions();

        for (WebElement eachOptions:actualOptions
        ) {
            System.out.println(eachOptions.getText());
        }
        softAssert.assertEquals(expectedOptions.length,actualOptions.size());

        for (int i = 0; i < expectedOptions.length; i++) {
            softAssert.assertEquals(actualOptions.get(i).getText(),expectedOptions[i]);
        }

        Driver.closeDriver();
    }
}
