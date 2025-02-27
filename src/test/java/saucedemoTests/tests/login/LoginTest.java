package saucedemoTests.tests.login;

import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){

        for(String userName: usersInfo.getRegisteredUsers()){
            ProductsPage productsPage = loginPage.logIntoApplication(userName, usersInfo.getCorrectPassword());
            assertTrue(productsPage.isProductsHeaderDisplayed(), "\n It was not possible to login \n");

            System.out.println("User: " + userName + " , Login confirmed");
            productsPage.logOutApplication();
            usersInfo.getRegisteredUsers();
        }
    }
}