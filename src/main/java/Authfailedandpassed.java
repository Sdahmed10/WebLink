import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Authfailedandpassed {

    public static void main(String[] args) {
        // Créer une instance du navigateur Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Attente implicite globale

        // Ouvrir la page de connexion
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");

        // Cas d'authentification avec succès
        authentificationAvecSucces(driver, "masori4915@ahieh.com", "12345Aa@");

        // Réinitialiser l'attente implicite
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Cas d'authentification avec échec
        authentificationAvecEchec(driver, "yihog598961@losvtn.com", "1234587");

        // Fermer le navigateur
        driver.quit();
    }

    public static void authentificationAvecSucces(WebDriver driver, String username, String password) {
        // Trouver le champ de saisie de nom d'utilisateur
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='email']"));
        // Saisir le nom d'utilisateur
        usernameField.sendKeys(username);

        // Trouver le champ de saisie de mot de passe
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        // Saisir le mot de passe
        passwordField.sendKeys(password);

        // Trouver le bouton de connexion
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        // Cliquer sur le bouton de connexion
        loginButton.click();

        // Vérifier si l'authentification a réussi en vérifiant la présence d'un élément sur la page suivante
        // par exemple, l'élément qui s'affiche après une connexion réussie
        WebElement successElement = driver.findElement(By.xpath("//img[@alt='linkefoot-logo']"));
        if (successElement.isDisplayed()) {
            System.out.println("Authentification avec succès !");
        } else {
            System.out.println("Échec de l'authentification !");
        }
        driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();

    }

    public static void authentificationAvecEchec(WebDriver driver, String username, String password) {
        // Trouver le champ de saisie de nom d'utilisateur
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='email']"));
        // Saisir le nom d'utilisateur
        usernameField.sendKeys(username);

        // Trouver le champ de saisie de mot de passe
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        // Saisir le mot de passe
        passwordField.sendKeys(password);

        // Trouver le bouton de connexion
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        // Cliquer sur le bouton de connexion
        loginButton.click();

        // Vérifier si l'authentification a échoué en vérifiant la présence d'un message d'erreur sur la page de connexion
        try {
            WebElement errorElement = driver.findElement(By.xpath("//p[@class=' error-message']"));
            if (errorElement.isDisplayed()) {
                System.out.println("Authentification avec échec !");
            }
        } catch (Exception e) {
            System.out.println("L'authentification a réussi, alors qu'elle aurait dû échouer !");
        }
    }
}
