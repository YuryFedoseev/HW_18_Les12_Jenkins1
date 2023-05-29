package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    private final SelenideElement submit = $("#submit");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }
    public RegistrationPage closeBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value).pressTab();

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value).pressTab();

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value).pressTab();

        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byTagAndText("Label", value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumberInput.setValue(value).click();

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        $(byTagAndText("Label", value)).click();

        return this;
    }

    public RegistrationPage setImage(String value) {
        File pictures = new File(value);
        uploadPicture.uploadFile(pictures);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();


        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();


        return this;
    }


    public RegistrationPage setClickSubmit() {
        submit.pressEnter();

        return this;
    }


}
