import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Personal {
    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String URL1 = "https://devlinkfootweb.softylines.com/profile";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PWD_LOCATOR = "//input[@id='password']";
    private static final String LOGIN_LOCATOR = "//button[normalize-space()='Login']";
    private static final String PERSONAL_LOCATOR = "//span[normalize-space()='Personal Information']";
    private static final String PERS_LOCATOR = "//div[@class='personal-info-container']//div[1]//div[1]//div[1]//img[1]";
    private static final String EMAILL_LOCATOR = "//input[@id='email']";
    private static final String CONFIRM_LOCATOR = "//button[normalize-space()='Confirm']";
    private static final String SAVE_LOCATOR = "//button[normalize-space()='Confirmer']";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            successfulEdit(driver);
            Thread.sleep(2000);
            failedEdit(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public static void successfulEdit(WebDriver driver) throws InterruptedException {
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
            return;
        }

        clickElement(driver, PERSONAL_LOCATOR);
        clickElement(driver, PERS_LOCATOR);
        WebElement emailElement = driver.findElement(By.xpath(EMAILL_LOCATOR));
        emailElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        emailElement.sendKeys("ahmedsdiri+259@takiacademyteam.com");
        clickElement(driver, CONFIRM_LOCATOR);

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://login.live.com/login.srf','_blank');");

        Iterator<String> windowIterator = driver.getWindowHandles().iterator();
        String mainWindow = windowIterator.next();
        String newTab = windowIterator.next();
        driver.switchTo().window(newTab);

        loginToEmail(driver);

        WebElement msg = driver.findElement(By.xpath("(//div[@class='XG5Jd TszOG'])[1]"));
        msg.click();
        Thread.sleep(3000);
        WebElement confirmationElement = driver.findElement(By.xpath("//p[1]"));
        String confirmationText = confirmationElement.getText();
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(confirmationText);
        String confirmationCode = null;
        if (matcher.find()) {
            confirmationCode = matcher.group();
            System.out.println("Confirmation code: " + confirmationCode);
        } else {
            System.out.println("No confirmation code found.");
        }

        if (confirmationCode != null) {
            driver.switchTo().window(mainWindow);
            WebElement confirmationInput = driver.findElement(By.xpath("(//input[@id='7296ebeb-1923-4889-8e97-34082f09a649-0'])[1]"));
            confirmationInput.sendKeys(confirmationCode);
            clickElement(driver, SAVE_LOCATOR);
        }
    }

    public static void failedEdit(WebDriver driver) throws InterruptedException {
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
            return;
        }

        clickElement(driver, PERSONAL_LOCATOR);
        clickElement(driver, PERS_LOCATOR);
        WebElement emailElement = driver.findElement(By.xpath(EMAILL_LOCATOR));
        emailElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        emailElement.sendKeys("ahmedsdiri+259@takiacademyteam.com");
        clickElement(driver, CONFIRM_LOCATOR);

        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://login.live.com/login.srf','_blank');");

        Iterator<String> windowIterator = driver.getWindowHandles().iterator();
        String mainWindow = windowIterator.next();
        String newTab = windowIterator.next();
        driver.switchTo().window(newTab);

        loginToEmail(driver);

        WebElement msg = driver.findElement(By.xpath("(//div[@class='XG5Jd TszOG'])[1]"));
        msg.click();
        Thread.sleep(3000);
        WebElement confirmationElement = driver.findElement(By.xpath("//p[1]"));
        String confirmationText = confirmationElement.getText();
        Pattern pattern = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher = pattern.matcher(confirmationText);
        String confirmationCode = null;
        if (matcher.find()) {
            confirmationCode = matcher.group();
            System.out.println("Confirmation code: " + confirmationCode);
        } else {
            System.out.println("No confirmation code found.");
        }

        if (confirmationCode != null) {
            driver.switchTo().window(mainWindow);
            WebElement confirmationInput = driver.findElement(By.xpath("(//input[@id='7296ebeb-1923-4889-8e97-34082f09a649-0'])[1]"));
            confirmationInput.sendKeys(confirmationCode);
            clickElement(driver, SAVE_LOCATOR);
        }
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

    private static void loginToEmail(WebDriver driver) throws InterruptedException {
        WebElement email1 = driver.findElement(By.xpath("(//input[@id='i0116'])[1]"));
        email1.sendKeys("ahmedsdiri@takiacademyteam.com");
        clickElement(driver, "(//input[@id='idSIButton9'])[1]");

        Thread.sleep(2000);
        WebElement psd = driver.findElement(By.xpath("(//input[@id='i0118'])[1]"));
        psd.sendKeys("Rux95633");
        clickElement(driver, "(//input[@id='idSIButton9'])[1]");

        Thread.sleep(2000);
        WebElement dontShow = driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']"));
        dontShow.click();
        clickElement(driver, "(//input[@id='idSIButton9'])[1]");
    }
}

