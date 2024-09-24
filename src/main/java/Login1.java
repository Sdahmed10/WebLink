
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class Login1 {

    private static final Logger log = LoggerFactory.getLogger(Login1.class);
    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Attendre 10 secondes maximum pour les éléments
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");  // l'URL de votre application
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testValidLogin() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        emailField.sendKeys("varoxe6978@kernuo.com");
        passwordField.sendKeys("12345Aa@");
        loginButton.click();
        Thread.sleep(2000);
        // Vérification si l'utilisateur est redirigé vers la page d'accueil ou un tableau de bord
        String expectedUrl = "https://devlinkfootweb.softylines.com/profile";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login successful and redirected to dashboard");
        WebElement logout = driver.findElement(By.xpath("//button[normalize-space()='Logout']"));
        log.info("Login successful: redirected to dashboard");
        logout.click();
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
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

