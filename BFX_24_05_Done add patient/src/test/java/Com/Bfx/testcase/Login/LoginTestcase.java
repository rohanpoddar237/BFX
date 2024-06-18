package Com.Bfx.testcase.Login;

import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;
import Com.Bfx.POM.Login.BfxLoginPage;

public class LoginTestcase extends Baseclass {
	// Testcase Baseclass, created obj of the 'Loginpage' it can use everywhere in the class
	BfxLoginPage LoginPage;

	@Test(description = "User enters valid credentials")
	public void enterCredentials() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.enterCredentials();
	}

	@Test(description = "User enters invalid credentials and clicks on Login button")
	public void enterInvalidCredentials() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.enterInvalidCredentials();
	}

	@Test(description = "User does not enter any credentials and clicks on Login button")
	public void doNotEnterCredentials() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.doNotEnterCredentials();
	}

	@Test(description = "Error message for invalid credentials should be displayed")
	public void verifyErrorForInvalidCredentials() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.verifyErrorForInvalidCredentials();
	}

	@Test(description = "User does not enter Username and clicks on Login button")
	public void validatepsw() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.validatepassword();
	}

	@Test(description = "enter blank password and check error message")
	public void verifyErrorForMandatoryFields() throws Exception {
		LoginPage = new BfxLoginPage();
		LoginPage.verifyErrorForMandatoryFields();
	}

}
