package Usecase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Recherche {

	public static void main(String[] args) throws InterruptedException {
		// chemin chrome driver
		System.setProperty("webdriver.chrome.driver","src/test/ressources/chromedriver.exe");
		
		//ouvrir un chrome driver
		WebDriver driver= new ChromeDriver();
		
		//option supp cookies
		driver.manage().deleteAllCookies();
		
		//option max page
		driver.manage().window().maximize();
		
		//ouvrir l'URL de l'app
		driver.navigate().to("https://www.google.com/");
		
		//sleep 5s
		Thread.sleep(5000);
		
		//Identifier les élements
		WebElement zoneText;
		WebElement bouton;
		
		//declarer le web element zone de text 
		zoneText= driver.findElement(By.name("q"));
		
		//déclarer le web element bouton 
		bouton= driver.findElement(By.name("btnK"));
		
		//action des element
		zoneText.sendKeys("Tunisie");
		// faire un espace
		zoneText.sendKeys(Keys.ENTER);
		//bouton.click();
		
		//Verification de resultat
		WebElement result;
		result= driver.findElement(By.id("result-stats"));
		
		String msg;
		msg= result.getText();
		Assert.assertTrue(msg.contains("résultats"));
		System.out.println("test ok");
		
		
		
		
		
		
		

	}

}
