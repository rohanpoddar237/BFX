package Com.Bfx.Package;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Com.Bfx.BaseClass.BasePage;
import Com.Bfx.Utilities.BfxUtlilities;

public class BfxAddPackage extends BasePage {
	BasePage baseobj = new BasePage();
	JavascriptExecutor js = (JavascriptExecutor) baseobj.driver;

	public WebDriver driver;

	public BfxAddPackage() {
		this.driver = baseobj.driver;
	}

	final String SetUpBtn = "//*[@id=\"root\"]/div[1]/div/div[1]/div/div/div/div/ul[12]/a/div";
	final String SetupSection = "/html/body/div/div[1]/div/div[2]/div[1]/div/div[2]/div/div/input";
	final String ClickonPackageBtn = "//div[1]//div[1]//div[4]//div[1]//div[2]//div[4]//button[1]";
	final String PatientSpecific = "//input[@name='patientSpecific']";
	final String PatientName = "//input[@id='patient']";

	final String PackageName = "//input[@id='packageName']";
	final String ExpireMonth = "//input[@id='expireAfterMonths']";
	final String PercentageRadiobtn = "//div[1]//div[3]//div[1]//div[2]//div[1]//div[1]//div[3]//fieldset[1]//div[1]//label[1]//span[1]//input[1]";
	final String PackageDiscount = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/input[1]";
	final String Description = "//input[@id='description']";
	final String ProductBtn = "/html/body/div/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/div/div[1]/fieldset/div/label[2]/span[1]/input";
	final String ProcedureBtn = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/div/div[1]/fieldset/div/label[1]/span[1]/input";
	final String Location = "/html/body/div/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/div/div[2]/div/div/div/input";
	final String ProductLocation = "//*[@id=\"locations\"]";
	final String ProcedureDropdown = "//input[@id='item']";
	final String ProductsDropdown = "//input[@id='item']";
	final String NumberOfVisits = "//input[@id='quantityOrVisits']";
	final String Quantity = "//input[@id='quantityOrVisits']";

	final String OriginalPrice = "//input[@id='originalPrice']";
	final String SelectItemProcedureBtn = "/html/body/div/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/div/div[4]/fieldset/div/label[1]/span[1]/input";
	final String SelectItemDiscount = "/html/body/div/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/div/div[5]/div/input";
	final String AddItemBtn = "//*[@id=\"root\"]/div[1]/div/div[2]/div[1]/div[4]/div/div[2]/div/button";
	final String SaveAndPublishBtn = "//*[@id=\"AssignPackage\"]";
	
	final String Searchbtn="/html/body/div/div[1]/div/div[2]/div[1]/div/div[4]/div[1]/div[2]/div[3]/button";
	final String SearchInput="/html/body/div[2]/div[3]/div/div[2]/div[3]/div/div/input";
	final String FindButton="/html/body/div[2]/div[3]/div/div[3]/button[1]";
	final String SearchPackageName="/html/body/div/div[1]/div/div[2]/div[1]/div/div[4]/div[2]/div/table/tbody/tr/td[1]";
	
	@FindBy(xpath = SearchInput)
	public WebElement searchInput;
	
	@FindBy(xpath = SearchPackageName)
	public WebElement searchPackageName;
	
	@FindBy(xpath = FindButton)
	public WebElement findButton;

	@FindBy(xpath = SetUpBtn)
	public WebElement Setupbtn;

	@FindBy(xpath = SetupSection)
	public WebElement setUpSection;

	@FindBy(xpath = ClickonPackageBtn)
	public WebElement clickOnPackagebtn;

	@FindBy(xpath = PatientSpecific)
	public WebElement patientSpecific;

	@FindBy(xpath = PatientName)
	public WebElement patientName;

	@FindBy(xpath = PackageName)
	public WebElement packageName;

	@FindBy(xpath = ExpireMonth)
	public WebElement expiremonth;

	@FindBy(xpath = PercentageRadiobtn)
	public WebElement percentagebtn;

	@FindBy(xpath = PackageDiscount)
	public WebElement packageDiscount;

	@FindBy(xpath = Description)
	public WebElement description;

	@FindBy(xpath = ProcedureBtn)
	public WebElement procedureBtn;

	@FindBy(xpath = ProductBtn)
	public WebElement productBtn;

	@FindBy(xpath = Location)
	public WebElement location;

	@FindBy(xpath = ProductLocation)
	public WebElement productLocation;

