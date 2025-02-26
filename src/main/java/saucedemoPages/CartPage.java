package saucedemoPages;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.Arrays;
import static utilities.JavaScriptsUtility.*;

public class CartPage extends BasePage {

    private final By cartList = By.id("cart_contents_container");
    private final By checkout = By.id(("checkout"));

    public String getCartInformation(){
        return find(cartList).getText();
    }

    public boolean checkProductsAdded(String cartList, String[] productsSelected ){
        return Arrays.stream(productsSelected).allMatch(cartList::contains);
    }

    public FirstCheckoutPage goToFirstCheckoutPage(){
        clickJS(checkout);
        return new  FirstCheckoutPage();
    }
}