package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDrop {

	public static void main(String[] args) {
		
		//chemin chrome driver 
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		//ouvrir web driver
		WebDriver navigateur = new ChromeDriver();
		
		//supp cookies et max fenetre
		navigateur.manage().deleteAllCookies();
		navigateur.manage().window().maximize();
		
		//implicity wait
		navigateur.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir navigateur
		navigateur.navigate().to("https://demoqa.com/droppable");
		
		//declarer les web elements
		WebElement from;
		WebElement to;
		
		from= navigateur.findElement(By.id("draggable"));
		to= navigateur.findElement(By.id("droppable"));
		
		//instanciation action
		Actions DragDrop= new Actions(navigateur);
		
		//Action drag and drop
		DragDrop.dragAndDrop(from, to).perform();
		
		//declarer msg
		String msg;
		msg=to.getText();
		
		Assert.assertEquals("Dropped!", msg);
		
		System.out.println("action drag and drop validee");
		navigateur.close();
		
		
		
		
		
	}
	

}
