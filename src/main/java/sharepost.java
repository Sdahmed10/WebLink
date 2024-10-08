import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class sharepost {
    private WebDriver driver;
    private WebDriverWait wait;

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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }

    public void login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("neyad39254@paxnw.com");
        email.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345Aa@");
        password.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        login.click();
    }

    public void successsharepost() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Community']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Share post']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Suivant']")).click();
        Thread.sleep(1000);
        WebElement upload = driver.findElement(By.id("upload-photo"));
        Thread.sleep(500);
        upload.sendKeys("/Users/takiacademy/Desktop/zlatan-ibrahimovic-zlatan.gif");
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(2000);
        checkSuccessMessage();
    }
    public void failedsharepost() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Community']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Share post']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Suivant']")).click();
        Thread.sleep(1000);
        WebElement upload = driver.findElement(By.id("upload-photo"));
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(1000);
        checkSuccessMessage();
    }

    private void checkSuccessMessage() {
        try {
            WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Post has been created successfully']")));
            if (success.isDisplayed()) {
                System.out.println("post shared successfully");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            System.out.println("Failed"); // Message when the element is not found
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sharepost sharepost = new sharepost();

        sharepost.setUp();
        sharepost.login();
        sharepost.successsharepost();

        sharepost.setUp();
        sharepost.login();
        sharepost.failedsharepost();

    }
}
