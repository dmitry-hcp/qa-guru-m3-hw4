package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    void shouldSubmitSimpleFormSWithValidData() {
        textBoxPage
                .openPage()
                .typeUserName(studentFullName)
                .submitForm()
                .fieldShouldHaveValue("name", "Name:" + studentFullName)
                .fieldShouldNotExist("email")
                .fieldShouldNotExist("currentAddress")
                .fieldShouldNotExist("permanentAddress");
    }

    @Test
    void shouldNotSubmitSimpleFormSWithWrongEmail() {
        textBoxPage
                .openPage()
                .typeUserName(studentFullName)
                .submitForm()
                .typeUserName(studentFullName)
                .typeUserEmail(invalidUserEmail)
                .submitForm()
                .fieldShouldHaveValue("name", "Name:" + studentFullName)
                .fieldShouldNotExist("email")
                .fieldShouldNotExist("currentAddress")
                .fieldShouldNotExist("permanentAddress");
    }
}
