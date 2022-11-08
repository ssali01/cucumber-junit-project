package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Dropdown_StepDef {
    DropdownPage dropdownPage = new DropdownPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

//        Select select = new Select(dropdownPage.monthDropdown);
//
//        List<WebElement> actualOptionsAsWebElement = select.getOptions(); // need these options to compare later
//
//        List<String> actualOptionsAsString = new ArrayList<>();
//
//        for (WebElement each : actualOptionsAsWebElement) { // need to go through each webElement and convert to String type by..->
//            actualOptionsAsString.add(each.getText()); // ->using getText() and I will add them to my List of String here actualOptionsAsString by "Add" method
//        }

        // this utility method will return List of String of given dropdown webElement
       List<String> actualOptionsAsString = BrowserUtils.dropdownOptionsAsString(dropdownPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualOptionsAsString); // Assert will check the SIZE of the List first. If it is matching it will check/verify 1 by 1
    }
}
