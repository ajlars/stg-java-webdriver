package challenge5;

import copart.copartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class challenge5 {
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
    public void getModels() throws InterruptedException{
        page.search("Porsche");
        page.setResultMax(100);
        List<String> results = page.getResultsColumnText("model");
        Set<String> makes = new HashSet<>(results);
        Map<String, Integer> modelCounts = new HashMap<>();
        for (String make : makes) {
            modelCounts.put(make, 0);
        }
        for (String item : results){
            modelCounts.put(item, modelCounts.get(item) + 1);
        }
        for (Map.Entry<String,Integer> entry : modelCounts.entrySet()){
            System.out.println("Model '" + entry.getKey() +"' was found " + entry.getValue() + " times.");
        }
    }

    @Test
    public void getDamage() throws InterruptedException{
        page.search("Porsche");
        page.setResultMax(100);
        List<String> results = page.getResultsColumnText("damage");
        LinkedHashMap<String, Integer> damageCounts = new LinkedHashMap<>();
        damageCounts.put("REAR END", 0);
        damageCounts.put("FRONT END", 0);
        damageCounts.put("MINOR DENT/SCRATCHES", 0);
        damageCounts.put("UNDERCARRIAGE", 0);
        damageCounts.put("MISC", 0);
        for (String item : results){
            switch(item){
                case "REAR END":
                    damageCounts.put("REAR END", damageCounts.get("REAR END")+1);
                    break;
                case "FRONT END":
                    damageCounts.put("FRONT END", damageCounts.get("FRONT END")+1);
                    break;
                case "MINOR DENT/SCRATCHES":
                    damageCounts.put("MINOR DENT/SCRATCHES", damageCounts.get("MINOR DENT/SCRATCHES")+1);
                    break;
                case "UNDERCARRIAGE":
                    damageCounts.put("UNDERCARRIAGE", damageCounts.get("UNDERCARRIAGE")+1);
                    break;
                default:
                    damageCounts.put("MISC", damageCounts.get("MISC")+1);
                    break;

            }
        }
        for (Map.Entry<String,Integer> entry : damageCounts.entrySet()){
            System.out.println("Damage '" + entry.getKey() +"' occurred " + entry.getValue() + " times.");
        }
    }
}
