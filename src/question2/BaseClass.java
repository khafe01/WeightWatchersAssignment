package question2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.base.Function;


public class BaseClass
{
	protected WebDriver driver;
	private HomePage homePage;

	public BaseClass(WebDriver driver) {
		this.driver = driver;
	}

	public void delayFor(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException explicit) {

		}
	}

	public WebElement waitForElement(final WebElement element) {
		
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
				wait.withTimeout(30, TimeUnit.SECONDS);
				wait.pollingEvery(100, TimeUnit.MILLISECONDS);
				wait.ignoring(NoSuchElementException.class);

		WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				highlightElement(element);
				return element;
			}
		});
		return ele;
	}

	public void highlightElement(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: yellow; border: 2px solid red;");
			delayFor(200);
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	public HomePage homePage(){

		if(homePage == null){
			homePage = new HomePage(driver);
		}
		return homePage;
	}
}