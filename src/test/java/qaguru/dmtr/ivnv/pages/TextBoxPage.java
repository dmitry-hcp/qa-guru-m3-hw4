package qaguru.dmtr.ivnv.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static qaguru.dmtr.ivnv.config.Endpoints.*;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement userEmailInput = ($("#userEmail"));
    private final SelenideElement submitButton = ($("#submit"));
    private final SelenideElement outputResults = ($("#output"));

    public TextBoxPage openPage() {
        open(TEXT_BOX);
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        return this;
    }

    public TextBoxPage typeUserName(String userName) {
        userNameInput.setValue(userName);

        return this;
    }

    public TextBoxPage typeUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public TextBoxPage fieldShouldHaveValue(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }

    public TextBoxPage fieldShouldNotExist(String key) {
        outputResults.$(byId(key)).shouldNot(exist);

        return this;
    }
}