	@FindBy(xpath = ProcedureDropdown)
	public WebElement procedureDropdown;

	@FindBy(xpath = ProductsDropdown)
	public WebElement productsDropdown;

	@FindBy(xpath = NumberOfVisits)
	public WebElement numberOfVisits;

	@FindBy(xpath = Quantity)
	public WebElement quantity;

	@FindBy(xpath = SelectItemProcedureBtn)
	public WebElement selectItemProcedureBtn;

	@FindBy(xpath = OriginalPrice)
	public WebElement originalPrice;

	@FindBy(xpath = AddItemBtn)
	public WebElement addItemBtn;

	@FindBy(xpath = SelectItemDiscount)
	public WebElement selectItemDiscount;

	@FindBy(xpath = SaveAndPublishBtn)
	public WebElement saveAndPublishBtn;
	
	@FindBy(xpath = Searchbtn)
	public WebElement searchbtn;
	

	public void clickOnSetUpBtn() throws Exception {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = "https://bfxnonprod-cu.boomerangfxalpha.com/staging-pms/setup";
		driver.get(url);
		// js.executeScript("document.body.style.zoom = '80%';"); Thread.sleep(3000);
		// setUpSection.click();
		BfxUtlilities.clickOnElementByActionClass(setUpSection);
		BfxUtlilities.selectTheOption(14);
	}

	public void clickOnAddPackage() throws Exception {
		Thread.sleep(3000);
		clickOnPackagebtn.click();
	}

