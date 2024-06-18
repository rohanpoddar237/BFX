package Com.Bfx.POM.patient;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Com.Bfx.BaseClass.BasePage;
import Com.Bfx.Utilities.BfxUtlilities;
import net.bytebuddy.utility.RandomString;

public class BfxEditPatient extends BasePage {
	
	//driver initialize
	BasePage baseobj= new BasePage();
	
	//Inherit Addpatient details
	BfxAddPatient AddPatients = new BfxAddPatient();
	
	// Driver for Edit Patient
	public WebDriver driver;
	
	//constructor
	public BfxEditPatient() {
		this.driver =  baseobj.driver;
	}

	final public String PatientName = "//div[@data-testid='Name']//input[@id='standard-helperText']";
	final public String SearchBtn = "(//button[normalize-space()='Search'])[1]";
	final public String SelectEdit = "//tbody/tr[1]/td[7]/div[1]/div[1]/button[1]";
	final public  String NotesLink="(//button[contains(@class,\"MuiButtonBase-root MuiStepButton\")])[4]"; 
	final public String UpdateSuccesfullMsg="//div[@class='Toastify']";
	final public String BasicInfoLink="(//button[contains(@class,\"MuiButtonBase-root MuiStepButton\")])[1]"; 
	final public String ContactAndAddressLink="(//button[contains(@class,\"MuiButtonBase-root MuiStepButton\")])[2]"; 
	final public String CardDetailsLink="(//button[contains(@class,\"MuiButtonBase-root MuiStepButton\")])[3]"; 
	final public String PageTitle="//li[@class=\"MuiBreadcrumbs-li\"]/div";
	final public String SaveButtonForDuplicateRecords = "//button[text()=\"Save\"]";
	
	@FindBy(xpath=PageTitle)
	public WebElement pageTitle;
	
	@FindBy(xpath=BasicInfoLink)
	WebElement basicInfoLink;
	
	@FindBy(xpath= ContactAndAddressLink)
	WebElement contactAndAddressLink;
	
	@FindBy(xpath= CardDetailsLink)
	WebElement cardDetailsLink;
	
	@FindBy(xpath=UpdateSuccesfullMsg)
	WebElement updateMsg;
	
	@FindBy(xpath= NotesLink)
	WebElement notesLink;
	
	@FindBy(xpath = PatientName)
	WebElement patientNames;

	@FindBy(xpath = SearchBtn)
	WebElement Search;
	
	@FindBy(xpath=SaveButtonForDuplicateRecords)
	WebElement saveButtonForDuplicateRecords;

	@FindBy(xpath = SelectEdit)
	WebElement selectEditBtn;	
	
	// Search the Patient and navigate to edit page
	public void searchPatientName() throws Exception {
		Thread.sleep(3000);
		patientNames.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "Patientname"));
		Search.click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(selectEditBtn);
		Thread.sleep(5000);
	}

	//Validate the Basic Information section
	public void updateBasicInformation() throws Exception {
		Thread.sleep(5000);
		BfxUtlilities.clickOnElementByActionClass(AddPatients.ReferralSource);
		BfxUtlilities.selectTheOption(5);
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(AddPatients.firstNameTextBox);
		BfxUtlilities.clearTextByDelete(AddPatients.firstNameTextBox);
		AddPatients.firstNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "PatientsFirstName"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.lastNameTextBox);
		BfxUtlilities.clearTextByDelete(AddPatients.lastNameTextBox);
		AddPatients.lastNameTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "PatientsLastName"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.genderRadioButton);
		Thread.sleep(2000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		calendar(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "CalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "BirthYear"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "BirthDay"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.emailTextBox);
		BfxUtlilities.clearTextByDelete(AddPatients.emailTextBox);
		RandomString random=new RandomString();
		String randomEmail=random.make(2);
		String email=randomEmail+BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientEmail");
		AddPatients.emailTextBox.sendKeys(email);
		BfxUtlilities.clickOnElementByJavaExecutor(AddPatients.saveAndGoToNextButton);
		Thread.sleep(3000);	
	}
	
	//Validate the Contact And Address section
	public void updateContactAndAddressSection() throws Exception {
		BfxUtlilities.clickOnElementByActionClass(AddPatients.alternatePhoneType1RadioButton);
		BfxUtlilities.clickOnElementByActionClass(AddPatients.alternatePhoneNumber1TextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.alternatePhoneNumber1TextBox);
		AddPatients.alternatePhoneNumber1TextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","AlternatePhoneNumber1"));
		AddPatients.alternatePhoneType2RadioButton.click();
		BfxUtlilities.clickOnElementByActionClass(AddPatients.alternatePhoneNumber2TextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.alternatePhoneNumber2TextBox);
		AddPatients.alternatePhoneNumber2TextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","AlternatePhoneNumber2"));
		BfxUtlilities.scrollByJavaExecutor();
		AddPatients.addressTypeRadioButton.click();
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,400)", "");	
		BfxUtlilities.clickOnElementByActionClass(AddPatients.addressTextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.addressTextBox);
		AddPatients.addressTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","PatientAddress"));				
		BfxUtlilities.clickOnElementByActionClass(AddPatients.countryTextBox);
		BfxUtlilities.selectTheOption(1);		
		BfxUtlilities.clickOnElementByActionClass(AddPatients.stateOrProvTextBox);
		BfxUtlilities.selectTheOption(2);		
		BfxUtlilities.clickOnElementByActionClass(AddPatients.cityTextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.cityTextBox);	
		AddPatients.cityTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","City"));		
		BfxUtlilities.clickOnElementByActionClass(AddPatients.postalCodeTextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.postalCodeTextBox);
		AddPatients.postalCodeTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","PostalCode"));		
		BfxUtlilities.clickOnElementByJavaExecutor(AddPatients.saveAndGoToNextButton);
		Thread.sleep(2000);	
	}
	
	//Validate the Cards Details section
	public void updateDetailsInCardDetailSection() throws Exception {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,-400)", "");
		BfxUtlilities.clickOnElementByActionClass(AddPatients.healthCardNumberTextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.healthCardNumberTextBox);
		AddPatients.healthCardNumberTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"AddNewPatient","HealthCardNumber"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.healthCardVersionTextBox);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.healthCardVersionTextBox);
		AddPatients.healthCardVersionTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"AddNewPatient","HealthCardVersion"));
		calendarWithYearAndMonthSelect(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "CalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "Year"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "Month"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.nameOfInsured);
		Thread.sleep(2000);
		BfxUtlilities.clearText(AddPatients.nameOfInsured);
		AddPatients.nameOfInsured.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "NameOfInsured"));
		calendar(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "InsuranceCalendarIndex"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthYear"),
				BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "BirthDay"));
       	AddPatients.patientRelationshipToInsured.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PatientRelationshipToInsured"));
