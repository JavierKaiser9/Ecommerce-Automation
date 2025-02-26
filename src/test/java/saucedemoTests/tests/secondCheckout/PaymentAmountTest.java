package saucedemoTests.tests.secondCheckout;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.CartPage;
import saucedemoPages.FirstCheckoutPage;
import saucedemoPages.ProductsPage;
import saucedemoPages.SecondCheckoutPage;
import saucedemoTests.base.BaseTest;
import saucedemoTests.tests.cart.CartTest;

import static org.testng.Assert.assertEquals;

public class PaymentAmountTest extends BaseTest {

    @Test
    public void checkAmountOfMoneyToBePaid() {

        ProductsPage productsPage = loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 5);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        SecondCheckoutPage secondCheckoutPage = firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, UsersInfo.checkOutLastName, UsersInfo.postalCode);

        var getProductsInformation = secondCheckoutPage.getProductsListInformation();
        String calculatedFinalPrice = secondCheckoutPage.calculateSubTotal(getProductsInformation);
        String subTotal = secondCheckoutPage.getDisplayedSubtotal();
        String total = secondCheckoutPage.getDisplayedTotal();

        System.out.println("Calculated Total: " + calculatedFinalPrice);
        System.out.println("Displayed subtotal: " + subTotal);
        System.out.println("Displayed total: " + total);

        assertEquals(calculatedFinalPrice,total);

    }
}
