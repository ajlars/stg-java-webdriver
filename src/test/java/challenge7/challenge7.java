package challenge7;

import copart.copartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class challenge7 {
    private copartPage page;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println("All done!!!");
    }

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
    public void checkPopularLinks(){
        String [][] results = page.getPopularItems();
        for(String[] result: results){
            page.getDriver().get(result[1]);
            String searchString = page.getSearchString().toLowerCase();
            String linkTextMassaged = result[0].replace(' ', '-').toLowerCase(); //the pages and urls use hyphens anywhere spaces were present in make/model
            String url = page.getCurrentUrl().toLowerCase();
            Assert.assertTrue(searchString.contains(linkTextMassaged), "The search text didn't match the link text.");
            Assert.assertTrue(url.contains(linkTextMassaged), "The link didn't contain the link text.");
        }

    }
}
