package org.serenity.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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


    public WebElementFacade getLoginButton() {
        return loginButton;
    }
    public WebElementFacade getUserName() {
        return userName;
    }
    public WebElementFacade getUserPassword() {
        return userPassword;
    }
    public WebElementFacade getPasswordErrorMessage() {
        return passwordErrorMessage;
    }
    public WebElementFacade getEmailErrorMessage() {
        return emailErrorMessage;
    }

}