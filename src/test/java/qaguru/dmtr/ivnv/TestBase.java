package qaguru.dmtr.ivnv;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import qaguru.dmtr.ivnv.pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    TextBoxPage textBoxPage =  new TextBoxPage();

    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x1024";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

}