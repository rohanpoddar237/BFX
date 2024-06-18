package Com.Bfx.testcase.Scheduler;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;

import Com.Bfx.POM.Scheduler.BfxPOMScheduler;

public class SchedulerTestcase extends Baseclass {

	BfxPOMScheduler Schedulers;
	
	/*
	 * @Test(description = "verify patient page") public void VerifySchedulerpage()
	 * throws Exception { Schedulers= new Bfx_POM_Scheduler(driver);
	 * Schedulers.clickOnScheduler(); }
	 */
	
	@Test(description = "verify Scheduler time")
	public void verifySchedulerbooktime() throws Exception {
		Schedulers= new BfxPOMScheduler();
		Schedulers.clickOnScheduler();
		
		Schedulers.clickOnSchedulerAppointment();
		Schedulers.clickOnSchedulerTIME();
		

	}
	


	
	
}
