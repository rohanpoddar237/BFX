package Com.Bfx.patient;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;
import Com.Bfx.POM.Login.BfxLoginPage;

import Com.Bfx.POM.patient.BfxAddPatient;
import Com.Bfx.POM.patient.BfxPatient;

public class AddPatientTestcase extends Baseclass {

	BfxPatient Patients;
	BfxAddPatient AddPatients;

	@Test(description = "Verify Add Patient page")
	public void verifyAddPatientpage() throws Exception {
		Patients = new BfxPatient();
		Patients.clickOnpatients();
		Thread.sleep(2000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		AddPatients.clickOnAddPatient();
	}

	@Test(description = "Add Patient Basic details")
	public void addPatientInfo() throws Exception {
		Patients = new BfxPatient();
		Patients.clickOnpatients();
		Thread.sleep(2000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		AddPatients.clickOnAddPatient();
		AddPatients.basicInformation();
		AddPatients.verifyPatientAddedWithBasicInfo();
	}

	@Test(description = "Add Patient Error Message")
	public void verifyErrorMessage() throws Exception {
		Patients = new BfxPatient();
		Patients.clickOnpatients();
		Thread.sleep(2000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		AddPatients.clickOnAddPatient();
		AddPatients.clickSavePatientButton();
		AddPatients.verifyErrorMessage();
	}

	@Test(description = "Verify Duplicate Patient Details")
	public void duplicatePatientDetails() throws Exception {
		Patients = new BfxPatient();
		Patients.clickOnpatients();
		Thread.sleep(2000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Thread.sleep(3000);
		AddPatients.clickOnAddPatient();
		AddPatients.duplicatePatientDetails();
		AddPatients.verifyDuplicatePatientRecords();
	}

	@Test(description = "Verify Duplicate Patient Email Details")
	public void duplicatePatientEmail() throws Exception {
		Patients = new BfxPatient();
		Patients.clickOnpatients();
		Thread.sleep(3000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Thread.sleep(3000);
		AddPatients.clickOnAddPatient();
		AddPatients.patientDuplicateEmailDetails();
		AddPatients.verifyPotentialDuplicatePatientRecord();
	}

}
