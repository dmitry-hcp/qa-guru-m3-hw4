package qaguru.dmtr.ivnv.pages;

import com.codeborne.selenide.SelenideElement;
import qaguru.dmtr.ivnv.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    CalendarComponent calendarComponent =  new CalendarComponent();

    private final SelenideElement userFirstNameInput = $("#firstName");
    private final SelenideElement userLastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement userMobileNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement currentUserAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitButton = ($("#submit"));

    public StudentRegistrationFormPage openPage(String path) {
        open(path);

        return this;
    };

    public StudentRegistrationFormPage removeDemoQaObstructiveElements() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        return this;
    };

    public StudentRegistrationFormPage typeUserFirstName(String firstName) {
        userFirstNameInput.setValue(firstName);

        return this;
    };

    public StudentRegistrationFormPage typeUserLastName(String lastName) {
        userLastNameInput.setValue(lastName);

        return this;
    };

    public StudentRegistrationFormPage typeUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    };

    public StudentRegistrationFormPage setGender(String gender) {
        genderContainer.$(byText(gender)).click();

        return this;
    };

    public StudentRegistrationFormPage typeUserMobileNumber(String number) {
        userMobileNumberInput.setValue(number);

        return this;
    };

    public StudentRegistrationFormPage setBirthDay(int day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    };

    public StudentRegistrationFormPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();

        return this;
    };

    public StudentRegistrationFormPage setHobby(String hobby) {
        hobbiesContainer.$(byText(hobby)).click();

        return this;
    };

    public StudentRegistrationFormPage uploadPicture(String pictureFileName) {
        uploadPictureInput.uploadFromClasspath(pictureFileName);

        return this;
    };

    public StudentRegistrationFormPage typeCurrentAddress(String address) {
        currentUserAddressInput.setValue(address);

        return this;
    };

    public StudentRegistrationFormPage setState(String state) {
        stateSelect.click();
        stateCityContainer.$(byText(state)).click();

        return this;
    };

    public StudentRegistrationFormPage setCity(String city) {
        citySelect.click();
        stateCityContainer.$(byText(city)).click();
        return this;
    };

    public StudentRegistrationFormPage setStateAndCity(String stateName, String cityName) {
        setState(stateName);
        setCity(cityName);

        return this;
    };

    public StudentRegistrationFormPage submitForm() {
        submitButton.click();

        return this;
    };

}
