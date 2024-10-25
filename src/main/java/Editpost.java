import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Editpost {
    private WebDriver driver;
    private WebDriverWait wait ;

    @BeforeClass
    public void Setup(){
        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    @Test(priority = 1)
    public void login(){
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        email.sendKeys("neyad39254@paxnw.com");
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        password.sendKeys("12345Aa@");
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"light\"]/div/div/form/button")));
        login.click();
    }

    @Test(priority = 2)
    public void edit() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-label='ellipsis']//*[name()='svg']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='anticon anticon-ellipsis ellipsis-icon post-three-dots']//*[name()='svg']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Update']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='post-container']//*[name()='svg']"))).click();
    }

    public static void main(String[] args) throws InterruptedException {
        Editpost edit = new Editpost();
        edit.Setup();
        edit.login();
        edit.edit();
        Thread.sleep(5000);
        edit.tearDown(); // Ferme le navigateur après successsharepost
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Test completed successfully");
    }
}
