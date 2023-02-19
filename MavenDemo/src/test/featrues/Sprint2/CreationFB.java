package Sprint2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreationFB {
	
	WebDriver driver;
	
	@Given("Ouvrir le navigateur")
	public void ouvrir_le_navigateur() {
		// chemin web driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
				
		//ouvrir chrome driver
		driver= new ChromeDriver();
				
		//supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
				
		//implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	    
	}

	@And("Ouvrir l URL")
	public void ouvrir_l_url() {
		//ouvrir navigateur
	    driver.navigate().to("https://www.facebook.com/");
	}

	@Given("Cliquer sur le bouton Creer un  compte")
	public void cliquer_sur_le_bouton_creer_un_compte() {
		//Identifier les élements
	  	WebElement creer;
	  	creer=driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
	  	creer.click(); 
	}

	@When("Saisir le nom")
	public void saisir_le_nom() {
		WebElement nom= driver.findElement(By.name("lastname"));
		nom.sendKeys("Thabet");
	}

	@And("Saisir le prenom")
	public void saisir_le_prenom() {
		WebElement prenom= driver.findElement(By.name("firstname"));
		prenom.sendKeys("Amal");
	    
	}

	@And("Saisir l email")
	public void saisir_l_email() {
	    WebElement email= driver.findElement(By.name("reg_email__"));
	    email.sendKeys("Amal@gmail.com");
	}

	@And("Saisir l email confirme")
	public void saisir_l_email_confirme() {
	    WebElement emailConfirme= driver.findElement(By.name("reg_email_confirmation__"));
	    emailConfirme.sendKeys("Amal@gmail.com");
	}

	@And("Saisir le password")
	public void saisir_le_password() {
	    WebElement password= driver.findElement(By.id("password_step_input")); 
	    password.sendKeys("Amal123");
	}

	@And("Saisir la date de naissance")
	public void saisir_la_date_de_naissance() {
		WebElement listeJ=driver.findElement(By.id("day"));
	  	WebElement listeM=driver.findElement(By.id("month"));
	  	WebElement listeA=driver.findElement(By.id("year"));
	  	
	    //appel classe select
	  	Select selectJ= new Select(listeJ);
	  	selectJ.selectByValue("3");
	  	
	  	Select selectM= new Select(listeM);
	  	selectM.selectByValue("7");
	  	
	  	Select selectA= new Select(listeA);
	  	selectA.selectByValue("1996");
	}

	@And("Selectionner le genre")
	public void selectionner_le_genre() {
		WebElement radio1=driver.findElement(By.xpath("//label[normalize-space()='Femme']"));
	  	radio1.click();
	}

	@And("Cliquer sur le bouton Inscription")
	public void cliquer_sur_le_bouton_inscription() {
		WebElement Inscription= driver.findElement(By.xpath("//button[@name='websubmit']"));
		Inscription.click();
	}

	@Then("Compte cree")
	public void compte_cree() {
		WebElement verif=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]/div/div[2]/h2")); //selecterhub
	    String message=verif.getText();
	    
	    Assert.assertEquals("Entrez le code de votre e-mail", message);
	    System.out.println("Inscription validee");
	    //driver.close();
	    
	}

}
