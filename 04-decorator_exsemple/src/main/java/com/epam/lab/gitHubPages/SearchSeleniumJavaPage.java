package com.epam.lab.gitHubPages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.Element;
import org.openqa.selenium.support.FindBy;

public class SearchSeleniumJavaPage extends PageObject {
    @Name("Search or jump to…")
    @FindBy(className = "js-site-search-focus")
    private Element search ;

    @Name("Check validity page")
    @FindBy(xpath = "//img[@alt='@Poltor22']")
    private Element signUpHeader;


    public void textOfHeader(String text) {
        signUpHeader.attributeValueShouldBeEqualTo("alt", text);
    }
    public void searchValue(String value ) {
        search.sendKeys(value);
        search.submit();
    }

}
