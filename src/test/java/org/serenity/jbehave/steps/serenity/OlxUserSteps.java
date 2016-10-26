package org.serenity.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.jruby.ext.ffi.Type;
import org.jruby.ir.operands.Array;
import org.serenity.jbehave.pages.OlxLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OlxUserSteps extends AbstractSteps {

    OlxLoginPage olxLoginPage;
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
        int counter = 0;
        String[] expMess = messages.split(",");
        String[] actMess = (olxLoginPage.getEmailErrorMessage().getText() + ","
                + olxLoginPage.getPasswordErrorMessage().getText()).split(",");
        if (expMess.length == actMess.length) {
            for (String message : expMess) {
                int i = 0;
                if (message.equals(actMess[i])) {
                    counter++;
                }
            }
        }
        assertThat(counter).as("Equals not all messages").isEqualTo(actMess.length);
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
}