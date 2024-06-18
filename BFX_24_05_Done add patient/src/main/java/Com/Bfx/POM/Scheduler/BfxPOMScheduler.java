package Com.Bfx.POM.Scheduler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.BasePage;

public class BfxPOMScheduler extends BasePage {

	BasePage baseobj= new BasePage();

	
	final String Scheduler="/html/body/div/div[1]/div/div[1]/div/div/div/div/ul[2]/a/div";
	final String SchedulerBook="//div[@aria-label='11 May 2024']";
	final String Schedulertime="//div[@class='dhx_marked_timespan dhx_now_time']";
	
	
	@FindBy(xpath = Scheduler)
	WebElement Schedulerbtn;
	
	@FindBy(xpath = SchedulerBook)
	WebElement SchedulerBooktime;
	
	@FindBy(xpath = Schedulertime)
	WebElement SchedulerBookTime;
	

	@Test 
	public void clickOnScheduler() throws Exception {		
		Schedulerbtn.click();
	}
	
	@Test
	public void clickOnSchedulerAppointment() throws Exception {		
		SchedulerBooktime.click();
	}
	
	@Test
	public void clickOnSchedulerTIME() throws Exception {		
		SchedulerBookTime.click();
		
	}
	
  

	public WebDriver driver;
	public BfxPOMScheduler() {
		this.driver =  baseobj.driver;
	}
	
}
