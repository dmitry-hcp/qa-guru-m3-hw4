package qaguru.dmtr.ivnv;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import qaguru.dmtr.ivnv.pages.TextBoxPage;
import qaguru.dmtr.ivnv.pages.StudentRegistrationFormPage;
import qaguru.dmtr.ivnv.pages.components.TableComponent;
import qaguru.dmtr.ivnv.testdata.TestData;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    TextBoxPage textBoxPage =  new TextBoxPage();
    StudentRegistrationFormPage studentRegistrationFormPage =  new StudentRegistrationFormPage();
    TableComponent tableComponent = new TableComponent();
    TestData testData = new TestData();

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