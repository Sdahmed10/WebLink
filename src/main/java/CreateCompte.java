import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class CreateCompte {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
        // Clear all cookies
        driver.manage().deleteAllCookies();
        // Set implicit wait time for the WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        // Open the target website
        driver.get("https://staginglinkfoot.softylines.com/auth/jwt/login");

        // Creating multiple player accounts
        createPlayerAccount(driver, "John", "Doe", "john.doe", "Forward", "john.doe@example.com", "1234567890", "Password123");
        createPlayerAccount(driver, "Jane", "Smith", "jane.smith", "Midfielder", "jane.smith@example.com", "0987654321", "Password456");
        // Add more calls to createPlayerAccount as needed

        // Close the browser
        driver.quit();
    }

    public static void createPlayerAccount(WebDriver driver, String firstName, String lastName, String username, String position, String email, String phoneNumber, String password) {
        WebElement connect = driver.findElement(By.xpath("(//button[normalize-space()='Connexion'])[1]"));
        connect.click();
        driver.findElement(By.xpath("//span[normalize-space()='Utilisateurs']")).click();
        driver.findElement(By.xpath("(//div[contains(@class,'css-19bb58m')])[1]")).click();
        driver.findElement(By.id("react-select-4-option-2")).click();
        // Fill in first name
        WebElement firstNameField = driver.findElement(By.id("firstName")); // Replace with actual locator
        firstNameField.clear();
        firstNameField.sendKeys(firstName);

        // Fill in last name
        WebElement lastNameField = driver.findElement(By.id("lastName")); // Replace with actual locator
        lastNameField.clear();
        lastNameField.sendKeys(lastName);

        // Fill in username
        WebElement usernameField = driver.findElement(By.id("username")); // Replace with actual locator
        usernameField.clear();
        usernameField.sendKeys(username);

        // Select position from dropdown
        WebElement positionDropdown = driver.findElement(By.id("position")); // Replace with actual locator
        positionDropdown.click();
        WebElement positionOption = driver.findElement(By.xpath("//option[@value='" + position + "']")); // Replace with actual locator
        positionOption.click();

        // Fill in email
        WebElement emailField = driver.findElement(By.id("email")); // Replace with actual locator
        emailField.clear();
        emailField.sendKeys(email);

        // Fill in phone number
        WebElement phoneNumberField = driver.findElement(By.id("phoneNumber")); // Replace with actual locator
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);

        // Fill in password
        WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual locator
        passwordField.clear();
        passwordField.sendKeys(password);

        // Click on the 'Create' button
        WebElement createButton = driver.findElement(By.id("createButton")); // Replace with actual locator
        createButton.click();

        // Add a wait or verification step to ensure the account creation is processed before moving to the next one
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
