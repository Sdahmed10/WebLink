
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Login1 {

    private static final Logger log = LoggerFactory.getLogger(Login1.class);
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Attendre 10 secondes maximum pour les éléments
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    private void takeScreenshot(String stepName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = "Login1/" + stepName + "_" + timestamp + ".png";
        try {
            Files.createDirectories(Paths.get("Login1"));
            Files.copy(screenshot.toPath(), Paths.get(filename));
            System.out.println("Screenshot taken: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys("spontaneous.tuna.dpai@flashpost.net");
        passwordField.sendKeys("12345Aa@");
        loginButton.click();
        Thread.sleep(5000);
        takeScreenshot("testValidLogin");
        // Vérification si l'utilisateur est redirigé vers la page d'accueil ou un tableau de bord
        String expectedUrl = "https://devlinkfootweb.softylines.com/profile";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login successful and redirected to dashboard");
        WebElement logout = driver.findElement(By.xpath("//button[normalize-space()='Logout']"));
        log.info("Login successful: redirected to dashboard");
        logout.click();
        Thread.sleep(2000);
        takeScreenshot("Logout success");
    }

    @Test(priority = 2)
    public void testInvalidLogin() throws InterruptedException {
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys("invalid@example.com");
        passwordField.sendKeys("12345Aa@");
        loginButton.click();
        Thread.sleep(2000);
        // Vérification du message d'erreur pour login incorrect
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='login-error-message error-message']"));
        Assert.assertTrue(errorMessage.isDisplayed(), "User not registered or not verified");
        log.info("Invalid login attempt: error message displayed");

        Thread.sleep(2000);
        takeScreenshot("testInvalidLogin");
    }

    @Test(priority = 3)
    public void testEmptyEmailAndPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys(Keys.chord(Keys.META, "a"));
        emailField.sendKeys(Keys.BACK_SPACE);
        emailField.sendKeys("");
        passwordField.sendKeys(Keys.chord(Keys.META, "a"));
        passwordField.sendKeys(Keys.BACK_SPACE);
        passwordField.sendKeys("");
        loginButton.click();
        Thread.sleep(2000);
        // Vérification des messages d'erreur pour les champs vides
        WebElement emailError = driver.findElement(By.xpath("//p[normalize-space()='E-mail is required']"));
        WebElement passwordError = driver.findElement(By.xpath("//p[normalize-space()='Password is required']"));
        Assert.assertTrue(emailError.isDisplayed(), "Email is required");
        Assert.assertTrue(passwordError.isDisplayed(), "Password is required");
        log.info("Empty email and password: error messages displayed");

        Thread.sleep(2000);
        takeScreenshot("testEmptyEmailAndPassword");

    }

    @Test(priority = 4)
    public void testEmptyEmail() throws InterruptedException {
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys("");
        passwordField.sendKeys("12345Aa@");
        loginButton.click();
        Thread.sleep(2000);
        // Vérification du message d'erreur pour email vide
        WebElement emailError = driver.findElement(By.xpath("//p[normalize-space()='E-mail is required']"));
        Assert.assertTrue(emailError.isDisplayed(), "Email is required");
        log.info("Empty email: error message displayed");

        Thread.sleep(2000);
        takeScreenshot("testEmptyEmail");
    }

    @Test(priority = 5)
    public void testEmptyPassword() throws InterruptedException {
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys("koyog72467@calunia.com");
        passwordField.sendKeys(Keys.chord(Keys.META, "a"));
        passwordField.sendKeys(Keys.BACK_SPACE);
        passwordField.sendKeys("");
        loginButton.click();
        Thread.sleep(2000);
        // Vérification du message d'erreur pour mot de passe vide
        WebElement passwordError = driver.findElement(By.xpath("//p[normalize-space()='Password is required']"));
        Assert.assertTrue(passwordError.isDisplayed(), "Password is required");
        log.info("Empty password: error message displayed");

        Thread.sleep(2000);
        takeScreenshot("testEmptyPassword");
    }


    public static void main(String[] args) throws InterruptedException {
        Login1 login = new Login1();
        login.setUp();
        login.testValidLogin();
        login.tearDown();

        login.setUp();
        login.testInvalidLogin();
        login.tearDown();

        login.setUp();
        login.testEmptyEmailAndPassword();
        login.tearDown();

        login.setUp();
        login.testEmptyEmail();
        login.tearDown();

        login.setUp();
        login.testEmptyPassword();
        login.tearDown();



    }
    @AfterClass
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}

