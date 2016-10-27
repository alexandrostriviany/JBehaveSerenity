package org.serenity.jbehave.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://www.olx.ua/")
public class OlxPage extends AbstractPage {

    @FindBy(id = "headerSearch")
    private WebElementFacade headerSearch;

    @FindBy(id = "submit-searchmain")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@class='marginright5 link linkWithHash detailsLink'][1]")
    private WebElementFacade productsList;

    private String adsInd = "//*[@id='body-container']//*[@title='Объявление успешно оплачено']";

    public int getCountOfTopAds() {
        List<WebElementFacade> count = findAll(By.xpath(adsInd));
        return count.size();
    }

    public WebElementFacade getHeaderSearch() {
        return headerSearch;
    }

    public WebElementFacade getSearchButton() {
        return searchButton;
    }

    public WebElementFacade getProductsList() {
        return productsList;
    }

}