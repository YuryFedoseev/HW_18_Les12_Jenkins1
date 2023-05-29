package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.CheckRegistrationPage;
import pages.RegistrationPage;

public class TestWebFormParametrize extends TestBase {
    private TestData testData = new TestData() ;
    RegistrationPage registrationPage = new RegistrationPage();
    CheckRegistrationPage checkRegistrationPage = new CheckRegistrationPage();

    @BeforeEach
    void openPageAndKillBannerAndSetFieldsExceptHobby() {
        registrationPage
                .openPage()
                .closeBanner()
                .setFirstName(testData.userName)
                .setLastName(testData.userLastName)
                .setEmail(testData.userEmail)
                .setPhone(testData.userPhone)
                .setSubject(testData.userSubject)
                .setImage(testData.userImage)
                .setAddress(testData.userAddress)
                .setState(testData.userState)
                .setCity(testData.userCity)
                .setGender(testData.userGender)
                .setHobby(testData.userHobby)
                .setGender(testData.userGender)
                .setHobby(testData.userHobby);

    }



    @ValueSource(strings = {"Music", "Sports", "Reading"})
    @DisplayName("Параметризованный тест выбора хобби на форме регистрации")
    @ParameterizedTest (name ="В форме заполнения выбор Хобби -  {0}")
    @Tag("Web")
    void checkingWhetherTheHobbyFieldWithDifferentValuesTest(String testData) {

        registrationPage
                .setHobby(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkHobby(testData);


    }

    @ValueSource(strings = {"Female", "Male", "Other"})
    @DisplayName("Параметризованный тест выбора пола на форме регистрации")
    @ParameterizedTest (name = "В форме заполнения параметризованный выбор Пола {0}")
    @Tag("Web")
    void checkingWhetherTheGenderFieldWithDifferentValuesTest(String testData) {

        registrationPage
                .setGender(testData)
                .setClickSubmit();
        checkRegistrationPage
                .checkGender(testData);


    }


    @CsvFileSource(resources = "/testData/checkingWhetherTheCityFieldWithDifferentValuesTest.csv")
    @ParameterizedTest (name = "В форме заполнения параметризованный выбор страны -{0}  и города {1}")
    @DisplayName("Параметризованный тест выбора места локации на форме регистрации")
    @Tag("Web")
    void checkingWhetherTheCityFieldWithDifferentValuesTest(String testData, String expectedText) {

        registrationPage

                .setState(testData)
                .setCity(expectedText)
                .setClickSubmit();
        checkRegistrationPage
                .checkState(testData)
               .checkCity(expectedText);

    }


    @CsvSource(value ={
            "Sirius, Black",
            "Draco, Malfoy",
            "Dolores, Umbridge",
            "Harry, Potter"})

    @ParameterizedTest (name = "В форме заполнения параметризованный выбор Имени -{0}  и Фамилии- {1}")
    @DisplayName("Параметризованный тест выбора связки имен и фамилий на форме регистрации")
    @Tag("Web")
    void checkingWhetherTheNameAndLastNameFieldWithDifferentValuesTest(String testData, String expectedText) {

        registrationPage

                .setFirstName(testData)
                .setLastName(expectedText)
                .setClickSubmit();
        checkRegistrationPage
                .checkNameAndLastName(testData,expectedText );


    }
}

