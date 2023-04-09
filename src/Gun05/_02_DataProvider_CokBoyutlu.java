package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test(dataProvider = "getData")
    void LoginTest(String userName, String password){
        System.out.println("userName = " + userName + ", password = " + password);
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] logins = {
                {"Tancan", "234q2t"},
                {"Ahmet", "agew35qy"},
                {"Hasan", "dfagdsb456"},
                {"Günhan", "dfgsd"}
        };
        return logins;
    }
}
