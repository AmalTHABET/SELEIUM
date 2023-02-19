package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Authentification {

	public static void main(String[] args) throws InterruptedException {
		
		
		// chemin chrome driver
		System.setProperty("webdriver.chrome.driver","src/test/ressources/chromedriver.exe");
		
		//ouvrir un chrome driver
		WebDriver driver= new ChromeDriver();
		
		//option supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		
		//implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//ouvrir l'URL de l'app
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Identifier les élements
		WebElement Username;
		WebElement Password;
		WebElement Bouton;
		
		//declarer le web element zone de text 
		Username=driver.findElement(By.name("username"));
		Password=driver.findElement(By.name("password"));
		Bouton=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		
		//action des element: ecrire login et mp
		Username.sendKeys("Admin");
		Password.sendKeys("admin123");
		Bouton.click();
		
		//Verification de resultat: prendre un element du page pour verifier le resultat
		WebElement profil;
		profil=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span"));
		
		//declarer variable pour avoir resultat
		String message;
		
		//resultat dans le variable
		message=profil.getText();
		System.out.println(message);
		
		//comparer resultat obtenu au resultat attendu
		Assert.assertEquals("Paul Collings", message);
		
		System.out.println("Test OK");
		
		
		
		;

	}

}
