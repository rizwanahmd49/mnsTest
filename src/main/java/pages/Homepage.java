package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Base;

public class Homepage extends Base {

    private String url = "https://www.msn.com/en-in/weather/today/New-Delhi,Delhi,India/we-city-28.608,77.201?iso=IN";
    public By homepage_facebook_link = By.xpath("//span[text()='Like']");
    public By facebook_link=By.xpath("//*[@id='u_0_0']/div/button");
    public  final By facebook_frame=By.xpath("//li[@id='fbcount']/iframe");

    @BeforeTest
    protected void init() {
        invokeBrowser();
        getUrl(url);
    }

    @Test
    private void searchInGoogle(){
        scrollToBottom();
        WebElement frame=driver.findElement(facebook_frame);
        waitforElement(facebook_frame);
        switchToFrame(facebook_frame);
        WebElement element = driver.findElement(facebook_link);
        Actions action=new Actions(driver);
        action.moveToElement(element).click().build().perform();
      //  moveAndClick(facebook_link);
       // clickOnElement(homepage_facebook_link);
        System.out.println("clicked on facebook link");
    }

    @AfterTest
    private void tearDown() throws InterruptedException {
       Thread.sleep(10000);
        driver.quit();
    }
}
