package org.serenity.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import static org.apache.commons.beanutils.locale.LocaleConvertUtils.convert;

@DefaultUrl("https://www.olx.ua/account/")
public class OlxLoginPage extends AbstractPage {

    @FindBy(id = "userEmail")
    private WebElementFacade userName;

    @FindBy(id = "userPass")
    private WebElementFacade userPassword;

    @FindBy(xpath = "//*[@id='se_emailError']//*[@for='userPass']")
    private WebElementFacade passwordErrorMessage;

    @FindBy(xpath = "//*[@id='se_emailError']//*[@for='userEmail']")
    private WebElementFacade emailErrorMessage;

    @FindBy(id = "se_userLogin") // //*[contains(text(),'Войти')]
    private WebElementFacade loginButton;

    public void pressLoginButton() {
        loginButton.click();
    }

    public void enterUserName(String email) {
        userName.type(email);
    }

    public void enterUserPassword(String pass) {
        userPassword.type(pass);
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }
}