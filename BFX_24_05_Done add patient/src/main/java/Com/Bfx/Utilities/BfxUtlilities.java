package Com.Bfx.Utilities;

import java.io.FileReader;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Bfx.BaseClass.BasePage;
import Com.Bfx.BaseClass.Baseclass;

public class BfxUtlilities extends Baseclass{

	
	public static String getStringDataFromJsonArray(String filePath,String arraykey,String key) throws Exception {
		JSONParser jsonParser=new JSONParser();
		FileReader fileReader=new FileReader(filePath);
		Object object = jsonParser.parse(fileReader);
		JSONObject jsonObject=(JSONObject)object;
		JSONArray jarray=(JSONArray)jsonObject.get(arraykey);
		String getValue="";
		for(int i=0;i<1;i++)
		{
			JSONObject jso=(JSONObject)jarray.get(0);
			String getTestData=(String)jso.get(key);
			getValue=getTestData;
		}
		return getValue;
	}
	
	public static void clickOnElementByJavaExecutor(WebElement element) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Thread.sleep(1000);
		jse.executeScript("arguments[0].click()", element);
	}
	
	public static void implicitwait(Integer timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void waitForElement(WebElement element, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static String popupMessageText() {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	public static int getIntegerDataFromJsonArray(String filePath,String arraykey,String key) throws Exception {
		JSONParser jsonParser=new JSONParser();
		FileReader fileReader=new FileReader(filePath);
		Object object = jsonParser.parse(fileReader);
		JSONObject jsonObject=(JSONObject)object;
		JSONArray jarray=(JSONArray)jsonObject.get(arraykey);
		int getValue=0;
		for(int i=0;i<1;i++)
		{
			JSONObject jso=(JSONObject)jarray.get(0);
			String getTestData=(String)jso.get(key);
			int testData=Integer.parseInt(getTestData);
			getValue=testData;
		}
		
		return getValue;
	}
	public static void scrollDownToBottom(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static void clickOnElementByActionClass(WebElement element)
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	
	public static void scrollUPByActionsClass() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}
	

	public static void scrollByJavaExecutor() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
	}
	

	
	public static void selectTheOption(int index) throws InterruptedException {
		Actions actionOnGotoSetupSection=new Actions(driver);
		for(int i=1;i<=index;i++)
		{
			Thread.sleep(500);
			actionOnGotoSetupSection.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		Thread.sleep(500);
		actionOnGotoSetupSection.sendKeys(Keys.ENTER).build().perform();
	}
	
	public static void verifyPageTitle(String expectedText,WebElement pageTitleText) throws Exception{
		Thread.sleep(1000);
		String actualText=pageTitleText.getText();
		Assert.assertEquals(expectedText, actualText);
	}
	
	public static void clearText(WebElement element) throws InterruptedException
	{
		Actions ac=new Actions(driver);
		ac.keyDown(Keys.CONTROL)
	    .sendKeys("a")
	    .keyUp(Keys.CONTROL)
	    .sendKeys(Keys.BACK_SPACE)
	    .build()
	    .perform();
	}
	
	public static void clearTextByDelete(WebElement element) throws InterruptedException{
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}

	public static void waitForElementVisibility(String xpathElement, Duration timeOutInSeconds) {
		// TODO Auto-generated method stub
	    try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathElement)));
        } catch (Exception e) {
            // Handle any exceptions that might occur during waiting
            e.printStackTrace(); // You might want to log the exception instead of printing stack trace
        }
	}
	
}
