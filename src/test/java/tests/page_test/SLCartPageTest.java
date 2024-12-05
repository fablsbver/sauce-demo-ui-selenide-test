package tests.page_test;

import org.junit.jupiter.api.Test;
import pages.SLCartPage;
import pages.SLShopPage;
import tests.base_test.BaseTest;

import static constants.Constants.slShopPage;
import static steps.LoginStep.loginToPage;
import static test_data.TestData.UserData.PASSWORD;
import static test_data.TestData.UserData.STANDART_USER_NAME;

public class SLCartPageTest extends BaseTest {

    @Test
    public void checkShoppingCartBudgeFunc() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        slCartPage
                .clickRemove()
                .hideShoppingCartBadgeNumber();
    }

    @Test
    public void checkContShopBtn() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .addBackpackToCart();
        SLCartPage slCartPage = slShopPage
                .clickToShoppingCart();
        SLShopPage newSlShopPage = slCartPage
                .clickContinueShopping();
        newSlShopPage.checkLogoIsDisplayed();
    }
}
