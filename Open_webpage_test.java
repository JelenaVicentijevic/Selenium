/*
Napraviti testNG klasu koja ce testirati da li se zeljena web stranica otvorila. 
Proveru izvrsiti na osnovu Title-a.
*/
package domaci_0316;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Open_webpage_test {

	/*
	 * razumem da je ovaj zadatak mogao da se odradi sa par linija koda u jednoj
	 * metodi sa @Test anotacijom i samo sa hard assert-om (i da bi za ovaj zahtev to bilo
	 * najefikasnije), ali ja sam testirala otvaranje webstranice na dva nacina tj.
	 * sa 2@Test metode samo kako bih proverila i hard i soft assert i ispratila
	 * redosled izvrsavanja metoda u odnosu na njihove nazive i anotacije u TestNG
	 * report-u
	*/

	private WebDriver wd;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		wd = new ChromeDriver();
	}

	@AfterMethod
	public void closeBrowser() {
		wd.close();
	}

	@Test
	public void testWebpageOpening2() {
		wd.get("https://itbootcamp.rs/vesti-2/");

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(wd.getTitle(), "Vesti - ITBootcamp");
		sa.assertAll();
	}

	@Test
	public void testWebpageOpening1() {
		wd.get("https://itbootcamp.rs/vesti-2/");

		Assert.assertEquals(wd.getTitle(), "Vesti - ITBootcamp");
	}

}
