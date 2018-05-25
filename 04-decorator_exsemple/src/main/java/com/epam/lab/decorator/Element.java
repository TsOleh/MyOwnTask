package com.epam.lab.decorator;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Element implements IElement {

    protected WebElement webElement;
    private String name;
    private Element element;
    List<IElement> element2;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void click() {
        System.out.println("Click on [" + name + "]");
        webElement.click();
    }

    public void textOfElementShouldBeEqualTo(String text) {
        Assert.assertEquals(getText(), text, "Text of element [" + name + "] does not match");
    }
    public void attributeValueShouldBeEqualTo(String actual,String expected) {
        Assert.assertEquals(getAttribute(actual), expected, "Text of element [" + name + "] does not match");

    }

    public void submit() {
        webElement.submit();
    }

    public void sendKeys(CharSequence... keysToSend) {
        System.out.println("Sending keys to [" + name + "] value [" + Arrays.toString(keysToSend) + "]");
        webElement.sendKeys(keysToSend);
    }

    public void clear() {
        webElement.clear();
    }

    public String getTagName() {
        return webElement.getTagName();
    }

    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

     public List<IElement> findElements(By by)
    {
        return (List)webElement.findElements(by);
    }

    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public Point getLocation() {
        return webElement.getLocation();
    }

    public Dimension getSize() {
        return webElement.getSize();
    }

    public Rectangle getRect() {
        return webElement.getRect();
    }

    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }
}
