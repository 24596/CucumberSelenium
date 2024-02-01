package StepDefinitions;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.jv.Lan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup){

        this.testContextSetup = testContextSetup;
    }

    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
    }


    @When("User searched with short name {string} and extract the actual name of the product")
    public void user_searched_with_short_name_and_extract_the_actual_name_of_the_product(String shortName) throws InterruptedException {
        LandingPage landingPage = testContextSetup.pageObjectManager.landingPage;
        landingPage.searchItem(shortName);
        Thread.sleep(3000);
        testContextSetup.landingPageProductName = landingPage.getItem();
        }
}
