package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SLOverviewPage {

    private final SelenideElement finishBtn = $(byId("finish"));
    private final SelenideElement checkoutText = $x("//span[@class='title']");


    public SLCompletePage clickFinish() {
        finishBtn.click();
        return new SLCompletePage();
    }

    public SLOverviewPage checkOverviewText() {
        checkoutText.shouldHave(text("Checkout: Overview"));
        return this;
    }

}
