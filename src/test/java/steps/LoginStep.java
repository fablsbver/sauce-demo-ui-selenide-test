package steps;

import pages.SLLoginPage;
import pages.SLShopPage;

public class LoginStep {
    private static final SLLoginPage slLoginPage = new SLLoginPage();

    public static void loginToPage(String userName, String password) {
        SLShopPage slShopPage = slLoginPage
                .openPage()
                .enterUserName(userName)
                .enterPassword(password)
                .clickLogin();
    }

    public static void checkErrorMessage(String text) {
        slLoginPage.checkErrorMessage(text);
    }

}
