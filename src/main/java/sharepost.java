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
        //Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }


    public void login() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("neyad39254@paxnw.com");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("12345Aa@");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        loginButton.click();
    }

    public void successsharepost() {
        // Naviguer vers la communauté
        WebElement communityLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Community']")));
        communityLink.click();

        // Cliquer sur "Share post"
        WebElement sharePostButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Share post']")));
        sharePostButton.click();

        // Suivant
        WebElement suivantButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Suivant']")));
        suivantButton.click();

        // Upload photo
        WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("upload-photo")));
        upload.sendKeys("/Users/takiacademy/Desktop/zlatan-ibrahimovic-zlatan.gif");

        // Suivant après l'upload
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")));
        nextButton.click();

        checkSuccessMessage();
    }

    public void failedsharepost() {
        WebElement communityLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Community']")));
        communityLink.click();

        WebElement sharePostButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Share post']")));
        sharePostButton.click();

        WebElement suivantButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Suivant']")));
        suivantButton.click();

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")));
        nextButton.click();

        checkSuccessMessage();
    }

    private void checkSuccessMessage() {
        try {
            WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Post has been created successfully']")));
            if (success.isDisplayed()) {
                System.out.println("Post shared successfully");
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            System.out.println("Failed");
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        sharepost sharepost = new sharepost();

        sharepost.setUp();
        sharepost.login();
        sharepost.successsharepost();
        sharepost.tearDown(); // Ferme le navigateur après successsharepost

        sharepost.setUp();
        sharepost.login();
        sharepost.failedsharepost();
        sharepost.tearDown(); // Ferme le navigateur après successsharepost
    }
}
