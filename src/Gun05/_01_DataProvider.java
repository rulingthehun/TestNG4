package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test (dataProvider = "getData") // SearchTest methodunun data sağlacısı getData fonksiyonudur.
    void SearchTest(String searchText){
        System.out.println(searchText);
    }

    @DataProvider // Bu methoda dataprovider görevi verildi.
    Object[] getData(){ // DataProvider olarak kullanılacak methodun tipi Object olmak zorunda.

        Object[] data={"Mac", "Samsung", "Huawei", "iPhone", "PC", "Xiaomi"}; // 1, 3, 5, 7

        return data;
    }

    /*****************************************************/

    @Test (dataProvider = "aranacaklar") // SearchTest methodunun data sağlacısı getData fonksiyonudur.
    void SearchTest2(String searchText){
        System.out.println(searchText);
    }

    @DataProvider(name = "aranacaklar") // Bu methoda dataprovider görevi verildi.
    Object[] getData2(){ // DataProvider olarak kullanılacak methodun tipi Object olmak zorunda.

        Object[] data= {"Mac", "Samsung", "Huawei", "iPhone", "PC", "Xiaomi"}; // 1, 3, 5, 7

        return data;
    }

}
