package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.config.Endpoints.*;
import static qaguru.dmtr.ivnv.testdata.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void shouldSubmitWithValidData() {

        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(testData.firstName)
                .typeUserLastName(testData.lastName)
                .typeUserEmail(testData.validUserEmail)
                .setGender(userGender)
                .typeUserMobileNumber(testData.validUserMobileNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubject(subjectValue)
                .setHobby(hobbyValue)
                .uploadPicture(pictureFileName)
                .typeCurrentAddress(userAddress)
                .setStateAndCity(stateOption, cityOption)
                .submitForm();
        tableComponent
                .resultsContainerShouldAppear()
                .resultsContainerTitleShouldHave("Thanks for submitting the form")
                .resultsContainerTableRowShouldHave("Student Name", testData.studentFullName)
                .resultsContainerTableRowShouldHave("Student Email", testData.validUserEmail)
                .resultsContainerTableRowShouldHave("Gender", userGender)
                .resultsContainerTableRowShouldHave("Mobile", testData.validUserMobileNumber)
                .resultsContainerTableRowShouldHave("Date of Birth", fullDateOfBirth)
                .resultsContainerTableRowShouldHave("Subjects", subjectValue)
                .resultsContainerTableRowShouldHave("Hobbies", hobbyValue)
                .resultsContainerTableRowShouldHave("Picture", pictureFileName)
                .resultsContainerTableRowShouldHave("Address", userAddress)
                .resultsContainerTableRowShouldHave("State and City", stateAndCityValue);
    }

//    @Test
//    void shouldSubmitWithValidRequiredFields() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserFirstName(firstName)
//                .typeUserLastName(lastName)
//                .setGender(userGender)
//                .typeUserMobileNumber(validUserMobileNumber)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldAppear()
//                .resultsContainerTitleShouldHave("Thanks for submitting the form")
//                .resultsContainerTableRowShouldHave("Student Name", studentFullName)
//                .resultsContainerTableValueShouldBeEmpty("Student Email")
//                .resultsContainerTableRowShouldHave("Gender", userGender)
//                .resultsContainerTableRowShouldHave("Mobile", validUserMobileNumber)
//                .dateOfBirthShouldNotBeEmpty("Date of Birth")
//                .resultsContainerTableValueShouldBeEmpty("Subjects")
//                .resultsContainerTableValueShouldBeEmpty("Hobbies")
//                .resultsContainerTableValueShouldBeEmpty("Picture")
//                .resultsContainerTableValueShouldBeEmpty("Address")
//                .resultsContainerTableValueShouldBeEmpty("State and City");
//    }
//
//    @Test
//    void shouldNotSubmitWithoutFirstName() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserLastName(lastName)
//                .setGender(userGender)
//                .typeUserMobileNumber(validUserMobileNumber)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldNotExist();
//    }
//
//    @Test
//    void shouldNotSubmitWithoutLastName() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserFirstName(firstName)
//                .setGender(userGender)
//                .typeUserMobileNumber(validUserMobileNumber)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldNotExist();
//    }
//
//    @Test
//    void shouldNotSubmitWithoutGender() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserFirstName(firstName)
//                .typeUserLastName(lastName)
//                .typeUserMobileNumber(validUserMobileNumber)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldNotExist();
//    }
//
//    @Test
//    void shouldNotSubmitWithoutMobileNumber() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserFirstName(firstName)
//                .typeUserLastName(lastName)
//                .setGender(userGender)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldNotExist();
//    }
//
//    @Test
//    void shouldNotSubmitWithWrongMobileNumber() {
//        studentRegistrationFormPage
//                .openPage(AUTOMATION_PRACTICE_FORM)
//                .removeDemoQaObstructiveElements()
//                .typeUserFirstName(firstName)
//                .typeUserLastName(lastName)
//                .setGender(userGender)
//                .typeUserMobileNumber(invalidUserMobileNumber)
//                .submitForm();
//        tableComponent
//                .resultsContainerShouldNotExist();
//    }
}