package challenge3;

import copart.copartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class challenge3 {
    private copartPage page;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println("All done!!!");
    }

    // @BeforeClass
    // public void startClass() throws Exception{
    //     System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
    //     driver = new ChromeDriver();
    //     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //     page = new copartPage(driver);
    //     page.navigate();
    // }

    @BeforeClass
    public void startClass() throws Exception{
        page = new copartPage("chrome");
        page.navigate();
    }

    @AfterClass
    public void stopClass(){
        page.quit();
    }

    @BeforeMethod()
    public void BeforeMethod() throws Exception{
    }

    @AfterMethod()
    public void AfterMethod(){
    }

    @Test
    public void printPopularItems(){
        String [][] results = page.getPopularItems();
        for(String [] result: results) {
            System.out.println(result[0] + " - " + result[1]);
        }
    }
}
