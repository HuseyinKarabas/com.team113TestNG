package tests.day18_TestNGReports_ParalelCalistirma;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class C01_RaporluAmazonSearch extends TestBaseRapor {
    @Test
    public void test01(){

        extentTest=extentReports.createTest("Amazon arama testi","Kullanici istedigi kelimeyi aratabilmeli");

      //amazon'a gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici Amazon anasayfaya gider");
        ReusableMethods.bekle(2);

      //Nutella icin arama yapin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
        extentTest.info("Arama kutusuna belirlenen aranacak kelimeyi yazar ve aratır");
        ReusableMethods.bekle(2);

      //arama sonuclarinin Nutella icerdigini test edin

        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String expectedIcerik=ConfigReader.getProperty("amazonExpectedIcerik");
        extentTest.info("Arama sonucları kaydedildi");
        ReusableMethods.bekle(2);

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        extentTest.pass("belirlenen aranacak kelime aratıldıgında , arama sonucunda expected icerik oldugu test edildi");
        Driver.closeDriver();
    }
}
