package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    By searchBox = By.cssSelector("input[type='search']");
    By productName = By.xpath("//h4[@class='product-name']");

    By topDealsButton = By.cssSelector("a[href='#/offers']");

    public void searchItem(String name){
        driver.findElement(searchBox).sendKeys(name);
    }

    public String getItem(){
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void clickOnTopDeals(){
        driver.findElement(topDealsButton).click();
    }
}
