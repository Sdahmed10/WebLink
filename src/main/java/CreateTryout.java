import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateTryout {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);

        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
    public void successPublishtryout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[2]"))).click();

        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Tryout Title']")));
        title.sendKeys("Tryout test");

        WebElement MaxParticipants = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tryout-create main-layout-outlet']//div[2]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 2; i++) {
            MaxParticipants.click();
        }

        WebElement Price = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 10; i++) {
            Price.click();
        }

        WebElement Positions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-selection-overflow']")));
        Positions.click();

        WebElement GK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")));
        GK.click();

        WebElement RB = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='RB']//div[@class='shared-async-select__option']")));
        RB.click();

        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Stadium']")));
        search.click();

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search an address']")));
        address.sendKeys("sousse,tunisie");
        address.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save position']"))).click();

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-picker-input']")));
        date.click();

        WebElement date3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='27']")));
        date3.click();

        WebElement MiniAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 24; i++) {
            MiniAge.click();
        }

        WebElement MaxAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[8]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 26; i++) {
            MaxAge.click();
        }

        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        description.sendKeys("1234567890");

        WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='publish']")));
        publish.click();
    }

    @Test(priority = 3)
    public void sharepostfailed() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[2]"))).click();

        WebElement MaxParticipants = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tryout-create main-layout-outlet']//div[2]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 2; i++) {
            MaxParticipants.click();
        }

        WebElement Positions = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-selection-overflow']")));
        Positions.click();

        WebElement GK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")));
        GK.click();

        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Stadium']")));
        search.click();

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search an address']")));
        address.sendKeys("sousse,tunisie");
        address.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Save position']"))).click();

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-picker-input']")));
        date.click();

        WebElement date3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='28']")));
        date3.click();

        WebElement MiniAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[7]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 24; i++) {
            MiniAge.click();
        }

        WebElement MaxAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[8]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        for (int i = 0; i < 26; i++) {
            MaxAge.click();
        }

        WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='publish']")));
        publish.click();

        // Verify error messages
        WebElement titleErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='required tryout title']")));
        Assert.assertTrue(titleErrorMessage.isDisplayed(), "Le message d'erreur pour le champ 'Title' n'est pas affiché");

        WebElement participantsErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='required tryout description']")));
        Assert.assertTrue(participantsErrorMessage.isDisplayed(), "Le message d'erreur pour le champ 'Max Participants' n'est pas affiché");
    }

    public static void main(String[] args) throws InterruptedException {
        Tryout tryout = new Tryout();

        tryout.Setup();
        tryout.login();
        tryout.successPublishtryout();
        tryout.tearDown(); // Ferme le navigateur après successsharepost

        tryout.Setup();
        tryout.login();
        tryout.sharepostfailed();
        tryout.tearDown(); // Ferme le navigateur après successsharepost

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Test completed successfully");
    }
}
