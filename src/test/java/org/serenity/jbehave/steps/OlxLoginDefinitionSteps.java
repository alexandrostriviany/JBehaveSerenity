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

    @When("user confirm invalid <$login>")
    public void userConfirmInvalidEmail(final String email){
        olxUser.confirmInvalidLogin(email);
    }

    @When("user click 'Войти' button")
    public void userClickOnTheButton(){
        olxUser.userClickOnTheButton();
    }

    @Then("system shows error <$pass_error> under 'password' field")
    public void systemShowsPasswordError(final String pass_error) {
        olxUser.systemShowsPasswordError(pass_error);
    }

    @Then("system shows error <$email_error> under 'email' field")
    public void systemShowsEmailError(final String email_error) {
        olxUser.systemShowsEmailError(email_error);
    }

    @Then("system shows several error messages <$errors>")
    public void systemShowsSeveralErrorMessages(final String errors){
        olxUser.allErrorMessages(errors);
    }

}
