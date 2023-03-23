import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {
    WebDriver driver;

    @BeforeMethod
    public void open(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void WaitsTest1(){
        driver.navigate().to("https://demoqa.com/progress-bar");
        driver.findElement(By.id("startStopButton")).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.attributeToBe(driver.findElement(By.xpath("//div[@role='progressbar']")),"aria-valuenow","50"));



    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    //ZM
}
