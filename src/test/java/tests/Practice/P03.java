package tests.Practice;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class P03 {
    @Test
    public void test01(){

        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("fbUrl"));

        ReusableMethods.bekle(3);

        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        FacebookPage facebookPage=new FacebookPage();
        facebookPage.fbCerezRed.click();

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        ReusableMethods.bekle(3);
        facebookPage.loginElement.click();
        ReusableMethods.bekle(3);

        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.loginElement.isEnabled());
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
}
