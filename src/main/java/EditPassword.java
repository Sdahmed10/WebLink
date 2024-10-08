import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class EditPassword {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        driver = new ChromeDriver(options);
        //driver = new SafariDriver();
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }


    @Test(priority = 1)
    public void login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("taxip60889@rowplant.com");
        email.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345Aa@");
        password.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        login.click();
    }
    @Test(priority = 2)
    public void failedchangepassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Password']")).click();
        Thread.sleep(1000);
        WebElement oldPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oldPassword']")));
        typePasswordCharacterByCharacter(oldPassword, "123456Aa@");
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPassword']")));
        typePasswordCharacterByCharacter(newPassword, "624376143");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        typePasswordCharacterByCharacter(confirmPassword, "624376143");
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[@class=' error-message']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Doit contenir 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial (@, $, !, %, *, ?, &)");
            } else {
                System.out.println("Succes de changement de mot de passe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 3)
    public void failedchangepassword1() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Password']")).click();
        Thread.sleep(1000);
        WebElement oldPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oldPassword']")));
        typePasswordCharacterByCharacter(oldPassword, "123456Aa@");
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPassword']")));
        typePasswordCharacterByCharacter(newPassword, "12345Aa@");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        typePasswordCharacterByCharacter(confirmPassword, "624376143");
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        confirm.click();
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[@class=' error-message']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("The passwords must match");
            } else {
                System.out.println("Succes de changement de mot de passe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 4)
    public void failedchangepassword2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Password']")).click();
        Thread.sleep(1000);
        WebElement oldPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oldPassword']")));
        typePasswordCharacterByCharacter(oldPassword, "123456Aa@");
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPassword']")));
        typePasswordCharacterByCharacter(newPassword, "12345Aa@");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        typePasswordCharacterByCharacter(confirmPassword, "");
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        confirm.click();
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[@class=' error-message']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Password confirmation is required");
            } else {
                System.out.println("Succes de changement de mot de passe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 5)
    public void failedchangepassword3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Password']")).click();
        Thread.sleep(1000);
        WebElement oldPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oldPassword']")));
        typePasswordCharacterByCharacter(oldPassword, "123456Aa@");
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPassword']")));
        typePasswordCharacterByCharacter(newPassword, "");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        typePasswordCharacterByCharacter(confirmPassword, "12345Aa@");
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        confirm.click();
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[@class=' error-message']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("New password is required");
            } else {
                System.out.println("Succes de changement de mot de passe");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 6)
    public void Sucesschangepassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Password']")).click();
        Thread.sleep(1000);
        WebElement oldPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='oldPassword']")));
        typePasswordCharacterByCharacter(oldPassword, "123456Aa@");
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='newPassword']")));
        typePasswordCharacterByCharacter(newPassword, "12345Aa@");
        WebElement confirmPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='confirmPassword']")));
        typePasswordCharacterByCharacter(confirmPassword, "12345Aa@");
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        confirm.click();
        Thread.sleep(2000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Profile']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (success.isDisplayed()) {
                System.out.println("Succes de changement de mot de passe");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void typePasswordCharacterByCharacter(WebElement element, String password) throws InterruptedException {
        for (char c : password.toCharArray()) {
            element.sendKeys(Character.toString(c));
            Thread.sleep(100); // Vous pouvez ajuster la durée de la pause si nécessaire
        }
    }

    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        EditPassword EditPassword = new EditPassword();

        EditPassword.setUp();
        EditPassword.login();
        EditPassword.failedchangepassword();
        EditPassword.tearDown();

        EditPassword.setUp();
        EditPassword.login();
        EditPassword.failedchangepassword1();
        EditPassword.tearDown();

        EditPassword.setUp();
        EditPassword.login();
        EditPassword.failedchangepassword2();
        EditPassword.tearDown();

        EditPassword.setUp();
        EditPassword.login();
        EditPassword.failedchangepassword3();
        EditPassword.tearDown();

        EditPassword.setUp();
        EditPassword.login();
        EditPassword.Sucesschangepassword();
        EditPassword.tearDown();
    }
}
