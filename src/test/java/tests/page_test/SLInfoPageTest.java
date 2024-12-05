package tests.page_test;

import org.junit.jupiter.api.Test;
import pages.SLCartPage;
import pages.SLInfoPage;
import pages.SLOverviewPage;
import tests.base_test.BaseTest;

import static constants.Constants.slShopPage;
import static steps.LoginStep.loginToPage;
import static test_data.TestData.TextData.*;
import static test_data.TestData.UserData.PASSWORD;
import static test_data.TestData.UserData.STANDART_USER_NAME;
import static test_data.TestData.UserInfo.*;

public class SLInfoPageTest extends BaseTest {

    @Test
    public void sendCompletedInfo() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        SLInfoPage slInfoPage = slCartPage
                .checkoutOrder();
        slInfoPage
                .typeFirstName(FIRST_NAME)
                .typeLastName(LAST_NAME)
                .typePostalCode(POSTAL_CODE);
        SLOverviewPage slOverviewPage = slInfoPage
                .clickContinueBtn();
        slOverviewPage
                .checkOverviewText();
    }

    @Test
    public void sendEmptyInfoField() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        SLInfoPage slInfoPage = slCartPage
                .checkoutOrder();
        slInfoPage
                .typeFirstName("")
                .typeLastName("")
                .typePostalCode("")
                .clickContinueBtn();

        slInfoPage.checkErrorMessage(EMPTY_FIRST_NAME_TEXT);
    }

    @Test
    public void sendEmptyLastNameAndPostalCodeField() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        SLInfoPage slInfoPage = slCartPage
                .checkoutOrder();
        slInfoPage
                .typeFirstName(FIRST_NAME)
                .typeLastName("")
                .typePostalCode("")
                .clickContinueBtn();

        slInfoPage.checkErrorMessage(EMPTY_LAST_NAME_TEXT);
    }

    @Test
    public void sendEmptyPostalCodeField() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        SLInfoPage slInfoPage = slCartPage
                .checkoutOrder();
        slInfoPage
                .typeFirstName(FIRST_NAME)
                .typeLastName(LAST_NAME)
                .typePostalCode("")
                .clickContinueBtn();

        slInfoPage.checkErrorMessage(EMPTY_CODE_TEXT);
    }

}
