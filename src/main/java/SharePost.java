import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SharePost {
    private WebDriver driver;
    private WebDriverWait wait;


    public SharePost() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    public void login() throws InterruptedException {
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("varoxe6978@kernuo.com");
        email.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345Aa@");
        password.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        login.click();
    }

    public void scenario1sharepostsuccess() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Community']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'share_button')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Créer carte de score']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Suivant']")).click();
        Thread.sleep(1000);
        WebElement calendar = driver.findElement(By.xpath("//div[contains(@class,'ant-picker-input')]"));
        calendar.click();
        Thread.sleep(1000);
        WebElement calendarDate = driver.findElement(By.xpath("//td[contains(@title,'2024-07-10')]//div[contains(@class,'ant-picker-cell-inner')][normalize-space()='10']"));
        calendarDate.click();
        Thread.sleep(1000);
        WebElement score = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[2]/div/div/div[2]/img[2]"));
        int n = 5;
        for (int i = 0; i < n; i++) {
            score.click();
            Thread.sleep(500);
        }
        WebElement score1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[3]/div/div/div[2]/img[2]"));
        int n1 = 3;
        for (int i = 0; i < n1; i++) {
            score1.click();
            Thread.sleep(500);
        }
        WebElement buts = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[5]/div/div/div[2]/img[2]"));
        int n2 = 3;
        for (int i = 0; i < n2; i++) {
            buts.click();
            Thread.sleep(500);
        }
        WebElement assists = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[6]/div/div/div[2]/img[2]"));
        int n3 = 2;
        for (int i = 0; i < n3; i++) {
            assists.click();
            Thread.sleep(500);
        }
        Thread.sleep(2000);
        WebElement locator = driver.findElement(By.xpath("//span[normalize-space()='Ajouter un localisation du stade']"));
        locator.click();
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search an address']"));
        search.sendKeys("sousse,tunisie");
        search.click();
        Thread.sleep(2000);
        WebElement clickk = driver.findElement(By.xpath("//*[@id=\"636688316\"]/span"));
        clickk.click();
        driver.findElement(By.xpath("//button[normalize-space()='Sauvegarder la localisation']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        WebElement messageSucces = driver.findElement(By.xpath("//font[contains(text(),'post has been created successfully.')]"));
        if (messageSucces.isDisplayed()) {
            System.out.println("Partage effectué avec succès : " + messageSucces.getText());
        } else {
            System.out.println("Le partage n'a pas été effectué avec succès.");
        }
    }
    public void scenario2sharepostfailed() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Community']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(@class,'share_button')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[normalize-space()='Créer carte de score']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Suivant']")).click();
        Thread.sleep(1000);
        WebElement calendar = driver.findElement(By.xpath("//div[contains(@class,'ant-picker-input')]"));
        calendar.click();
        Thread.sleep(1000);
        WebElement calendarDate = driver.findElement(By.xpath("//td[contains(@title,'2024-07-10')]//div[contains(@class,'ant-picker-cell-inner')][normalize-space()='10']"));
        calendarDate.click();
        Thread.sleep(1000);
        WebElement score = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[2]/div/div/div[2]/img[2]"));
        int n = 1;
        for (int i = 0; i < n; i++) {
            score.click();
            Thread.sleep(500);
        }
        WebElement score1 = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[3]/div/div/div[2]/img[2]"));
        int n1 = 3;
        for (int i = 0; i < n1; i++) {
            score1.click();
            Thread.sleep(500);
        }
        WebElement buts = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[5]/div/div/div[2]/img[2]"));
        int n2 = 3;
        for (int i = 0; i < n2; i++) {
            buts.click();
            Thread.sleep(500);
        }
        WebElement assists = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div/div/form/div/div[6]/div/div/div[2]/img[2]"));
        int n3 = 2;
        for (int i = 0; i < n3; i++) {
            assists.click();
            Thread.sleep(500);
        }
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        SharePost sharePost = new SharePost();
        sharePost.login();
        // Appel du premier scénario
        sharePost.scenario1sharepostsuccess();
        // Appel du deuxième scénario
        sharePost.scenario2sharepostfailed();
    }
}
