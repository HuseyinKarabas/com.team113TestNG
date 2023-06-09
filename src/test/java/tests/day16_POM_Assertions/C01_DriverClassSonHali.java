package tests.day16_POM_Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class C01_DriverClassSonHali {

    //3 tane test methodu olusturalim
    //1. method'da amazon'a gidip, url'nin amazon icerdigini test edin
    @Test
    public void amazonTest(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
    //2. method'da Wisequarter anasayfaya gidip, title'in Wise Quarter icerdigini test edin
    @Test
    public void wiseTest(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
        String expectedIcerik="Wise Quarter";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
    //3. method'da facebook anasayfaya gidip, title'in facebook icerdigini test edin
    @Test
    public void facebookTest(){
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        String expectedIcerik="Facebook";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        ReusableMethods.bekle(3);
        Driver.closeDriver();
    }
    //her method'da yeni driver olusturup method sonunda driver'i kapatin
}
