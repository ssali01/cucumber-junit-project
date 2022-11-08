package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsySearch_StepDefinitions {

    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String keyword) {
    etsyHomePage.searchBox.sendKeys(keyword);

    }
    @When("User clicks search button")
    public void user_clicks_search_button() {
        etsyHomePage.submitBtn.click();

    }
    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String expectedKeyword) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedKeyword));
       }
    }


