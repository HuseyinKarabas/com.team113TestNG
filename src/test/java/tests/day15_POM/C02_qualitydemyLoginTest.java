package tests.day15_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;
public class C02_qualitydemyLoginTest {
    @Test
    public void test01(){
        //qualitydemy ansayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com");
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        //login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.cookieKabulButonu.click();

        ReusableMethods.bekle(3);

        //gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");

        ReusableMethods.bekle(3);

        //login butonuna basin
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(3);

        //basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.basariliGirisKontrolElementi.isDisplayed());

        //sayfayi kapatin
        Driver.closeDriver();
        ReusableMethods.bekle(3);
    }
}
