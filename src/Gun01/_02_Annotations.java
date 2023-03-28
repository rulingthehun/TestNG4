package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
    /*
      @BeforeClass    --> // Class'ın başında çalışır
        @BeforeMethod --> // Her methodda önce çalışacak (@Test)
          @Test       --> // Testlerin çalıştığı methodlar
          @Test       --> // Testlerin çalıştığı methodlar
        @AfterMethod  --> // Her methoddan sonra çalışır
      @AfterMethod    --> // Class'ın çalışmasının sonunda çalışır (like driverStop)
     */

    @BeforeClass
    void beforeClass() {
        System.out.println("Started before every class");
        // driver ve test öncesi diğer bütün işlemler burada yapılır
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Started before every method");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Started after every method");
    }

    @AfterClass
    void afterClass() {
        System.out.println("Started after every class");
        // driverStop vb...
    }

    @Test
    void test1() {
        System.out.println("Test 1 build");
    }

    @Test
    void test2() {
        System.out.println("Test 2 build");
    }
}
