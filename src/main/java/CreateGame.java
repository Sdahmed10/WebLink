import org.openqa.selenium.*;
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

public class CreateGame {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        // Create a map to store preferences
        Map<String, Object> prefs = new HashMap<>();
        // Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        // Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // Set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        // Initialize the Chrome driver with the options
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    @Test(priority = 1)
    public void login() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        email.sendKeys("varoxe6978@kernuo.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        password.sendKeys("12345Aa@");

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"light\"]/div/div/form/button")));
        login.click();
    }

    @Test(priority = 2)
    public void successPublishgame() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[1]"))).click();

        WebElement club = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rc_select_0")));
        club.sendKeys("metz");
        club.click();

        WebElement metz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Metz']//div[@class='shared-async-select__option']")));
        metz.click();


        WebElement hours = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Match Time']")));
        hours.click();

        WebElement hours1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@data-type='hour']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='05']")));
        hours1.click();

        WebElement hours2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@data-type='minute']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='05']")));
        hours2.click();


        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Stadium Location']")));
        search.click();

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search an address']")));
        address.sendKeys("Sousse,Tunisie");
        address.click();

        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();

        WebElement miniAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            miniAge.click();
        }

        WebElement maxAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            maxAge.click();
        }

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Match Date']")));
        date.click();

        WebElement date3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[title='2024-10-29'] div[class='ant-picker-cell-inner']")));
        date3.click();

        WebElement description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        description.sendKeys("1234567890");

        WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Publish']")));
        publish.click();

        try {
            // Wait for the confirmation message
            WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Game created successfully']")));
            if (success.isDisplayed()) {
                System.out.println("La création du jeu a été confirmée avec succès.");
            }
        } catch (TimeoutException e) {
            System.out.println("Échec de la confirmation de la création du jeu.");
        }
    }

    @Test(priority = 3)
    public void FailedPublishgame() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[1]"))).click();


        WebElement club = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='search']")));
        club.sendKeys("metz");
        club.click();

        WebElement metz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Metz']//div[@class='shared-async-select__option']")));
        metz.click();


        WebElement hours = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Match Time']")));
        hours.click();

        WebElement hours1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@data-type='hour']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='05']")));
        hours1.click();

        WebElement hours2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@data-type='minute']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='05']")));
        hours2.click();


        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();

        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Stadium Location']")));
        search.click();

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search an address']")));
        address.sendKeys("Sousse,Tunisie");
        address.click();

        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();

        WebElement miniAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[4]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            miniAge.click();
        }

        WebElement maxAge = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[5]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]")));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            maxAge.click();
        }

        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Match Date']")));
        date.click();

        WebElement date3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("td[title='2024-10-29'] div[class='ant-picker-cell-inner']")));
        date3.click();


        // Publish without setting maximum age
        WebElement publish = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Publish']")));
        publish.click();

        // Wait for the error message
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='description-required']"))); // Adjust this xpath to the actual error message
            if (errorMessage.isDisplayed()) {
                System.out.println("Erreur: " + errorMessage.getText());
            }
        } catch (TimeoutException e) {
            System.out.println("Aucun message d'erreur affiché.");
        }
    }

    public static void main(String[] args) {
        CreateGame createGame = new CreateGame();

        createGame.Setup();
        createGame.login();
        createGame.successPublishgame();
        createGame.tearDown(); // Ferme le navigateur après successsharepost

        createGame.Setup();
        createGame.login();
        createGame.FailedPublishgame();
        createGame.tearDown(); // Ferme le navigateur après successsharepost
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            System.out.println("Test completed successfully");
        }
    }
}
