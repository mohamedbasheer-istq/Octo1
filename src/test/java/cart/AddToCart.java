package cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCart {

    WebDriver driver;
    public final String url = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSWAG() throws Exception {
        driver.navigate().to(url);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(),"Remove");


    }

}
