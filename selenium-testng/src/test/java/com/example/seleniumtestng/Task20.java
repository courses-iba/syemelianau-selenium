package com.example.seleniumtestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.wildberries.by/
public class Task20 {
    @FindBy(xpath = "//button[@class='header__hamburger' and @data-place='ariaLabel']")
    public WebElement hamburgerButton;

    @FindBy(xpath = "//li[@data-ind='4']")
    public WebElement listElement;

    @FindBy(xpath = "//li[@data-ind='9']")
    public WebElement sublistElement;

    @FindBy(xpath = "//ul[@class='menu__items']")
    public WebElement menuItemsElement;

    public Task20(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
