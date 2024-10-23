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
import java.util.List;
import java.util.Map;

public class Chat {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    @Test(priority = 1)
    public void login() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        email.sendKeys("neyad39254@paxnw.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        password.sendKeys("12345Aa@");

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"light\"]/div/div/form/button")));
        login.click();
    }

    @Test(priority = 2)
    public static void chat1() throws InterruptedException {
        WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Message'])[1]")));
        message.click();

        WebElement ess = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout chat-container']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='chat-container--wrraper']/div[@class='conversation-container']/div[@class='list-conversation--items-container no-conversation']/div[@class='list-conversation--items']/div[2]")));
        ess.click();

        WebElement message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Votre message...']")));
        String messageText = "hello everyone";
        message1.sendKeys(messageText);

        WebElement send = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Envoyer']")));
        send.click();

        // Wait for a short moment to ensure the message is sent and updated
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='list-conversation--items']/div"))); // Adjust if necessary

        // Get all messages in the chat
        List<WebElement> messages = driver.findElements(By.xpath("//div[@class='list-conversation--items']/div")); // Adjust if necessary

        // Verify the last sent message
        if (!messages.isEmpty()) {
            String lastMessageText = messages.get(messages.size() - 1).getText();
            if (lastMessageText.equals(messageText)) {
                System.out.println("Message sent successfully: " + lastMessageText);
            } else {
                System.out.println("Failed to send the message. Last message: " + lastMessageText);
            }
        } else {
            System.out.println("No messages found.");
        }
    }
}
