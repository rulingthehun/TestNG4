package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DataProvider_Iterator {

    @Test(dataProvider = "getData")
        // SearchTest methodunun data sağlacısı getData fonksiyonudur.
    void SearchTest(String searchText) {
        System.out.println(searchText);
    }

    @DataProvider
        // Bu methoda dataprovider görevi verildi.
    Iterator<Object> getData() { // DataProvider olarak kullanılacak methodun tipi Object olmak zorunda.

        List<Object> data = new ArrayList<>();
        data.add("Mac");
        data.add("Samsung");
        data.add("Huawei");
        data.add("iPhone");
        return data.iterator();
    }

    /************************************/

    @Test(dataProvider = "getData2")
    // SearchTest methodunun data sağlacısı getData fonksiyonudur.
    void LoginTest(String userName, String password) {
        System.out.println("userName = " + userName + ", password = " + password);
    }

    @DataProvider
        // Bu methoda dataprovider görevi verildi.
    Iterator<Object[]> getData2() { // DataProvider olarak kullanılacak methodun tipi Object olmak zorunda.

        List<Object[]> logins = new ArrayList<>();
        logins.add(new Object[]{"Mert", "dsfasg4"});
        logins.add(new Object[]{"Can", "35645sghsgfh"});
        logins.add(new Object[]{"Burak", "jderyj56ehtr"});
        return logins.iterator();
    }
}
