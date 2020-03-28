/*
Pomocu jave i selenijuma
1) otici na sajt youtube
2) u search-u pronaci Rick Astley i pustiti pesmu Never gonna give you up
// voditi racuna da ako postoje reklame da ih preskocite

Dodatni zadatak
Nakon sto je pustena pesma, iz liste sa desne strane (watch next) pustiti drugi predlozen video
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak_1_0327 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver wd = new ChromeDriver();

		// go to youtube webapage
		wd.get("https://www.youtube.com/");
		
		// maximize window
		wd.manage().window().maximize();
		WebDriverWait wdw = new WebDriverWait(wd, 5);

		// wait until commercial add is visible and click on dismiss button
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//yt-formatted-string[@id='text'][@class='style-scope ytd-button-renderer style-text size-default']")))
				.click();

		// input Rick Astley in search and click
		wd.findElement(By.xpath("//input[@id='search']")).sendKeys("Rick Astley");
		wd.findElement(By.xpath("//button[@id='search-icon-legacy']//yt-icon[@class='style-scope ytd-searchbox']"))
				.click();

		// wait until song is visible then click
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//yt-formatted-string[@class='style-scope ytd-video-renderer'][contains(text(),'Rick Astley - Never Gonna Give You Up (Video)')]")))
				.click();

		// wait for second video in next songs list is visible then click
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//body/ytd-app/div[@id='content']/ytd-page-manager[@id='page-manager']/ytd-watch-flexy[@class='style-scope ytd-page-manager hide-skeleton']/div[@id='columns']/div[@id='secondary']/div[@id='secondary-inner']/div[@id='related']/ytd-watch-next-secondary-results-renderer[@class='style-scope ytd-watch-flexy']/div[@id='items']/ytd-compact-video-renderer[1]/div[1]/ytd-thumbnail[1]/a[1]/yt-img-shadow[1]/img[1]")))
				.click();

		// wait to possible add is display if add is display click to close it
		WebElement dismiss = wd.findElement(By.cssSelector("yt-formatted-string#text"));
	
		if (dismiss.isDisplayed())
			dismiss.click();
		wd.close();
	}
}