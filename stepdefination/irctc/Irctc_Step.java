package irctc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.Irctc;
import utils.Base;


import java.util.Set;

public class Irctc_Step extends Base {

    @Given("I navigated to Irctc {string}")
    public void iNavigatedToIrctc(String arg0) {
        invokeBrowser();
        setURL(arg0);
    }

    @And("I login to Irctc with valid credintion")
    public void iLoginToIrctcWithValidCredintion() {
        Set<String> allwindows=driver.getWindowHandles();
        int totalwindows=allwindows.size();
        System.out.println(totalwindows);
        for(String window:allwindows){
            System.out.println("Window: "+window);
        }
        //driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//div[@class='text-center col-xs-12']/button")).click();
        driver.findElement(Irctc.loginLind).click();
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        driver.findElement(Irctc.userTextbox).sendKeys(username);
        driver.findElement(Irctc.password).sendKeys(password);
    }

    @And("I click on Login button after entering the capcha manually")
    public void iClickOnLoginButtonAfterEnteringTheCapchaManually() {
        System.out.println("please enter the Captcha \n And hid the SIGN IN button");

    }

    @Then("I should land to the homepage")
    public void iShouldLandToTheHomepage() {
        System.out.println("Landed to the homepage");
    }

    @Given("I enter the Origin {string} and Destination {string}")
    public void iEnterTheOriginAndDestination(String origin, String destination) {
        driver.findElement(Irctc.origin).sendKeys(origin);
        driver.findElement(Irctc.destination).sendKeys(destination);
    }

    @And("I enter date {string} in datetime piker")
    public void iEnterDateInDatetimePiker(String destination) {
        driver.findElement(Irctc.journeyDate).sendKeys(destination);
    }
}
