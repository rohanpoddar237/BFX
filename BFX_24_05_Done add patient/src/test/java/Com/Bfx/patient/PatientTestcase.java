package Com.Bfx.patient;

import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;

import Com.Bfx.POM.patient.BfxPatient;

public class PatientTestcase extends Baseclass {

	BfxPatient Patients;

	@Test(description = "verify patient page")
	public void verifyPatientPage() throws Exception {

		Patients = new BfxPatient();
		Patients.clickOnpatients();

		Thread.sleep(2000);
		Patients.clickOnpatientsList();
	}

	
	/*
	 * @Test(description = "Search for the patient by their name ") public void
	 * verifyPatientname() throws Exception {
	 * 
	 * Patients = new BfxPatient(); Patients.clickOnpatients(); Thread.sleep(5000);
	 * Patients.clickOnpatientsList(); Patients.searchPatientname(); }
	 * 
	 * @Test(description = "Search for the patient by their email") public void
	 * verifyPatientemail() throws Exception { // common used object for every
	 * 
	 * Patients = new BfxPatient(); Patients.clickOnpatients(); Thread.sleep(5000);
	 * Patients.clickOnpatientsList(); Thread.sleep(5000);
	 * Patients.searchPatientEmail(); }
	 * 
	 * @Test(description = "find the patient name by their search filter") public
	 * void findrecords() throws Exception { Patients = new BfxPatient();
	 * Patients.clickOnpatients(); Thread.sleep(5000);
	 * Patients.clickOnpatientsList(); Thread.sleep(5000); Patients.searchRecords();
	 * }
	 */

}





