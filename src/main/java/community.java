import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class community {
    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String URL1 = "https://devlinkfootweb.softylines.com/profile";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PWD_LOCATOR = "//input[@id='password']";
    private static final String LOGIN_LOCATOR = "//button[normalize-space()='Login']";
    private static final String PROFILE_LOCATOR = "//div[@class='user-info']";
    private static final String LEFT_LOCATOR = "//img[@alt='left-arrow']";
    private static final String SCROLL_LOCATOR = "//div[@class='swiper-slide swiper-slide-active']//div[@class='reel-info']";
    private static final String SCROLLL_LOCATOR = "//div[@class='swiper-slide swiper-slide-duplicate swiper-slide-active']//div[@class='reel-info']";
    private static final String VIDEO_LOCATOR = "//span[normalize-space()='joao cancelo']";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            communityy(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }

    public static void communityy(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, LOGIN_LOCATOR);
        Thread.sleep(3000);
        String actualURL = driver.getCurrentUrl();
        if (URL1.equals(actualURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + URL1);
            System.out.println("Actual URL: " + actualURL);
        }
        Thread.sleep(3000);
        clickElement(driver, PROFILE_LOCATOR);
        Thread.sleep(3000);
        WebElement scroll = driver.findElement(By.xpath(SCROLL_LOCATOR));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
        WebElement left = driver.findElement(By.xpath(LEFT_LOCATOR));
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            left.click();
            // Optionnel: Ajouter une petite pause entre les clics si nécessaire
            Thread.sleep(500);
    }
        clickElement(driver, SCROLLL_LOCATOR);
        Thread.sleep(2000);
        WebElement video = driver.findElement(By.xpath(VIDEO_LOCATOR));
        scrollToElement(driver, video);
        clickElement(driver, VIDEO_LOCATOR);
    }
    private static void fillForm(WebDriver driver, String email, String password) {
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PWD_LOCATOR, password);
    }

    private static void setInputValue(WebDriver driver, String locator, String value) {
        WebElement element = driver.findElement(By.xpath(locator));
        element.sendKeys(value);
    }

    private static void clickElement(WebDriver driver, String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
    private static void scrollToElement(WebDriver driver, WebElement video) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", video);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(video));
    }

}
