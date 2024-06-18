package Com.Bfx.POM.patient;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.BasePage;

import Com.Bfx.Utilities.BfxUtlilities;
import net.bytebuddy.utility.RandomString;

public class BfxAddPatient extends BasePage {
	
	BasePage baseobj= new BasePage();
	
	public WebDriver driver;
	public BfxAddPatient() {
		this.driver =  baseobj.driver; 
	}
	
	final String AddPatientbtn = "/html/body/div/div[1]/div/div[2]/div[1]/div/div/div/div[3]/div[1]/div[2]/div[4]/button";
	final String ReferralSourceDropdown = "//input[@id='cmbReferralSource']";
	final String FirstNameTextBox = "//input[@id=\"txtFirstName\"]";
	final String LastNameTextBox = "//input[@id=\"txtLastName\"]";
	final String GenderRadioButton = "//input[@id='rdbMale']";
	final String DateOfBirth = "//input[@id='dob']";
	final String EmailTextBox = "//input[@id=\"txtEmail\"]";
	final String PrimaryPhoneTypeRadioButton = "//input[@id='rdbWork']";
	final String PrimaryPhoneNumberTextBox = "//input[@name=\"PrimaryPhone\"]";
	final String LocationDropdown = "//input[@id='cmbClinicLocation']";
	final String SavePatientButton = "//*[@id=\"savepatient\"]";
	final String CancelButton="(//button[@name=\"btnDoneSteps\"])[1]";
	final String PatientAddedPopupMessageWithBasicInfo="//p[text()=\"Patient record has been created!\"]";
	final String DoneForNowButton="//button[text()=\"Done for Now\"]";
	final String SaveAndGoToNextButton="//button[text()=\"Save & Go To Next\"]";
	final String GoToNextButton="//button[@name=\"btnDoneSteps\"]";
	final String DuplicatePatientRecordPopup="//div[text()=' Duplicate Record(s) found']";
	final String PotentialDuplicatePatientRecordPopup="//div[text()='Potential Duplicate Record(s) found']";
	final String PotentialSaveButton="//button[text()='Save']";
	final String AlternatePhoneType1RadioButton="(//span[contains(@class,\"MuiRadio-root\")])[2]";

	final String AlternatePhoneNumber1TextBox="(//input[@id=\"primaryPhone2\"])";
	final String AlternatePhoneType2RadioButton="(//span[contains(@class,\"MuiRadio-root\")])[6]";
	final String AlternatePhoneNumber2TextBox="(//input[@id=\"primaryPhone3\"])";
	final String AddressTypeRadioButton="(//span[contains(@class,\"MuiRadio-root\")])[10]";
	final String AddressTextBox="//input[@id=\"txtAddress\"]";
	final String PostalCodeTextBox="//input[@id=\"txtPostalCode\"]";
	final String CityTextBox="//input[@id=\"txtCity\"]";
	final String StateOrProvTextBox="//div[@id='txtState']";
	final String CountryTextBox="//div[@id='txtCountry']";	
	
	final String HealthCardNumberTextBox="//input[@id=\"txtHealthCardNumber\"]";
	final String HealthCardVersionTextBox="//input[@id=\"txtHealthCardVirsion\"]";
	final String AdditionalInformationTextBox="//textarea[@id=\"txtNotes\"]";
	final String NameOfInsured="(//input[@id=\"txtHealthCardNumber\"])[2]";
	final String PatientRelationshipToInsured="(//input[@id=\"txtHealthCardVirsion\"])[2]";

	final String DoneButton="//button[@name=\"done\"]";

	@FindBy(xpath=PatientRelationshipToInsured)
	public WebElement patientRelationshipToInsured;

	@FindBy(xpath=DoneButton)
	public WebElement doneButton;
	
	@FindBy(xpath=StateOrProvTextBox)
	public WebElement stateOrProvTextBox;
	
	@FindBy(xpath=CountryTextBox)
	public 	WebElement countryTextBox;
	
	JavascriptExecutor js = (JavascriptExecutor) baseobj.driver;

	
	@FindBy(xpath = AddPatientbtn)
	public	WebElement addPatient;

	@FindBy(xpath = ReferralSourceDropdown)
	public WebElement ReferralSource;

	@FindBy(xpath = FirstNameTextBox)
	public WebElement firstNameTextBox;

	@FindBy(xpath = LastNameTextBox)
	public WebElement lastNameTextBox;

	@FindBy(xpath = GenderRadioButton)
	public WebElement genderRadioButton;

	@FindBy(xpath = EmailTextBox)
	public WebElement emailTextBox;

