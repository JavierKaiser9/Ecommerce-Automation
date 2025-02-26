package saucedemoTests.tests.secondCheckout;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PaymentAmountTest extends BaseTest {

    @Test
    public void checkAmountOfMoneyToBePaid() {

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.correctPassword);
        productsPage.addOrRemoveItem("add", 1);
        productsPage.addOrRemoveItem("add", 5);
        productsPage.goToCartPage();
        cartPage.goToFirstCheckoutPage();
        firstCheckoutPage.setCustomerData(UsersInfo.checkOutName, UsersInfo.checkOutLastName, UsersInfo.postalCode);

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
