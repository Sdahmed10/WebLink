import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class EditProfile {
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
        //driver = new SafariDriver();
        //driver = new FirefoxDriver();
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

    public void failedEditprofile() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(1000);
        WebElement yearOfEstablishment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='yearOfEstablishment']")));
        typeEditCharacterByCharacter(yearOfEstablishment, "1946");
        WebElement numoftitles = driver.findElement(By.xpath("//div[@class=' main-layout-outlet']//img[1]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            numoftitles.click();
        }
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        typeEditCharacterByCharacter(city, "");
        WebElement Summary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='about']")));
        typeEditCharacterByCharacter(Summary, "Club football");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[normalize-space()='City is required']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("City is required");
            } else {
                System.out.println("Edit Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failededitprofile1() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(1000);
        WebElement yearOfEstablishment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='yearOfEstablishment']")));
        typeEditCharacterByCharacter(yearOfEstablishment, "");
        WebElement numoftitles = driver.findElement(By.xpath("//div[@class=' main-layout-outlet']//img[1]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            numoftitles.click();
        }
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        typeEditCharacterByCharacter(city, "Auxerre");
        WebElement Summary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='about']")));
        typeEditCharacterByCharacter(Summary, "Club football");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[normalize-space()='Year of establishment is required']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Year of establishment is required");
            } else {
                System.out.println("Edit Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failededitprofile2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(1000);
        WebElement yearOfEstablishment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='yearOfEstablishment']")));
        typeEditCharacterByCharacter(yearOfEstablishment, "");
        WebElement numoftitles = driver.findElement(By.xpath("//div[@class=' main-layout-outlet']//img[1]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            numoftitles.click();
        }
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        typeEditCharacterByCharacter(city, "");
        WebElement Summary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='about']")));
        typeEditCharacterByCharacter(Summary, "Club football");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[normalize-space()='Year of establishment is required']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Year of establishment is required");
            } else {
                System.out.println("Edit Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[normalize-space()='City is required']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("City is required");
            } else {
                System.out.println("Edit Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void failededitprofile3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(1000);
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        //WebElement usernameField = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys(Keys.chord(Keys.META, "a"));
        name.sendKeys(Keys.BACK_SPACE);
        typeEditCharacterByCharacter(name, "Auxerre");
        //usernameField.sendKeys("Auxerre");
        Thread.sleep(2000);
        WebElement yearOfEstablishment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='yearOfEstablishment']")));
        typeEditCharacterByCharacter(yearOfEstablishment, "");
        WebElement numoftitles = driver.findElement(By.xpath("//div[@class=' main-layout-outlet']//img[1]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            numoftitles.click();
        }
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        typeEditCharacterByCharacter(city, "Auxerre");
        WebElement Summary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='about']")));
        typeEditCharacterByCharacter(Summary, "Club football");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//p[@class=' error-message']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Club name is required");
            } else {
                System.out.println("Edit Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Sucesseditprofile() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        Thread.sleep(1000);
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
        //WebElement usernameField = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys(Keys.chord(Keys.META, "a"));
        name.sendKeys(Keys.BACK_SPACE);
        typeEditCharacterByCharacter(name, "Auxerre");
        //usernameField.sendKeys("Auxerre");
        Thread.sleep(2000);
        WebElement yearOfEstablishment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='yearOfEstablishment']")));
        typeEditCharacterByCharacter(yearOfEstablishment, "1914");
        WebElement numoftitles = driver.findElement(By.xpath("//div[@class=' main-layout-outlet']//img[1]"));
        int n = 2;
        for (int i = 0; i < n; i++) {
            numoftitles.click();
        }
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='city']")));
        typeEditCharacterByCharacter(city, "Auxerre");
        WebElement Summary = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='about']")));
        typeEditCharacterByCharacter(Summary, "Club football");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
        Thread.sleep(1000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement failed = driver.findElement(By.xpath("//span[normalize-space()='Club has been successfully modified']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (failed.isDisplayed()) {
                System.out.println("Edit Success");
            } else {
                System.out.println("Edit failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void typeEditCharacterByCharacter(WebElement element, String edit) throws InterruptedException {
        for (char c : edit.toCharArray()) {
            element.sendKeys(Character.toString(c));
            Thread.sleep(100); // Vous pouvez ajuster la durée de la pause si nécessaire
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EditProfile EditProfile = new EditProfile();

        EditProfile.setUp();
        EditProfile.login();
        EditProfile.failedEditprofile();
        EditProfile.tearDown();

        EditProfile.setUp();
        EditProfile.login();
        EditProfile.failededitprofile1();
        EditProfile.tearDown();

        EditProfile.setUp();
        EditProfile.login();
        EditProfile.failededitprofile2();
        EditProfile.tearDown();

        EditProfile.setUp();
        EditProfile.login();
        EditProfile.failededitprofile3();
        EditProfile.tearDown();

        EditProfile.setUp();
        EditProfile.login();
        EditProfile.Sucesseditprofile();
        EditProfile.tearDown();
    }
}
