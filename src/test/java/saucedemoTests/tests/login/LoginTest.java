package saucedemoTests.tests.login;

import dataBase.UsersInfo;
import org.testng.annotations.Test;
import saucedemoPages.ProductsPage;
import saucedemoTests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){

        for(String userName: UsersInfo.registeredUsers){
            ProductsPage productsPage = loginPage.logIntoApplication(userName, UsersInfo.correctPassword);
            assertTrue(productsPage.isProductsHeaderDisplayed(), "\n It was not possible to login \n");

            System.out.println("User: " + userName + " , Login confirmed");
            productsPage.logOutApplication();
        }
    }
}