
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        //add key and value to map as follow to switch off browser notification
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
    public void successPublishtryout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Tryouts']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new essay']")).click();
        Thread.sleep(1000);
        WebElement title = driver.findElement(By.xpath("//textarea[@placeholder='Title']"));
        title.sendKeys("Tryout test");
        title.click();
        Thread.sleep(1000);
        WebElement MaxParticipants = driver.findElement(By.xpath("//div[@class='tryout-create main-layout-outlet']//div[2]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            MaxParticipants.click();
        }
        Thread.sleep(1000);
        WebElement Price = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n1 = 10;
        for (int i = 0; i < n1; i++) {
            Price.click();
        }
        WebElement Positions = driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']"));
        Positions.click();
        Thread.sleep(1000);
        WebElement GK = driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']"));
        GK.click();
        Thread.sleep(1000);
        WebElement RB = driver.findElement(By.xpath("//div[@title='RB']//div[@class='shared-async-select__option']"));
        RB.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();  // Cliquer dans le coin supérieur gauche de la page
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//*[name()='rect' and contains(@width,'11')]"));
        search.click();
        Thread.sleep(2000);
        WebElement adress = driver.findElement(By.xpath("//input[@placeholder='Search an address']"));
        adress.sendKeys("sousse,tunisie");
        adress.click();
        Thread.sleep(2000);
        WebElement location = driver.findElement(By.xpath("//p[normalize-space()='Sousse, Tunisie']"));
        location.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();
        Thread.sleep(1000);
        WebElement date = driver.findElement(By.xpath("//div[@class='ant-picker-input']"));
        date.click();
        Thread.sleep(2000);
        WebElement date1 = driver.findElement(By.xpath("//div[@class='ant-picker-input']"));
        date1.click();
        Thread.sleep(1000);
        WebElement date3 = driver.findElement(By.xpath("//div[normalize-space()='27']"));
        date3.click();
        Thread.sleep(1000);
        WebElement MiniAge = driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            MiniAge.click();
        }
        Thread.sleep(1000);
        WebElement MaxAge = driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            MaxAge.click();
        }
        Thread.sleep(1000);
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
        description.sendKeys("1234567890");
        description.click();
        Thread.sleep(1000);
        WebElement publish = driver.findElement(By.xpath("//button[normalize-space()='publish']"));
        publish.click();
//        String expectedUrl = "";
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(actualUrl, expectedUrl, "Tryout created successfully");
    }

    @Test(priority = 3)
    public void sharepostfailed() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Tryouts']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new essay']")).click();
        Thread.sleep(1000);
//        WebElement title = driver.findElement(By.xpath("//textarea[@placeholder='Title']"));
//        title.sendKeys("Tryout test");
//        title.click();
//        Thread.sleep(1000);
        WebElement MaxParticipants = driver.findElement(By.xpath("//div[@class='tryout-create main-layout-outlet']//div[2]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            MaxParticipants.click();
        }
        Thread.sleep(1000);
//        WebElement Price = driver.findElement(By.xpath("//div[3]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
//        int n1 = 10;
//        for (int i = 0; i < n1; i++) {
//            Price.click();
//        }
        WebElement Positions = driver.findElement(By.xpath("//div[@class='ant-select-selection-overflow']"));
        Positions.click();
        Thread.sleep(1000);
        WebElement GK = driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']"));
        GK.click();
//        Thread.sleep(1000);
//        WebElement RB = driver.findElement(By.xpath("//div[@title='RB']//div[@class='shared-async-select__option']"));
//        RB.click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().perform();  // Cliquer dans le coin supérieur gauche de la page
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.xpath("//*[name()='rect' and contains(@width,'11')]"));
        search.click();
        Thread.sleep(2000);
        WebElement adress = driver.findElement(By.xpath("//input[@placeholder='Search an address']"));
        adress.sendKeys("sousse,tunisie");
        adress.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Save position']")).click();
        Thread.sleep(1000);
        WebElement date = driver.findElement(By.xpath("//div[@class='ant-picker-input']"));
        date.click();
        Thread.sleep(2000);
        WebElement date1 = driver.findElement(By.xpath("//div[@class='ant-picker-input']"));
        date1.click();
        Thread.sleep(2000);
        WebElement date3 = driver.findElement(By.xpath("//div[normalize-space()='28']"));
        date3.click();
        Thread.sleep(1000);
        WebElement MiniAge = driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n2 = 24;
        for (int i = 0; i < n2; i++) {
            MiniAge.click();
        }
        Thread.sleep(1000);
        WebElement MaxAge = driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[1]//*[name()='svg']//*[name()='path' and contains(@d,'M15.3852 1')]"));
        int n3 = 26;
        for (int i = 0; i < n3; i++) {
            MaxAge.click();
        }
//        Thread.sleep(1000);
//        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
//        description.sendKeys("1234567890");
//        description.click();
        Thread.sleep(1000);
        WebElement publish = driver.findElement(By.xpath("//button[normalize-space()='publish']"));
        publish.click();
//        String expectedUrl = "https://devlinkfootweb.softylines.com/tryouts";
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(actualUrl, expectedUrl, "Tryout created successfully");
        // Vérifier si le message d'erreur du champ Titre est affiché
        Thread.sleep(2000);
        WebElement titleErrorMessage = driver.findElement(By.xpath("//p[normalize-space()='required tryout title']"));
        Assert.assertTrue(titleErrorMessage.isDisplayed(), "Le message d'erreur pour le champ 'Title' n'est pas affiché");

        // Vérifier si le message d'erreur du champ description est affiché
        WebElement participantsErrorMessage = driver.findElement(By.xpath("//p[normalize-space()='required tryout description']"));
        Assert.assertTrue(participantsErrorMessage.isDisplayed(), "Le message d'erreur pour le champ 'Max Participants' n'est pas affiché");

    }

    public static void main(String[] args) throws InterruptedException {
        CreateTryout CreateTryout = new CreateTryout();
        CreateTryout.login();
        // Appel du premier scénario
        CreateTryout.successPublishtryout();
        //Appel du deuxième scénario
        CreateTryout.sharepostfailed();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        System.out.println("Test completed successfully");
    }
}