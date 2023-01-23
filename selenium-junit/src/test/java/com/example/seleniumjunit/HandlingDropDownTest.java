package com.example.seleniumjunit;

import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * class description
 */

public class HandlingDropDownTest {
    WebDriver driver;

    /**
     * Set up browser settings and open the application
     */

    @BeforeEach
    public void setUp() {
        String dir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        // Opened the application
        driver.get("file:\\\\\\" + dir + "\\src\\test\\java\\com\\example\\seleniumjunit\\DemoWebAlert.html");
        driver.manage().window().maximize();
    }

    /**
     * Test to select the dropdown values
     */

    @Test
    public void testSelectFunctionality() throws InterruptedException {

        // Go to google
        driver.findElement(By.linkText("Google")).click();

        // navigate back to previous webpage
        driver.navigate().back();
        Thread.sleep(5000);

        // select the first operator using "select by value"
        Select selectByValue = new Select(driver.findElement(By.id("SelectID_One")));
        selectByValue.selectByValue("greenvalue");
        Thread.sleep(5000);

        // select the second dropdown using "select by visible text"
        Select selectByVisibleText = new Select(driver.findElement(By.id("SelectID_Two")));
        selectByVisibleText.selectByVisibleText("Lime");
        Thread.sleep(5000);

        // select the third dropdown using "select by index"
        Select selectByIndex = new Select(driver.findElement(By.id("SelectID_Three")));
        selectByIndex.selectByIndex(2);
        Thread.sleep(5000);
    }

    /**
     * Tear down the setup after test completes
     */

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
