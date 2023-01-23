package com.example.seleniumjunit;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitDemonstrationTest {

    // created reference variable for WebDriver
    WebDriver drv;

    @BeforeEach
    public void setup() throws InterruptedException {
        String dir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + dir);
        System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_win32\\chromedriver.exe");

        // initializing drv variable using FirefoxDriver
        drv = new ChromeDriver();
        // launching gmail.com on the browser
        drv.get("https://gmail.com");
        // maximized the browser window
        drv.manage().window().maximize();
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws InterruptedException {

        // saving the GUI element reference into a "username" variable of WebElement type
        WebElement username = drv.findElement(By.id("Email"));

        // entering username
        username.sendKeys("shruti.shrivastava.in");

        // entering password
        drv.findElement(By.id("Passwd")).sendKeys("password");

        // clicking signin button
        drv.findElement(By.id("signIn")).click();

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(drv, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
        // click on the compose button as soon as the "compose" button is visible
        drv.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
    }

    @AfterEach
    public void teardown() {
        // closes all the browser windows opened by web driver
        drv.quit();
    }
}
