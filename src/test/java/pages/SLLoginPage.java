package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.Properties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static steps.TestProperties.getProperty;

public class SLLoginPage {

    private final SelenideElement userName = $(byId("user-name"));
    private final SelenideElement password = $(byId("password"));
    private final SelenideElement loginBtn = $x("//input[@type='submit']");
    private final SelenideElement errorMessageContainer = $x("//div[@class='error-message-container error']");

    public SLLoginPage openPage() {
        Selenide.open(getProperty("baseUrl"));
        return this;
    }

    public SLLoginPage enterUserName(String name) {
        userName.sendKeys(name);
        return this;
    }

    public SLLoginPage enterPassword(String userPassword) {
        password.sendKeys(userPassword);
        return this;
    }

    public SLShopPage clickLogin() {
        loginBtn.click();
        return new SLShopPage();
    }

    public SLLoginPage checkErrorMessage(String message) {
        errorMessageContainer.shouldHave(text(message));
        return this;
    }

}
