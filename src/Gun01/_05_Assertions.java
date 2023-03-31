package Gun01;

import Utility.BaseDriverEdge;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Assertions {
    // Yeşil tik  : test de hata yok
    // Sarı çarpi : test de hata var
    // Beyaz      : test çalıştırılmadı.skip
    @Test
    void EqualOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";
        //Actual, Expected, Message (optional)
        Assert.assertEquals(s1, s2, "Karşılaştırma sonucu"); //Hard assertion, soft assertion
    }

    @Test
    void NotEqualOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba.";

        Assert.assertNotEquals(s1, s2, "Karşılaştırma sonucu");
    }

    @Test
    void TrueOrnek() {
        int n1 = 5;
        int n2 = 6;

        Assert.assertNotEquals(n1, n2, "Karşılaştırma sonucu");
    }

    @Test
    void nullOrnek() {
        String s1 = null;
        String s2 = "";

        Assert.assertNull(s1, "İşlem sonucu");
        Assert.assertNull(s2, "İşlem sonucu");
    }

    @Test
    void DirectlyFail() {
        int a = 44;

        Assert.fail("fail e.g.");
    }
}
