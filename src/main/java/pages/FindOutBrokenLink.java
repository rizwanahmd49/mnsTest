package pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.Module.SetupContext;
import utils.Base;

public class FindOutBrokenLink extends Base {
    String makemysushi_url = new String("https://makemysushi.com/404?");
    String amazon_URL = "https://www.amazon.in/";

    @BeforeTest
    private void init() {
        invokeBrowser();
        setURL(makemysushi_url);
    }

    @Test
    private void verifyBrokenLink() throws Exception {
        List<WebElement> a_inks = driver.findElements(By.tagName("a"));
        System.out.println("Total img:==>" + a_inks.size());
        for (int i = 0; i < a_inks.size(); i++) {
            WebElement element = a_inks.get(i);
            String link = element.getAttribute("href");
            if (link != null && link.contains("https://")) {
                System.out.println(link + " ==> " + verifyLink(link));
            }

        }

    }


    @AfterTest
    private void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
