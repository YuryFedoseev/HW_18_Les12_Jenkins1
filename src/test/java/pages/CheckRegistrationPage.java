package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckRegistrationPage {
    private final SelenideElement checkTableResponsive = $x("//div[@class='table-responsive']");

    //Проверка данных
    public CheckRegistrationPage checkNameAndLastName(String valueName, String valueLastName) {
        checkTableResponsive.shouldHave(Condition.text(valueName));
        checkTableResponsive.shouldHave(Condition.text(valueLastName));

        return this;
    }

    public CheckRegistrationPage checkEmail(String values) {
        checkTableResponsive.shouldHave(Condition.text(values));

        return this;
    }

    public CheckRegistrationPage checkGender(String values) {
        checkTableResponsive.shouldHave(Condition.text(values));

        return this;
    }

    public CheckRegistrationPage checkPhone(String value) {
        checkTableResponsive.shouldHave(Condition.text(value));

        return this;
    }

    public CheckRegistrationPage checkSubject(String value) {
        checkTableResponsive.shouldHave(Condition.text(value));

        return this;
    }

    public CheckRegistrationPage checkHobby(String value) {
        checkTableResponsive.shouldHave(Condition.text(value));

        return this;
    }

    public CheckRegistrationPage checkImage(String value) {
        checkTableResponsive.shouldHave(Condition.text(value));

        return this;
    }

    public CheckRegistrationPage checkAddress(String value) {
        checkTableResponsive.shouldHave(Condition.text(value));

        return this;
    }

    public CheckRegistrationPage checkState(String valueState) {
        checkTableResponsive.shouldHave(Condition.text(valueState));

        return this;
    }

    public CheckRegistrationPage checkCity(String valueCity) {
        checkTableResponsive.shouldHave(Condition.text(valueCity));

        return this;
    }


}
