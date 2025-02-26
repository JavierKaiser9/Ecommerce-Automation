package saucedemoTests.tests.login;

import dataBase.UsersInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemoTests.base.BaseTest;

public class ErrorMessageTest extends BaseTest {

    @Test
    public void testLoginErrorMessageCorrectUserWrongPassword() {

        loginPage.logIntoApplication(UsersInfo.correctUser, UsersInfo.wrongPassword);

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginErrorMessageWrongUserCorrectPassword() {

        loginPage.logIntoApplication(UsersInfo.wrongUser, UsersInfo.correctPassword);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginErrorMessageNoUser() {
        loginPage.logIntoApplication("", UsersInfo.correctPassword);
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username is required"));
    }

    @Test
    public void testLoginErrorMessageNoPassword() {
        loginPage.logIntoApplication(UsersInfo.correctUser, "");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Password is required"));
    }
}