package question2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

	@FindBy(how=How.ID, using = "ela-menu-visitor-desktop-supplementa_find-a-meeting")
	private WebElement findaMeetingIcon;

	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public HomePage clickOnFindaMeetingIcon(){
		waitForElement(findaMeetingIcon);
		highlightElement(findaMeetingIcon);
		findaMeetingIcon.click();
        return new HomePage(driver);
	}
	
	public HomePage verifyPageTitle(String expected){
		String actual = driver.getTitle();
		org.testng.Assert.assertEquals(expected, actual);
        return new HomePage(driver);
	}

	public FindMeetingPage verifyPageTitleContains(String expected){
		String actual = driver.getTitle();
		org.testng.Assert.assertTrue(actual.contains(expected));
        return new FindMeetingPage(driver);
	}
	

}
