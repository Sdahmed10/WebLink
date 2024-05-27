import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class editprofile {

    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String URL1 = "https://devlinkfootweb.softylines.com/profile";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PWD_LOCATOR = "//input[@id='password']";
    private static final String LOGIN_LOCATOR = "//button[normalize-space()='Login']";
    private static final String MYACCOUNT_LOCATOR = "//span[normalize-space()='My Account']";
    private static final String USERNAME_LOCATOR = "//input[@id='name']";
    private static final String YEAR_LOCATOR = "//input[@id='yearOfEstablishment']";
    private static final String TITLES_LOCATOR = "//input[@id='numberOfTitles']";
    private static final String CITY_LOCATOR = "//input[@id='city']";
    private static final String SUMMARY_LOCATOR = "//textarea[@id='about']";
    private static final String SAVE_LOCATOR = "//button[normalize-space()='Save changes']";
    private static final String LOGOUT_LOCATOR = "//button[normalize-space()='Logout']";
    private static final String LINK_LOCATOR = "//img[@alt='linkefoot-logo']";


    public static void main(String[] args) throws Exception {
        ScreenRecorderUtil.startRecord("main");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            successfuledit(driver);
            Thread.sleep(2000);
            failededit(driver);
            Thread.sleep(3000);
            failededit1(driver);
            Thread.sleep(3000);
            failededit2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ScreenRecorderUtil.stopRecord();
            driver.quit();
        }

    }

    public static void successfuledit(WebDriver driver) {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, MYACCOUNT_LOCATOR);
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_LOCATOR));
        usernameField.sendKeys(Keys.chord(Keys.META, "a"));
        usernameField.sendKeys(Keys.BACK_SPACE);
        usernameField.sendKeys("Olympique Lyonnais");
        clickElement(driver, YEAR_LOCATOR);
        WebElement yearField = driver.findElement(By.xpath(YEAR_LOCATOR));
        yearField.sendKeys(Keys.chord(Keys.META, "a"));
        yearField.sendKeys(Keys.BACK_SPACE);
        yearField.sendKeys("1900");
        clickElement(driver, TITLES_LOCATOR);
        WebElement titlesfield = driver.findElement(By.xpath(TITLES_LOCATOR));
        titlesfield.sendKeys(Keys.chord(Keys.META, "a"));
        titlesfield.sendKeys(Keys.BACK_SPACE);
        titlesfield.sendKeys("1");
        clickElement(driver, CITY_LOCATOR);
        WebElement cityfield = driver.findElement(By.xpath(CITY_LOCATOR));
        cityfield.sendKeys(Keys.chord(Keys.META, "a"));
        cityfield.sendKeys(Keys.BACK_SPACE);
        cityfield.sendKeys("LYON");
        clickElement(driver, SUMMARY_LOCATOR);
        WebElement summaryfield = driver.findElement(By.xpath(SUMMARY_LOCATOR));
        summaryfield.sendKeys(Keys.chord(Keys.META, "a"));
        summaryfield.sendKeys(Keys.BACK_SPACE);
        summaryfield.sendKeys("Test");
        clickElement(driver, SAVE_LOCATOR);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        clickElement(driver, LOGOUT_LOCATOR);
    }

    public static void failededit(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, MYACCOUNT_LOCATOR);
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_LOCATOR));
        usernameField.sendKeys(Keys.chord(Keys.META, "a"));
        usernameField.sendKeys(Keys.BACK_SPACE);
        usernameField.sendKeys("Olympique Lyonnais");
        clickElement(driver, YEAR_LOCATOR);
        WebElement yearField = driver.findElement(By.xpath(YEAR_LOCATOR));
        yearField.sendKeys(Keys.chord(Keys.META, "a"));
        yearField.sendKeys(Keys.BACK_SPACE);
        yearField.sendKeys("1900");
        clickElement(driver, TITLES_LOCATOR);
        WebElement titlesfield = driver.findElement(By.xpath(TITLES_LOCATOR));
        titlesfield.sendKeys(Keys.chord(Keys.META, "a"));
        titlesfield.sendKeys(Keys.BACK_SPACE);
        titlesfield.sendKeys("1");
        clickElement(driver, CITY_LOCATOR);
        WebElement cityfield = driver.findElement(By.xpath(CITY_LOCATOR));
        cityfield.sendKeys(Keys.chord(Keys.META, "a"));
        cityfield.sendKeys(Keys.BACK_SPACE);
        cityfield.sendKeys("LYON");
        clickElement(driver, SUMMARY_LOCATOR);
        WebElement summaryfield = driver.findElement(By.xpath(SUMMARY_LOCATOR));
        summaryfield.sendKeys(Keys.chord(Keys.META, "a"));
        summaryfield.sendKeys(Keys.BACK_SPACE);
        summaryfield.sendKeys("");
        clickElement(driver, SAVE_LOCATOR);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile/my-account";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        Thread.sleep(3000);
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }

    public static void failededit1(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, MYACCOUNT_LOCATOR);
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_LOCATOR));
        usernameField.sendKeys(Keys.chord(Keys.META, "a"));
        usernameField.sendKeys(Keys.BACK_SPACE);
        usernameField.sendKeys("");
        clickElement(driver, YEAR_LOCATOR);
        WebElement yearField = driver.findElement(By.xpath(YEAR_LOCATOR));
        yearField.sendKeys(Keys.chord(Keys.META, "a"));
        yearField.sendKeys(Keys.BACK_SPACE);
        yearField.sendKeys("1900");
        clickElement(driver, TITLES_LOCATOR);
        WebElement titlesfield = driver.findElement(By.xpath(TITLES_LOCATOR));
        titlesfield.sendKeys(Keys.chord(Keys.META, "a"));
        titlesfield.sendKeys(Keys.BACK_SPACE);
        titlesfield.sendKeys("1");
        clickElement(driver, CITY_LOCATOR);
        WebElement cityfield = driver.findElement(By.xpath(CITY_LOCATOR));
        cityfield.sendKeys(Keys.chord(Keys.META, "a"));
        cityfield.sendKeys(Keys.BACK_SPACE);
        cityfield.sendKeys("");
        clickElement(driver, SUMMARY_LOCATOR);
        WebElement summaryfield = driver.findElement(By.xpath(SUMMARY_LOCATOR));
        summaryfield.sendKeys(Keys.chord(Keys.META, "a"));
        summaryfield.sendKeys(Keys.BACK_SPACE);
        summaryfield.sendKeys("");
        clickElement(driver, SAVE_LOCATOR);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile/my-account";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        Thread.sleep(3000);
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }

    public static void failededit2(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, MYACCOUNT_LOCATOR);
        WebElement usernameField = driver.findElement(By.xpath(USERNAME_LOCATOR));
        usernameField.sendKeys(Keys.chord(Keys.META, "a"));
        usernameField.sendKeys(Keys.BACK_SPACE);
        usernameField.sendKeys("");
        clickElement(driver, YEAR_LOCATOR);
        WebElement yearField = driver.findElement(By.xpath(YEAR_LOCATOR));
        yearField.sendKeys(Keys.chord(Keys.META, "a"));
        yearField.sendKeys(Keys.BACK_SPACE);
        yearField.sendKeys("");
        clickElement(driver, TITLES_LOCATOR);
        WebElement titlesfield = driver.findElement(By.xpath(TITLES_LOCATOR));
        titlesfield.sendKeys(Keys.chord(Keys.META, "a"));
        titlesfield.sendKeys(Keys.BACK_SPACE);
        titlesfield.sendKeys("1");
        clickElement(driver, CITY_LOCATOR);
        WebElement cityfield = driver.findElement(By.xpath(CITY_LOCATOR));
        cityfield.sendKeys(Keys.chord(Keys.META, "q"));
        cityfield.sendKeys(Keys.BACK_SPACE);
        cityfield.sendKeys("");
        clickElement(driver, SUMMARY_LOCATOR);
        WebElement summaryfield = driver.findElement(By.xpath(SUMMARY_LOCATOR));
        summaryfield.sendKeys(Keys.chord(Keys.META, "a"));
        summaryfield.sendKeys(Keys.BACK_SPACE);
        summaryfield.sendKeys("");
        clickElement(driver, SAVE_LOCATOR);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile/my-account";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        Thread.sleep(3000);
        clickElement(driver, LINK_LOCATOR);
        clickElement(driver, LOGOUT_LOCATOR);
    }

    private static void fillForm(WebDriver driver, String email, String password) {
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PWD_LOCATOR, password);

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
