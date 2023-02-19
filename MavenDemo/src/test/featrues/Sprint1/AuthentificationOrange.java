package Sprint1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AuthentificationOrange {

	WebDriver driver;
	
	@Given("Ouvrir l URL de l application")
	public void ouvrir_l_url_de_l_application() {
		// chemin web driver chrome
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouvrir chrome
		driver = new ChromeDriver();

		// option supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir l'URL de l'app
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				

	}

	@When("Saisir Login")
	public void saisir_login() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@And("Saisir mot de passe")
	public void saisir_mot_de_passe() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Ouvrir page d acceuil")
	public void ouvrir_page_d_acceuil() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
