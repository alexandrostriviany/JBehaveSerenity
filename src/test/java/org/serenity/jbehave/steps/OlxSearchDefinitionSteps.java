package org.serenity.jbehave.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.serenity.jbehave.steps.serenity.OlxUserSteps;

/**
 * Created by BDSM on 26.10.2016.
 */
public class OlxSearchDefinitionSteps {
    @Steps
    OlxUserSteps olxUser;

    @Given ("user on the OLX home page")
    public void userOnTheOlxHomePage(){
        olxUser.openHomePage();
    }

    @When("user search product by name $searchName")
    public void userSearchProductByName(final String searchName){
        olxUser.userSearchProductByName(searchName);
    }

    @Then("system's responce contains the search word $searchName")
    public void systemsResponceContainsTheSearchWord(final String searchName){
        olxUser.systemsResponceContainsTheSearchWord(searchName);
    }
}
