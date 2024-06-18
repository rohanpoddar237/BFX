package Com.Bfx.POM.Login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.BasePage;

import Com.Bfx.Utilities.BfxUtlilities;

public class BfxLoginPage extends BasePage{  
	
	BasePage baseobj= new BasePage();

	//POM Basepage
	final String Username = "//input[@name='userName']";
	final String Password = "//input[@type='password']";
	final String LoginButton = "//button[text()='Login']";
	final String UsernameMandatoryError = "//p[@id='txtUserName-helper-text']";
	final String PasswordMandatoryError = "/html/body/div/div[1]/div/div[2]/div[2]/div/div/p";
	final String CommonSearchBar = "//div[text()=\"Dashboard\"]";
	final String InvalidCredError= "//div[contains(text(),'Please enter valid username and password')]";

	/////////////////POM////////// (data entering,Assertion,validation)
	
	@FindBy(xpath = Username)
	WebElement userName;

	@FindBy(xpath = Password)
	WebElement password;

	@FindBy(xpath = LoginButton)
	WebElement loginButton;

	@FindBy(xpath = UsernameMandatoryError)
	WebElement usernameMandatoryError;

	@FindBy(xpath = PasswordMandatoryError)
	WebElement passwordMandatoryError;

	@FindBy(xpath = CommonSearchBar)
	WebElement commonSearchBar;

	@FindBy(xpath = InvalidCredError)
	WebElement invalidCredError;
	
	WebDriver driver; 
	
    public BfxLoginPage() {	
		this.driver =  baseobj.driver;
	}

	@Test 
	public void enterCredentials() throws Exception {		
		//Read the utilities 3 string (file path,array file first name"login page", values)
		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","Username"));
		password.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","Password"));
		loginButton.click();
	}
	
	@Test 
	public void doNotEnterCredentials() throws Exception {
		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","BlankUsername"));
		Thread.sleep(3000);
		loginButton.click();
		String ActualUsernameErrorMsg = usernameMandatoryError.getText();
		String ExpectedUsernameErrorMsg = BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page", "ExpectedUsernameMandatoryError");
		Assert.assertEquals(ExpectedUsernameErrorMsg, ActualUsernameErrorMsg);
	}	
	
	@Test 
	public void validatepassword() throws Exception {
		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","InvalidUsername"));
		Thread.sleep(3000);
		loginButton.click();
		String ActualUsernameErrorMsg = passwordMandatoryError.getText();
		String ExpectedUsernameErrorMsg = BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page", "ExpectedPasswordMandatoryError");
		Assert.assertEquals(ExpectedUsernameErrorMsg, ActualUsernameErrorMsg);
	}

	public void enterInvalidCredentials() throws Exception {
		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","InvalidUsername"));
		Thread.sleep(3000);
		password.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","InvalidPassword"));
		Thread.sleep(3000);
		loginButton.click();
		Thread.sleep(3000);
	}
	
	public void verifyErrorForInvalidCredentials() throws Exception {
		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","InvalidUsername"));
		Thread.sleep(3000);
		password.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath,"Login Page","InvalidPassword"));
		loginButton.click();
		Thread.sleep(3000);
		invalidCredError.isDisplayed();
		String ActualError = invalidCredError.getText();
		String ExpectedError = BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page", "ExpectedInvalidCredentialsError");
		Assert.assertEquals(ExpectedError, ActualError);
		Thread.sleep(3000);
	}
	
	////////////////////////
	
	@Test
	public void verifyErrorForMandatoryFields() throws Exception {

		userName.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page", "BlankPassword"));
		loginButton.click();
		Thread.sleep(3000);
		usernameMandatoryError.isDisplayed();
		String ActualUsernameErrorMsg = usernameMandatoryError.getText();
		String ExpectedUsernameErrorMsg = BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page","ExpectedUsernameMandatoryError");
		Assert.assertEquals(ExpectedUsernameErrorMsg, ActualUsernameErrorMsg);
		Thread.sleep(3000);

		password.sendKeys(BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page", "BlankPassword"));
		Thread.sleep(3000);
		loginButton.click();
		passwordMandatoryError.isDisplayed();
		String ActualPasswordErrorMsg = passwordMandatoryError.getText();
		String ExpectedPasswordErrorMsg = BfxUtlilities.getStringDataFromJsonArray(LoginPgTestDataPath, "Login Page","ExpectedPasswordMandatoryError");
		Assert.assertEquals(ExpectedPasswordErrorMsg, ActualPasswordErrorMsg);
		Thread.sleep(3000);
	}
	
	
}
