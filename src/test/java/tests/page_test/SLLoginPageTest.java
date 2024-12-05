package tests.page_test;

import org.junit.jupiter.api.Test;
import tests.base_test.BaseTest;

import static steps.LoginStep.checkErrorMessage;
import static steps.LoginStep.loginToPage;
import static test_data.TestData.TextData.*;
import static test_data.TestData.UserData.*;

public class SLLoginPageTest extends BaseTest {

    @Test
    public void loginUsingCorrectData() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
    }

    @Test
    public void loginUsingProblemUserData() {
        loginToPage(PROBLEM_USER_NAME, PASSWORD);
    }

    @Test
    public void loginUsingPerformanceGlitchUserData() {
        loginToPage(PERFORMANCE_GLITCH_USER_NAME, PASSWORD);
    }

    @Test
    public void loginUsingLockedData() {
        loginToPage(LOCKED_OUT_USER_NAME, PASSWORD);
        checkErrorMessage(LOCKED_USER_TEXT);
    }

    @Test
    public void loginUsingUncorrectedData() {
        loginToPage(WRONG_USER_NAME, WRONG_PASSWORD);
        checkErrorMessage(WRONG_USER_TEXT);
    }

    @Test
    public void loginUsingEmptyData() {
        loginToPage("", "");
        checkErrorMessage(EMPTY_USER_TEXT);
    }

    @Test
    public void loginUsingEmptyLoginField() {
        loginToPage("", PASSWORD);
        checkErrorMessage(EMPTY_USER_TEXT);
    }

    @Test
    public void loginUsingEmptyPasswordField() {
        loginToPage(STANDART_USER_NAME, "");
        checkErrorMessage(EMPTY_PASSWORD_TEXT);
    }
}
