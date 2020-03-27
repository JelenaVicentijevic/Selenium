/*
Dodatni neobavezni zadatak
Nadji metodu kojom ces vratiti duzinu “naslova”, ne samo naslov
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_title_commands {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://itbootcamp.rs");
		String naslov = driver.getTitle();
		int duzinanaslova = driver.getTitle().length();
		driver.close();

		System.out.println("Naslov " + naslov + " ima " + duzinanaslova + " karaktera sa razmacima");

	}

}