	@FindBy(xpath = PrimaryPhoneTypeRadioButton)
	public WebElement primaryPhoneTypeRadioButton;

	@FindBy(xpath = PrimaryPhoneNumberTextBox)
	public WebElement primaryPhoneNumberTextBox;

	@FindBy(xpath = LocationDropdown)
	public WebElement locationDropdown;

	@FindBy(xpath = DateOfBirth)
	public WebElement dateOfBirth;

	@FindBy(xpath = SavePatientButton)
	public WebElement savePatientButton;
	
	@FindBy(xpath=CancelButton)
	public WebElement cancelButton;
	
	@FindBy(xpath=PatientAddedPopupMessageWithBasicInfo)
	public WebElement patientAddedPopupMessageWithBasicInfo;
	
	@FindBy(xpath=DoneForNowButton)
	public WebElement doneForNowButton;
	
	@FindBy(xpath=SaveAndGoToNextButton)
	public WebElement saveAndGoToNextButton;
	
	@FindBy(xpath=GoToNextButton)
	public WebElement goToNextButton;
	

	@FindBy(xpath=DuplicatePatientRecordPopup)
	public WebElement duplicatePatientRecordPopup;
	
	@FindBy(xpath=PotentialDuplicatePatientRecordPopup)
	public WebElement potentialDuplicatePatientRecordPopup;
	
	@FindBy(xpath=PotentialSaveButton)
	public WebElement potentialSaveButton;
	
	
	@FindBy(xpath=AlternatePhoneType1RadioButton)
	WebElement alternatePhoneType1RadioButton;
	
	@FindBy(xpath=AlternatePhoneNumber1TextBox)
	WebElement alternatePhoneNumber1TextBox;
	
	@FindBy(xpath=AlternatePhoneType2RadioButton)
	WebElement alternatePhoneType2RadioButton;
	
	@FindBy(xpath=AlternatePhoneNumber2TextBox)
	public WebElement alternatePhoneNumber2TextBox;

	@FindBy(xpath=AddressTypeRadioButton)
	public WebElement addressTypeRadioButton;
	
	@FindBy(xpath=AddressTextBox)
	public WebElement addressTextBox;
	
	@FindBy(xpath=PostalCodeTextBox)
	public WebElement postalCodeTextBox;
	
	@FindBy(xpath=CityTextBox)
	public WebElement cityTextBox;
	
	
	@FindBy(xpath=HealthCardNumberTextBox)
	public WebElement healthCardNumberTextBox;
	
	@FindBy(xpath=HealthCardVersionTextBox)
	public WebElement healthCardVersionTextBox;
	
	@FindBy(xpath=AdditionalInformationTextBox)
	public WebElement additionalInformationTextBox;
	
	@FindBy(xpath=NameOfInsured)
	public WebElement nameOfInsured;
	
	
	//Driver for Add Patient

	
    //Click on Add patient button
	public void clickOnAddPatient() throws Exception {
		addPatient.click();
	}
	//click on cancel button
	public void clickOnCancelButton() throws InterruptedException {
		BfxUtlilities.clickOnElementByJavaExecutor(cancelButton);
	}
	//click on save button
	public void clickSavePatientButton() throws InterruptedException {
		BfxUtlilities.scrollByJavaExecutor();
		Thread.sleep(1000);
		BfxUtlilities.clickOnElementByJavaExecutor(savePatientButton);
	}

