package org.serenity.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.serenity.jbehave.pages.OlxLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OlxUserSteps extends AbstractSteps {

    OlxLoginPage olxLoginPage;
    private final String MESSAGE_IS_NOT_MATCHED = "Error message not matched";

    @Step
    public void userClickOnTheButton(){
        olxLoginPage.pressLoginButton();
    }

    @Step
    public void onOlxLoginPage() {
        olxLoginPage.openLink();
    }

    @Step
    public void confirmInvalidLoginAndPassword(final String login, final String password) {
        olxLoginPage.enterUserName(login);
        olxLoginPage.enterUserPassword(password);
        olxLoginPage.pressLoginButton();
    }

    @Step
    public void systemShowsPasswordError(final String error_message) {
        assertThat(olxLoginPage.getPasswordErrorMessage()).as(MESSAGE_IS_NOT_MATCHED).isEqualTo(error_message);
    }

    @Step
    public void allErrorMessages(final String messages) {
        int counter = 0;
        String[] expMess = messages.split(",");
        String[] actMess = (olxLoginPage.getEmailErrorMessage() + "," + olxLoginPage.getPasswordErrorMessage())
                .split(",");
        if (expMess.length == actMess.length) {
            for (String message : expMess) {
                int i = 0;
                if (message.equals(actMess[i])) {
                    counter++;
                }
            }
        }
        assertThat(expMess.equals(actMess));
        assertThat(counter).as("Equals not all messages").isEqualTo(actMess.length);
    }

    @Step
    public void systemShowsEmailError(final String error_message) {
        assertThat(olxLoginPage.getEmailErrorMessage()).as(MESSAGE_IS_NOT_MATCHED).isEqualTo(error_message);
    }

    @Step
    public void confirmInvalidLogin(final String email) {
        olxLoginPage.enterUserName(email);
        olxLoginPage.pressLoginButton();
    }
}