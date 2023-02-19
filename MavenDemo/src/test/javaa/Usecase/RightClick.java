package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class RightClick {

	public static void main(String[] args) {
		// contextClick
		// chemin web driver chrome
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");

		// ouvrir chrome
		WebDriver driver = new ChromeDriver();

		// option supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// ouvrir URL
		driver.navigate().to("https://demoqa.com/buttons");

		// identifier les elements
		WebElement rightClick;

		// declarer web element
		rightClick = driver.findElement(By.id("rightClickBtn"));

		// instantiation de la classe action
		Actions action = new Actions(driver);

		// action sur element: double click
		action.contextClick(rightClick).perform();

		// identifier element
		WebElement verif;
		// declarer element
		verif = driver.findElement(By.id("rightClickMessage"));

		// prendre l'element dans un variable
		String msg;
		msg = verif.getText();

		// comparer result obtenu au resultat attendu
		Assert.assertEquals("You have done a right click", msg);

		driver.close();

	}

}
