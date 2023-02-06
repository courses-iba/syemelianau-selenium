package com.example.seleniumjunit.wildberries;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WildberriesTest {
    private final String url = "https://www.wildberries.by/";
    private static final String current_dir = System.getProperty("user.dir");
    private static final String driver_name = "webdriver.chrome.driver";
    private static final String driver_path = "\\chromedriver_win32\\chromedriver.exe";

    private static WebDriver driver;

    private HomePage homePage;
    private CatalogPage catalogPage;
    private BasketPage basketPage;

    @BeforeAll
    public static void driverSetUp() {
        System.setProperty(driver_name, current_dir + driver_path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeEach
    public void setUp() {
        driver.get(url);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateAndCheck() {
        try {
            homePage = new HomePage(driver);
            catalogPage = new CatalogPage(driver);

            homePage.assertMenuItemsElementIsDisplayed(false);
            homePage.clickOnHamburgerButton();
            homePage.assertMenuItemsElementIsDisplayed(true);

            homePage.clickOnListElement();
            homePage.clickOnSublistElement();
            homePage.assertMenuItemsElementIsDisplayed(false);

            catalogPage.assertCheckboxIsActive(false);
            catalogPage.clickOnCheckbox();
            catalogPage.assertCheckboxIsActive(true);
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }

    @Test
    @Order(1)
    public void searchAndAddToCart() {
        try {
            final String searchQuery = "ковер";

            homePage = new HomePage(driver);
            catalogPage = new CatalogPage(driver);

            homePage.assertSearchIsDisplayed(true);
            homePage.waitSearchToLoad();
            homePage.enterSearchQuery(searchQuery);
            homePage.enterSearchQuery(Keys.ENTER);

            catalogPage.assertTitle(searchQuery);
            catalogPage.assertAddToCartButtonIsDisplayed(true);
            homePage.assertCartBadgeIsDisplayed(false);

            catalogPage.clickOnAddToCartButton();
            homePage.assertCartBadgeIsDisplayed(true);
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }

    @Test
    @Order(2)
    public void removeFromCart() {
        try {
            homePage = new HomePage(driver);
            basketPage = new BasketPage(driver);

            homePage.assertCartButtonIsDisplayed(true);
            homePage.clickOnCardButton();

            basketPage.assertTitle();
            basketPage.assertBasketListIsDisplayed(true);
            basketPage.assertRemoveButtonIsDisplayed(true);

            basketPage.clickOnRemoveButton();
            basketPage.assertBasketListIsDisplayed(false);
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }
}
