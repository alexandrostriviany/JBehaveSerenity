package org.serenity.jbehave.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.olx.ua/")
public class OlxPage extends AbstractPage {

    @FindBy(id = "headerSearch")
    private WebElementFacade headerSearch;

    @FindBy(id = "submit-searchmain")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//*[@class='marginright5 link linkWithHash detailsLink'][1]")
    private WebElementFacade productsList;

    private final String topAdsInd =
            "//*[@id='body-container']//*[@title='Объявление успешно оплачено']";

    private final String normalAdTitle =
            ".//*[@id='offers_table']//*[@class = 'marginright5 link linkWithHash detailsLink']/strong";

    public int getCountOfTopAds() {
        List<WebElementFacade> count = findAll(By.xpath(topAdsInd));
        return count.size();
    }

    public List<WebElementFacade> getNormalAdsTitle() {
        List<WebElementFacade> titles = findAll(normalAdTitle);
        titles.get(1).getText();
        return titles;
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