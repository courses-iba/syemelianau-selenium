package com.example.seleniumtestng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wildberries {
    public static String page_url = "https://www.wildberries.by/";
    public static String dir = System.getProperty("user.dir");
    public static String drv = "webdriver.chrome.driver";
    public static String drv_path = "\\chromedriver_win32\\chromedriver.exe";
    public static String checkbox_selector = "div[class='subject-filter-item__likecheckbox']";
    public static String cb_active_cls = "is-active";
    public static String search_str = "ковер";
    public static String cart_str = "Корзина";

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

    @FindBy(xpath = "//button[@class='btn btn--primary b-card__btn btn-basket']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//a[@href='/basket']")
    public WebElement cartBtn;

    @FindBy(xpath = "//a[@href='/basket']/span/span[contains(@class, 'user-menu__badge')]")
    public WebElement cartBadge;

    @FindBy(xpath = "//button[@class='quantity__delete is-show']")
    public WebElement removeBtn;

    @FindBy(xpath = "//div[@class='basket-list']")
    public WebElement basketList;

    public Wildberries(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
