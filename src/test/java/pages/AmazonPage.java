package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    /*
    page class'lari sürekli kullandigimiz locate islemleri ve varsa
    login gibi kucuk islevleri iceren method'lar barindirir.
    Selenium ile locate islemi veya herhangi bir islev gerceklestirmek istedigimizde
    WebDriver objesine ihtiyac vardir.

    POM'de Driver class'inda olusturdugumuz WebDriver driver objesini page class'larina tanimlamak icin
    PageFactory class'indan initElements() kullanilir.
     */

    AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        /*
        Bu ayari constructor icine koyma sebebimiz:
        page sayfalarina obje olusturularak ulasildigi için kim page
        sayfasini kullanmak isterse pages sayfasindan obje olusturmak için
        constructor calisacak ve bu constructor'in icinde bulunan initElements()
        gerekli ayari yapmiş olacak.
         */
    }
}
