package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class KeyBoardEvent {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		//ouvrir chrome
		WebDriver driver= new ChromeDriver();
		
		//supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir Url
		driver.navigate().to("https://demoqa.com/text-box");
		
		//identifier element 
		WebElement champs1= driver.findElement(By.id("currentAddress"));
		WebElement champs2= driver.findElement(By.id("permanentAddress"));
		
		champs1.sendKeys("120 rue d la marsa");
		
		//instatiation de la classe action
		Actions action= new Actions(driver);
		
		//selectionner
		action.keyDown(champs1, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		//copier
		action.keyUp(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		//coller
		action.sendKeys(champs2, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		
		Assert.assertEquals(champs1.getText(), champs2.getText());
		
		System.out.println("copier coller deja fait");
		
		driver.close();
	}

}
