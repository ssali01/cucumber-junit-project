package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTableOrderPage extends BasePage {

    public WebTableOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this); // this keyword for all objects web elements
    }

    @FindBy(name = "product")
    public WebElement productTypeDropdown;


    @FindBy(name = "quantity")
    public WebElement inputQty;


    @FindBy(name = "name")
    public WebElement inputName;


    @FindBy(name = "street")
    public WebElement inputStreet;

    @FindBy(name = "city")
    public WebElement inputCity;

    @FindBy(name = "state")
    public WebElement inputState;

    @FindBy(name = "zip")
    public WebElement inputZip;

    @FindBy(name = "card") // use common attributeName to locate the element
    public List<WebElement> CardType; // if you have couple options like radio buttons

    @FindBy(name = "cardNo")
    public WebElement inputCardNo;

    @FindBy(name = "cardExp")
    public WebElement inputExpdate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement ProcessOrderButton;

public void cardOpts (String cardType){
//    WebTableOrderPage webTableOrderPage = new WebTableOrderPage();
    for (WebElement eachCardType : new WebTableOrderPage().CardType) {
        if (eachCardType.getAttribute("value").equalsIgnoreCase(cardType)){
           eachCardType.click();
        }
    }
}
}
