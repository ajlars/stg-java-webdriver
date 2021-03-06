package challenge1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class challenge1 {
    private WebDriver driver;
    
//    @BeforeSuite
//    public void startSuite() throws Exception {
//    }

    @AfterSuite
    public void stopSuite() {
        System.out.println("All done!!!");
    }

    @BeforeClass
    public void startClass() {
        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void stopClass(){
        driver.quit();
    }

//    @BeforeMethod()
//    public void BeforeMethod() throws Exception{
//    }

//    @AfterMethod()
//    public void AfterMethod(){
//    }

    @Test()
    public void goToGoogle() {
        driver.get("https://www.google.com");
    }

    @Test()
    public void verifyGoogleTitle() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }
}
