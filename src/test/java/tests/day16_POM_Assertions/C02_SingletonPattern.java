package tests.day16_POM_Assertions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
public class C02_SingletonPattern {
    /*
    Otomasyon icin elimiz ve kolumuz olarak Driver class'indaki
    WebDriver driver objesini kullaniyoruz ANCAK driver'in bizim
    istedigimiz islemleri yapabilmesi icin öncelikle
    getDriver() icinde yaptigimiz atama islemlerine ihtiyaci var.

    Bir framework'de calisan kisilerin getDriver() kullanmadan direk driver objesine
    erisimini engellemek icin Singleton Pattern kullanimi TERCİH EDİLMİSTİR.

    Singleton Pattern bir class'dan obje olusturulmasini ve o obje ile class'daki
    class uyelerine erisimi engellemek icin kullanilir.

    OOP koncept cercevesinde Driver class'ini farkli farkli yontemlerle kullanabilirsiniz
    Ekip cakismasinin tek duzen uzerinden gitmesi onemli oldugundan

    farkli yontemlerle WebDriver driver'in kullanimini engellemek istiyoruz
     */
    @Test
    public void test01(){
       // Driver.driver.get(ConfigReader.getProperty("amazonUrl"));
        /*
        getDriver() calismadigindan driver null olarak isaretlendiginden
        NullPointerException verir.
         */
        //Driver driver=new Driver();
        //driver.get("https://www.amazon.com")
        //driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        /*
        Driver class'indaki constructor'i private yapinca kimse Driver
        class'indan obje olusturamaz.
         */
        System.out.println(Driver.driver);


    }
}
