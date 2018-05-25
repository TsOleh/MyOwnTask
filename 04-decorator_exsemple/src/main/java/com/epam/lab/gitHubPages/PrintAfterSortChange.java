package com.epam.lab.gitHubPages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.IElement;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrintAfterSortChange extends PageObject {
    private static final Logger LOGGER = Logger.getLogger(PrintCountAndTitle.class.getName());
    @Name("List of founded titles")
    @FindBy(className ="pr-4")
    private List<IElement> allTitles;

    @Name("Count of founded titles")
    @FindBy(css =".pb-3 h3")
    private Element countElement;

    public void printTitleCount() {
        for (WebElement title : allTitles) {
            LOGGER.info(title.getText());
        }
        LOGGER.info("--- " + countElement.getText() + " ---\n");
    }
}
