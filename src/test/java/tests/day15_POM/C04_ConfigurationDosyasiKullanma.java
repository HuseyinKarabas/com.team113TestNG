package tests.day15_POM;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_ConfigurationDosyasiKullanma {
    /*
    POM'de hedef test class'inda
    manuel olarak hic bir Test Data'si GIRMEMEKTIR

    Test datalari :
    1- Kullanacagimiz WebDriver : Driver class'indan dinamik olarak kullaniyoruz
    2- Locate : Locate'leri pages sayfalarindan dinamik olarak kullaniyoruz
    3- kullanilan Url, aranan kelime, expected icerik, dogru kullanici adi,
    yanlis kullanici adi, yanlis sifre... gibi datalar
     */
    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.bekle(3);

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        ReusableMethods.bekle(3);

        String expectedIcerik=ConfigReader.getProperty("amazonExpectedIcerik");
        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        ReusableMethods.bekle(3);

        Driver.closeDriver();
        ReusableMethods.bekle(3);




    }
}
