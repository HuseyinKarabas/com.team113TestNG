package tests.day15_POM;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class C06_QualitydemyNegatifLoginTesti {
    @Test
    public void gecersizIsimSifreTesti(){
        //Qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //log in linkine tiklayin
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.cookieKabulButonu.click();
        ReusableMethods.bekle(3);
        qualitydemyPage.ilkLoginLinki.click();

        //gecersiz username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        //login butonuna basarak
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(3);

        //basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
        ReusableMethods.bekle(3);
    }
    @Test(groups = "smoke")
    public void gecersizIsimTesti(){
        //Qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //log in linkine tiklayin
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.cookieKabulButonu.click();
        ReusableMethods.bekle(3);
        qualitydemyPage.ilkLoginLinki.click();

        //gecersiz username ve gecerli sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        //login butonuna basarak
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(3);

        //basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
        ReusableMethods.bekle(3);
    }
    @Test
    public void gecersizSifreTesti(){
        //Qualitydemy ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        //log in linkine tiklayin
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.cookieKabulButonu.click();
        ReusableMethods.bekle(3);
        qualitydemyPage.ilkLoginLinki.click();

        //gecerli username ve gecersiz sifre yi ilgili kutulara yazin
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        //login butonuna basarak
        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(3);

        //basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        //sayfayi kapatin
        Driver.closeDriver();
        ReusableMethods.bekle(3);
    }
}
