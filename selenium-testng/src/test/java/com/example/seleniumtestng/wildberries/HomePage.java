package com.example.seleniumtestng.wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class HomePage {
    WebDriver driver;

    private final WebDriverWait wait;
    private final String search_placeholder = "Я ищу...";

    @FindBy(xpath = "//button[@class='header__hamburger' and @data-place='ariaLabel']")
    public WebElement hamburgerButton;

    @FindBy(xpath = "//li[@data-ind='4']")
    public WebElement listElement;

    @FindBy(xpath = "//li[@data-ind='9']")
    public WebElement sublistElement;

    @FindBy(xpath = "//ul[@class='menu__items']")
    public WebElement menuItemsElement;

    @FindBy(id = "search-input")
    public WebElement search;

    @FindBy(xpath = "//a[@href='/basket']")
    public WebElement cartButton;

    @FindBy(xpath = "//a[@href='/basket']/span/span[contains(@class, 'user-menu__badge')]")
    public WebElement cartBadge;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnHamburgerButton() {
        hamburgerButton.click();
    }

    public void clickOnListElement() {
        listElement.click();
    }

    public void clickOnSublistElement() {
        sublistElement.click();
    }

    public void clickOnCardButton() {
        cartButton.click();
    }

    public void enterSearchQuery(CharSequence searchQuery) {
        search.sendKeys(searchQuery);
    }

    public void waitSearchToLoad() {
        wait.until(ExpectedConditions.attributeToBe(search, "placeholder", search_placeholder));
    }

    public void assertMenuItemsElementIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, menuItemsElement.isDisplayed());
    }

    public void assertSearchIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, search.isDisplayed());
    }

    public void assertCartBadgeIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, cartBadge.isDisplayed());
    }

    public void assertCartButtonIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, cartButton.isDisplayed());
    }
}
