package com.epam.lab;

import com.epam.lab.gitHubPages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DecoratorTest {

    @AfterMethod
    public void closeDriver() {
        WebDriverUtils.close();
    }

    @Test
    //@Parameters({"gitLogin","gitPassword"})
    public void testDecorator(){
        WebDriverUtils.load("https://github.com");
        final ClickSingInPage singInPage = new ClickSingInPage();
        singInPage.clickSingIn();

        final LogGitHubPage login = new LogGitHubPage();
        login.putLoginPassword("Poltor22","hdyR567Rdeq");

        final SearchSeleniumJavaPage search = new SearchSeleniumJavaPage();
        search.textOfHeader("@Poltor22");
        search.searchValue("selenium java");

        final PrintCountAndTitle countAndTitle = new PrintCountAndTitle();
        Assert.assertEquals(countAndTitle.runAllMethods(),10);

        final ChangeSortItemPage changeSearch = new ChangeSortItemPage();
        changeSearch.printTitleCount();
        changeSearch.searchValue("annotation");

        final PrintAfterSortChange afterSortChange = new PrintAfterSortChange();
        afterSortChange.printTitleCount();
    }
}
