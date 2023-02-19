package Usecase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstProject {

	public static void main(String[] args) {
		
		String msg; 
		
		// chemin chrome
		
		System.setProperty("webdriver.chrome.driver", "src/test/ressources/chromedriver.exe");
		
		//afficher chrome
		WebDriver driver=new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//driver.get("https://www.youtube.com/");
		driver.navigate().to("https://www.youtube.com/");
		
		msg=driver.getTitle();
		System.out.println(msg);
	}

}
