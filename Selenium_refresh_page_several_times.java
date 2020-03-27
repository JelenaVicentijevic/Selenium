/*
Dodatni neobavezni zadatak Selenium
Pomocu jave i seleniuma otvoriti pretrazivac i otici na Youtube. 
Pet puta kliknuti na dugme refresh, i tek onda zatvoriti pretrazivac. 
 */



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_refresh_page_several_times_in_two_ways {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		// prva varijanta sa koriscenjem elementa na web stranici
		wd.get("https://www.youtube.com/");
		Dimension targetSize1 = wd.manage().window().getSize();
		wd.manage().window().maximize();

		for (int i = 0; i < 5; i++) {
			wd.findElement(By.id("search-icon-legacy")).click();
		}
		wd.manage().window().setSize(targetSize1);

		// druga varijanta sa refresh-om pretrazivaca
		WebDriver wd2 = new ChromeDriver();
		wd2.get("https://www.youtube.com/");
		Dimension targetSize2 = wd2.manage().window().getSize();
		wd2.manage().window().maximize();
		for (int i = 0; i < 5; i++) {
			wd2.navigate().refresh();
		}
		wd2.manage().window().setSize(targetSize2);
		
		wd2.close();
		wd.close();
	}

}
