package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;

public class FirstCheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By continueToNextPage = By.id("continue");

    public SecondCheckoutPage clickContinueSecondCheckout(){
        click(continueToNextPage);
        return new SecondCheckoutPage();
    }

    public SecondCheckoutPage setCustomerData(String customerName, String customerLastName, String customerPostalCode){
        set(firstName, customerName);
        set(lastName, customerLastName);
        set(postalCode, customerPostalCode);
        return clickContinueSecondCheckout();
    }

    public String getErrorMessageFirstCheckoutPage(){
        return find(errorMessage).getText();
    }
}
