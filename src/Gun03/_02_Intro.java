package Gun03;

import Utility.BaseDriverChrome;
import org.testng.annotations.*;

public class _02_Intro {
      /*
        @BeforeTest
            @BeforeClass
                @BeforeMethod
                    @Test1 method
                    @Test2 method
                @AfterMethod
           @AfterClass
        @AfterSuit
     */
    @BeforeSuite
    void bSuit(){System.out.println("Before Suit");}

    @BeforeTest
    void bTest(){System.out.println("Before Test");}

    @BeforeGroups
    void bGroups(){System.out.println("Before Groups");}

    @BeforeClass
    void bClass(){System.out.println("Before Class");}

    @BeforeMethod
    void bMethod(){System.out.println("Before Test");}

    @Test
    void Intro1_Test1(){System.out.println("Intro1_Test 1");}

    @Test
    void Intro1_Test2(){System.out.println("Intro1_Test 2");}
    @AfterMethod
    void aMethod(){System.out.println("After Method");}

    @AfterClass
    void aClass(){System.out.println("After Class");}

    @AfterGroups
    void aGroups(){System.out.println("After Groups");}

    @AfterTest
    void aTest(){System.out.println("After Test");}

    @AfterSuite
    void aSuit(){System.out.println("After Suit");}
}
