package StepDefinitions;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefiniton {
    public String offerPgaeProductName;
    TestContextSetup testContextSetup;

    PageObjectManager pageObjectManager;

    public OfferPageStepDefiniton(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("User searched for the same short name {string} in offers page")
    public void user_searched_for_the_same_short_name_in_offers_page(String shortName) {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.clickOnTopDeals();
        OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
        switchToOffersPage();
        offersPage.searchItem(shortName);
        String offerPgaeProductName = offersPage.getOfferPageitem();
    }

    public void switchToOffersPage(){
        testContextSetup.genericUtils.switchWindow();
        System.out.println("hello");

    }

    @Then("Validate product name in offers page matches with product name in home page")
    public void validate_product_name_in_offers_page_matches_with_product_name_in_home_page() {
//        Assert.assertEquals(testContextSetup.landingPageProductName,offerPgaeProductName);
    }
}
