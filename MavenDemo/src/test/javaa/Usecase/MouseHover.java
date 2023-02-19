package Usecase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		// chemin driver
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		//ouvrir chrome
		WebDriver driver= new ChromeDriver();
		
		//supp cookies et max fenetre
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//implicity wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//ouvrir Url
		driver.navigate().to("https://demoqa.com/menu/");
		
		//identification element
		WebElement main1;
		main1= driver.findElement(By.xpath("//a[normalize-space()='Main Item 2']"));
		
		//initiation action
		Actions action=new Actions(driver);
		
		//action mouse hover
		action.moveToElement(main1).perform();
		
		//identification element
		WebElement main2;
		main2= driver.findElement(By.xpath("//a[normalize-space()='SUB SUB LIST »']"));
				
		//action mouse hover
		action.moveToElement(main2).perform();
				
		//identification element
		WebElement sub;
		sub= driver.findElement(By.xpath("//a[normalize-space()='Sub Sub Item 2']"));	
		
		//action mouse hover
		action.moveToElement(sub).perform(); 
		
		driver.close();

	}

}
