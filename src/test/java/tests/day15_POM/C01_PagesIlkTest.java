package tests.day15_POM;

import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesIlkTest {

    @Test
    public void amazonTest(){
        //amazon anasayfaya gidelim
        Driver.getDriver().get("https://www.amazon.com");

        //Nutella icin arama yapalim

        /*
        Arama kutusunun locate'i pages sayfasinda POM'de pages sayfasindaki locate'lere
        erismek icin pages sayfalarindan bir obje olusturulur.
         */
        AmazonPage amazonPage=new AmazonPage();

        //sonuclarin Nutella icerdigini test edelim

        //sayfayi kapatalim
    }
}
