package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Base {

    protected WebDriver driver;

    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void getUrl(String url) {
        driver.get(url);
    }

    @Deprecated
    public void scrollToElement(By selector) {
        WebElement element = driver.findElement(selector);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }
    public void scrollToBottom(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("Window is scrolled to bottom");
    }
    public void switchToFrame(By selector){
        driver.switchTo().frame(driver.findElement(selector));
        System.out.println("Successfully switch to Iframe");
    }
    public void waitforElement(By selector){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
        System.out.println("Element is displayed");
    }
    public void clickOnElement(By selector){
        driver.findElement(selector).click();
    }
    public  boolean isClickable(By selector)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void moveAndClick(By selector){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(selector));
       actions.click().build().perform();

    }
}
