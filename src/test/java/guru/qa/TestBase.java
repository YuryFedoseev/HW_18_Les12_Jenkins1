package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {



    @BeforeAll
    static void beforeAll() {

        Configuration.browser = System.getProperty("browser", "chrome");

        Configuration.browserVersion = System.getProperty("browserVersion", "100" );

        Configuration.browserSize = System.getProperty("browserSize","720x880" );

        Configuration.baseUrl = System.getProperty("baseUrl","https://demoqa.com");

        Configuration.remote = System.getProperty("remoteUrl","https://user1:1234@selenoid.autotests.cloud/wd/hub");

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
