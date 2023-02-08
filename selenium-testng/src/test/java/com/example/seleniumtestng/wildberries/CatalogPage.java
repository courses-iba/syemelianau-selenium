package com.example.seleniumtestng.wildberries;

import com.example.seleniumtestng.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class CatalogPage {
    WebDriver driver;

    private final WebDriverWait wait;
    private final String active_class = "is-active";

    @FindBy(xpath = "//button[@class='btn btn--primary b-card__btn btn-basket']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'subject-filter-item__likecheckbox')]")
    public WebElement checkbox;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnCheckbox() {
        checkbox.click();
    }

    public void assertTitle(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void assertCheckboxIsActive(boolean isActive) {
        assertEquals(isActive, Tools.containsClass(checkbox, active_class));
    }

    public void assertAddToCartButtonIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, addToCartButton.isDisplayed());
    }
}
