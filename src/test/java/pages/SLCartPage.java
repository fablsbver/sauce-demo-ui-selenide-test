package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class SLCartPage {

    private final SelenideElement checkoutBtn = $x("//button[@class='btn btn_action btn_medium checkout_button ']");
    private final SelenideElement continueShoppingPageBtn = $x("//button[@class='btn btn_secondary back btn_medium']");
    private final SelenideElement removeBtn = $x("//button[@class='btn btn_secondary btn_small cart_button']");
    private final SelenideElement shoppingCartBadge = $x("//span[@class='shopping_cart_badge']");

    public SLInfoPage checkoutOrder() {
        checkoutBtn.click();
        return new SLInfoPage();
    }

    public SLShopPage clickContinueShopping() {
        continueShoppingPageBtn.click();
        return new SLShopPage();
    }

    public SLCartPage clickRemove() {
        removeBtn.click();
        return this;
    }

    public SLCartPage hideShoppingCartBadgeNumber() {
        shoppingCartBadge.should(disappear);
        return this;
    }
}
