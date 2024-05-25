import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class edit {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
            driver.get("https://devlinkfoot.softylines.com/auth/jwt/login");

            WebElement email = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
            email.sendKeys(Keys.chord(Keys.META, "a"));
            email.sendKeys(Keys.BACK_SPACE);
            email.sendKeys("hamzabouyahya198@gmail.com");
            email.click();

            WebElement password = driver.findElement(By.xpath("(//input[@id=':r1:'])[1]"));
            password.sendKeys(Keys.chord(Keys.META, "a"));
            password.sendKeys(Keys.BACK_SPACE);
            password.sendKeys("Super123");
            password.click();
            driver.findElement(By.xpath("(//button[normalize-space()='Connexion'])[1]")).click();
            driver.findElement(By.xpath("//img[@alt='super']")).click();
            driver.findElement(By.xpath("//li[normalize-space()='Profil']")).click();

            WebElement upload = driver.findElement(By.xpath("//span[@class='MuiTypography-root MuiTypography-caption css-176slt']"));
            //upload.click();
            String filePath = "/Users/takiacademy/Desktop/01.jpg"; // Chemin absolu de l'image
            upload.sendKeys(filePath);
Thread.sleep(3000);
            WebElement save = driver.findElement(By.xpath("(//button[normalize-space()='Enregistrer'])[1]"));
            save.click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }

    }
}
