package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase  {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "720x880";
        Configuration.baseUrl = "https://github.com/YuryFedoseev/HW_18_Les11_Allure";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }
}
