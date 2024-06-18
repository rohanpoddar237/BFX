package Com.Bfx.patient;

import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;

import Com.Bfx.POM.patient.BfxAddPatient;
import Com.Bfx.POM.patient.BfxEditPatient;
import Com.Bfx.POM.patient.BfxPatient;

public class EditPatientTestcase extends Baseclass {

	BfxPatient Patients;
	BfxAddPatient AddPatients;
	BfxEditPatient Editpatient;

	@Test(description = "Edit Patient Details")
	public void editpatientpage() throws Exception {
		Patients = new BfxPatient(); // Thread.sleep(5000);
		Patients.clickOnpatients();
		Thread.sleep(3000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Editpatient = new BfxEditPatient();
		Thread.sleep(3000);
		Editpatient.searchPatientName();
		Editpatient.updateBasicInformation();
		Editpatient.updateContactAndAddressSection();
		Editpatient.updateDetailsInCardDetailSection();
		Editpatient.updateNotes();
		Editpatient.verifyRecordsUpdatedMsg();
	}

	@Test(description = "Navigate to Basic Information section")
	public void verifyNavigateToBasicInformationSection() throws Exception {
		Patients = new BfxPatient();
		Thread.sleep(5000);
		Patients.clickOnpatients();
		Thread.sleep(3000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Editpatient = new BfxEditPatient();
		Thread.sleep(3000);
		Editpatient.searchPatientName();
		Editpatient.navigateToBasicInfoSection();
		Editpatient.verifyUserNavigateToBasicInfoSection();
	}

	@Test(description = "Navigate to Contact and Address section")
	public void verifyNavigateToContactandAdressSection() throws Exception {
		Patients = new BfxPatient();
		Thread.sleep(5000);
		Patients.clickOnpatients();
		Thread.sleep(5000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Editpatient = new BfxEditPatient();
		Thread.sleep(3000);
		Editpatient.searchPatientName();
		Editpatient.navigateToContactAndAddressSection();
		Editpatient.verifyUserNavigateToContactAndAddressSection();
	}

	@Test(description = "Navigate to Card and Insurance section")
	public void verifyNavigateToCardDetailsSection() throws Exception {
		Patients = new BfxPatient();
		Thread.sleep(5000);
		Patients.clickOnpatients();
		Thread.sleep(5000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Editpatient = new BfxEditPatient();
		Thread.sleep(3000);
		Editpatient.searchPatientName();
		Editpatient.navigateToCardDetailsSection();
		Editpatient.verifyUserNavigateToCardDetailsSection();
	}

	@Test(description = "Navigate to Notes section")
	public void verifyNavigateToNotesSection() throws Exception {
		Patients = new BfxPatient();
		Thread.sleep(5000);
		Patients.clickOnpatients();
		Thread.sleep(5000);
		Patients.clickOnpatientsList();
		AddPatients = new BfxAddPatient();
		Editpatient = new BfxEditPatient();
		Thread.sleep(3000);
		Editpatient.searchPatientName();
		Editpatient.navigateToNotesSection();
		Editpatient.verifyUserNavigateToNotesSection();
	}

}
