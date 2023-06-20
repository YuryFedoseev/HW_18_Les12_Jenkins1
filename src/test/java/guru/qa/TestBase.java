package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase  {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "720x880";
        Configuration.baseUrl = "https://github.com/YuryFedoseev/HW_18_Les11_Allure";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:option", Map.<String,Object>of(
                "enableVNC",true,
                "enableVideo", true
                ));
        Configuration.browserCapabilities = capabilities;
    }
}
