package com.example.seleniumjunit;

import org.junit.jupiter.api.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * class description
 */

public class DemoWebAlertTest {
    WebDriver driver;

    /**
     * Constructor
     */
    public DemoWebAlertTest() {
    }

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
        driver.get("file:\\\\\\" + dir + "\\src\\test\\java\\com\\example\\seleniumjunit\\DemoWebPopup.htm");
        driver.manage().window().maximize();
    }

    /**
     * Test to check Select functionality
     */

    @Test
    public void testWebAlert() throws InterruptedException {
        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Thread.sleep(5000);

        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Thread.sleep(5000);

        // accepting javascript alert
        driver.switchTo().alert().dismiss();

        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        Thread.sleep(5000);

        // accepting javascript alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    /**
     * Tear down the setup after test completes
     */

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
