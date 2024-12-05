package tests.page_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.base_test.BaseTest;

import java.util.List;

import static constants.Constants.slShopPage;
import static steps.LoginStep.loginToPage;
import static test_data.ProductSortingType.*;
import static test_data.TestData.UserData.PASSWORD;
import static test_data.TestData.UserData.STANDART_USER_NAME;

public class SLShopPageTest extends BaseTest {

    @Test
    public void logout() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        slShopPage
                .clickBurgerMenu()
                .clickLogout();
    }

    @Test
    public void checkIsItemNamesAreSortedAZ() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        List<String> itemList = slShopPage.getExpectedListOfItems(AZ);
        List<String> sortedItemList = slShopPage.getActualListOfItems(AZ);
        Assertions.assertEquals(itemList, sortedItemList);
    }

    @Test
    public void checkIsItemNamesAreSortedZA() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        List<String> itemList = slShopPage.getExpectedListOfItems(ZA);
        List<String> sortedItemList = slShopPage.getActualListOfItems(ZA);
        Assertions.assertEquals(itemList, sortedItemList);
    }

    @Test
    public void checkIsItemNamesAreSortedLoHi() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        List<String> itemList = slShopPage.getExpectedListOfItems(LOHI);
        List<String> sortedItemList = slShopPage.getActualListOfItems(LOHI);
        Assertions.assertEquals(itemList, sortedItemList);
    }

    @Test
    public void checkIsItemNamesAreSortedHiLo() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        List<String> itemList = slShopPage.getExpectedListOfItems(HILO);
        List<String> sortedItemList = slShopPage.getActualListOfItems(HILO);
        Assertions.assertEquals(itemList, sortedItemList);
    }

    @Test
    public void checkShoppingCartBudgeFunc() {
        loginToPage(STANDART_USER_NAME, PASSWORD);
        Integer actualAmount = slShopPage
                .addBackpackToCart()
                .addJacketToCart()
                .getShoppingCartBadgeNumber();
        Integer expectedAmount = slShopPage.countItemsInCart();
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

}
