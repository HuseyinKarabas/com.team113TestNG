package tests.Practice;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class P04 {
    static String sifre="12zjd*99jjd";
    @Test
    public void test01(){


        SoftAssert softAssert=new SoftAssert();

        softAssert.assertFalse(sifre.contains(" "),"Bosluk içermemeli");
        softAssert.assertFalse(sifre.length()>=8,"uzunluk en az 8 karakter olmali");

        softAssert.assertAll();
    }
}
