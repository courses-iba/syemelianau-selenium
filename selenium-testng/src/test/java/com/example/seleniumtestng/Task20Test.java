package com.example.seleniumtestng;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.*;

import java.time.Duration;

public class Task20Test {
    private WebDriver driver;
    private Task20 wildberries;

    @BeforeMethod
    public void setUp() {
        String dir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wildberries.by/");

        wildberries = new Task20(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateAndCheck() throws InterruptedException {
        Thread.sleep(2000);

        assertFalse(wildberries.menuItemsElement.isDisplayed());
        wildberries.hamburgerButton.click();
        assertTrue(wildberries.menuItemsElement.isDisplayed());

        try {
            wildberries.listElement.click();
            wildberries.sublistElement.click();
        } catch (InvalidSelectorException e) {
            System.out.println("Selector is incorrect or syntactically invalid");
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the list element");
        }


        try {
            WebElement checkbox = driver.findElement(By.cssSelector("div[class='subject-filter-item__likecheckbox']"));
            checkbox.click();
        } catch (NoSuchElementException e) {
            System.out.println("WebDriver couldn't locate the element");
        }

        Thread.sleep(2000);
    }
}
