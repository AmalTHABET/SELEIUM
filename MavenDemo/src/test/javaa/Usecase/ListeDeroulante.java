package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListeDeroulante {

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
		driver.navigate().to("https://demoqa.com/select-menu");
		
		//declarer element
		WebElement Liste= driver.findElement(By.id("oldSelectMenu"));
		
		//appeler la classe Select
		Select select= new Select(Liste);
		
		//selectionner l'option
		select.selectByValue("7");
		
		
		System.out.println("couleur selectionne");

	}

}
