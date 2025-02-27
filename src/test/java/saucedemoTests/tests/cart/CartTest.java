package saucedemoTests.tests.cart;

import dataBase.ProductsInfo;
import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.CartPage;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;
import static org.testng.Assert.*;

public class CartTest extends BaseTest {

    @Test
    public void cartTest(){
        String[] productsToCheck = {productsInfo.getOriginalProductsNames()[2], productsInfo.getOriginalProductsNames()[3]};

        ProductsPage productsPage = loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getCorrectPassword());
        productsPage.addOrRemoveItem("add", 2);
        productsPage.addOrRemoveItem("add", 3);
        CartPage cartPage = productsPage.goToCartPage();

        var cartInformation = cartPage.getCartInformation();
        assertTrue(cartPage.checkProductsAdded(cartInformation,productsToCheck));

    }
}
