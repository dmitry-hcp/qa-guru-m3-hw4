package qaguru.dmtr.ivnv.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private SelenideElement dayOption(int day) {
        return $(".react-datepicker__day--" + String.format("%03d", day) + ":not(.react-datepicker__day--outside-month)");
    };

    public void setDate(int day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        dayOption(day).click();
    }
};
