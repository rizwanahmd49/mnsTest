package pages;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Base;

import java.util.List;
import java.util.Map;


public class DB_GetDocumentName extends Base {
    String docubuilder_url = new String("https://jhfuat.docubuilder.com/");
    String userID = "dcisupportjhf";
    String password = "Internal@13";
    private By userId=By.id("username");
    private By by_password=By.id("password");
    private By by_LoginButton=By.id("login_img");

    @BeforeTest
    private void init() {
        invokeBrowser();
        setURL(docubuilder_url);
    }

    @Test
    private void getDocumentName() throws InterruptedException {
        driver.findElement(By.id("username")).sendKeys(userID);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login_img")).click();
        driver.findElement(By.xpath("//*[@id='proofsDropdownMenuIcon']/a")).click();
        WebElement element = driver.findElement(By.xpath("//ul[@class='topHeaderProofSubMenu']/li[2]"));

        System.out.println(element.getText());
        element.click();
      /*  List<WebElement> documentName = driver.findElements(By.xpath("//span[contains(@class, 'inProcessStatus')or contains(@class,'errorStatus') or contains(@class,'readyProcessStatus')]//parent::span//parent::td//preceding-sibling::td[2]/a/span"));
        for (WebElement ele:documentName){

            System.out.println(ele.getText());

        }*/
       // Multimap<String, String> docs = getDocumentNameAndStatus("inProcessStatus");
         Multimap<String, String> docs = getDocumentNameWithAllStatus(); getDocumentNameHavingStatus("test");

        int i=1;
        for (Map.Entry<String, String> entry : docs.entries()) {

            System.out.println(i+") "+entry.getKey() + " : " + entry.getValue());
            i++;
        }
        Thread.sleep(5000);
    }
    protected Multimap<String, String> getDocumentNameWithAllStatus() {
        List<WebElement> documentName = driver.findElements(By.xpath("//span[contains(@class, " +
                "'inProcessStatus')or contains(@class,'errorStatus') or contains(@class,'readyProcessStatus')]" +
                "//parent::span//parent::td//preceding-sibling::td[2]/a/span"));
        List<WebElement> documentstatus = driver.findElements(By.xpath("//span[contains(@class, 'inProcessStatus')or contains(@class,'errorStatus') or contains(@class,'readyProcessStatus')]"));
        System.out.println("Fetching All the Document Having notification");
       // Map<String, String> map = new HashMap();
        Multimap<String, String> multimap = ArrayListMultimap.create();
        if (!documentName.isEmpty() & !documentstatus.isEmpty()) {
            for (int i = 0; i < documentName.size(); i++) {
                WebElement d_name = documentName.get(i);
                WebElement d_status = documentstatus.get(i);
                String attribute = d_status.getAttribute("class");
                String[] att_StatusList = attribute.split(" ");
                String att_status = att_StatusList[0];
                String att_Name = d_name.getText();
                multimap.put(att_Name,att_status);
            }
          /*  for (Map.Entry<String, String> entry : multimap.entries()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }*/
            return multimap;

        } else {
            System.out.println("No document found with status ");
            return null;
        }
    }
    @Deprecated
    protected void getDocumentNameHavingStatus(String status) {
        List<WebElement> documentName = driver.findElements(By.xpath("//span[contains(@class, '" + status + "')]//parent::span//parent::td//preceding-sibling::td[2]/a/span"));
        System.out.println("Fetching Documents as per Status => '" + status + "'");
        if (!documentName.isEmpty()) {
            for (WebElement ele : documentName) {
                String attribute = ele.getAttribute("class");
                System.out.println(attribute + " => " + ele.getText());
            }
        } else {
            System.out.println("No document found with status " + status);
        }

    }
    protected Multimap<String, String> getDocumentNameAndStatus(String status) {
        List<WebElement> documentName = driver.findElements(By.xpath("//span[contains(@class, '" + status + "')]//parent::span//parent::td//preceding-sibling::td[2]/a/span"));
        List<WebElement> documentstatus = driver.findElements(By.xpath("//span[contains(@class, '" + status + "')]"));
        System.out.println("Fetching Document as per Status => '" + status + "'");
        Multimap<String, String> multimap = ArrayListMultimap.create();
        if (!documentName.isEmpty() & !documentstatus.isEmpty()) {
            for (int i = 0; i < documentName.size(); i++) {
                WebElement d_name = documentName.get(i);
                WebElement d_status = documentstatus.get(i);
                String attribute = d_status.getAttribute("class");
                String[] att_StatusList = attribute.split(" ");
                String att_status = att_StatusList[0];
                String att_Name = d_name.getText();
                multimap.put(att_status, att_Name);
            }
            for (Map.Entry<String, String> entry : multimap.entries()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            return multimap;

        } else {
            System.out.println("No document found with status " + status);
            return null;
        }

    }

    @AfterTest
    private void tearDown() {
        driver.quit();
    }

}
