package qaguru.dmtr.ivnv.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    private final SelenideElement resultsContainer = ($(".modal-dialog"));
    private final SelenideElement resultsContainerTitle = ($("#example-modal-sizes-title-lg"));
    private final SelenideElement resultsContainerTable = ($(".table-responsive"));

    public TableComponent resultsContainerShouldAppear() {
        resultsContainer.should(appear);

        return this;
    };

    public TableComponent resultsContainerShouldNotExist() {
        resultsContainer.shouldNot(exist);

        return this;
    };

    public TableComponent resultsContainerTitleShouldHave(String textValue) {
        resultsContainerTitle.shouldHave(text(textValue));

        return this;
    };

    public TableComponent resultsContainerTableRowShouldHave(String key, String value) {
        resultsContainerTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    };

    public TableComponent resultsContainerTableValueShouldBeEmpty(String key) {
        resultsContainerTable.$(byText(key)).parent().$$("td").get(1).shouldBe(empty);

        return this;
    };

    public TableComponent dateOfBirthShouldNotBeEmpty(String key) {
        resultsContainerTable.$(byText(key)).parent().$$("td").get(1).shouldNotBe(empty);

        return this;
    };
}
