package saucedemoTests.tests.login;

import dataBase.UsersInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemoTests.base.BaseTest;

public class LoginErrorMessageTest extends BaseTest {

    @Test
    public void testLoginErrorMessageCorrectUserWrongPassword() {

        loginPage.logIntoApplication(usersInfo.getCorrectUser(), usersInfo.getWrongPassword());

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginErrorMessageWrongUserCorrectPassword() {

        loginPage.logIntoApplication(usersInfo.getWrongUser(), usersInfo.getCorrectPassword());
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void testLoginErrorMessageNoUser() {
        loginPage.logIntoApplication("", usersInfo.getCorrectPassword());
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Username is required"));
    }

    @Test
    public void testLoginErrorMessageNoPassword() {
        loginPage.logIntoApplication(usersInfo.getCorrectUser(), "");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.
                contains("Epic sadface: Password is required"));
    }
}