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
    private WebDriver driver ;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        //Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
        driver = new ChromeDriver(options);
        //driver = new SafariDriver();
        //driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://devlinkfootweb.softylines.com/auth/jwt/login");
    }
    @Test(priority = 1)
    public void login() throws InterruptedException {
        Thread.sleep(500);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("varoxe6978@kernuo.com");
        email.click();
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345Aa@");
        password.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"light\"]/div/div/form/button"));
        login.click();
    }
    @Test(priority = 2)
    public void successPublishRecruitement() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='user-info']"))).click();
        Thread.sleep(2000);
        WebElement Recruitement = driver.findElement(By.xpath("//body/div[@id='root']/div[@id='light']/div[@class='main-layout my-profile-wrapper']/div[@class='main-layout-content ']/div[@class=' main-layout-outlet']/div[@class=' main-layout-container']/div[@class='my-profile-container']/div[@class='my-profile-section my-profile-section__user-events']/div[@class='club-event-container']/p[3]"));
        Recruitement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new recruitment']")).click();
        Thread.sleep(1000);
        WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
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
        Description.click();
        Thread.sleep(1000);
        WebElement playerposition = driver.findElement(By.cssSelector("input[type='search']"));
        playerposition.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='publish']")).click();
        Thread.sleep(2000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement Recruitement1 = driver.findElement(By.xpath("//p[@class='tryouts-list__nav-bar__title']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (Recruitement1.isDisplayed()) {
                System.out.println("La création du recrutement a été confirmée avec succès.");
            } else {
                System.out.println("Échec de la creation du recrutement. ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 3)
    public void failedPublishRecruitement() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Recruitement = driver.findElement(By.xpath("//a[normalize-space()='Recruitment']"));
        Recruitement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new recruitment']")).click();
        Thread.sleep(1000);
        WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
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
        Description.click();
//        Thread.sleep(1000);
//        WebElement playerposition = driver.findElement(By.cssSelector("input[type='search']"));
//        playerposition.click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='publish']")).click();
        Thread.sleep(2000);
        try {
            // Attendre que le message d'erreur soit visible (par exemple, un message d'erreur sous le formulaire)
            WebElement errorMessage = driver.findElement(By.xpath("//p[normalize-space()='required Positions']"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Erreur lors de la création du recrutement : " + errorMessage.getText());
            } else {
                System.out.println("Échec de la création du recrutement, mais aucun message d'erreur visible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur inattendue lors de la vérification de l'échec du recrutement.");
        }
    }
    @Test(priority = 4)
    public void failedPublishRecruitement1() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Recruitement = driver.findElement(By.xpath("//a[normalize-space()='Recruitment']"));
        Recruitement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new recruitment']")).click();
//        Thread.sleep(1000);
//        WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
//        Description.sendKeys("Responsabilités:\n" +
//                "Entraîner et conditionner le corps pour chaque match\n" +
//                "Exécuter les stratégies de jeu élaborées par le coach\n" +
//                "Faire preuve d'une grande précision et efficacité lors des actions de jeu\n" +
//                "Communiquer efficacement avec les autres membres de l'équipe pendant le match\n" +
//                "Agir rapidement et prendre des décisions importantes en temps réel\n" +
//                "Aider à la planification et à l'exécution des pratiques d'entraînement\n" +
//                "Maintenir une attitude professionnelle et positive à tout moment sur et hors du terrain\n" +
//                "Exigences:\n" +
//                "Expérience en tant que joueur de football professionnel ou semi-professionnel\n" +
//                "Connaissances techniques solides en termes de technique, tactique et stratégie de football\n" +
//                "Capacité à travailler en équipe et à communiquer clairement avec les autres membres de l'équipe\n" +
//                "Excellentes compétences physiques, y compris la vitesse, l'endurance et la force physique\n" +
//                "Compréhension des règles et des réglementations du football et capacité à suivre les directives de l'arbitre en toute circonstance\n" +
//                "Engagement envers l'excellence en tant que joueur et désir de continuellement améliorer votre jeu\n" +
//                "Capacité à gérer la pression et à faire face à l'adversité lors de situations de haut niveau\n" +
//                "Disponibilité pour l'entraînement régulier et pour voyager pour des matchs et des tournois professionnels");
//        Description.click();
        Thread.sleep(1000);
        WebElement playerposition = driver.findElement(By.cssSelector("input[type='search']"));
        playerposition.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='publish']")).click();
        Thread.sleep(2000);
        try {
            // Attendre que le message d'erreur soit visible (par exemple, un message d'erreur sous le formulaire)
            WebElement errorMessage = driver.findElement(By.xpath("//p[normalize-space()='required tryout description']"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Erreur lors de la création du recrutement : " + errorMessage.getText());
            } else {
                System.out.println("Échec de la création du recrutement, mais aucun message d'erreur visible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur inattendue lors de la vérification de l'échec du recrutement.");
        }
    }
    @Test(priority = 5)
    public void failedPublishRecruitement2() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Recruitement = driver.findElement(By.xpath("//a[normalize-space()='Recruitment']"));
        Recruitement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new recruitment']")).click();
//        Thread.sleep(1000);
//        WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
//        Description.sendKeys("Responsabilités:\n" +
//                "Entraîner et conditionner le corps pour chaque match\n" +
//                "Exécuter les stratégies de jeu élaborées par le coach\n" +
//                "Faire preuve d'une grande précision et efficacité lors des actions de jeu\n" +
//                "Communiquer efficacement avec les autres membres de l'équipe pendant le match\n" +
//                "Agir rapidement et prendre des décisions importantes en temps réel\n" +
//                "Aider à la planification et à l'exécution des pratiques d'entraînement\n" +
//                "Maintenir une attitude professionnelle et positive à tout moment sur et hors du terrain\n" +
//                "Exigences:\n" +
//                "Expérience en tant que joueur de football professionnel ou semi-professionnel\n" +
//                "Connaissances techniques solides en termes de technique, tactique et stratégie de football\n" +
//                "Capacité à travailler en équipe et à communiquer clairement avec les autres membres de l'équipe\n" +
//                "Excellentes compétences physiques, y compris la vitesse, l'endurance et la force physique\n" +
//                "Compréhension des règles et des réglementations du football et capacité à suivre les directives de l'arbitre en toute circonstance\n" +
//                "Engagement envers l'excellence en tant que joueur et désir de continuellement améliorer votre jeu\n" +
//                "Capacité à gérer la pression et à faire face à l'adversité lors de situations de haut niveau\n" +
//                "Disponibilité pour l'entraînement régulier et pour voyager pour des matchs et des tournois professionnels");
//        Description.click();
        Thread.sleep(1000);
//        WebElement playerposition = driver.findElement(By.cssSelector("input[type='search']"));
//        playerposition.click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")).click();
//        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='publish']")).click();
        Thread.sleep(2000);
        try {
            // Attendre que le message d'erreur soit visible (par exemple, un message d'erreur sous le formulaire)
            WebElement errorMessage = driver.findElement(By.xpath("//p[normalize-space()='required tryout description']"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Erreur lors de la création du recrutement : " + errorMessage.getText());
            } else {
                System.out.println("Échec de la création du recrutement, mais aucun message d'erreur visible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur inattendue lors de la vérification de l'échec du recrutement.");
        }
        try {
            // Attendre que le message d'erreur soit visible (par exemple, un message d'erreur sous le formulaire)
            WebElement errorMessage1 = driver.findElement(By.xpath("//p[normalize-space()='required Positions']"));
            if (errorMessage1.isDisplayed()) {
                System.out.println("Erreur lors de la création du recrutement : " + errorMessage1.getText());
            } else {
                System.out.println("Échec de la création du recrutement, mais aucun message d'erreur visible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur inattendue lors de la vérification de l'échec du recrutement.");
        }
    }
    @Test(priority = 6)
    public void failedPublishRecruitement3() throws InterruptedException {
        Thread.sleep(2000);
        WebElement Recruitement = driver.findElement(By.xpath("//a[normalize-space()='Recruitment']"));
        Recruitement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='create new recruitment']")).click();
        Thread.sleep(1000);
        WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Description']"));
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
        Description.click();
        Thread.sleep(1000);
        WebElement playerposition = driver.findElement(By.cssSelector("input[type='search']"));
        playerposition.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@title='GK']//div[@class='shared-async-select__option']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='cancel']")).click();
        Thread.sleep(2000);
        try {
            // Attendre que le résultat soit visible (par exemple, un message de confirmation)
            WebElement Recruitement1 = driver.findElement(By.xpath("//p[@class='recruitment-list__nav-bar__title']"));
            Thread.sleep(1000);
            // Vérifier que le message de succès est affiché
            if (Recruitement1.isDisplayed()) {
                System.out.println("La création du recrutement a été annulé avec succès.");
            } else {
                System.out.println("Succes de la creation du recrutement.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CreateRecruitement createRecruitement = new CreateRecruitement();

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.successPublishRecruitement();
        createRecruitement.tearDown(); // Ferme le navigateur après successsharepost

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.failedPublishRecruitement();
        createRecruitement.tearDown(); // Ferme le navigateur après successsharepost

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.failedPublishRecruitement1();
        createRecruitement.tearDown(); // Ferme le navigateur après successsharepost

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.failedPublishRecruitement2();
        createRecruitement.tearDown(); // Ferme le navigateur après successsharepost

        createRecruitement.setUp();
        createRecruitement.login();
        createRecruitement.failedPublishRecruitement3();
        createRecruitement.tearDown(); // Ferme le navigateur après successsharepost
    }
        @AfterClass
        public void tearDown() {
            driver.close();
            System.out.println("Test completed successfully");
        }
    }

