import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void shouldSubmitWithValidData() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $$("#genterWrapper").findBy(text(userGender)).click(); // клик по всему диву, наад подумать, как бы решить этот момент
        $("#userNumber").setValue(userMobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOption);
        $(".react-datepicker__year-select").selectOption(yearOption);
        $(".react-datepicker__day--018").click();
        $("#subjectsInput").setValue(subjectValue).pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFromClasspath(uploadPictureName);
        $("#currentAddress").setValue(userAddress);
        $("#react-select-3-input").setValue(stateOption).pressEnter();
        $("#react-select-4-input").setValue(cityOption).pressEnter();
        $("#submit").click();
        $$("tbody tr").findBy(text(studentNameKey)).shouldHave(text(expectedStudentName));
        $$("tbody tr").findBy(text(studentEmailKey)).shouldHave(text(userEmail));
        $$("tbody tr").findBy(text(studentGenderKey)).shouldHave(text(userGender));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("7479990002"));
        $$("tbody tr").findBy(text("Date of Birth")).shouldHave(text("18 July,2000"));
        $$("tbody tr").findBy(text("Subjects")).shouldHave(text("Maths"));
        $$("tbody tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("tbody tr").findBy(text("Picture")).shouldHave(text("client_rights_on_red.png"));
        $$("tbody tr").findBy(text("Address")).shouldHave(matchText("Проснись, John Doe.*, все спокойно,.*, что он сын волка"));
        $$("tbody tr").findBy(text("State and City")).shouldHave(text("Haryana Karnal"));
    }
    @Test
    void shouldSubmitWithValidRequiredFields() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
//        $("[id=userEmail]").setValue("some-male@example.com"); // test fail check
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7479990002");
        $("#submit").click();
//        System.out.println($$("tbody tr").texts());
        $$("tbody tr").findBy(text("Student Name")).shouldHave(text("John Doe"));
        $$("tbody tr").findBy(text("Student Email")).$("td", 1).shouldBe(empty);
        $$("tbody tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("tbody tr").findBy(text("Mobile")).shouldHave(text("7479990002"));
        $$("tbody tr").findBy(text("Date of Birth")).shouldNotBe(empty);
        $$("tbody tr").findBy(text("Subjects")).$("td", 1).shouldBe(empty);
        $$("tbody tr").findBy(text("Hobbies")).$("td", 1).shouldBe(empty);
        $$("tbody tr").findBy(text("Picture")).$("td", 1).shouldBe(empty);
        $$("tbody tr").findBy(text("Address")).$("td", 1).shouldBe(empty);
        $$("tbody tr").findBy(text("State and City")).$("td", 1).shouldBe(empty);
    }

    @Test
    void shouldNotSubmitWithoutFirstName() {
        open("/automation-practice-form");

        $("#lastName").setValue("Doe");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7479990002");
        $("#submit").click();
        $(".modal-content").shouldNot(exist);
        $("#firstName").shouldHave(attribute("required"));
        $("#firstName").shouldBe(empty);
    }

    @Test
    void shouldNotSubmitWithoutLastName() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("7479990002");
        $("#submit").click();
        $(".modal-content").shouldNot(exist);
        $("#lastName").shouldHave(attribute("required"));
        $("#lastName").shouldBe(empty);
    }

    @Test
    void shouldNotSubmitWithoutGender() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userNumber").setValue("7479990002");
        $("#submit").click();
//        System.out.println($("#gender-radio-1").getAttribute("checked"));
//        System.out.println($("#gender-radio-2").getAttribute("checked"));
//        System.out.println($("#gender-radio-3").getAttribute("checked"));
        $(".modal-content").shouldNot(exist);
        $("#gender-radio-1").shouldHave(attribute("required"));
        $("#gender-radio-2").shouldHave(attribute("required"));
        $("#gender-radio-3").shouldHave(attribute("required"));
        $("#gender-radio-1").shouldNot(selected);
        $("#gender-radio-2").shouldNot(selected);
        $("#gender-radio-3").shouldNot(selected);
    }

    @Test
    void shouldNotSubmitWithoutMobileNumber() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#gender-radio-1").click();
        $("#submit").click();
        $(".modal-content").shouldNot(exist);
        $("#userNumber").shouldHave(attribute("required"));
        $("#userNumber").shouldBe(empty);
//        System.out.println($("#userNumber").getAttribute("required"));
//        System.out.println($("#subjectsInput").getAttribute("required"));
    }

    @Test
    void shouldNotSubmitWithWrongMobileNumber() {
        open("/automation-practice-form");

        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("+774799900");
        $("#submit").click();
        $(".modal-content").shouldNot(exist);
        $("#userNumber").shouldHave(attribute("required"));
        $("#userNumber").shouldHave(value("+774799900"));
    }

    @Test
    void shouldSubmitSimpleFormSWithValidData() {
        open("/text-box");

        $("#userName").setValue("John Doe");
//        $("#currentAddress-wrapper #currentAddress").setValue("hjdjvb");
//        $("#permanentAddress-wrapper #permanentAddress").setValue("hjdjvb");
        $("#submit").click();
        $("#name").shouldHave(text("Name:John Doe"));
        $("#email").shouldNot(exist);
        $("#output #currentAddress").shouldNot(exist);
        $("#output #permanentAddress").shouldNot(exist);

    }

    @Test
    void shouldNotSubmitSimpleFormSWithWrongEmail() {
        open("/text-box");

        $("#userName").setValue("John Doe");
        $("#submit").click();
        $("#userName").setValue("Jane Doe");
        $("#userEmail").setValue("emailWitoutDomen");
        $("#submit").click();
        $("#name").shouldHave(text("Name:John Doe"));
        $("#email").shouldNot(exist);
        $("#output #currentAddress").shouldNot(exist);
        $("#output #permanentAddress").shouldNot(exist);

    }
}