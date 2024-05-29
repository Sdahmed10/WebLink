import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class personalcredentials {
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

    public static void main(String[] args) throws Exception {
        //ScreenRecorderUtil.startRecord("main");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        try {
            successfuledit(driver);
            Thread.sleep(2000);
            failededit(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ScreenRecorderUtil.stopRecord();
            driver.quit();
        }
    }

    public static void successfuledit(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, EMAIL_LOCATOR);
        clickElement(driver, PWD_LOCATOR);
        clickElement(driver, LOGIN_LOCATOR);
        Thread.sleep(2000);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        clickElement(driver, PERSONAL_LOCATOR);
        clickElement(driver, PERS_LOCATOR);
        WebElement Email = driver.findElement(By.xpath(EMAILL_LOCATOR));
        Email.sendKeys(Keys.chord(Keys.META, "a"));
        Email.sendKeys(Keys.BACK_SPACE);
        Email.sendKeys("ahmedsdiri+259@takiacademyteam.com");
        clickElement(driver, CONFIRM_LOCATOR);
        Thread.sleep(3000);
        // Open new tab to access email
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1713364904&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d2f19e8d9-4690-c6c7-5674-9e8cc4840d6d&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c','_blank');");
        // Switch to new tab
        Iterator<String> windowIterator = driver.getWindowHandles().iterator();
        String mainWindow = windowIterator.next();
        String newTab = windowIterator.next();
        driver.switchTo().window(newTab);
        // Log in to email account
        WebElement email1 = driver.findElement(By.xpath("(//input[@id='i0116'])[1]"));
        email1.sendKeys("ahmedsdiri@takiacademyteam.com");
        email1.click();
        WebElement next = driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
        next.click();
        WebElement psd = driver.findElement(By.xpath("(//input[@id='i0118'])[1]"));
        psd.sendKeys("Rux95633");
        psd.click();
        WebElement login = driver.findElement(By.xpath("(//input[@id='idSIButton9'])[1]"));
        login.click();
        WebElement dontshow = driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']"));
        dontshow.click();
        WebElement yes = driver.findElement(By.xpath("(//input[@id='idSIButton9'])[1]"));
        yes.click();
        Thread.sleep(3000);
        // Open email and extract confirmation code
        WebElement msg = driver.findElement(By.xpath("(//div[@class='XG5Jd TszOG'])[1]"));
        msg.click();
        Thread.sleep(3000);
        WebElement confirmationElement = driver.findElement(By.xpath("//p[1]"));
        Thread.sleep(2000);
        String confirmationText = confirmationElement.getText();
        Pattern pattern = Pattern.compile("\\b\\d{6}\\b");
        Matcher matcher = pattern.matcher(confirmationText);
        String confirmationCode = null;
        if (matcher.find()) {
            confirmationCode = matcher.group();
            System.out.println("Code de confirmation : " + confirmationCode);
        } else {
            System.out.println("Aucun code de confirmation trouvé.");
        }
        // If code found, switch back to main window and enter the code
        if (confirmationCode != null) {
            driver.switchTo().window(mainWindow);
            WebElement confirmationInput = driver.findElement(By.xpath("(//input[@id='7296ebeb-1923-4889-8e97-34082f09a649-0'])[1]"));
            confirmationInput.sendKeys(confirmationCode);
            clickElement(driver, SAVE_LOCATOR);
        }
    }
    public static void  failededit(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        fillForm(driver, "genox73126@grassdev.com", "12345Aa@");
        clickElement(driver, EMAIL_LOCATOR);
        clickElement(driver, PWD_LOCATOR);
        clickElement(driver, LOGIN_LOCATOR);
        String expectedURL = "https://devlinkfootweb.softylines.com/profile";
        // Compare the expected URL with the actual URL
        if (URL1.equals(expectedURL)) {
            System.out.println("URLs match. Test passed!");
        } else {
            System.out.println("URLs do not match. Test failed!");
            System.out.println("Expected URL: " + expectedURL);
            System.out.println("Actual URL: " + URL1);
        }
        Thread.sleep(3000);
        clickElement(driver, PERSONAL_LOCATOR);
        clickElement(driver, PERS_LOCATOR);
        WebElement Email = driver.findElement(By.xpath(EMAILL_LOCATOR));
        Email.sendKeys(Keys.chord(Keys.META, "a"));
        Email.sendKeys(Keys.BACK_SPACE);
        Email.sendKeys("ahmedsdiri+259@takiacademyteam.com");
        clickElement(driver, CONFIRM_LOCATOR);
        // Open new tab to access email
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1713364904&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d2f19e8d9-4690-c6c7-5674-9e8cc4840d6d&id=292841&aadredir=1&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c','_blank');");
        // Switch to new tab
        Iterator<String> windowIterator = driver.getWindowHandles().iterator();
        String mainWindow = windowIterator.next();
        String newTab = windowIterator.next();
        driver.switchTo().window(newTab);
        // Log in to email account
        WebElement email1 = driver.findElement(By.xpath("(//input[@id='i0116'])[1]"));
        email1.sendKeys("ahmedsdiri@takiacademyteam.com");
        email1.click();
        WebElement next = driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
        next.click();
        WebElement psd = driver.findElement(By.xpath("(//input[@id='i0118'])[1]"));
        psd.sendKeys("Rux95633");
        psd.click();
        WebElement login = driver.findElement(By.xpath("(//input[@id='idSIButton9'])[1]"));
        login.click();
        WebElement dontshow = driver.findElement(By.xpath("//input[@id='KmsiCheckboxField']"));
        dontshow.click();
        WebElement yes = driver.findElement(By.xpath("(//input[@id='idSIButton9'])[1]"));
        yes.click();
        Thread.sleep(3000);
        // Open email and extract confirmation code
        WebElement msg = driver.findElement(By.xpath("(//div[@class='XG5Jd TszOG'])[1]"));
        msg.click();
        Thread.sleep(3000);
        WebElement confirmationElement = driver.findElement(By.xpath("//p[1]"));
        Thread.sleep(2000);
        String confirmationText = confirmationElement.getText();
        Pattern pattern = Pattern.compile("\\b\\d{5}\\b");
        Matcher matcher = pattern.matcher(confirmationText);
        String confirmationCode = null;
        if (matcher.find()) {
            confirmationCode = matcher.group();
            System.out.println("Code de confirmation : " + confirmationCode);
        } else {
            System.out.println("Aucun code de confirmation trouvé.");
        }
        // If code found, switch back to main window and enter the code
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