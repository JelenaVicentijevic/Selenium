/*
Koristeci selenijum, napravi screenshot web sajta po izboru.
Okaciti ovaj zadatak i kao .java (kod sa selenijumom) i sliku(screenshot).
*/

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_screenshot {

	public static void screenshot(WebDriver w) throws IOException  {

		TakesScreenshot screenShot = ((TakesScreenshot) w);
		File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\WIN10\\Desktop\\printscreen.png");
		FileUtils.copyFile(scrFile, destFile);
	}
	
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chromedriver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		wd.get("https://itbootcamp.rs/");
		wd.manage().window().maximize();
		wd.navigate().to("https://itbootcamp.rs/course/testiranje-softvera/");
		
		screenshot(wd);
		
		wd.close();
	}

}
