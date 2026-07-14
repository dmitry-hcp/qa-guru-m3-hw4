package qaguru.dmtr.ivnv.testdata;

import net.datafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker fakerRu = new Faker(new Locale("ru"));
    Faker faker = new Faker();
    public String firstName = fakerRu.name().firstName();
    public String lastName = fakerRu.name().lastName();
    public String studentFullName = firstName + " " + lastName;
    public String validUserEmail = faker.internet().emailAddress();
    public String invalidUserEmail = firstName + lastName;
    public static String userGender = "Male";
    public String validUserMobileNumber = fakerRu.numerify("7#########");
    public static String invalidUserMobileNumber = "747999000";
//    public String birthMonth = faker.date().;
    public static String birthYear = "2000";
    public static String birthDay = "18";
    public static String fullDateOfBirth = birthDay + " " + birthMonth + "," + birthYear;
    public static String subjectValue = "Maths";
    public static String hobbyValue = "Sports";
    public static String pictureFileName = "clients_rights_is_always_true.jpeg";
    public static String userAddress = "110 Kunaev Street";
    public static String stateOption = "Haryana";
    public static String cityOption = "Karnal";
    public static String stateAndCityValue = stateOption + " " + cityOption;
}
