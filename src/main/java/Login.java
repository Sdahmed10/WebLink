import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Login {
    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_LOCATOR = "//input[@id='password']";
    private static final String CONNECTER_LOCATOR = "//button[normalize-space()='Login']";
    private static final String LOGOUT_LOCATOR = "//button[normalize-space()='Logout']";

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //ScreenRecorderUtil.startRecord("main");
        try {
            successfulLogin(driver);
            Thread.sleep(3000);

            failedLogin1(driver);
            Thread.sleep(3000);

            failedLogin(driver);
            Thread.sleep(3000);

            failedLogin2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ScreenRecorderUtil.stopRecord();
            driver.quit();
        }
}
    public static void successfulLogin(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver,"ahmedsdiri+16@takiacademyteam.com", "123456Aa@");
        clickElement(driver, CONNECTER_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
        System.out.println("Successful login");
        takeScreenshot(driver, "/Users/takiacademy/Documents/successful_login.png");
    }
    public static void failedLogin1(WebDriver driver){
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "hjsdfgqshg@gmail.com", "12345aA@");
        clickElement(driver, CONNECTER_LOCATOR);
        System.out.println("Failed login1");
        takeScreenshot(driver, "/Users/takiacademy/Documents/Failed_login1.png");
}
    public static void failedLogin(WebDriver driver){
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "", "12345aA@");
        clickElement(driver, CONNECTER_LOCATOR);
        System.out.println("Failed login");
        takeScreenshot(driver, "/Users/takiacademy/Documents/Failed_login.png");
    }
    public static void failedLogin2(WebDriver driver){
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "", "");
        clickElement(driver, CONNECTER_LOCATOR);
        System.out.println("Failed login2");
        takeScreenshot(driver, "/Users/takiacademy/Documents/Failed_login2.png");
    }
    private static void fillForm(WebDriver driver,  String email, String password) {
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PASSWORD_LOCATOR, password);
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
