package org.serenity.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.serenity.jbehave.pages.OlxLoginPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class OlxUserSteps extends ScenarioSteps {

    OlxLoginPage olxLoginPage;

    @Step
    public void onTheOLXLoginPage() {
        olxLoginPage.open();
    }

    @Step
    public void confirmInvalidLoginAndPassword(final String login, final String password) {
        olxLoginPage.enterUserName(login);
        olxLoginPage.enterUserPassword(password);
        olxLoginPage.pressLoginButton();
    }

    @Step
    public void systemShowsError(final String error_message) {
        assertThat(olxLoginPage.getPasswordErrorMessage()).as("Message"," is not matched ").isEqualTo(error_message);
    }
}