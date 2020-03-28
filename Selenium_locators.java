/*
Koristeci Selenium webdriver otici na sajt https://www.techlistic.com/p/selenium-practice-form.html i 
popuniti formu (idealno celu, ako ne ide onda probajte bar do kontinenta)
Potrudite se da koristite vise lokatora za pronalazenje elemenata.
*/

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak_1_0326 {

	public static void main(String[] args) {
		System.setProperty("webriver.chrome.driver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		wd.get("https://www.techlistic.com/p/selenium-practice-form.html");

		wd.manage().window().maximize();

		// By.name
		wd.findElement(By.name("firstname")).sendKeys("Jelena");

		// By.xpath
		wd.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Vicentijevic");

		// By.id
		wd.findElement(By.id("sex-1")).click();

		// By.cssSelector
		wd.findElement(By.cssSelector("input#exp-0")).click();

		wd.findElement(By.cssSelector("input#datepicker")).sendKeys("27.03.2020.");

		// By.name
		List<WebElement> checkbox = wd.findElements(By.name("profession"));
		for (int i = 0; i < checkbox.size(); i++) {
			checkbox.get(i).click();
		}

		// By.id
		wd.findElement(By.id("tool-2")).click();

		// By.className
		wd.findElement(By.className("input-xlarge")).sendKeys("Europe");

		Select seleniumCommands = new Select(wd.findElement(By.id("selenium_commands")));

		seleniumCommands.selectByVisibleText("WebElement Commands");
		// seleniumCommands.selectByIndex(0);

		wd.findElement(By.name("photo")).sendKeys("C:\\Users\\WIN10\\Desktop\\test.png");

		// By.linkText
		wd.findElement(By.linkText("Click here to Download File")).click();
		wd.navigate().back();

		timeWait();

		// By.xpath
		wd.findElement(By.xpath("//button[@id='submit']")).click();

		timeWait();

		wd.close();

	}

	public static void timeWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
