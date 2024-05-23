import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forget {
    public static void main(String[] args) throws Exception {
        ScreenRecorderUtil.startRecord("main");
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Navigate to "Forgot password" page
        driver.findElement(By.xpath("//span[normalize-space()='Forgot password ?']")).click();
        Thread.sleep(5000);

        // Enter email for password reset
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("ahmedsdiri+16@takiacademyteam.com");
        email.click();
        driver.findElement(By.xpath("//button[normalize-space()='Next']")).click();
        Thread.sleep(3000);

        // Click on confirmation card (adjust this as needed based on your page's structure)
        driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='auth-main-layout']/div[@class='confirmation-account-container auth-main-container']/div[@class=' confirmation-cards']/div[2]")).click();

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]")));
            WebElement confirmationInput = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"));
            confirmationInput.sendKeys(confirmationCode);
            WebElement ok = driver.findElement(By.xpath("//button[normalize-space()='Next']"));
            ok.click();
            WebElement motdepasse = driver.findElement(By.xpath("//input[@id='password']"));
            motdepasse.sendKeys("123456Aa@");
            WebElement confirmmotdepasse = driver.findElement(By.xpath("//input[@id='confirmPassword']"));
            confirmmotdepasse.sendKeys("123456Aa@");
            Thread.sleep(2000);
            WebElement OK = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
            OK.click();
            try {
                System.out.println("Réinitialisation du mot de passe réussie !");
            } catch (Exception e) {
                System.out.println("Échec de la réinitialisation du mot de passe : " + e.getMessage());
            } finally {
                Thread.sleep(5000);
                ScreenRecorderUtil.stopRecord();
                driver.quit();
            }
        } else {
            driver.quit();
        }
    }
}
