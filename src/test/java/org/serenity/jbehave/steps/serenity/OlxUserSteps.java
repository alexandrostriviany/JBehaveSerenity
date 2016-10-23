package org.serenity.jbehave.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.serenity.jbehave.pages.DictionaryPage;
import org.serenity.jbehave.pages.OlxLoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
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
        assertThat(olxLoginPage.getLoginErrorMessage(), equals(error_message));
    }
}