	public void addPackageWithProcedureDetails() throws Exception {
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(packageName);
		packageName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageName"));
		Thread.sleep(2000);
		BfxUtlilities.clickOnElementByActionClass(expiremonth);
		expiremonth.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "ExpireMonths"));
		percentagebtn.click();
		BfxUtlilities.clickOnElementByActionClass(packageDiscount);
		packageDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageDiscount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(description);
		description.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Description"));
		procedureBtn.click();
		BfxUtlilities.clickOnElementByActionClass(location);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(procedureDropdown);
		BfxUtlilities.selectTheOption(3);
		BfxUtlilities.clickOnElementByActionClass(numberOfVisits);
		numberOfVisits.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "NumberOfVisits"));
		selectItemProcedureBtn.click();
		BfxUtlilities.clickOnElementByActionClass(selectItemDiscount);
		selectItemDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Discount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		BfxUtlilities.scrollByJavaExecutor();
		Thread.sleep(3000);

		BfxUtlilities.clickOnElementByActionClass(saveAndPublishBtn);
		Thread.sleep(3000);

	}

	public void addPackageWithproductDetails() throws Exception {

		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(packageName);
		packageName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageName"));
		Thread.sleep(2000);
		BfxUtlilities.clickOnElementByActionClass(expiremonth);
		expiremonth.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "ExpireMonths"));
		percentagebtn.click();
		BfxUtlilities.clickOnElementByActionClass(packageDiscount);
		packageDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageDiscount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(description);
		description.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Description"));
		productBtn.click();
		BfxUtlilities.clickOnElementByActionClass(location);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(productsDropdown);
		BfxUtlilities.selectTheOption(3);
		BfxUtlilities.clickOnElementByActionClass(quantity);
		quantity.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Quantity"));
		BfxUtlilities.clickOnElementByActionClass(selectItemDiscount);
		selectItemDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Discount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		BfxUtlilities.scrollByJavaExecutor();
		Thread.sleep(3000);

		BfxUtlilities.clickOnElementByActionClass(saveAndPublishBtn);
		Thread.sleep(3000);

	}

	public void addPackageWithProcedureandproductDetails() throws Exception {
		// Procedure
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(packageName);
		packageName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageName"));
		Thread.sleep(2000);
		BfxUtlilities.clickOnElementByActionClass(expiremonth);
		expiremonth.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "ExpireMonths"));
		percentagebtn.click();
		BfxUtlilities.clickOnElementByActionClass(packageDiscount);
		packageDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageDiscount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(description);
		description.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Description"));
		procedureBtn.click();
		BfxUtlilities.clickOnElementByActionClass(location);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(procedureDropdown);
		BfxUtlilities.selectTheOption(3);
		BfxUtlilities.clickOnElementByActionClass(quantity);
		numberOfVisits.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "NumberOfVisits"));
		selectItemProcedureBtn.click();
		BfxUtlilities.clickOnElementByActionClass(selectItemDiscount);
		selectItemDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Discount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		Thread.sleep(3000);
		BfxUtlilities.scrollUPByActionsClass();
		Thread.sleep(3000);

		// Product

		productBtn.click();
		BfxUtlilities.clickOnElementByActionClass(location);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(productLocation);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(procedureDropdown);
		BfxUtlilities.selectTheOption(4);
		BfxUtlilities.clickOnElementByActionClass(productsDropdown);
		BfxUtlilities.selectTheOption(4);
		BfxUtlilities.clickOnElementByActionClass(numberOfVisits);
		numberOfVisits.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "NumberOfVisits"));
		selectItemProcedureBtn.click();
		BfxUtlilities.clickOnElementByActionClass(selectItemDiscount);
		selectItemDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Discount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		BfxUtlilities.scrollByJavaExecutor();
		Thread.sleep(3000);

		BfxUtlilities.clickOnElementByActionClass(saveAndPublishBtn);
		Thread.sleep(3000);

	}

	public void addPackageWithPatientSpecificDetails() throws Exception {

		BfxUtlilities.clickOnElementByActionClass(patientSpecific);
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(patientName);
		patientName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PatientSpecificName"));
		BfxUtlilities.clickOnElementByActionClass(patientName);
		BfxUtlilities.selectTheOption(1);
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(packageName);
		packageName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageName"));
		Thread.sleep(2000);
		BfxUtlilities.clickOnElementByActionClass(expiremonth);
		expiremonth.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "ExpireMonths"));
		percentagebtn.click();
		BfxUtlilities.clickOnElementByActionClass(packageDiscount);
		packageDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageDiscount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(description);
		description.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Description"));
		productBtn.click();
		BfxUtlilities.clickOnElementByActionClass(location);
		BfxUtlilities.selectTheOption(1);
		BfxUtlilities.clickOnElementByActionClass(productsDropdown);
		BfxUtlilities.selectTheOption(3);
		BfxUtlilities.clickOnElementByActionClass(quantity);
		quantity.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Quantity"));
		BfxUtlilities.clickOnElementByActionClass(selectItemDiscount);
		selectItemDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Discount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		BfxUtlilities.scrollByJavaExecutor();
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(saveAndPublishBtn);
		Thread.sleep(3000);

	}

	
	public void verifySelectItemErrorMessage()throws Exception	{
		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(packageName);
		packageName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageName"));
		Thread.sleep(2000);
		BfxUtlilities.clickOnElementByActionClass(expiremonth);
		expiremonth.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "ExpireMonths"));
		percentagebtn.click();
		BfxUtlilities.clickOnElementByActionClass(packageDiscount);
		packageDiscount.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "PackageDiscount"));
		BfxUtlilities.scrollByJavaExecutor();
		BfxUtlilities.clickOnElementByActionClass(description);
		description.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "AddPackage", "Description"));
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,800)", "");
		BfxUtlilities.clickOnElementByActionClass(addItemBtn);
		}
	
	
	int counter=0;
	public void verifyErrorMessage() throws Exception {
		
		List<WebElement> allErrorMessage = driver.findElements(By.xpath("//p"));
		for(WebElement element:allErrorMessage) {
			String actualErrorText = element.getText();
			if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath,"ErrorMessage", "ErrorMessageForLocation"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath,"ErrorMessage", "ErrorMessageForProcedures"))) {
				counter=++counter;
			}
			else if(actualErrorText.equals(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath,"ErrorMessage", "ErrorMessageForVisit"))) {
				counter=++counter ;
			}
		}
		assertEquals(counter, BfxUtlilities.getIntegerDataFromJsonArray(PackagePgTestDataPath, "ErrorMessage", "ErrorCount"));
	}
	
	
	public void searchPackageName() throws Exception {	

		Thread.sleep(3000);
		BfxUtlilities.clickOnElementByActionClass(searchbtn);
		BfxUtlilities.clickOnElementByActionClass(searchInput);
		searchInput.sendKeys(BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath, "Search", "Packagename"));
		findButton.click();
		
		searchPackageName.isDisplayed();
		String ActualError = searchPackageName.getText();
		String ExpectedError = BfxUtlilities.getStringDataFromJsonArray(PackagePgTestDataPath,"Search", "Expectedpackagename");
		Assert.assertEquals(ExpectedError, ActualError);
		Thread.sleep(2000);	
	}
	
	
}
