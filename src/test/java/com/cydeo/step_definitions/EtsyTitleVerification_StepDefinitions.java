package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyTitleVerification_StepDefinitions {

    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("User is on {string} page")
    public void user_is_on_page(String etsyPage) {
        Driver.getDriver().get(etsyPage);
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);
        wait.until(ExpectedConditions.titleContains(expected));

    }

    @When("User sees title is as expected.")
    public void user_sees_title_is_as_expected() {

    }

    @Then("User sees {string} in the title of the page")
    public void user_sees_in_the_title_of_the_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
    }
}
