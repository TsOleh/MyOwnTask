package com.epam.lab.gitHubPages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.IElement;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.Element;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PrintCountAndTitle extends PageObject {
    private static final Logger LOGGER = Logger.getLogger(PrintCountAndTitle.class.getName());

    int count;
    @Name("List of founded titles")
    @FindBy(className ="pr-4")
    private  List<IElement> allTitles;

    @Name("Count of founded titles")
    @FindBy(css =".pb-3 h3")
    private Element countElement;

    @Name("Sort button")
    @FindBy(className = "js-menu-target")
    private Element sortButton;

    @Name("select-menu-item-text")
    @FindBy(xpath = "//*[.='Most forks']")
    private Element changeSort;

    public int runAllMethods(){
        printTitleCount();
        checkForTagSelenium();
        sortButton.click();
        changeSort.click();
        return count;
    }
    public void printTitleCount() {
        for (WebElement title : allTitles) {
            LOGGER.info(title.getText());
        }
        LOGGER.info("--- " + countElement.getText() + " ---\n");
    }
    public void checkForTagSelenium() {
        for (WebElement element : allTitles) {
            if(element.findElements(By.xpath("//*[.='selenium']")).size()>0){
                count++;
            }
        }
    }
}
