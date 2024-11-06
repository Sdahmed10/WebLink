import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateRecruitement {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 1);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }

    @Test(priority = 1)
    public void login() {
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("spontaneous.tuna.dpai@flashpost.net");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("12345Aa@");

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"light\"]/div/div/form/button")));
        login.click();
    }

    @Test(priority = 2)
    public void successPublishRecruitement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();

        WebElement Recruitement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[3]")));
        Recruitement.click();


        WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        Description.sendKeys("Responsabilités:\n" +
                "Entraîner et conditionner le corps pour chaque match\n" +
                "Exécuter les stratégies de jeu élaborées par le coach\n" +
                "Faire preuve d'une grande précision et efficacité lors des actions de jeu\n" +
                "Communiquer efficacement avec les autres membres de l'équipe pendant le match\n" +
                "Agir rapidement et prendre des décisions importantes en temps réel\n" +
                "Aider à la planification et à l'exécution des pratiques d'entraînement\n" +
                "Maintenir une attitude professionnelle et positive à tout moment sur et hors du terrain\n" +
                "Exigences:\n" +
                "Expérience en tant que joueur de football professionnel ou semi-professionnel\n" +
                "Connaissances techniques solides en termes de technique, tactique et stratégie de football\n" +
                "Capacité à travailler en équipe et à communiquer clairement avec les autres membres de l'équipe\n" +
                "Excellentes compétences physiques, y compris la vitesse, l'endurance et la force physique\n" +
                "Compréhension des règles et des réglementations du football et capacité à suivre les directives de l'arbitre en toute circonstance\n" +
                "Engagement envers l'excellence en tant que joueur et désir de continuellement améliorer votre jeu\n" +
                "Capacité à gérer la pression et à faire face à l'adversité lors de situations de haut niveau\n" +
                "Disponibilité pour l'entraînement régulier et pour voyager pour des matchs et des tournois professionnels");


        WebElement playerposition = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout ']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='tryout-create__content']/form[@class='shared-form']/div[@class='shared-form']/div[2]/div[1]/div[1]")));
        playerposition.click();

        WebElement positionOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")));
        positionOption.click();

        WebElement publishButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='publish']")));
        publishButton.click();

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='tryouts-list__nav-bar__title']")));
        System.out.println("La création du recrutement a été confirmée avec succès: " + successMessage.isDisplayed());
    }

    @Test(priority = 3)
    public void failedPublishRecruitement() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();

        WebElement Recruitement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[3]")));
        Recruitement.click();

        WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@placeholder='Description']")));
        Description.sendKeys("Responsabilités:\n" +
                "Entraîner et conditionner le corps pour chaque match\n" +
                "Exécuter les stratégies de jeu élaborées par le coach\n" +
                "Faire preuve d'une grande précision et efficacité lors des actions de jeu\n" +
                "Communiquer efficacement avec les autres membres de l'équipe pendant le match\n" +
                "Agir rapidement et prendre des décisions importantes en temps réel\n" +
                "Aider à la planification et à l'exécution des pratiques d'entraînement\n" +
                "Maintenir une attitude professionnelle et positive à tout moment sur et hors du terrain\n" +
                "Exigences:\n" +
                "Expérience en tant que joueur de football professionnel ou semi-professionnel\n" +
                "Connaissances techniques solides en termes de technique, tactique et stratégie de football\n" +
                "Capacité à travailler en équipe et à communiquer clairement avec les autres membres de l'équipe\n" +
                "Excellentes compétences physiques, y compris la vitesse, l'endurance et la force physique\n" +
                "Compréhension des règles et des réglementations du football et capacité à suivre les directives de l'arbitre en toute circonstance\n" +
                "Engagement envers l'excellence en tant que joueur et désir de continuellement améliorer votre jeu\n" +
                "Capacité à gérer la pression et à faire face à l'adversité lors de situations de haut niveau\n" +
                "Disponibilité pour l'entraînement régulier et pour voyager pour des matchs et des tournois professionnels");

        WebElement publishButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='publish']")));
        publishButton.click();

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='required Positions']")));
        System.out.println("Erreur lors de la création du recrutement : " + errorMessage.getText());
    }

    // Other failedPublishRecruitement methods would follow the same pattern...

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Test completed successfully");
    }

    public static void main(String[] args) {
        CreateRecruitement createRecruitement = new CreateRecruitement();
        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.successPublishRecruitement();
        createRecruitement.tearDown();

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.failedPublishRecruitement();
        createRecruitement.tearDown();
        // Repeat for other test methods...
    }
}
