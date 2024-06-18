package Com.Bfx.POM.patient;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.BasePage;

import Com.Bfx.Utilities.BfxUtlilities;

public class BfxPatient extends BasePage {
	
	BasePage baseobj= new BasePage();


	final String Patient="//li[@data-testid='patients']//div[@role='button']";
	final String PatientList="//span[normalize-space()='Patients']";
	final String SearchBtn="(//button[normalize-space()='Search'])[1]";
	final String PatientName="//div[@data-testid='Name']//input[@id='standard-helperText']";
	final String PatientEmail="//div[@data-testid='EmailAddress']//input[@id='standard-helperText']";
	final String PatientEmailverify="//button[normalize-space()='rohanpoddar85@gmail.com']";
	final String RecordsSearchbtn="/html/body/div/div[1]/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div[2]/div[3]/button";
	final String FindBtn="/html/body/div[2]/div[3]/div/div[3]/button[1]";
	final String InputSearch="/html/body/div[2]/div[3]/div/div[2]/div[3]/div/div/input";
		
	@FindBy(xpath = Patient)
	WebElement patients;

	@FindBy(xpath = PatientList)
	WebElement patientsList;
	
	@FindBy(xpath=PatientName)
	WebElement patientNames;
	
	@FindBy(xpath=PatientEmail)
	WebElement patientEmails;
	
	@FindBy(xpath=SearchBtn)
	WebElement Search;
	
	@FindBy (xpath=PatientEmailverify)
	WebElement patientEmailver;
	
	@FindBy(xpath=RecordsSearchbtn)
	WebElement recordsSearch;
	
	@FindBy(xpath=FindBtn)
	WebElement find;
	
	@FindBy(xpath=InputSearch)
	WebElement inputSearch;
	
	
	@Test 
	public void clickOnpatients() throws Exception {		
		patients.click();
	}
	
	@Test 
	public void clickOnpatientsList() throws Exception {	
		patientsList.click();
	}
	
	@Test
	public void searchPatientname() throws Exception {		
		patientNames.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"Search","patient name"));
		Search.click();
	}
	
	@Test
	public void searchPatientEmail() throws Exception {		
		patientEmails.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"Search","email address"));
		Search.click();
		Thread.sleep(2000);
		patientEmailver.isDisplayed();
		String ActualError = patientEmailver.getText();
		String ExpectedError = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"Search", "Expectedpatientemail");
		Assert.assertEquals(ExpectedError, ActualError);
		Thread.sleep(2000);	
	}
	
	@Test
	public void searchRecords() throws Exception
	{
		Thread.sleep(2000);	
		recordsSearch.click();	
		inputSearch.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"Search","SearchRecords"));
		find.click();
	}
	
	
	WebDriver driver;
	public BfxPatient() {
		this.driver =  baseobj.driver;
	}
	
	
}
