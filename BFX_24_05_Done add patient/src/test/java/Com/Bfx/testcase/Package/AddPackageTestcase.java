package Com.Bfx.testcase.Package;

import org.testng.annotations.Test;

import Com.Bfx.BaseClass.Baseclass;
import Com.Bfx.POM.patient.BfxPatient;
import Com.Bfx.Package.BfxAddPackage;

public class AddPackageTestcase extends Baseclass {

	BfxPatient Patients;
	BfxAddPackage AddPackage;

	@Test(description = "Add Packages with procedure Details")
	public void addPackagewithProceduredetails() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.clickOnAddPackage();
		AddPackage.addPackageWithProcedureDetails();
	}

	@Test(description = "Add Packages with product Details")
	public void addPackagewithProductdetails() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.clickOnAddPackage();
		AddPackage.addPackageWithproductDetails();
	}

	@Test(description = "Add Packages with product and procedure Details")
	public void addPackagewithProcedureandproductDetails() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.clickOnAddPackage();
		AddPackage.addPackageWithProcedureandproductDetails();
	}

	@Test(description = "Add Packages with Patient Specific Name")
	public void addPackageWithPatientSpecificName() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.clickOnAddPackage();
		AddPackage.addPackageWithPatientSpecificDetails();
	}

	@Test(description = "Verify Error Message")
	public void addPackageWithErrormessage() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.clickOnAddPackage();
		AddPackage.verifySelectItemErrorMessage();
		AddPackage.verifyErrorMessage();
	}

	@Test(description = "Search by package name")
	public void searchPackageDetails() throws Exception {
		Patients = new BfxPatient();
		AddPackage = new BfxAddPackage();
		AddPackage.clickOnSetUpBtn();
		AddPackage.searchPackageName();
	}

}
