package com.example.seleniumtestng;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WildberriesTest {
    private static WebDriver driver;
    private static Wildberries wildberries;

    @BeforeClass
    public static void driverSetUp() {
        System.setProperty(Wildberries.drv, Wildberries.dir + Wildberries.drv_path);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wildberries = new Wildberries(driver);
    }

    @BeforeMethod
    public void setUp() {
        driver.get(Wildberries.page_url);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateAndCheck() {
        try {
            assertFalse(wildberries.menuItemsElement.isDisplayed());
            wildberries.hamburgerButton.click();
            assertTrue(wildberries.menuItemsElement.isDisplayed());

            wildberries.listElement.click();
            wildberries.sublistElement.click();
            assertFalse(wildberries.menuItemsElement.isDisplayed());

            WebElement checkbox = driver.findElement(By.cssSelector(Wildberries.checkbox_selector));
            assertFalse(Tools.containsClass(checkbox, Wildberries.cb_active_cls));
            checkbox.click();
            assertTrue(Tools.containsClass(checkbox, Wildberries.cb_active_cls));
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }

    @Test(priority = 1)
    public void searchAndAddToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            assertTrue(wildberries.search.isDisplayed());
            wait.until(ExpectedConditions.attributeToBe(wildberries.search, "placeholder", Wildberries.search_placeholder));
            wildberries.search.sendKeys(Wildberries.search_str);
            wildberries.search.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.titleIs(Wildberries.search_str));
            assertTrue(wildberries.addToCartBtn.isDisplayed());
            assertFalse(wildberries.cartBadge.isDisplayed());

            wildberries.addToCartBtn.click();
            assertTrue(wildberries.cartBadge.isDisplayed());
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }

    @Test(priority = 2)
    public void removeFromCart() {
        try {
            assertTrue(wildberries.cartBtn.isDisplayed());
            wildberries.cartBtn.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleIs(Wildberries.cart_str));

            assertTrue(wildberries.basketList.isDisplayed());
            assertTrue(wildberries.removeBtn.isDisplayed());

            wildberries.removeBtn.click();

            assertFalse(wildberries.basketList.isDisplayed());
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid\n" + e);
            throw e;
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element\n" + e);
            throw e;
        }
    }
}
