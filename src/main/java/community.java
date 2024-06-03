import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
   //private static final String LEFT_LOCATOR = "//img[@alt='left-arrow']";
    private static final String SCROLL_LOCATOR = "//div[@class='swiper-slide swiper-slide-active']//div[@class='reel-info']";
    private static final String SCROLLLL_LOCATOR = "//div[@class='swiper-slide swiper-slide-active']//div[@class='reel-info']";
    private static final String VIDEO_LOCATOR = "//span[normalize-space()='joao cancelo']";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            community(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }

    public static void community(WebDriver driver) throws InterruptedException {
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

        WebElement scrollElement = driver.findElement(By.xpath(SCROLL_LOCATOR));
        scrollToElement(driver, scrollElement);

        WebElement videoElement = driver.findElement(By.xpath(SCROLLLL_LOCATOR));
        swipeToElement(driver, scrollElement, videoElement);

        Thread.sleep(200);
        clickElement(driver, SCROLLLL_LOCATOR);
        Thread.sleep(6000);

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

    private static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private static void swipeToElement(WebDriver driver, WebElement scrollElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        boolean isElementVisible = false;

        while (!isElementVisible) {
            try {
                if (targetElement.isDisplayed()) {
                    isElementVisible = true;
                } else {
                    throw new NoSuchElementException("Element not visible");
                }
            } catch (NoSuchElementException e) {
                actions.clickAndHold(scrollElement)
                        .moveByOffset(200, 0) // Adjust the offset value as needed
                        .release()
                        .perform();
                try {
                    Thread.sleep(500);  // Pause to let the swipe action complete
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
