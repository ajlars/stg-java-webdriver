package challenge6;

import copart.copartPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.util.*;

public class challenge6 {
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
    public void stopClass() {
        page.quit();
    }

//    @BeforeMethod()
//    public void BeforeMethod() throws Exception {
//    }

//    @AfterMethod()
//    public void AfterMethod() {
//    }

    @Test
    public void filterModels() throws Exception {
        String category = "Model";
        String filter = "Skyline";
        try {
            page.search("nissan");
            page.filterResults(category, filter);
        } catch (NoSuchFieldException e) {
            System.out.println(e + " : Exception caught");
            File src = ((TakesScreenshot)page.getDriver()).getScreenshotAs(OutputType.FILE);
            String filePath = System.getProperty("user.dir") + "/errorScreenshots/challenge6_" + new Date().hashCode() + ".png";
            FileHandler.copy(src, new File(filePath));
            System.out.println("Screenshot saved to : '" + filePath + "'");
        }
    }
}
