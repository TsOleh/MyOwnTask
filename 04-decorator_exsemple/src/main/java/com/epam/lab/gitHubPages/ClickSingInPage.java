package com.epam.lab.gitHubPages;

import com.epam.lab.PageObject;
import com.epam.lab.decorator.Name;
import com.epam.lab.decorator.Element;
import org.openqa.selenium.support.FindBy;

public class ClickSingInPage extends PageObject {
    @Name("SignUp header")
    @FindBy(css = "a[href='/login']")
    private Element signIn;

    public void clickSingIn() {

        signIn.click();
    }
}
