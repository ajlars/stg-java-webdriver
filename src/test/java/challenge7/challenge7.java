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
    public void checkPopularLinks() throws InterruptedException{
        String [][] results = page.getPopularItems();
        for(String[] result: results){
            String linkTextMassaged = result[0].replace(' ', '-').toLowerCase(); //the pages and urls use hyphens anywhere spaces were present in make/model
            String searchString;
            page.getDriver().get(result[1]);
            Boolean searchSuccessful = page.waitForSearch();
            System.out.println("Found: " + result[0] + " match? " + searchSuccessful);
            if(searchSuccessful){
                searchString = page.getSearchString().toLowerCase();
            }
            else{
                searchString = page.getFailedSearchString().toLowerCase();
            }
            Assert.assertTrue(searchString.contains(linkTextMassaged), "The search text didn't match the link text. Search Text: '" + searchString + "', Link Text: " + linkTextMassaged + "'.");
            String url = page.getCurrentUrl().toLowerCase();
            Assert.assertTrue(url.contains(linkTextMassaged), "The search page url didn't contain the link text. URL: '" + url + "', Link Text: '" + linkTextMassaged +"'.");
        }

    }
}
