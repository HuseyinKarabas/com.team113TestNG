package tests.day18_TestNGReports_ParalelCalistirma;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {
    @Test
    public void test01(){

        extentTest=extentReports.createTest("Nutella testi","Kullanici amazonda Nutella aratti");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("Arama kutusuna Nutella yazip, arama yapildi");

        String actualSonucYazisi=amazonPage.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("Arama sonucları kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("Arama sonuclarinin Nutella icerdigi test edildi");
    }
}
