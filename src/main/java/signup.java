import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class signup {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Successful signup attempt
        try {
            successfulSignup(driver);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Failed signup1 attempt
        try {
            failedSignup1(driver);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Failed signup attempt
        try {
            failedSignup(driver);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Failed signup2 attempt
        try {
            failedSignup2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
    public static void successfulSignup(WebDriver driver) throws InterruptedException {
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/register");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        WebElement nameofclub = driver.findElement(By.xpath("//input[@id='name']"));
        nameofclub.sendKeys("brest");
        nameofclub.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("ahmedsdiri+188@takiacademyteam.com");
        email.click();
        WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
        pswd.sendKeys("12345Aa@");
        pswd.click();
        WebElement confirmpswd = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmpswd.sendKeys("12345Aa@");
        confirmpswd.click();
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        phone.sendKeys("632145789");
        phone.click();
        WebElement accept = driver.findElement(By.xpath("//input[@id='remember_me']"));
        accept.click();
        WebElement next = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        next.click();
        // Assume success if no error message is found
        System.out.println("Successful signup");
        takeScreenshot(driver, "/Users/takiacademy/Documents/successful_signup.png");
    }
    public static void failedSignup1(WebDriver driver) throws InterruptedException {
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/register");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        WebElement nameofclub = driver.findElement(By.xpath("//input[@id='name']"));
        nameofclub.sendKeys("brest");
        nameofclub.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("ahmedsdiri+188@takiacademyteam.com");
        email.click();
        WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
        pswd.sendKeys("12345Aa@");
        pswd.click();
        WebElement confirmpswd = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmpswd.sendKeys("12345Aa@");
        confirmpswd.click();
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        phone.sendKeys("632145789");
        phone.click();
        WebElement next = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        next.click();
        // Assume success if no error message is found
        System.out.println("failed signup");
        takeScreenshot(driver, "/Users/takiacademy/Documents/failed_signup1.png");
    }
    public static void failedSignup(WebDriver driver) throws InterruptedException {
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/register");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        WebElement nameofclub = driver.findElement(By.xpath("//input[@id='name']"));
        nameofclub.sendKeys(""); // Leave the name empty to induce failure
        nameofclub.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("qsfqh@gmail.com"); // Invalid email to induce failure
        email.click();
        WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
        pswd.sendKeys("12345678");
        pswd.click();
        WebElement confirmpswd = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmpswd.sendKeys("12345678");
        confirmpswd.click();
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        phone.sendKeys("968787454");
        phone.click();
        WebElement accept = driver.findElement(By.xpath("//input[@id='remember_me']"));
        accept.click();
        WebElement next = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        next.click();
        // Check for error messages
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'It must contain 8 characters, one uppercase letter')]"));
            System.out.println("Signup failed: " + errorMessage.getText());
            takeScreenshot(driver, "/Users/takiacademy/Documents/failed_signup.png");
        } catch (NoSuchElementException e) {
            System.out.println("No error message found, signup might have unexpectedly succeeded.");
        }
    }
    public static void failedSignup2(WebDriver driver) throws InterruptedException {
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/register");
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        WebElement nameofclub = driver.findElement(By.xpath("//input[@id='name']"));
        nameofclub.sendKeys(""); // Leave the name empty to induce failure
        nameofclub.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys(""); // Invalid email to induce failure
        email.click();
        WebElement pswd = driver.findElement(By.xpath("//input[@id='password']"));
        pswd.sendKeys("");
        pswd.click();
        WebElement confirmpswd = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
        confirmpswd.sendKeys("");
        confirmpswd.click();
        WebElement phone = driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']"));
        phone.sendKeys("");
        phone.click();
        WebElement accept = driver.findElement(By.xpath("//input[@id='remember_me']"));
        accept.click();
        WebElement next = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
        try {
            next.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", next);
        }
        // Check for error messages
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//p[normalize-space()='Club name is required']"));
            System.out.println("Signup failed: " + errorMessage.getText());
            takeScreenshot(driver, "/Users/takiacademy/Documents/failed_signup2.png");
        } catch (NoSuchElementException e) {
            System.out.println("No error message found, signup might have unexpectedly succeeded.");
        }
    }
    public static void takeScreenshot(WebDriver driver, String filePath) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(filePath));
            System.out.println("Screenshot taken: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
