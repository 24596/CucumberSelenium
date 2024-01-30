package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.JavaConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class GreenKartStepDefinition {
    public WebDriver driver;
    public String homePgaeProductName;
    public String offerPgaeProductName;

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        System.setProperty("webdriver.driver.chrome","C:\\Users\\mansi\\OneDrive\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }


    @When("User searched with short name {string} and extract the actual name of the product")
    public void user_searched_with_short_name_and_extract_the_actual_name_of_the_product(String string) throws InterruptedException {
        driver.findElement(By.cssSelector("input[type='search']")).sendKeys(string);
        Thread.sleep(3000);
        String homePgaeProductName =
                driver.findElement(By.xpath("//h4[@class='product-name']"))
                        .getText().split("-")[0].trim();
    }


    @Then("User searched for the same short name {string} in offers page")
    public void user_searched_for_the_same_short_name_in_offers_page(String string) {
       driver.findElement(By.cssSelector("a[href='#/offers']")).click();
       Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.findElement(By.cssSelector("#search-field")).sendKeys(string);
        String offerPgaeProductName = driver.findElement(By.xpath("//tr/td[1]")).getText().trim();
    }

    @Then("Validate product name in offers page matches with product name in home page")
    public void validate_product_name_in_offers_page_matches_with_product_name_in_home_page() {
        Assert.assertEquals(homePgaeProductName,offerPgaeProductName);
    }

}
