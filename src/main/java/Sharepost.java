import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sharepost {
    private static final String URL_LOCATOR = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String Email_LOCATOR ="//input[@id='email']";
    private static final String Password_LOCATOR ="//input[@id='password']";
    private static final String Login_LOCATOR = "//button[normalize-space()='Login']";
    private static final String Community_LOCATOR ="//a[normalize-space()='Community']";
    private static final String share_LOCATOR = "//button[contains(@class,'share_button')]";
    private static final String media_LOCATOR ="//input[@value='1']";
    private static final String next_LOCATOR ="//button[normalize-space()='Suivant']";
    private static final String Add_LOCATOR = "//img[@alt='upload-icon']";
    private static final String Next_LOCATOR ="//button[@type='submit']";


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        try {
            successfulshare(driver);
            Thread.sleep(2000);
            //failedshare(driver);
            //Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //driver.quit();
        }
    }

    public static void successfulshare (WebDriver driver) throws InterruptedException {
        driver.get(URL_LOCATOR);
        fillForm(driver, "mikesif797@exeneli.com", "12345Aa@");
        clickElement(driver, Login_LOCATOR);
        Thread.sleep(3000);
        clickElement(driver, Community_LOCATOR);
        Thread.sleep(4000);
        clickElement(driver, share_LOCATOR);
        clickElement(driver, media_LOCATOR);
        clickElement(driver, next_LOCATOR);
        WebElement inputField = driver.findElement(By.xpath("//div[contains(@class,'upload-photo-item')]"));
        inputField.click();
        inputField.sendKeys("/Users/takiacademy/Desktop/AdobeStock_275812837.jpeg");



    }
    private static void clickElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        try {
            element.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
    private static void fillForm(WebDriver driver, String email, String password) {
        setInputValue(driver, Email_LOCATOR, email);
        setInputValue(driver, Password_LOCATOR, password);

    }
    private static void setInputValue(WebDriver driver, String locator, String value) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
        element.click();
    }


}
