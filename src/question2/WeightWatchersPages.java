package question2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

import java.util.Calendar;
import java.util.List;

public class WeightWatchersPages extends BaseClass{


		private FindMeetingPage findAMeetingPage = new FindMeetingPage(driver);

		@FindBy(how = How.XPATH, using = "//*[@location= 'vm.location']//div[@class='location__top']")
		private WebElement locationInJoinPg;

		@FindBy(how = How.XPATH, using = "//*[@class= 'hours-list list-unstyled in collapse']")
		private WebElement allhours;

		public WeightWatchersPages(WebDriver driver) {
			super(driver);
			PageFactory.initElements(driver, this);
		}

		private List<WebElement> hoursByday(){
			return allhours.findElements(By.tagName("li"));
		}

		public WeightWatchersPages clickOnFirstResultAndVerifyName(){
			WebElement firstResult = findAMeetingPage.locationLists().get(0).findElement(By.xpath("//*[@class='location__top']"));
			//String name = firstResult.getText();
			String [] name = firstResult.getText().split("\\r?\\n");
			String cname = name[0];

			firstResult.click();
			waitForElement(locationInJoinPg);
			String locationinJoinPg = locationInJoinPg.getText();

			AssertJUnit.assertTrue(cname.equalsIgnoreCase(locationinJoinPg));
	        return new WeightWatchersPages(driver);
		}

		public void printTodaysHours(){
			Calendar calendar = Calendar.getInstance();
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			List<WebElement> sevenDaysWithhours = hoursByday();
			System.out.println("Today's Hours of Operation is: ");

			switch (day) {
				case Calendar.SUNDAY:
					System.out.println("Sunday. Hours:");
					gethoursText(sevenDaysWithhours.get(0));
	                break;
				case Calendar.MONDAY:
					System.out.println("Monday. Hours:");
					gethoursText(sevenDaysWithhours.get(1));
	                break;
				case Calendar.TUESDAY:
					System.out.println("Tuesday. Hours:");
					gethoursText(sevenDaysWithhours.get(2));
	                break;
				case Calendar.WEDNESDAY:
					System.out.println("Wednesday. Hours:");
					gethoursText(sevenDaysWithhours.get(3));
	                break;
				case Calendar.THURSDAY:
					System.out.println("Thursday. Hours:");
					gethoursText(sevenDaysWithhours.get(4));
	                break;
				case Calendar.FRIDAY:
					System.out.println("Friday. Hours:");
					gethoursText(sevenDaysWithhours.get(5));
	                break;
				case Calendar.SATURDAY:
					System.out.println("Saturday. Hours:");
					gethoursText(sevenDaysWithhours.get(6));
			}
		}

		private void gethoursText(WebElement element){
			System.out.println(element.findElement(By.className("hours-list-item-hours")).getText());
		}
	}
