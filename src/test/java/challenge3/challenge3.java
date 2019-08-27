package challenge3;

import copart.copartPage;
import org.testng.annotations.*;

public class challenge3 {
    private copartPage page;

//    @BeforeSuite
//    public void startSuite() throws Exception {
//    }

    @AfterSuite
    public void stopSuite() {
        System.out.println("All done!!!");
    }

    @BeforeClass
    public void startClass() {
        page = new copartPage("chrome");
        page.navigate();
    }

    @AfterClass
    public void stopClass(){
        page.quit();
    }

//    @BeforeMethod()
//    public void BeforeMethod() throws Exception{
//    }

//    @AfterMethod()
//    public void AfterMethod(){
//    }

    @Test
    public void printPopularItems(){
        String [][] results = page.getPopularItems();
        for(String [] result: results) {
            System.out.println(result[0] + " - " + result[1]);
        }
    }
}
