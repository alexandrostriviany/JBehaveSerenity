package org.serenity.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.serenity.jbehave.steps.serenity.OlxUserSteps;

public class OlxLoginDefinitionSteps {

    @Steps
    OlxUserSteps olxUser;

    @Given("user is on the OLX login page")
    public void userIsOnTheOLXLoginPage() {
       olxUser.onTheOLXLoginPage();
    }

    @When("user confirm invalid <$login> and <$password>")
    public void userConfirmInvalidLoginAndPassword(final String login, final String password) {
        olxUser.confirmInvalidLoginAndPassword(login,password);
    }

    @Then("system shows error <$error_message>")
    public void systemShowsError(final String error_message) {
        olxUser.systemShowsError(error_message);
    }

}
