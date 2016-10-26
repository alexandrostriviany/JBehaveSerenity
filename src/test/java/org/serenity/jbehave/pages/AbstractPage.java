package org.serenity.jbehave.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleksandr_Mosin on 10/25/2016.
 */
public abstract class AbstractPage extends PageObject{

    public void maximizeBrowser() {
        final WebDriver.Window browserWindow = getDriver().manage().window();
        browserWindow.maximize();
        Dimension actualDimension = browserWindow.getSize();
        final Integer actualHeight = actualDimension.getHeight();
        final Integer actualWidth = actualDimension.getWidth();
    }

    public void openLink(){
        maximizeBrowser();
        open();
    }
}
