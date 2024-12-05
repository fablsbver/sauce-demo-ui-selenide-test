package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SLInfoPage {

    private final SelenideElement firstName = $(byId("first-name"));
    private final SelenideElement lastName = $(byId("last-name"));
    private final SelenideElement postalCode = $(byId("postal-code"));
    private final SelenideElement continueBtn = $(byId("continue"));
    private final SelenideElement errorMessageContainer = $x("//div[@class='error-message-container error']");


    public SLInfoPage typeFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    public SLInfoPage typeLastName(String name) {
        lastName.sendKeys(name);
        return this;
    }

    public SLInfoPage typePostalCode(String code) {
        postalCode.sendKeys(code);
        return this;
    }

    public SLOverviewPage clickContinueBtn() {
        continueBtn.click();
        return new SLOverviewPage();
    }

    public SLInfoPage checkErrorMessage(String message) {
        errorMessageContainer.shouldHave(text(message));
        return this;
    }
}
