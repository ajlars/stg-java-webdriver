package challenge2;

import copart.copartPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class challenge2 {
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
//        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Test()
    public void doesSearch() {
        page.search("Exotics");
        List<String> makes = page.getResultsColumnText("make");
        Assert.assertTrue(makes.contains("PORSCHE"), "PORSCHE is present in search result makes.");
    }
}