	//Validate All basic Information
	public void basicInformation() throws Exception {
		Thread.sleep(5000);
		BfxUtlilities.clickOnElementByActionClass(ReferralSource);
		BfxUtlilities.selectTheOption(2);
		firstNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientsFirstName"));
		lastNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientsLastName"));
		BfxUtlilities.clickOnElementByActionClass(genderRadioButton);
		Thread.sleep(2000);
		 dateOfBirth.click();
		calendar(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath , "AddNewPatient", "CalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthYear"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthDay"));
		Thread.sleep(1000);
		BfxUtlilities.clickOnElementByActionClass(primaryPhoneTypeRadioButton);
		Thread.sleep(2000);
		primaryPhoneNumberTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"AddNewPatient", "PrimaryPhoneNumber1"));
		emailTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientEmail"));
		BfxUtlilities.clickOnElementByActionClass(locationDropdown);
		BfxUtlilities.selectTheOption(1);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		BfxUtlilities.clickOnElementByActionClass(savePatientButton);
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(saveAndGoToNextButton);
	}

	//Assert Patient Successful Message
	public void verifyPatientAddedWithBasicInfo() throws Exception {
		Thread.sleep(4000);
		String actualPopupMessage = patientAddedPopupMessageWithBasicInfo.getText();
		String expectedPopupMessage = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientAddedPopuMessage");
		Assert.assertEquals(expectedPopupMessage, actualPopupMessage);
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(doneForNowButton);
		Thread.sleep(2000);
	}
	
	//Validate Duplicate Patient Details
	public void duplicatePatientDetails() throws Exception {
		Thread.sleep(5000);
		BfxUtlilities.clickOnElementByActionClass(ReferralSource);
		BfxUtlilities.selectTheOption(2);
		firstNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "NewPatientsFirstName"));
		lastNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "NewPatientsLastName"));
		BfxUtlilities.clickOnElementByActionClass(genderRadioButton);
		Thread.sleep(2000);
		 dateOfBirth.click();
		calendar(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "CalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthYear"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthDay"));
		Thread.sleep(1000);
		BfxUtlilities.clickOnElementByActionClass(primaryPhoneTypeRadioButton);
		Thread.sleep(2000);
		primaryPhoneNumberTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"AddNewPatient", "PrimaryPhoneNumber1"));
		emailTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientEmail"));
		BfxUtlilities.clickOnElementByActionClass(locationDropdown);
		BfxUtlilities.selectTheOption(1);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		BfxUtlilities.clickOnElementByActionClass(savePatientButton);
		Thread.sleep(3000);
		//Bfx_Utlilities.clickOnElementByActionClass(saveAndGoToNextButton);
	}

	//Assert Duplicate Patient Details
	public void verifyDuplicatePatientRecords() throws Exception {
		String actualText = duplicatePatientRecordPopup.getText();
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "DuplicatePatientRecordPopuMessage");
		Assert.assertEquals(expectedText, actualText);
	}
	
	
	
	
	//Validate Duplicate Patient Details
	public void patientDuplicateEmailDetails() throws Exception {
		Thread.sleep(5000);
		BfxUtlilities.clickOnElementByActionClass(ReferralSource);
		BfxUtlilities.selectTheOption(2);
		firstNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "NewPatientsFirstName"));
		lastNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "NewPatientsLastName"));
		BfxUtlilities.clickOnElementByActionClass(genderRadioButton);
		Thread.sleep(2000);
		 dateOfBirth.click();
		calendar(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "CalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthYear"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthDay"));
		Thread.sleep(1000);
		BfxUtlilities.clickOnElementByActionClass(primaryPhoneTypeRadioButton);
		Thread.sleep(2000);
		primaryPhoneNumberTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"AddNewPatient", "PrimaryPhoneNumber1"));
		RandomString random=new RandomString();
		String randomEmail=random.make(2);
		String email=randomEmail+BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientEmail");
		emailTextBox.sendKeys(email);
		//emailTextBox.sendKeys(Bfx_Utlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientEmail"));
		BfxUtlilities.clickOnElementByActionClass(locationDropdown);
		BfxUtlilities.selectTheOption(1);
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		BfxUtlilities.clickOnElementByActionClass(savePatientButton);
		Thread.sleep(3000);
		//Bfx_Utlilities.clickOnElementByActionClass(saveAndGoToNextButton);
	}
	
	
	public void verifyPotentialDuplicatePatientRecord() throws Exception {
		String actualPopupMessage = potentialDuplicatePatientRecordPopup.getText();
		String expectedPopupMessage = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PotentialDuplicatePatientRecordPopupMessage");
		assertEquals(actualPopupMessage, expectedPopupMessage);
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(potentialSaveButton);
		Thread.sleep(3000);
	}
	
	
	//Assert all Error Messages
	int counter=0;
	public void verifyErrorMessage() throws Exception {
		
		List<WebElement> allErrorMessage = driver.findElements(By.xpath("//p"));
		for(WebElement element:allErrorMessage) {
			String actualErrorText = element.getText();
			if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForReferralSourceDropdown"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForSalutation"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForFirstName"))) {
				counter=++counter ;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForLastName"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForGender"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForDateOfBirth"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForEmail"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForPrimaryPhoneType"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForPrimaryPhoneNumber"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForLocation"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForPhysician"))) {
				counter=++counter;
			}
			
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"ErrorMessage", "ErrorMessageForProcedure"))) {
				counter=++counter;
			}
		}
		assertEquals(counter, BfxUtlilities.getIntegerDataFromJsonArray(PatientPgTestDataPath, "ErrorMessage", "ErrorCount"));
	}
	





}
