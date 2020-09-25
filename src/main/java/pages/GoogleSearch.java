package pages;
import io.github.sukgu.Shadow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.annotations.Test;

public class GoogleSearch {
    WebDriver driver;
    String url="https://www.google.com/";

    @Test
    private void init(){
        invokeBrowser("chrome");
        Shadow shadow=new Shadow(driver);
        WebElement element=shadow.findElement("");

    }

    private void invokeBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }
       if( browser.equalsIgnoreCase("ff")){

        }

    }
}
