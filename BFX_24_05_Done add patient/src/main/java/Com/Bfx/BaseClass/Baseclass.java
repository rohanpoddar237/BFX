package Com.Bfx.BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Com.Bfx.POM.Login.BfxLoginPage;

import Com.Bfx.Utilities.BfxUtlilities;

public class Baseclass  {
//To Access URL from the json file
public static String LoginPgTestDataPath= "src\\test\\resources\\TestData\\Loginpage\\LoginPage.json";

private static ExtentReports extent;
BfxLoginPage LoginPage;

private static ThreadLocal parentTest = new ThreadLocal();
private static ThreadLocal test = new ThreadLocal();

public static WebDriver driver;

	@BeforeMethod
	public void initialization() throws Exception {		
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","URL"));		
		LoginPage = new BfxLoginPage();
		LoginPage.enterCredentials(); 
		
	}
		
	/////////////////// For Extent Report/////////////////
	
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("ExtentReports.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReports.html");
		extent.attachReporter(htmlReporter);
	}
	
    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public synchronized void beforeMethod(Method method) {
        ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
        test.set(child);
    }
    
    @AfterMethod
    public synchronized void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE)
            ((ExtentTest) test.get()).fail(result.getThrowable());
        else if (result.getStatus() == ITestResult.SKIP)
            ((ExtentTest) test.get()).skip(result.getThrowable());
        else
            ((ExtentTest) test.get()).pass("Test passed");
        extent.flush();
    }
	
    public void FailedScreenshot(String testMethodName)
    {
    	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	Date d = new Date();
    	// Create a SimpleDateFormat object with the desired format (HH hours, mm minutes)
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    	// Format the date to generate the timestamp
    	String TimeStamp = dateFormat.format(d);  	
    	try {
			FileUtils.copyFile(srcFile, new File("./Screenshots/"+ testMethodName + "_" +TimeStamp+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // If test fails, take screenshot
        	FailedScreenshot(result.getMethod().getMethodName());
        }
        // Quit WebDriver or window
        
    //  driver.quit();
    }    
	
	
	//  @AfterMethod public void close() { driver.close(); driver.quit(); }
	  
	
}
