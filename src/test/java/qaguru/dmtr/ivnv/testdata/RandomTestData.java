package qaguru.dmtr.ivnv.testdata;

import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;



public class RandomTestData {
    Faker fakerRu = new Faker(new Locale("ru"));
    Faker faker = new Faker();

    public String firstName = fakerRu.name().firstName();
    public String lastName = fakerRu.name().lastName();
    public String studentFullName = firstName + " " + lastName;
    public String validUserEmail = faker.internet().emailAddress();
    public String invalidUserEmail = firstName + lastName;
    public String userGender = faker.options().option("Male", "Female", "Other");
    public String validUserMobileNumber = fakerRu.phoneNumber().subscriberNumber(10);
    public String invalidUserMobileNumber = fakerRu.phoneNumber().subscriberNumber(9);
    public String hobbyValue = faker.options().option("Sports", "Reading", "Music");
    public String userAddress = fakerRu.address().fullAddress();

    private final int maxAge = Period.between(LocalDate.of(1900, 1, 1), LocalDate.now()).getYears();
    private final LocalDate generatedBirthdate = faker.timeAndDate().birthday(16, maxAge);
    public String birthMonth = generatedBirthdate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    public String birthYear = String.valueOf(generatedBirthdate.getYear());
    public int birthDay = generatedBirthdate.getDayOfMonth();
    public String fullDateOfBirth = birthDay + " " + birthMonth + "," + birthYear;

    private final String[] subjects = {
            "Accounting",
            "Arts",
            "Biology",
            "Chemistry",
            "Civics",
            "Commerce",
            "Computer Science",
            "Economics",
            "English",
            "Hindi",
            "History",
            "Maths",
            "Physics",
            "Social Studies"
    };
    public String subjectValue = faker.options().option(subjects);

    private final String[] pictures = {
            "clients_rights_is_always_true.jpeg",
            "client_rights_on_red copy-1.png",
            "client_rights_on_red copy-2.png",
            "client_rights_on_red copy-3.png",
            "client_rights_on_red copy-4.png",
    };
    public String pictureFileName = faker.options().option(pictures);

    private final String[] states = {
            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"};
    public String stateOption = faker.options().option(states);

    private final String cityOptionNCR = faker.options().option("Delhi", "Gurgaon", "Noida");
    private final String cityOptionUttarPradesh = faker.options().option("Agra", "Lucknow", "Merrut");
    private final String cityOptionHaryana = faker.options().option("Karnal", "Panipat");
    private final String cityOptionRajasthan = faker.options().option("Jaipur", "Jaiselmer");

    private String selectCity (String state) {
        return switch (state) {
            case "NCR" -> cityOptionNCR;
            case "Uttar Pradesh" -> cityOptionUttarPradesh;
            case "Haryana" -> cityOptionHaryana;
            case "Rajasthan" -> cityOptionRajasthan;
            default ->  throw new AssertionError("Unexpected state: " + state);
        };
    };

    public String cityOption = selectCity(stateOption);


    public String stateAndCityValue = stateOption + " " + cityOption;
}
