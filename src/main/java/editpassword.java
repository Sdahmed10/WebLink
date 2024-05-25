import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class editpassword {
    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_LOCATOR = "//input[@id='password']";
    private static final String LOGIN_LOCATOR = "//button[normalize-space()='Login']";
    private static final String PWD_LOCATOR = "//span[normalize-space()='Password']";
    private static final String ACTUAL_LOCATOR = "//input[@id='oldPassword']";
    private static final String NEWPWD_LOCATOR = "//input[@id='newPassword']";
    private static final String CONFIRMPWD_LOCATOR = "//input[@id='confirmPassword']";
    private static final String SAVE_LOCATOR = "//button[normalize-space()='Confirm']";
    private static final String LOGOUT_LOCATOR = "//button[normalize-space()='Logout']";
    private static final String LINK_LOCATOR = "//img[@alt='linkefoot-logo']";


    public static void main(String[] args) throws Exception {
        ScreenRecorderUtil.startRecord("main");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        try {
            successfulreset(driver);
            Thread.sleep(3000);

            failedreset(driver);
            Thread.sleep(3000);

            failedreset1(driver);
            Thread.sleep(3000);

            failedreset2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ScreenRecorderUtil.stopRecord();
            driver.quit();
        }
    }

    public static void successfulreset(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "yevih95491@cgbird.com", "123456Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        System.out.println("Successful login");
        clickElement(driver, PWD_LOCATOR);
        fillForm1(driver, "123456Aa@","1234566Aa@", "1234566Aa@");
        Thread.sleep(5000);
        clickElement(driver, SAVE_LOCATOR);
        System.out.println("Successful reset");
        clickElement(driver, LINK_LOCATOR);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        clickElement(driver, LOGOUT_LOCATOR);

    }
    public static void failedreset(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "yevih95491@cgbird.com", "1234566Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        System.out.println("Successful login");
        clickElement(driver, PWD_LOCATOR);
        fillForm1(driver, "123456Aa@", "123456Aa@", "123456Aa@");
        Thread.sleep(5000);
        clickElement(driver, SAVE_LOCATOR);
        System.out.println("failed reset");
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }
    public static void failedreset1(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "yevih95491@cgbird.com", "1234566Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        System.out.println("Successful login");
        clickElement(driver, PWD_LOCATOR);
        fillForm1(driver, "1234566Aa@", "1234567Aa@", "123456Aa@");
        Thread.sleep(5000);
        clickElement(driver, SAVE_LOCATOR);
        System.out.println("failed reset1");
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }
    public static void failedreset2(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "yevih95491@cgbird.com", "1234566Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        System.out.println("Successful login");
        clickElement(driver, PWD_LOCATOR);
        fillForm1(driver, "", "", "" );
        Thread.sleep(5000);
        clickElement(driver, SAVE_LOCATOR);
        System.out.println("failed reset2");
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }
    private static void fillForm(WebDriver driver, String email, String password) {
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PASSWORD_LOCATOR, password);
    }

    private static void fillForm1(WebDriver driver, String actuel, String newpassword, String confirm){
        setInputValue(driver, ACTUAL_LOCATOR, actuel);
        setInputValue(driver, NEWPWD_LOCATOR, newpassword);
        setInputValue(driver, CONFIRMPWD_LOCATOR, confirm);
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
}
