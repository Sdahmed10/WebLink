import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Myaccounttestscases {
    private static final String URL = "https://devlinkfootweb.softylines.com/auth/jwt/register";
    private static final String URL1 = "https://devlinkfootweb.softylines.com/auth/jwt/login";
    private static final String NAME_LOCATOR = "//input[@id='name']";
    private static final String EMAIL_LOCATOR = "//input[@id='email']";
    private static final String PASSWORD_LOCATOR = "//input[@id='password']";
    private static final String CONFIRM_PASSWORD_LOCATOR = "//input[@id='confirmPassword']";
    private static final String PHONE_LOCATOR = "//input[@placeholder='1 (702) 123-4567']";
    private static final String ACCEPT_LOCATOR = "//input[@id='remember_me']";
    private static final String NEXT_LOCATOR = "//button[normalize-space()='Next']";
    private static final String ADRESSE_LOCATOR = "//input[@id='email']";
    private static final String PWD_LOCATOR = "//input[@id='password']";
    private static final String LOGIN_LOCATOR = "//button[normalize-space()='Login']";
    private static final String Email_LOCATOR = "//body/div[@id='root']/div[@id='light']/div[@class='auth-main-layout']/div[@class='confirmation-account-container auth-main-container']/div[@class=' confirmation-cards']/div[2]";
    private static final String Next_LOCATOR = "//button[normalize-space()='Next']";
    private static final String ACCOUNT_LOCATOR = "//span[normalize-space()='My Account']";
    private static final String YEAR_LOCATOR = "//input[@id='yearOfEstablishment']";
    private static final String SAVE_LOCATOR = "_LOCATOR";
    private static final String CITY_LOCATOR = "//input[@id='city']";
    private static final String SUMMARY_LOCATOR = "//textarea[@id='about']";
    private static final String NEXTT_LOCATOR = "//button[normalize-space()='Next']";
    private static final String VERIFIER_LOCATOR = "//button[normalize-space()='Vérifier']";
    private static final String ADD_LOCATOR = "(//span[@id='document-details'])[1]";

    public static void main(String[] args) throws Exception {
        //ScreenRecorderUtil.startRecord("main");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        try {
            successfulsign(driver);
            Thread.sleep(2000);
            successfuledit(driver);
            Thread.sleep(3000);
            failededit(driver);
            Thread.sleep(3000);
            failededit1(driver);
            Thread.sleep(3000);
            failededit2(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //ScreenRecorderUtil.stopRecord();
            driver.quit();
        }
    }

    public static void successfulsign(WebDriver driver) throws InterruptedException {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm(driver, "Nantes", "ahmedsdiri+209@takiacademyteam.com", "12345Aa@", "12345Aa@", "632145789");
        clickElement(driver, ACCEPT_LOCATOR);
        clickElement(driver, NEXT_LOCATOR);
        clickElement(driver, Email_LOCATOR);
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
        Thread.sleep(5000);
        // Open email and extract confirmation code
        WebElement msg = driver.findElement(By.xpath("(//div[@class='XG5Jd TszOG'])[1]"));
        msg.click();
        Thread.sleep(5000);
        WebElement confirmationElement = driver.findElement(By.xpath("//p[1]"));
        Thread.sleep(4000);
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
        Thread.sleep(5000);
        // If code found, switch back to main window and enter the code
        if (confirmationCode != null) {
            driver.switchTo().window(mainWindow);
            WebElement confirmationInput = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"));
            confirmationInput.sendKeys(confirmationCode);
            clickElement(driver, Next_LOCATOR);
            clickElement(driver, ADD_LOCATOR);
            // Téléchargez l'image

            Thread.sleep(5000);
            clickElement(driver, NEXTT_LOCATOR);
            Thread.sleep(5000);
            String newURL = "https://devlinkfoot.softylines.com/auth/jwt/login"; // Replace with the actual URL
            js.executeScript("window.open('" + newURL + "','_blank');");
            Set<String> windowHandles = driver.getWindowHandles();
            windowIterator = windowHandles.iterator();
            windowIterator.next(); // Skip main window
            windowIterator.next(); // Skip first new tab
            String anotherTab = windowIterator.next(); // Get new tab handle
            // Switch to new tab
            driver.switchTo().window(anotherTab);
            // Log in to email account
            WebElement emaill = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
            emaill.sendKeys(Keys.chord(Keys.META, "a"));
            emaill.sendKeys(Keys.BACK_SPACE);
            emaill.sendKeys("super@super.com");
            emaill.click();
            WebElement psd1 = driver.findElement(By.xpath("(//input[@id=':r1:'])[1]"));
            psd1.sendKeys(Keys.chord(Keys.META, "a"));
            psd1.sendKeys(Keys.BACK_SPACE);
            psd1.sendKeys("super123");
            psd1.click();
            Thread.sleep(2000);
            WebElement login1 = driver.findElement(By.xpath("(//button[normalize-space()='Connexion'])[1]"));
            login1.click();
            driver.findElement(By.xpath("//span[normalize-space()='Vérifications']")).click();
            WebElement confirmationElement1 = driver.findElement(By.xpath("//p[1]"));
            confirmationElement1.click();
            clickElement(driver, VERIFIER_LOCATOR);
            System.out.println("Successful signup");
            takeScreenshot(driver, "/Users/takiacademy/Documents/successful_signup.png");
        }
    }

    public static void successfuledit(WebDriver driver) {
        driver.get(URL1);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm1(driver, "ahmedsdiri+63@takiacademyteam.com", "12345Aa@", "1902", "Nante", "Test");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, ACCOUNT_LOCATOR);
        clickElement(driver, SAVE_LOCATOR);

    }

    public static void failededit(WebDriver driver) {
        driver.get(URL1);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm1(driver, "ahmedsdiri+63@takiacademyteam.com", "12345Aa@", "", "", "");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, ACCOUNT_LOCATOR);
        clickElement(driver, SAVE_LOCATOR);
    }

    public static void failededit1(WebDriver driver) {
        driver.get(URL1);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm1(driver, "ahmedsdiri+63@takiacademyteam.com", "12345Aa@", "1902", "", "");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, ACCOUNT_LOCATOR);
        clickElement(driver, SAVE_LOCATOR);
    }

    public static void failededit2(WebDriver driver) {
        driver.get(URL1);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        fillForm1(driver, "ahmedsdiri+63@takiacademyteam.com", "12345Aa@", "", "Nante", "");
        clickElement(driver, LOGIN_LOCATOR);
        clickElement(driver, ACCOUNT_LOCATOR);
        clickElement(driver, SAVE_LOCATOR);
    }

    private static void fillForm(WebDriver driver, String name, String email, String password, String confirmPassword, String phone) {
        setInputValue(driver, NAME_LOCATOR, name);
        setInputValue(driver, EMAIL_LOCATOR, email);
        setInputValue(driver, PASSWORD_LOCATOR, password);
        setInputValue(driver, CONFIRM_PASSWORD_LOCATOR, confirmPassword);
        setInputValue(driver, PHONE_LOCATOR, phone);
    }

    private static void fillForm1(WebDriver driver, String adresse, String Password, String year, String city, String summary) {
        setInputValue(driver, ADRESSE_LOCATOR, adresse);
        setInputValue(driver, PWD_LOCATOR, Password);
        setInputValue(driver, YEAR_LOCATOR, year);
        setInputValue(driver, CITY_LOCATOR, city);
        setInputValue(driver, SUMMARY_LOCATOR, summary);
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

    private static void switchToNewWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
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

