package org.serenity.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

import static org.apache.commons.beanutils.locale.LocaleConvertUtils.convert;

@DefaultUrl("https://www.olx.ua/account/")
public class OlxLoginPage extends PageObject {

    @FindBy(id = "userEmail")
    private WebElementFacade userName;

    @FindBy(id = "userPass")
    private WebElementFacade userPassword;

    @FindBy(id = "se_emailError")
    private WebElementFacade loginErrorMessage;

    @FindBy(id = "se_userLogin")
    private WebElementFacade loginButton;

    public void pressLoginButton(){
        loginButton.click();
    }

    public void enterUserName(String email) {
        userName.type(email);
    }

    public void enterUserPassword(String pass) {
        userPassword.type(pass);
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getAttribute("error");
    }
}