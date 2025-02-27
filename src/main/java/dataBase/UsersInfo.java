package dataBase;

public class UsersInfo extends WebsiteData {

    /**
     * Information for the tests.
     */

    private final String[] registeredUsers;
    private final String correctPassword;
    private final String correctUser;
    private final String wrongUser;
    private final String wrongPassword;
    private final String checkOutName;
    private final String checkOutLastName;
    private final String postalCode;

    public UsersInfo() {
        this.registeredUsers = new String[]{"standard_user", "error_user", "problem_user"};
        this.correctPassword = "secret_sauce";
        this.correctUser = "standard_user";
        this.wrongUser = "Wrong User";
        this.wrongPassword = "Wrong Password";
        this.checkOutName = "Testing Name";
        this.checkOutLastName = "Testing Last Name";
        this.postalCode = "123-456";
    }

    public String[] getRegisteredUsers() {
        return registeredUsers;
    }

    public String getCorrectPassword() {
        return correctPassword;
    }

    public String getCorrectUser() {
        return correctUser;
    }

    public String getWrongUser() {
        return wrongUser;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getCheckOutName() {
        return checkOutName;
    }

    public String getCheckOutLastName() {
        return checkOutLastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}