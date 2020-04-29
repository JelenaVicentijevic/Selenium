/*
	Pomocu jave i selenijuma
	1) otici na sajt youtube
	2) u search-u pronaci Rick Astley i pustiti pesmu Never gonna give you up
	// voditi racuna da ako postoje reklame da ih preskocite

	Dodatni zadatak
	Nakon sto je pustena pesma, iz liste sa desne strane (watch next) pustiti drugi predlozen video
	*/

package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Youtube_Song {
	private static final String URL = "https://www.youtube.com/";
	private static final String SEARCH_XPATH = "//input[@id='search']";
	private static final String SEARCH_BTN_XPATH = "//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']";
	private static final String SONG_XPATH = "//yt-formatted-string[@class='style-scope ytd-video-renderer'][contains(text(),'Rick Astley - Never Gonna Give You Up (Video)')]";
	private static final String NEXT_BTN_XPATH = "//a[@class='ytp-next-button ytp-button']";
	public static final String SKIP_BTN_XPATH = "//span[@class='ytp-ad-skip-button-icon']";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		// go to youtube webpage
		wd.get(URL);

		// maximize window
		wd.manage().window().maximize();

		// input Rick Astley in search and click
		wd.findElement(By.xpath(SEARCH_XPATH)).sendKeys("Rick Astley");
		wd.findElement(By.xpath(SEARCH_BTN_XPATH)).click();

		// wait until song is visible then click
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wd.findElement(By.xpath(SONG_XPATH)).click();

		// if add appears skip it
		try {
			JavascriptExecutor executor = (JavascriptExecutor) wd;
			executor.executeScript("arguments[0].click();", wd.findElement(By.xpath(SKIP_BTN_XPATH)));
			System.out.println("Skip button clicked");

		} catch (NoSuchElementException ex) {
			System.out.println("Skip button not found");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// let song plays
		Thread.sleep(5000);

		// go to second song inf playlist
		for (int i = 0; i < 2; i++) {
			wd.findElement(By.xpath(NEXT_BTN_XPATH)).click();
			Thread.sleep(1000);
		}

		// quit driver
		wd.quit();
	}

}
