import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateGame {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void Setup() {
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
    public void successPublishgame() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Games']")).click();
        Thread.sleep(1000);
        WebElement create = driver.findElement(By.xpath("//button[normalize-space()='create new game']"));
        create.click();
        Thread.sleep(2000);
        WebElement club = driver.findElement(By.cssSelector("#rc_select_0"));
        club.sendKeys("metz");
        club.click();
        Thread.sleep(2000);
        WebElement everton = driver.findElement(By.xpath("//div[@class='shared-async-select__option']"));
        everton.click();
        WebElement hours = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout ']/div[@class='main-layout-content ']/div[@class='game-create main-layout-outlet']/div[@class=' main-layout-container']/div[@class='game-create__content']/form[@class='shared-form']/div[2]/div[1]/div[1]/div[1]/div[1]"));
        hours.click();
        Thread.sleep(1000);
        WebElement hours1 = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout ']/div[@class='main-layout-content ']/div[@class='game-create main-layout-outlet']/div[@class=' main-layout-container']/div[@class='game-create__content']/form[@class='shared-form']/div[2]/div[1]/div[1]/div[1]/div[1]"));
        hours1.click();
        Thread.sleep(1000);
        WebElement hours2 = driver.findElement(By.xpath("//ul[@data-type='hour']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='07']"));
        hours2.click();
        WebElement hours3 = driver.findElement(By.xpath("//ul[@data-type='minute']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='06']"));
        hours3.click();
        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Match Stadium']"));
        search.click();
        Thread.sleep(2000);
        WebElement adress = driver.findElement(By.xpath("//input[@placeholder='Search an address']"));
        adress.sendKeys("Sousse,Tunisie");
        adress.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();
        Thread.sleep(1000);
        WebElement MiniAge = driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            MiniAge.click();
        }
        Thread.sleep(1000);
        WebElement MaxAge = driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            MaxAge.click();
        }
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Match Date']"));
        date.click();
        Thread.sleep(2000);
        WebElement date3 = driver.findElement(By.cssSelector("td[title='2024-09-29'] div[class='ant-picker-cell-inner']"));
        date3.click();
        Thread.sleep(1000);
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        description.sendKeys("1234567890");
        description.click();
        Thread.sleep(1000);
        WebElement publish = driver.findElement(By.xpath("//button[normalize-space()='publish']"));
        publish.click();
        Thread.sleep(3000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement Modifierlematch = driver.findElement(By.xpath("//button[normalize-space()='Modifier le match']"));
            // Vérifier que le message de succès est affiché
            if (Modifierlematch.isDisplayed()) {
                System.out.println("La création du jeu a été confirmée avec succès.");
            } else {
                System.out.println("Échec de la confirmation de la création du jeu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void FailedPublishgame() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Games']")).click();
        Thread.sleep(1000);
        WebElement create = driver.findElement(By.xpath("//button[normalize-space()='create new game']"));
        create.click();
        Thread.sleep(2000);
        WebElement club = driver.findElement(By.cssSelector("input[type='search']"));

//        WebElement club = driver.findElement(By.xpath("//input[type='search']"));
        club.sendKeys("metz");
        club.click();
        Thread.sleep(2000);
        WebElement everton = driver.findElement(By.xpath("//div[@class='shared-async-select__option']"));
        everton.click();
        WebElement hours = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout ']/div[@class='main-layout-content ']/div[@class='game-create main-layout-outlet']/div[@class=' main-layout-container']/div[@class='game-create__content']/form[@class='shared-form']/div[2]/div[1]/div[1]/div[1]/div[1]"));
        hours.click();
        Thread.sleep(1000);
        WebElement hours1 = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout ']/div[@class='main-layout-content ']/div[@class='game-create main-layout-outlet']/div[@class=' main-layout-container']/div[@class='game-create__content']/form[@class='shared-form']/div[2]/div[1]/div[1]/div[1]/div[1]"));
        hours1.click();
        Thread.sleep(1000);
        WebElement hours2 = driver.findElement(By.xpath("//ul[@data-type='hour']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='07']"));
        hours2.click();
        WebElement hours3 = driver.findElement(By.xpath("//ul[@data-type='minute']//div[@class='ant-picker-time-panel-cell-inner'][normalize-space()='06']"));
        hours3.click();
        driver.findElement(By.xpath("//span[normalize-space()='OK']")).click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Match Stadium']"));
        search.click();
        Thread.sleep(2000);
        WebElement adress = driver.findElement(By.xpath("//input[@placeholder='Search an address']"));
        adress.sendKeys("Sousse,Tunisie");
        adress.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();
        Thread.sleep(1000);
        WebElement MiniAge = driver.findElement(By.xpath("//div[4]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            MiniAge.click();
        }
        Thread.sleep(1000);
        WebElement MaxAge = driver.findElement(By.xpath("//div[5]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            MaxAge.click();
        }
        Thread.sleep(2000);
        WebElement date = driver.findElement(By.xpath("//input[@placeholder='Match Date']"));
        date.click();
        Thread.sleep(2000);
        WebElement date3 = driver.findElement(By.cssSelector("td[title='2024-09-29'] div[class='ant-picker-cell-inner']"));
        date3.click();
        Thread.sleep(1000);
        WebElement publish = driver.findElement(By.xpath("//button[normalize-space()='publish']"));
        publish.click();
        Thread.sleep(2000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement Modifierlematch = driver.findElement(By.xpath("//p[normalize-space()='required match description']"));
            Thread.sleep(3000);
            // Vérifier que le message de succès est affiché
            if (Modifierlematch.isDisplayed()) {
                System.out.println("Échec de la confirmation de la création du jeu. ");
            } else {
                System.out.println("La création du jeu a été confirmée avec succès.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}

