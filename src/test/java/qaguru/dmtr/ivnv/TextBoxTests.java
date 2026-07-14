package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.config.Endpoints.*;
import static qaguru.dmtr.ivnv.testdata.TestData.*;

public class TextBoxTests extends TestBase {

    @Disabled
    @Test
    void shouldSubmitSimpleFormSWithValidData() {
        textBoxPage
                .openPage(TEXT_BOX)
                .removeDemoQaObstructiveElements()
                .typeUserName(testData.studentFullName)
                .submitForm()
                .fieldShouldHaveValue("name", "Name:" + testData.studentFullName)
                .fieldShouldNotExist("email")
                .fieldShouldNotExist("currentAddress")
                .fieldShouldNotExist("permanentAddress");
    }

//    @Test
//    void shouldNotSubmitSimpleFormSWithWrongEmail() {
//        textBoxPage
//                .openPage(TEXT_BOX)
//                .removeDemoQaObstructiveElements()
//                .typeUserName(studentFullName)
//                .submitForm()
//                .typeUserName(studentFullName)
//                .typeUserEmail(invalidUserEmail)
//                .submitForm()
//                .fieldShouldHaveValue("name", "Name:" + studentFullName)
//                .fieldShouldNotExist("email")
//                .fieldShouldNotExist("currentAddress")
//                .fieldShouldNotExist("permanentAddress");
//    }
}
