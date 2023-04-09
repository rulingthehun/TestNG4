package Gun05;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _05_SoftAssertVsHardAssert {
    @Test
    void hardAssert(){
        String s1 = "Merhaba";
        System.out.println("Hard Assert öncesi");
        Assert.assertEquals("Merhaba 123", s1, "HardAssert sonucu");
        System.out.println("Hard Assert kontrol sonrası");
    }

    @Test
    void softAssert(){
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";
        System.out.println("Hard Assert öncesi");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("www.facebook.com/homepage", strHomePage);
        System.out.println("assert 1");

        softAssert.assertEquals("www.facebook.com/profile", strCartPage);
        System.out.println("assert 2");

        softAssert.assertEquals("www.facebook.com/settings", strEditAccount);
        System.out.println("assert 3");

        softAssert.assertAll();
        System.out.println("Aktiflik sonrası");
    }
}
