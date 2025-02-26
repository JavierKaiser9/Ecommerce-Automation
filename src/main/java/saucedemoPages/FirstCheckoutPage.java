package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;

public class FirstCheckoutPage extends BasePage {
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By continueToNextPage = By.id("continue");

    public SecondCheckoutPage goToSecondCheckout(){
        click(continueToNextPage);
        return new SecondCheckoutPage();
    }

    public SecondCheckoutPage setCustomerData(String customerName, String customerLastName, String customerPostalCode){
        set(firstName, customerName);
        set(lastName, customerLastName);
        set(postalCode, customerPostalCode);
        return new SecondCheckoutPage();
    }

    public String getErrorMessageFirstCheckoutPage(){
        return find(errorMessage).getText();
    }
}
