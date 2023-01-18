import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String dir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + dir);

        System.setProperty("webdriver.chrome.driver", dir + "\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("gbwa")).click();
        driver.quit();

        System.out.println("Test script executed successfully.");
        System.exit(0);
    }
}
