package tests.Practice;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
public class P06 {
    //- Birbirine bağımlı testler oluşturarak
    //- ilk once wisequarte'a gidin
    //-sonra wisequarte'a bağımlı olarak youtube'a gidin
    // daha sonra youtube'a bağımlı olarak amazon' a gidin
    //- driver'i kapatın.
    @Test
    public void wisequarter(){
        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }
    @Test(dependsOnMethods = "wisequarter")
    public void youtube(){
        Driver.getDriver().get(ConfigReader.getProperty("youtubeUrl"));
    }
    @Test(dependsOnMethods = "youtube")
    public void amazon(){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.closeDriver();
    }
}
