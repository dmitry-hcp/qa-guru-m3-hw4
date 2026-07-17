package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.config.Endpoints.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void shouldSubmitWithValidData() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .typeUserLastName(randomTestData.lastName)
                .typeUserEmail(randomTestData.validUserEmail)
                .setGender(randomTestData.userGender)
                .typeUserMobileNumber(randomTestData.validUserMobileNumber)
                .setBirthDay(randomTestData.birthDay, randomTestData.birthMonth, randomTestData.birthYear)
                .setSubject(randomTestData.subjectValue)
                .setHobby(randomTestData.hobbyValue)
                .uploadPicture(randomTestData.pictureFileName)
                .typeCurrentAddress(randomTestData.userAddress)
                .setStateAndCity(randomTestData.stateOption, randomTestData.cityOption)
                .submitForm();
        tableComponent
                .resultsContainerShouldAppear()
                .resultsContainerTitleShouldHave("Thanks for submitting the form")
                .resultsContainerTableRowShouldHave("Student Name", randomTestData.studentFullName)
                .resultsContainerTableRowShouldHave("Student Email", randomTestData.validUserEmail)
                .resultsContainerTableRowShouldHave("Gender", randomTestData.userGender)
                .resultsContainerTableRowShouldHave("Mobile", randomTestData.validUserMobileNumber)
                .resultsContainerTableRowShouldHave("Date of Birth", randomTestData.fullDateOfBirth)
                .resultsContainerTableRowShouldHave("Subjects", randomTestData.subjectValue)
                .resultsContainerTableRowShouldHave("Hobbies", randomTestData.hobbyValue)
                .resultsContainerTableRowShouldHave("Picture", randomTestData.pictureFileName)
                .resultsContainerTableRowShouldHave("Address", randomTestData.userAddress)
                .resultsContainerTableRowShouldHave("State and City", randomTestData.stateAndCityValue);
    }

    @Test
    void shouldSubmitWithValidRequiredFields() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .typeUserLastName(randomTestData.lastName)
                .setGender(randomTestData.userGender)
                .typeUserMobileNumber(randomTestData.validUserMobileNumber)
                .submitForm();
        tableComponent
                .resultsContainerShouldAppear()
                .resultsContainerTitleShouldHave("Thanks for submitting the form")
                .resultsContainerTableRowShouldHave("Student Name", randomTestData.studentFullName)
                .resultsContainerTableValueShouldBeEmpty("Student Email")
                .resultsContainerTableRowShouldHave("Gender", randomTestData.userGender)
                .resultsContainerTableRowShouldHave("Mobile", randomTestData.validUserMobileNumber)
                .dateOfBirthShouldNotBeEmpty("Date of Birth")
                .resultsContainerTableValueShouldBeEmpty("Subjects")
                .resultsContainerTableValueShouldBeEmpty("Hobbies")
                .resultsContainerTableValueShouldBeEmpty("Picture")
                .resultsContainerTableValueShouldBeEmpty("Address")
                .resultsContainerTableValueShouldBeEmpty("State and City");
    }

    @Test
    void shouldNotSubmitWithoutFirstName() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserLastName(randomTestData.lastName)
                .setGender(randomTestData.userGender)
                .typeUserMobileNumber(randomTestData.validUserMobileNumber)
                .submitForm();
        tableComponent
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutLastName() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .setGender(randomTestData.userGender)
                .typeUserMobileNumber(randomTestData.validUserMobileNumber)
                .submitForm();
        tableComponent
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutGender() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .typeUserLastName(randomTestData.lastName)
                .typeUserMobileNumber(randomTestData.validUserMobileNumber)
                .submitForm();
        tableComponent
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutMobileNumber() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .typeUserLastName(randomTestData.lastName)
                .setGender(randomTestData.userGender)
                .submitForm();
        tableComponent
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithWrongMobileNumber() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .removeDemoQaObstructiveElements()
                .typeUserFirstName(randomTestData.firstName)
                .typeUserLastName(randomTestData.lastName)
                .setGender(randomTestData.userGender)
                .typeUserMobileNumber(randomTestData.invalidUserMobileNumber)
                .submitForm();
        tableComponent
                .resultsContainerShouldNotExist();
    }
}