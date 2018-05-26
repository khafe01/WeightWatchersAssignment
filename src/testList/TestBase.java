package testList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import question2.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class TestBase {


	    protected WebDriver driver;
	    private BaseClass baseClass;

	    @BeforeClass
	    public void beforeclass() {
	       
		Reporter.log("======================Browser Session Started========================", true);
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.navigate().to("https://www.weightwatchers.com/us/");
	        driver.manage().window().maximize();
	        Reporter.log("=====================Application Started====================",true);
	    }

	    @BeforeMethod
	    public void beforMethod(){

	    }

	    @AfterMethod
	    public void afterMethod(){

	    }

	    @AfterClass
	    public void afterclass() {
	        driver.close();
	        driver.quit();
	    }

	    public BaseClass baseClass(){

	        if(baseClass == null){
	            baseClass = new BaseClass(driver);
	        }
	        return baseClass;
	    }
	}

