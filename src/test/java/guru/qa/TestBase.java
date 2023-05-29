package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase  {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "720x880";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com/YuryFedoseev/HW_18_Les11_Allure";
    }
}
