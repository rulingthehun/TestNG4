package Gun07;

import Gun06._02_PlaceOrderElements;
import Utility.BaseDriverChrome;
import Utility.Tools;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_WishListPOM extends BaseDriverChrome {
    @Test
    @Parameters("itemName")
    void addToWishList(String wordToFind){
        Gun06._02_PlaceOrderElements poe = new _02_PlaceOrderElements();
        poe.search.sendKeys(wordToFind);
        poe.search.sendKeys(Keys.ENTER);
        Gun07._02_WishListElements wle = new _02_WishListElements();
        int randomNum = Tools.randomGenerator(wle.searchResults.size());
        String wishItemName = wle.searchResults.get(randomNum).getText();
        System.out.println("wishItemName = " + wishItemName);
        wle.wishBtnList.get(randomNum).click();
        wle.btnWishList.click();

        Tools.listContainsString(wle.wishTableName, wishItemName);
    }
}
