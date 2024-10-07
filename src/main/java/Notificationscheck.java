import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Notificationscheck {
    private static final Logger log = LoggerFactory.getLogger(Login1.class);
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set ExperimentalOption - pref
        options.setExperimentalOption("prefs", prefs);
        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        Thread.sleep(1000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("varoxe6978@kernuo.com");
        email.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345Aa@");
        password.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        login.click();
    }
    @Test(priority = 2)
    public void CheckNotifications() throws InterruptedException {
        Thread.sleep(2000);
        WebElement notif = driver.findElement(By.xpath("//a[@href='/notifications']"));
        notif.click();
        try{
        Thread.sleep(1000);
        WebElement first = driver.findElement(By.xpath("(//SELECTEUR_XPATH)[1]"));
            // Cliquer sur la première notification
            first.click();
            System.out.println("Première notification cliquée.");
        } catch (Exception e) {
            System.out.println("Aucune notification trouvée ou non cliquable : " + e.getMessage());
            }
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}
