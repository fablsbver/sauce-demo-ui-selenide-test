package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import test_data.ProductSortingType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;

public class SLShopPage {

    private final SelenideElement backpackAdd = $(byId("add-to-cart-sauce-labs-backpack"));
    private final SelenideElement jacketAdd = $(byId("add-to-cart-sauce-labs-fleece-jacket"));
    private final SelenideElement onesieAdd = $(byId("add-to-cart-sauce-labs-onesie"));
    private final SelenideElement menuBtn = $(byId("react-burger-menu-btn"));
    private final SelenideElement logoutBtn = $(byId("logout_sidebar_link"));
    private final SelenideElement reactBurgerMenu = $(byId("react-burger-menu-btn"));
    private final SelenideElement shoppCartBtn = $x("//a[@class='shopping_cart_link']");
    private final SelenideElement productSortContainer = $x("//select[@class='product_sort_container']");
    private final SelenideElement valueAZ = $x("//option[@value='az']");
    private final SelenideElement valueZA = $x("//option[@value='za']");
    private final SelenideElement valueLowToHigh = $x("//option[@value='lohi']");
    private final SelenideElement valueHighToLow = $x("//option[@value='hilo']");
    private final SelenideElement shoppingCartBadgeNumber = $x("//span[@class='shopping_cart_badge']");
    private final SelenideElement appLogo = $x("//div[@class='app_logo']");
    private final ElementsCollection itemName = $$x("//div[@data-test='inventory-item-name']");
    private final ElementsCollection itemPrice = $$x("//div[@data-test='inventory-item-price']");
    private final ElementsCollection removeBtn = $$x("//button[@class='btn btn_secondary btn_small btn_inventory ']");

    public SLShopPage checkLogoIsDisplayed() {
        appLogo.shouldHave(text("Swag Labs"));
        return this;
    }

    public SLShopPage addBackpackToCart() {
        backpackAdd.click();
        return this;
    }

    public SLShopPage addJacketToCart() {
        jacketAdd.click();
        return this;
    }

    public SLShopPage addOnesieToCart() {
        onesieAdd.click();
        return this;
    }

    public SLCartPage clickToShoppingCart() {
        shoppCartBtn.click();
        return new SLCartPage();
    }

    public SLShopPage clickMenu() {
        menuBtn.click();
        return this;
    }

    public SLShopPage clickBurgerMenu() {
        reactBurgerMenu.click();
        return this;
    }

    public SLShopPage clickLogout() {
        logoutBtn.click();
        return this;
    }

    public Integer getShoppingCartBadgeNumber() {
        return Integer.parseInt(shoppingCartBadgeNumber.getText());
    }

    public Integer countItemsInCart() {
        return removeBtn.size();
    }

    public List<String> getExpectedListOfItems(ProductSortingType type) {
        List<String> sortedItems = new ArrayList<>();
        switch (type) {
            case AZ:
                sortedItems = itemName
                        .stream()
                        .map(SelenideElement::getText)
                        .sorted()
                        .toList();
                break;
            case ZA:
                sortedItems = itemName
                        .stream()
                        .map(SelenideElement::getText)
                        .sorted(Comparator.reverseOrder())
                        .toList();
                break;
            case LOHI:
                sortedItems = itemPrice
                        .stream()
                        .map(SelenideElement::getText)
                        .sorted((s1, s2) -> {
                            double num1 = Double.parseDouble(s1.substring(1));
                            double num2 = Double.parseDouble(s2.substring(1));
                            return Double.compare(num1, num2);
                        })
                        .toList();
                break;
            case HILO:
                sortedItems = itemPrice
                        .stream()
                        .map(SelenideElement::getText)
                        .sorted((s1, s2) -> {
                            double num1 = Double.parseDouble(s1.substring(1));
                            double num2 = Double.parseDouble(s2.substring(1));
                            return Double.compare(num2, num1);
                        })
                        .toList();

        }
        return sortedItems;
    }

    public List<String> getActualListOfItems(ProductSortingType type) {
        List<String> sortedItems = new ArrayList<>();
        switch (type) {
            case AZ:
                productSortContainer.click();
                valueAZ.click();
                sortedItems = itemName
                        .stream()
                        .map(SelenideElement::getText)
                        .toList();
                break;
            case ZA:
                productSortContainer.click();
                valueZA.click();
                sortedItems = itemName
                        .stream()
                        .map(SelenideElement::getText)
                        .toList();
                break;
            case LOHI:
                productSortContainer.click();
                valueLowToHigh.click();
                sortedItems = itemPrice
                        .stream()
                        .map(SelenideElement::getText)
                        .toList();
                break;
            case HILO:
                productSortContainer.click();
                valueHighToLow.click();
                sortedItems = itemPrice
                        .stream()
                        .map(SelenideElement::getText)
                        .toList();
                break;
        }
        return sortedItems;
    }
}




