package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreationCompte {

	public static void main(String[] args) {
		
		// chemin web driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		//ouvrir chrome driver
		WebDriver driver= new ChromeDriver();
		
		//supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir navigateur
	    driver.navigate().to("https://www.facebook.com/");
	    
	    //Identifier les élements
	  	WebElement creer;
	  	creer=driver.findElement(By.xpath("//a[normalize-space()='Créer nouveau compte']"));
	  	creer.click();
	  	
	  	//assert
	  	
	  	//declarer element
	  	WebElement prenom;
	  	WebElement nom;
	  	WebElement email;
	  	WebElement emailConfirme;
	  	WebElement password; 
	  	WebElement Inscription; 
	  	
	    prenom= driver.findElement(By.name("firstname"));
	  	nom= driver.findElement(By.name("lastname"));
	  	email= driver.findElement(By.name("reg_email__"));
	  	emailConfirme= driver.findElement(By.name("reg_email_confirmation__"));
	  	password= driver.findElement(By.id("password_step_input"));
	  	Inscription= driver.findElement(By.xpath("//button[@name='websubmit']"));
	  	
	  	WebElement listeJ=driver.findElement(By.id("day"));
	  	WebElement listeM=driver.findElement(By.id("month"));
	  	WebElement listeA=driver.findElement(By.id("year"));
	  	
	  	
	  	prenom.sendKeys("Amal");
	  	nom.sendKeys("Thabet");
	  	email.sendKeys("Amal@gmail.com");
	  	emailConfirme.sendKeys("Amal@gmail.com");
	  	password.sendKeys("Amal123");
	  	
	  	//appel classe select
	  	Select selectJ= new Select(listeJ);
	  	selectJ.selectByValue("3");
	  	
	  	Select selectM= new Select(listeM);
	  	selectM.selectByValue("7");
	  	
	  	Select selectA= new Select(listeA);
	  	selectA.selectByValue("1996");
	  	
	  	//bouton radio 
	  	WebElement radio1=driver.findElement(By.xpath("//label[normalize-space()='Femme']"));
	  	radio1.click();
	  	
	  	Inscription.click();
	  	
	  	System.out.println("Inscription validee");

	  	
	  	
	  	
	  	
	  	
		
	}

}
