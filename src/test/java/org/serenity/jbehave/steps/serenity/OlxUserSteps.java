package org.serenity.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.hamcrest.MatcherAssert;
import org.jruby.ext.ffi.Type;
import org.jruby.ir.operands.Array;
import org.serenity.jbehave.pages.OlxLoginPage;
import org.serenity.jbehave.pages.OlxPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class OlxUserSteps extends AbstractSteps {

    OlxLoginPage olxLoginPage;

    OlxPage olxPage;

    private final String MESSAGE_IS_NOT_MATCHED = "Error message not matched";

    @Step
    public void confirmTheForm() {
        olxLoginPage.getLoginButton().click();
    }

    @Step
    public void openLoginPage() {
        olxLoginPage.openLink();
    }

    @Step
    public void enterEmail(final String email) {
        olxLoginPage.getUserName().type(email);
    }

    @Step
    public void enterPassword(final String pass) {
        olxLoginPage.getUserPassword().type(pass);
    }

    @Step
    public void confirmInvalidLoginAndPassword(final String login, final String password) {
        enterEmail(login);
        enterPassword(password);
        confirmTheForm();
    }

    @Step
    public void systemShowsPasswordError(final String error_message) {
        assertThat(olxLoginPage.getPasswordErrorMessage().getText()).as(MESSAGE_IS_NOT_MATCHED)
                .isEqualTo(error_message);
    }

    @Step
    public void allErrorMessages(final String messages) {
        List<String> actualMessages = new ArrayList<>();
        actualMessages.add(olxLoginPage.getEmailErrorMessage().getText());
        actualMessages.add(olxLoginPage.getPasswordErrorMessage().getText());
        List<String> expectedMessages = Arrays.asList(messages.split(","));
        Collections.sort(actualMessages);
        Collections.sort(expectedMessages);
        assertThat(actualMessages).as("Equals not all messages").isEqualTo(expectedMessages);
    }

    @Step
    public void systemShowsEmailError(final String error_message) {
        assertThat(olxLoginPage.getEmailErrorMessage().getText()).as(MESSAGE_IS_NOT_MATCHED).isEqualTo(error_message);
    }

    @Step
    public void confirmInvalidLogin(final String email) {
        enterEmail(email);
        confirmTheForm();
    }

    @Step
    public void openHomePage() {
        olxPage.openLink();
    }

    @Step
    public void userSearchProductByName(final String searchWord) {
        olxPage.getHeaderSearch().type(searchWord);
        olxPage.getSearchButton().click();
    }

    @Step
    public void systemsResponceContainsTheSearchWord(final String searchWord) {
        assertThat(olxPage.getProductsList().getText().replace(",", "").toLowerCase()).contains(searchWord);
    }


}
