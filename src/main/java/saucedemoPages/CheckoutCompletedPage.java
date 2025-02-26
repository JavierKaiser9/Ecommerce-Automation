package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;

public class CheckoutCompletedPage extends BasePage {
    private final By completedPurchase = By.xpath("//h2[@class='complete-header']");

    public boolean confirmPurchase(){
        return find(completedPurchase).isDisplayed();
    }
}
