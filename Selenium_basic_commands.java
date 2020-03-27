/*
Pomocu jave i seleniuma
1)	Otvoriti novi prozor u pretrazivacu i otici na IT Bootcamp
2)	Primeniti metode koje smo vezbali na casu (get URL i Title, navigate - refresh, to, back, forward) 
3)	U kodu treba da se prozor maksimizuje, a pre zatvaranja drajvera vrati na prvobitnu velicinu 
*/

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_basic_commands {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		wd.get("https://itbootcamp.rs/");
		Dimension targetSize = wd.manage().window().getSize();
		wd.manage().window().maximize();

		wd.navigate().to("https://itbootcamp.rs/course/testiranje-softvera/");
		String trenutniURL = wd.getCurrentUrl();
		String naslov = wd.getTitle();
		int duzinanaslova = wd.getTitle().length();
		System.out.println("Trenutna web stranica je " + trenutniURL + ".");
		System.out.println("Trenutni naslov je " + naslov + ".");
		System.out.println("Duzina trenutnog naslova je " + duzinanaslova + " karaktera sa razmacima.");
		wd.navigate().back();

		wd.navigate().forward();
		String url = "https://itbootcamp.rs/course/razvoj-veb-stranica/";
		wd.navigate().to(url);
		trenutniURL = wd.getCurrentUrl();
		naslov = wd.getTitle();
		duzinanaslova = wd.getTitle().length();
		System.out.println("Trenutna web stranica je " + trenutniURL + ".");
		System.out.println("Trenutni naslov je " + naslov + ".");
		System.out.println("Duzina trenutnog naslova je " + duzinanaslova + " karaktera sa razmacima.");

		wd.navigate().back();
		wd.manage().window().setSize(targetSize);
		wd.navigate().refresh();

		wd.close();
	}

}
