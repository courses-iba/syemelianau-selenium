package com.example.seleniumtestng.wildberries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BasketPage {
    WebDriver driver;

    private final WebDriverWait wait;
    private final String title = "Корзина";

    @FindBy(xpath = "//button[@class='quantity__delete is-show']")
    public WebElement removeButton;

    @FindBy(xpath = "//div[@class='basket-list']")
    public WebElement basketList;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickOnRemoveButton() {
        removeButton.click();
    }

    public void assertTitle() {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void assertRemoveButtonIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, removeButton.isDisplayed());
    }

    public void assertBasketListIsDisplayed(boolean isDisplayed) {
        assertEquals(isDisplayed, basketList.isDisplayed());
    }
}
