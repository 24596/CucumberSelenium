package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage{
    public WebDriver driver;
    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    By searchBox = By.cssSelector("#search-field");
    By offerPgaeProductName = By.xpath("//tr/td[1]");

    public void searchItem(String name){
        driver.findElement(searchBox).sendKeys(name);
    }

    public String getOfferPageitem(){
        return driver.findElement(offerPgaeProductName).getText().trim();
    }
}
