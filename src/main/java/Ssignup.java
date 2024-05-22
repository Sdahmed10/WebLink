import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ssignup {

    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/register";
    private static final String NAME_LOCATOR = "//input[@id='name']";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_LOCATOR = "//input[@id='password']";
    private static final String CONFIRM_PASSWORD_LOCATOR = "//input[@id='confirmPassword']";
    private static final String PHONE_LOCATOR = "//input[@placeholder='1 (702) 123-4567']";
    private static final String ACCEPT_LOCATOR = "//input[@id='remember_me']";
    private static final String NEXT_LOCATOR = "//button[normalize-space()='Next']";

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ScreenRecorderUtil.startRecord("main");
        try {
            successfulSignup(driver);
            Thread.sleep(3000);

            failedSignup1(driver);
            Thread.sleep(3000);

            failedSignup(driver);
            Thread.sleep(3000);

            failedSignup2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ScreenRecorderUtil.stopRecord();

            driver.quit();
        }
    }

    public static void successfulSignup(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        fillForm(driver, "brest", "ahmedsdiri+188@takiacademyteam.com", "12345Aa@", "12345Aa@", "632145789");
        clickElement(driver, ACCEPT_LOCATOR);
        clickElement(driver, NEXT_LOCATOR);

        System.out.println("Successful signup");
        takeScreenshot(driver, "/Users/takiacademy/Documents/successful_signup.png");
    }

    public static void failedSignup1(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        fillForm(driver, "brest", "ahmedsdiri+188@takiacademyteam.com", "12345Aa@", "12345Aa@", "632145789");
        clickElement(driver, NEXT_LOCATOR);

        System.out.println("Failed signup (case 1)");
        takeScreenshot(driver, "/Users/takiacademy/Documents/failed_signup1.png");
    }

    public static void failedSignup(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        fillForm(driver, "", "qsfqh@gmail.com", "12345678", "12345678", "968787454");
        clickElement(driver, ACCEPT_LOCATOR);
        clickElement(driver, NEXT_LOCATOR);

        checkForError(driver, "It must contain 8 characters, one uppercase letter", "/Users/takiacademy/Documents/failed_signup.png");
    }

    public static void failedSignup2(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        fillForm(driver, "", "", "", "", "");
        clickElement(driver, ACCEPT_LOCATOR);
        clickElement(driver, NEXT_LOCATOR);

        checkForError(driver, "Club name is required", "/Users/takiacademy/Documents/failed_signup2.png");
    }

    private static void fillForm(WebDriver driver, String name, String email, String password, String confirmPassword, String phone) {
        setInputValue(driver, NAME_LOCATOR, name);
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PASSWORD_LOCATOR, password);
        setInputValue(driver, CONFIRM_PASSWORD_LOCATOR, confirmPassword);
        setInputValue(driver, PHONE_LOCATOR, phone);
    }

    private static void setInputValue(WebDriver driver, String locator, String value) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
        element.click();
    }

    private static void clickElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    private static void checkForError(WebDriver driver, String errorMessage, String screenshotPath) {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[contains(text(),'" + errorMessage + "')]"));
            System.out.println("Signup failed: " + errorElement.getText());
            takeScreenshot(driver, screenshotPath);
        } catch (NoSuchElementException e) {
            System.out.println("No error message found, signup might have unexpectedly succeeded.");
        }
    }

    private static void takeScreenshot(WebDriver driver, String filePath) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(filePath));
            System.out.println("Screenshot taken: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
