package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.config.Endpoints.*;

public class TextBoxTests extends TestBase {

    @Disabled
    @Test
    void shouldSubmitSimpleFormSWithValidData() {
        textBoxPage
                .openPage(TEXT_BOX)
                .removeDemoQaObstructiveElements()
                .typeUserName(randomTestData.studentFullName)
                .submitForm()
                .fieldShouldHaveValue("name", "Name:" + randomTestData.studentFullName)
                .fieldShouldNotExist("email")
                .fieldShouldNotExist("currentAddress")
                .fieldShouldNotExist("permanentAddress");
    }

    @Test
    void shouldNotSubmitSimpleFormSWithWrongEmail() {
        textBoxPage
                .openPage(TEXT_BOX)
                .removeDemoQaObstructiveElements()
                .typeUserName(randomTestData.studentFullName)
                .submitForm()
                .typeUserName(randomTestData.studentFullName)
                .typeUserEmail(randomTestData.invalidUserEmail)
                .submitForm()
                .fieldShouldHaveValue("name", "Name:" + randomTestData.studentFullName)
                .fieldShouldNotExist("email")
                .fieldShouldNotExist("currentAddress")
                .fieldShouldNotExist("permanentAddress");
    }
}