//		AddPatients.primaryInsuranceProviderName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PrimaryInsuranceProviderName"));
//		AddPatients.primaryGroupNumber.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PrimaryGroupNumber"));
//		AddPatients.primaryProviderPhoneNumber.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PrimaryProviderPhoneNumber"));
//		AddPatients.primaryPolicyID.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PrimaryPolicyID"));
//		AddPatients.primaryPlanID.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "PrimaryPlanID"));
//		AddPatients.secInsuranceProviderName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "SecInsuranceProviderName"));
//		AddPatients.secGroupNumber.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "SecGroupNumber"));
//		AddPatients.secProviderPhoneNumber.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "SecProviderPhoneNumber"));
//		AddPatients.secPolicyID.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "SecPolicyID"));
//		AddPatients.secPlanID.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "AddNewPatient", "SecPlanID"));
		BfxUtlilities.clickOnElementByJavaExecutor(AddPatients.saveAndGoToNextButton);
	}

	//Validate the Notes section
	public void updateNotes() throws Exception {
		Thread.sleep(2000);
		AddPatients.additionalInformationTextBox.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath,"EditPatient","AdditionalInformation"));
		BfxUtlilities.clickOnElementByActionClass(AddPatients.doneButton);
		Thread.sleep(4000);
	}
	
	//Assert Updated Message 
	public void verifyRecordsUpdatedMsg() throws Exception {
		String actualText = updateMsg.getText();
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "UpdateSuccesfullMessage");
		Assert.assertEquals(expectedText, actualText);
	}
	
	public void navigateToBasicInfoSection() throws Exception {
		BfxUtlilities.clickOnElementByActionClass(basicInfoLink);
	}
	
	public void verifyUserNavigateToBasicInfoSection() throws Exception {
		String text = basicInfoLink.getText();
		String actualText = text.substring(2);
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "BasicInformationSection");
		Assert.assertEquals(expectedText, actualText);
	}
	public void navigateToContactAndAddressSection() throws Exception {
		Thread.sleep(4000);
		BfxUtlilities.clickOnElementByActionClass(contactAndAddressLink);
	}
	
	public void verifyUserNavigateToContactAndAddressSection() throws Exception {
		String text = contactAndAddressLink.getText();
		String actualText = text.substring(2);
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "ContactAndAddressSection");
		Assert.assertEquals(expectedText, actualText);
	}
	
	public void navigateToCardDetailsSection() throws Exception {
		BfxUtlilities.clickOnElementByActionClass(cardDetailsLink);
	}
	
	public void verifyUserNavigateToCardDetailsSection() throws Exception {
		String text = cardDetailsLink.getText().toLowerCase();
		String actualText = text.substring(2);
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "CardDetailsSection").toLowerCase();
		Assert.assertEquals(expectedText, actualText);
	}
	
	public void navigateToNotesSection() throws Exception {
		BfxUtlilities.clickOnElementByActionClass(notesLink);
	}
	
	public void verifyUserNavigateToNotesSection() throws Exception {
		String text = notesLink.getText();
		String actualText = text.substring(2);
		String expectedText = BfxUtlilities.getStringDataFromJsonArray(PatientPgTestDataPath, "EditPatient", "NotesSection");
		Assert.assertEquals(expectedText, actualText);
	}
	
	public void verifyUserNavigateToEditPatientPage(String expectedText) throws Exception {
		String actualText = pageTitle.getText();
		Assert.assertEquals(expectedText,actualText);
	}
	
	
}
