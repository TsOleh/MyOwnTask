package com.epam.lab.decorator;

import org.openqa.selenium.WebElement;

public interface IElement extends WebElement {
     void setName(String name);
     void textOfElementShouldBeEqualTo(String text) ;
     void attributeValueShouldBeEqualTo(String actual,String expected);
}
