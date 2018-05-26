package testList;
import org.testng.annotations.Test;

public class ExecuteTest extends TestBase{

	

	    @Test
	    public void WWProject(){
	        baseClass().homePage().verifyPageTitle("Weight Loss Program, Recipes & Help | Weight Watchers")
	                .clickOnFindaMeetingIcon()
	                .verifyPageTitleContains("Get Schedules & Times Near You")
	                .enterZipCodeInSearchBox("10011")
	                .printTitleAndDistanceFromFirstResult()
	                .clickOnFirstResultAndVerifyName()
	                .printTodaysHours();
	    }
	}

