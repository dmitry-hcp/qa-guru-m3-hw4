package qaguru.dmtr.ivnv;

import org.junit.jupiter.api.Test;

import static qaguru.dmtr.ivnv.config.Endpoints.*;
import static qaguru.dmtr.ivnv.testdata.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void shouldSubmitWithValidData() {

        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserEmail(validUserEmail)
                .setGender(userGender)
                .typeUserMobileNumber(validUserMobileNumber)
                .setBirthDay(birthDay, birthMonth, birthYear)
                .setSubject(subjectValue)
                .setHobby(hobbyValue)
                .uploadPicture(pictureFileName)
                .typeCurrentAddress(userAddress)
                .setStateAndCity(stateOption, cityOption)
                .submitForm()
                .resultsContainerShouldAppear()
                .resultsContainerTitleShouldHave("Thanks for submitting the form")
                .resultsContainerTableRowShouldHave("Student Name", studentFullName)
                .resultsContainerTableRowShouldHave("Student Email", validUserEmail)
                .resultsContainerTableRowShouldHave("Gender", userGender)
                .resultsContainerTableRowShouldHave("Mobile", validUserMobileNumber)
                .resultsContainerTableRowShouldHave("Date of Birth", fullDateOfBirth)
                .resultsContainerTableRowShouldHave("Subjects", subjectValue)
                .resultsContainerTableRowShouldHave("Hobbies", hobbyValue)
                .resultsContainerTableRowShouldHave("Picture", pictureFileName)
                .resultsContainerTableRowShouldHave("Address", userAddress)
                .resultsContainerTableRowShouldHave("State and City", stateAndCityValue);
    }

    @Test
    void shouldSubmitWithValidRequiredFields() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setGender(userGender)
                .typeUserMobileNumber(validUserMobileNumber)
                .submitForm()
                .resultsContainerShouldAppear()
                .resultsContainerTitleShouldHave("Thanks for submitting the form")
                .resultsContainerTableRowShouldHave("Student Name", studentFullName)
                .resultsContainerTableKeyShouldBeEmpty("Student Email")
                .resultsContainerTableRowShouldHave("Gender", userGender)
                .resultsContainerTableRowShouldHave("Mobile", validUserMobileNumber)
                .dateOfBirthShouldNotBeEmpty("Date of Birth")
                .resultsContainerTableKeyShouldBeEmpty("Subjects")
                .resultsContainerTableKeyShouldBeEmpty("Hobbies")
                .resultsContainerTableKeyShouldBeEmpty("Picture")
                .resultsContainerTableKeyShouldBeEmpty("Address")
                .resultsContainerTableKeyShouldBeEmpty("State and City");
    }

    @Test
    void shouldNotSubmitWithoutFirstName() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserLastName(lastName)
                .setGender(userGender)
                .typeUserMobileNumber(validUserMobileNumber)
                .submitForm()
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutLastName() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .setGender(userGender)
                .typeUserMobileNumber(validUserMobileNumber)
                .submitForm()
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutGender() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserMobileNumber(validUserMobileNumber)
                .submitForm()
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithoutMobileNumber() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setGender(userGender)
                .submitForm()
                .resultsContainerShouldNotExist();
    }

    @Test
    void shouldNotSubmitWithWrongMobileNumber() {
        studentRegistrationFormPage
                .openPage(AUTOMATION_PRACTICE_FORM)
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .setGender(userGender)
                .typeUserMobileNumber(invalidUserMobileNumber)
                .submitForm()
                .resultsContainerShouldNotExist();
    }
}