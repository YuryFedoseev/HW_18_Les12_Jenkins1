package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    @Test
    @Tag("browser")
    void setBrowserName() {
        String browserName = System.getProperty("browser");
        Configuration.browser = browserName;
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "720x880";
        Configuration.baseUrl = "https://github.com/YuryFedoseev/HW_18_Les11_Allure";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


        Configuration.browserVersion = "100.0";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:option", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
         Attach.addVideo();
    }
}
