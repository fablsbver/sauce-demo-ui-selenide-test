package tests.page_test;

import org.junit.jupiter.api.Test;
import pages.*;
import tests.base_test.BaseTest;

import static test_data.TestData.UserData.PASSWORD;
import static test_data.TestData.UserData.STANDART_USER_NAME;
import static test_data.TestData.UserInfo.*;


public class PurchaseTest extends BaseTest {
    @Test
    public void getPurchase() {
        SLLoginPage slLoginPage = new SLLoginPage()
                .openPage()
                .enterUserName(STANDART_USER_NAME)
                .enterPassword(PASSWORD);

        SLShopPage slShopPage = slLoginPage
                .clickLogin()
                .addBackpackToCart()
                .addJacketToCart()
                .addOnesieToCart();

        SLCartPage slCartPage = slShopPage.clickToShoppingCart();

        SLInfoPage slInfoPage = slCartPage
                .checkoutOrder()
                .typeFirstName(FIRST_NAME)
                .typeLastName(LAST_NAME)
                .typePostalCode(POSTAL_CODE);

        SLOverviewPage slOverviewPage = slInfoPage.clickContinueBtn();
        SLCompletePage slCompletePage = slOverviewPage
                .clickFinish()
                .checkOrder();

        SLShopPage backToShopPage = slCompletePage
                .clickBack()
                .clickMenu()
                .clickLogout();

    }

}
