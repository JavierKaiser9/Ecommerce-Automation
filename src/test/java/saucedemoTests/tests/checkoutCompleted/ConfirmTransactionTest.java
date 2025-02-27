package saucedemoTests.tests.checkoutCompleted;

import org.testng.annotations.Test;
import saucedemoPages.*;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.*;

public class ConfirmTransactionTest extends BaseTest {

    @Test
    public void confirmationOfFullTransaction(){
        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 2);
        CartPage cartPage = productsPage.goToCartPage();
        FirstCheckoutPage firstCheckoutPage = cartPage.goToFirstCheckoutPage();
        SecondCheckoutPage secondCheckoutPage = firstCheckoutPage.setCustomerData(usersInfo.getCheckOutName(),
                usersInfo.getCheckOutLastName(), usersInfo.getPostalCode());
        CheckoutCompletedPage checkoutCompletedPage = secondCheckoutPage.goToCompletedTransaction();
        assertTrue(checkoutCompletedPage.confirmPurchase());
    }
}
