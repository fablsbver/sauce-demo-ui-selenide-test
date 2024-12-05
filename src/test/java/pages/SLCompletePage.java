package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SLCompletePage {
    private final SelenideElement thnForOrderText = $x("//h2[@class='complete-header']");
    private final SelenideElement backBtn = $(byId("back-to-products"));

    public SLCompletePage checkOrder() {
        thnForOrderText.shouldHave().text().equals("Thank you for your order!");
        return this;
    }

    public SLShopPage clickBack() {
        backBtn.click();
        return new SLShopPage();
    }
}
