import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class loginfailedandpassed {

    static WebDriver driver;
    static String baseUrl;
    static Logger logger = Logger.getLogger(loginfailedandpassed.class.getName());

    @BeforeClass
    public static void setUp() {


        driver = new ChromeDriver();
        baseUrl = "https://devlinkfootweb.softylines.com/auth/jwt/login";
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginSuccess() {
        try {
            logger.info("Starting testLoginSuccess");


            // Locate and enter valid login information
            WebElement username = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Connecter']"));

            username.sendKeys("yihog59896@losvtn.com");
            password.sendKeys("12345Aa@");
            loginButton.click();

            // Verify if login is successful by checking the presence of an element specific to the homepage
            WebElement successMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='']")));
            Assert.assertTrue("Login successful - success message displayed", successMessage.isDisplayed());
            logger.info("testLoginSuccess completed successfully");
        } catch (Exception e) {
            logger.severe("Exception in testLoginSuccess: " + e.getMessage());
            Assert.fail("Exception in testLoginSuccess: " + e.getMessage());
        }
    }

    @Test
    public void testLoginFailure() {
        try {
            logger.info("Starting testLoginFailure");

            // Locate and enter invalid login information
            WebElement username = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Connecter']"));

            username.sendKeys("invalidUsername");
            password.sendKeys("1234487");
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            loginButton.click();

            // Verify if login failed by checking the presence of an error message
            WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error-message')]")));
            Assert.assertTrue("Login failed - error message displayed", errorMessage.isDisplayed());
            logger.info("testLoginFailure completed successfully");
        } catch (Exception e) {
            logger.severe("Exception in testLoginFailure: " + e.getMessage());
            Assert.fail("Exception in testLoginFailure: " + e.getMessage());
        }
    }


}
