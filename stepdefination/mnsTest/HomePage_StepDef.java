package mnsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Base;

public class HomePage_StepDef extends Base {
	private String url = "https://www.msn.com/en-in/weather/today/New-Delhi,Delhi,India/we-city-28.608,77.201?iso=IN";
	public By homepage_facebook_link = By.xpath("//span[text()='Like']");
	public By facebook_link = By.xpath("//*[@id='u_0_0']/div/button");
	public final By facebook_frame = By.xpath("//li[@id='fbcount']/iframe");

	@Given("I am on msn homepage")
	public void i_am_on_msn_homepage() {
		invokeBrowser();
		getUrl(url);
	}

	@Given("I scroll down the page")
	public void i_scroll_down_the_page() throws InterruptedException {
		scrollToBottom();
		
		//waitforElement(facebook_frame);
		 Thread.sleep(15000);
		 WebElement frame=driver.findElement(facebook_frame);
		driver.switchTo().frame(frame);
		 //switchToFrame(facebook_frame);
		moveAndClick(facebook_link);
		// clickOnElement(homepage_facebook_link);
		System.out.println("clicked on facebook link");
	}

	@Given("I click on facebook button")
	public void i_click_on_facebook_button() {

	}
	@Then("Close the browser")
	public void close_the_browser() throws InterruptedException {
		Thread.sleep(10000);
        driver.quit();
	}

}
