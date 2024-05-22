import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Signupwithusename2caracters {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/register");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        WebElement nameofclub = driver.findElement(By.xpath("//input[@id='name']"));
        nameofclub.sendKeys("Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch");
        nameofclub.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("ahmedsdiri+190@takiacademyteam.com");
        email.click();
        Thread.sleep(3000);
        WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
        pswd.sendKeys("12345Aa@");
        pswd.click();
        Thread.sleep(3000);
        WebElement confirmpswd = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmpswd.sendKeys("12345Aa@");
        confirmpswd.click();
        Thread.sleep(3000);
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        phone.sendKeys("632145789");
        phone.click();
        Thread.sleep(3000);
        WebElement accept = driver.findElement(By.xpath("//input[@id='remember_me']"));
        accept.click();
        WebElement next = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        next.click();
        Thread.sleep(2000);
        WebElement email1 = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[contains(@class,'auth-main-layout')]/div[contains(@class,'confirmation-account-container auth-main-container')]/div[contains(@class,'confirmation-cards')]/div[1]"));
        email1.click();
        Thread.sleep(5000);
        System.out.println("seccessfull login");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Save screenshot
        try {
            FileUtils.copyFile(screenshotFile, new File("/Users/takiacademy/Documents/capture4.png"));
            System.out.println("Capture d'écran effectuée avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

