package pages;

import org.openqa.selenium.By;

public class Irctc {

public static final By loginLind=By.id("loginText");
    public static final By userTextbox=By.id("userId");
    public static final By password =By.id("pwd");
    public static final By origin=By.xpath("//*[@id='destination']/span/input");
    public static final By destination=By.xpath("//*[@id='origin']/span/input");
    public static final By journeyDate=By.xpath("//span[starts-with(@class,'ng-tns-c12-5 ui-calendar')]/input");


}
