import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions.*;

import java.sql.Driver;
import java.util.List;


public class WebFormsTest {
    WebDriver driver;

    @BeforeMethod
    public void open(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void WebFormsTest1(){
        driver.navigate().to("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Select dropdown = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        dropdown.selectByIndex(2);

        WebElement Checkbox;
        String RelativeXpath;

        for (int i =1;i<5;i++){
            RelativeXpath = "//input[@value='option-"+Integer.toString(i)+"']";
            Checkbox = driver.findElement(By.xpath(RelativeXpath));

            if (Checkbox.isSelected() == false){
                driver.findElement(By.xpath(RelativeXpath)).click();
            }
        }

        WebElement elem = driver.findElement(By.xpath("//option[@value='orange']"));
        System.out.println("Orange Disabled Value is "+elem.getAttribute("disabled"));


    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
    //ZM
}
