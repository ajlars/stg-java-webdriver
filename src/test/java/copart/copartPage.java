package copart;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class copartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchInput = By.id("input-search");
    private By searchButton = By.cssSelector("button[data-uname='homepageHeadersearchsubmit']");
    private By resultsTable = By.id("serverSideDataTable");
    private By resultsTableMakes = By.xpath("//*[@id='serverSideDataTable']//tr/td[5]");
    private By popularItems = By.xpath("//div[@ng-if='popularSearches']//a");


    public copartPage(String browser) {
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                wait = new WebDriverWait(driver, 30);
                break;
            default:
                System.out.println("No valid browser specified.");
        }
    }

    public void startChrome(){
    }

    public void quit() {
        driver.quit();
    }

    public void navigate() {
        driver.get("https://www.copart.com");
        wait.until(ExpectedConditions.titleIs("Auto Auction - Copart USA - Salvage Cars For Sale"));
    }

    public void search(String searchTerm) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(searchTerm);
        driver.findElement(searchButton).click();
    }

    public String getSearchString() {
        return driver.findElement(By.cssSelector("[ng-if='searchText']")).getText();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public List<String> getResultsColumnText(String columnName) {
        int columnNumber;
        switch (columnName.toLowerCase()){
            case "year":
                columnNumber = 4;
                break;
            case "make":
                columnNumber = 5;
                break;
            case "model":
                columnNumber = 6;
                break;
            case "item#":
                columnNumber = 7;
                break;
            case "location / lane / row":
                columnNumber = 8;
                break;
            case "sale date":
                columnNumber = 9;
                break;
            case "odometer":
                columnNumber = 10;
                break;
            case "doc type":
                columnNumber = 11;
                break;
            case "damage":
                columnNumber = 12;
                break;
            case "est. retail value":
                columnNumber = 13;
                break;
            case "current bid":
                columnNumber = 14;
                break;
            default:
                columnNumber = 0;
                System.out.println("invalid column name provided");
        }
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(resultsTable)));
        List<WebElement> results = driver.findElements(By.xpath("//*[@id='serverSideDataTable']//tr/td[" + columnNumber + "]"));
        List<String> columnList = new ArrayList<>();
        for (WebElement result : results) {
            columnList.add(result.getText());
        }
        return columnList;
    }

    public String[][] getPopularItems() {
        String[][] results = new String[20][2];
        List<WebElement> items = driver.findElements((popularItems));
        for(int i = 0; i < items.size(); i++){
            WebElement item = items.get(i);
            results[i][0] = item.getText();
            results[i][1] = item.getAttribute("href");
        }
        return results;
    }

    public void setResultMax(int value) throws InterruptedException{
        WebElement table = driver.findElement(resultsTable);
        driver.findElement(By.xpath("(//select[@name='serverSideDataTable_length'])[1]/option[@value='"+value+"']")).click();
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(table)));
        Thread.sleep(1000);
    }

    public void filterResults(String category, String filter) throws Exception{
        WebElement filterCategory = driver.findElement(By.xpath("(//div[@class='filter-inner']//a[@data-toggle='collapse'])[contains(text(), '" + category + "')]"));
        boolean selected = false;
        String filterExpanded = filterCategory.getAttribute("aria-expanded");
        if(filterExpanded== null || !filterExpanded.equals("True")){
            filterCategory.click();
        }
        List<WebElement> categoryFilters = driver.findElements(By.xpath("(//div[@class='filter-inner']//a[@data-toggle='collapse'])[contains(text(), '" + category + "')]/../..//abbr"));
        for(WebElement subFilter: categoryFilters){
            if(!selected) {
                String label = subFilter.getText().trim();
                if (label.equals(filter)) {
                    selected = true;
                    subFilter.click();
                }
            }
        }
        if(!selected){
            String errorMessage = filter + " not found in " + category;
            throw new NoSuchFieldException(errorMessage);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
