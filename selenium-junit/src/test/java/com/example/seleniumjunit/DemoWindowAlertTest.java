package com.example.seleniumjunit;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWindowAlertTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        String dir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://gmail.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testWindowAlert() throws Exception {

        // enter a valid email address
        driver.findElement(By.id("Email")).sendKeys("TestSelenium1607@gmail.com");

        // enter a valid password
        driver.findElement(By.id("Passwd")).sendKeys("TestSelenium");

        // click on sign in button
        driver.findElement(By.id("signIn")).click();
        Thread.sleep(30000);

        // click on compose button
        driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();

        // click on attach files icon
        driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();

        // creating instance of Robot class (A java based utility)
        Robot rb = new Robot();

        // pressing keys with the help of keyPress and keyRelease events
        rb.keyPress(KeyEvent.VK_D);
        rb.keyRelease(KeyEvent.VK_D);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SHIFT);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_P);
        rb.keyRelease(KeyEvent.VK_P);

        rb.keyPress(KeyEvent.VK_I);
        rb.keyRelease(KeyEvent.VK_I);

        rb.keyPress(KeyEvent.VK_C);
        rb.keyRelease(KeyEvent.VK_C);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
